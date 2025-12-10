public class PayrollSystem {
    public static void displayEmployeeInfo(Employee emp) {
        System.out.println("=== Employee Information ===");
        System.out.println("Name: " + emp.getEmployeeName());
        System.out.println("ID: " + emp.getEmployeeID());
        System.out.println("Job Title: " + emp.getJobTitle());
        System.out.println("Address: " + emp.getAddress());
        System.out.println("Salary: $" + emp.getSalary());
        System.out.println("Bonus: " + emp.getBonusPercentage() + "%");
        System.out.println("Total Pay: $" + emp.calculateTotalPay());
        System.out.println();
    }

    public static void main(String[] args) {
        // Valid employee
        Employee emp1 = new Employee("Alice", "A123B6", 75000, 10, "123 Main St", "Developer");

        // Invalid salary and bonus, then corrected
        Employee emp2 = new Employee("Bob", "B234C7", 25000, 150, "456 Elm St", "Tester");
        emp2.setSalary(80000);           // Corrected
        emp2.setBonusPercentage(15);     // Corrected

        // Invalid ID
        Employee emp3 = new Employee("Charlie", "XYZ", 60000, 5, "789 Oak Ave", "Manager");

        // Display info
        displayEmployeeInfo(emp1);
        displayEmployeeInfo(emp2);
        displayEmployeeInfo(emp3);
    }
}
