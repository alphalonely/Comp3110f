
public class Media {
    private String title;
    private String genre;
    private int year;
    private int rating; // out of 5

    public Media(String title, String genre, int year, int rating) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public int getRating() { return rating; }

    public String toString() {
        return String.format("Title: %s , Genre: %s , Year: %d  Rating: %d/5", title, genre, year, rating);
    }
}
