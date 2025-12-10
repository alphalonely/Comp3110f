
public class Employee {
    private String employeeName;
    private String employeeID;
    private double salary;
    private double bonusPercentage;
    private String address;
    private String jobTitle;

    // Valid job titles
    private static final String[] VALID_TITLES = {"Manager", "Developer", "Designer", "Tester"};

    // Constructor
    public Employee(String name, String id, double salary, double bonus, String address, String title) {
        setEmployeeName(name);
        setEmployeeID(id);
        setSalary(salary);
        setBonusPercentage(bonus);
        setAddress(address);
        setJobTitle(title);
    }


    // Setters with validation
    public void setEmployeeName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.employeeName = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    public void setEmployeeID(String id) {
        if (id != null && id.matches("[a-zA-Z0-9]{6}")) {
            this.employeeID = id;
        } else {
            System.out.println("Invalid ID. Must be 6 alphanumeric characters.");
        }
    }

    public void setSalary(double salary) {
        if (salary >= 30000 && salary <= 200000) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary. Must be between 30,000 and 200,000.");
        }
    }

    public void setBonusPercentage(double bonus) {
        if (bonus >= 0 && bonus <= 100) {
            this.bonusPercentage = bonus;
        } else {
            System.out.println("Invalid bonus. Must be between 0 and 100.");
        }
    }

    public void setAddress(String address) {
        if (address != null && address.contains(" ")) {
            this.address = address;
        } else {
            System.out.println("Invalid address. Must contain a space.");
        }
    }

    public void setJobTitle(String title) {
        for (String valid : VALID_TITLES) {
            if (valid.equalsIgnoreCase(title)) {
                this.jobTitle = valid;
                return;
            }
        }
        System.out.println("Invalid job title. Must be Manager, Developer, Designer, or Tester.");
    }

    // Method to calculate total pay
    public double calculateTotalPay() {
        return salary + (salary * bonusPercentage / 100);
    }
}
