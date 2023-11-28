package employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.lang.NonNull;

public class Employee {
	
	
	@NonNull
    private Long employeeId;

   // @NotBlank
    private String firstName;

   // @NotBlank
    private String lastName;

   // @Email
    //@NotBlank
    private String email;

    //@NotEmpty
    private List<String> phoneNumbers;

    //@NotNull
    private LocalDate doj;

    //@Positive
    private BigDecimal salary;
    
    

    // Constructors, getters, setters
	
	  	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public LocalDate getDoj() {
		return doj;
	}

	

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

		

}
