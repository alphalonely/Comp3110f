
public class MusicAlbum extends Media {
    private String artist;
    private int tracks;
    private String releaseDate;

    public MusicAlbum(String title, String genre,
         int year, int rating,
                      String artist, int tracks, 
                      String releaseDate) {
        super(title, genre, year, rating);
        this.artist = artist;
        this.tracks = tracks;
        this.releaseDate = releaseDate;
    }

    public String toString() {
        return super.toString() +
               String.format(" , Artist: %s , Tracks: %d , Released: %s", artist, tracks, releaseDate);
    }
}
