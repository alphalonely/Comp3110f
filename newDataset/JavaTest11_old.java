
public class BackendDeveloper extends Developer {

    public BackendDeveloper(String name, int id, double salary, String role, String technology) {
        super(name, id, salary, role, technology);
      
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is building APIs and ensuring database integration.");
    }


    public void optimizeDatabase() {
        System.out.println(name + " is optimizing database queries for better performance.");
    }
    
	@Override
	public String toString() {
		return String.format("%s (ID: %d, %s, Salary: %.2f, Technology: %s)", name, id, role, salary, technology);
	}

}
