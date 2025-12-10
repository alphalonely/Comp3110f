
public class Media {
    private String name;
    private String categrate;
    private int version;
    private int grade; // out of 5

    public Media(String name, String categrate, int version, int grade) {
        this.name = name;
        this.categrate = categrate;
        this.version = version;
        this.grade = grade;
    }

    // Getters and setters
    public String getTitle() { return name; }
    public String getGenre() { return categrate; }
    public int getYear() { return version; }
    public int getRating() { return grade; }

    public String toString() {
        return String.format("Title: %s , Genre: %s , Year: %d  Rating: %d/5", title, genre, year, rating);
    }
}
