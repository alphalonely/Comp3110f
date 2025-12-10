
public class Movie extends Media {
    private String director;
    private int duration; // in minutes
    private String mpaaRating;

    public Movie(String title, String genre, int year, int rating, String director, int duration, String mpaaRating) {
        super(title, genre, year, rating);
        this.director = director;
        this.duration = duration;
        this.mpaaRating = mpaaRating;
    }

    public String toString() {
        return super.toString() +
               String.format(" , Director: %s , Duration: %d min , MPAA: %s",  director, duration, mpaaRating);
    }
}
