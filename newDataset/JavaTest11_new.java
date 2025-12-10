
public class BackendDeveloper extends Developer {

    public BackendDeveloper(String name, int id, double salary, String role, String technology) {
        super(name, id, salary, role, technology);
      
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is a test.");
    }


    public void optimizeDatabase() {
        System.out.println(name + " is test 2.");
    }
    
	@Override
	public String toString() {
		return String.format("This is the test3");
	}

}
