
public class Employee {
    protected String name;
    protected int id;
    protected double salary;
    protected String role;

    public Employee(String name, int id, double salary, String role) {
        this.name   = name;
        this.id     = id;
        this.salary = salary;
        this.role   = role;
    }

    public void performDuties() {
        System.out.println(name + " performs general duties as a " + role + ".");
    }


    public String toString() {

        return String.format("%s (ID: %d, %s, Salary: %.2f)", name, id, role, salary);
    }

    public void printInformation() {
    System.out.println(this);
    }

}
