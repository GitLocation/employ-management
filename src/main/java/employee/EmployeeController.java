package employee;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	 private List<Employee> employeeList = new ArrayList<>();

    @PostMapping("/store")
    public String storeEmployeeDetails(@RequestBody Employee employee) {
        // Validate employee data and throw errors on invalid data
        // Implement your validation logic here
        // Save employee details to a database or perform other necessary actions
    	
    	employeeList.add(employee);
        return "Employee details stored successfully";
    }

    @GetMapping("/tax-deduction")
    public TaxDeductionResult calculateTaxDeduction(@RequestParam String employeeId,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date doj,
                                                    @RequestParam double salary) {
        TaxDeductionResult result = new TaxDeductionResult();
        result.setEmployeeId(employeeId);
        result.setDoj(doj);
        result.setSalary(salary);

        // Implement tax calculation logic here
        double yearlySalary = calculateYearlySalary(doj, salary);
        double taxAmount = calculateTaxAmount(yearlySalary);
        double cessAmount = calculateCessAmount(yearlySalary);

        result.setTaxAmount(taxAmount);
        result.setCessAmount(cessAmount);

        return result;
    }
    
    private double calculateYearlySalary(Date doj, double salary) {
        // Implement logic to calculate yearly salary based on DOJ
        // For simplicity, let's assume a straightforward calculation for the example
        // This logic may need to be adjusted based on actual requirements
        return salary * 12; // Assuming salary is monthly
    }
    
    
    private double calculateTaxAmount(double yearlySalary) {
        // Implement logic to calculate tax amount based on tax slabs
        // For simplicity, let's assume a straightforward calculation for the example
        // This logic may need to be adjusted based on actual tax rules
        if (yearlySalary <= 250000) {
            return 0;
        } else if (yearlySalary <= 500000) {
            return (yearlySalary - 250000) * 0.05;
        } else if (yearlySalary <= 1000000) {
            return 250000 * 0.05 + (yearlySalary - 500000) * 0.1;
        } else {
            return 250000 * 0.05 + 500000 * 0.1 + (yearlySalary - 1000000) * 0.2;
        }
    }
    
    private double calculateCessAmount(double yearlySalary) {
        // Implement logic to calculate cess amount
        // For simplicity, let's assume a straightforward calculation for the example
        // This logic may need to be adjusted based on actual rules
        double excessAmount = Math.max(0, yearlySalary - 2500000);
        return excessAmount * 0.02; // 2% cess on the amount above 2500000
    }
}
