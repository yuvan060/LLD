package creational;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    /*
    Builder design pattern allows us to create complex objects that requires lot of objects to initialize an object
    the builder class allows us to set the attributes in builders object and when we call build, we will be able to create the object
     */

        // Personal Information
        private Long employeeId;
        private String firstName;
        private String middleName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String gender;
        private String nationality;
        private String maritalStatus;

        // Contact Information
        private String email;
        private String phoneNumber;
        private String alternatePhoneNumber;
        private String address;
        private String city;
        private String state;
        private String country;
        private String zipCode;

        // Employment Details
        private String jobTitle;
        private String department;
        private String division;
        private String employeeType;
        private LocalDate dateOfJoining;
        private LocalDate dateOfTermination;
        private String employmentStatus;

        // Compensation
        private Double basicSalary;
        private Double allowances;
        private Double bonus;
        private String currency;

        // Manager and Team
        private Long managerId;
        private String managerName;
        private List<Long> teamMemberIds;

        // Additional Information
        private String workLocation;
        private String skills;
        private String education;
        private Integer yearsOfExperience;

        private Employee(EmployeeBuilder employeeBuilder) {
            //copy constructor
        }

        public static class EmployeeBuilder {
            //List of fields
            private Long employeeId;
            private String firstName;
            private String middleName;
            private String lastName;
            private LocalDate dateOfBirth;
            private String gender;
            private String nationality;
            private String maritalStatus;

            // Contact Information
            private String email;
            private String phoneNumber;
            private String alternatePhoneNumber;
            private String address;
            private String city;
            private String state;
            private String country;
            private String zipCode;

            // Employment Details
            private String jobTitle;
            private String department;
            private String division;
            private String employeeType;
            private LocalDate dateOfJoining;
            private LocalDate dateOfTermination;
            private String employmentStatus;

            // Compensation
            private Double basicSalary;
            private Double allowances;
            private Double bonus;
            private String currency;

            // Manager and Team
            private Long managerId;
            private String managerName;
            private List<Long> teamMemberIds;

            // Additional Information
            private String workLocation;
            private String skills;
            private String education;
            private Integer yearsOfExperience;

            public EmployeeBuilder employeeId(Long employeeId) {
                this.employeeId = employeeId;
                return this;
            }

            // methods to set all Fields

            //build method
            public Employee build() {
                return new Employee(this);
            }
        }

        public static EmployeeBuilder builder() {
            return new EmployeeBuilder();
        }
}
