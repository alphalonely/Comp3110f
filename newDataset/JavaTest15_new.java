
public class Person {
    private String name;
    private Date birthday;
    private String country;

    public Person(String name, Date birthday, String country) {
        this.name = name;
        this.birthday = new Date(birthday); // Defensive copy
        this.country = country;
    }

    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.birthday = new Date(other.birthday);
        this.country = other.country;
    }

    public String toString() {
        return name + ", born on " + birthday + " in " + country;
    }


    public Date getBirthday() {
        return new Date(birthday);
    }
    public String getCountry(){
    	return country; 
    }

        public string addCountry(){
        this.country = country;}
}
