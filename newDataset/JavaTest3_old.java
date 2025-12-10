
public class DigitalLibraryTest {
    public static void main(String[] args) {
        DigitalLibrary<Media> library = new DigitalLibrary<>();
        
        Book myBook = new Book("Java Basics", "Education", 2020, 5, "Alice", "1234567890");
        library.addMedia(myBook);
        Movie myMovie = new Movie("Inception", "Sci-Fi", 2010, 5, "Nolan", 148, "PG-13");
        library.addMedia(myMovie);
        Podcast myPodcast = new Podcast("TechTalk", "Technology", 2022, 4, "Bob", 50);
        library.addMedia(myPodcast);
        MusicAlbum myMusicAlbum = new MusicAlbum("Dreams", "Pop", 2018, 5, "The Waves", 12, "2018-07-15");
        library.addMedia(myMusicAlbum);

        System.out.println(" All Media:");
        for (Media item : library.getAll()) {
            System.out.println(item);
        }
        
        System.out.println("\nRemoving item: " + myBook.getTitle());
        boolean removed = library.removeMedia(myBook);
        System.out.println("Removed: " + removed);
        
        System.out.println(" All Media:");
        for (Media item : library.getAll()) {
            System.out.println(item);
        }
        
        System.out.println("\n Filtered by genre 'Technology':");
        for (Media item : library.filterByGenre("Technology")) {
        	System.out.println(item);
        }
        
        System.out.println("\n Recommended (rating >= 5):");
        for (Media item : library.recommendByRating(5)) {
        	System.out.println(item);
        }

        System.out.println("\n Sorted by Title:");
        library.sortByTitle();
        for (Media item : library.getAll()) {
        	System.out.println(item);
        }

        System.out.println("\n Sorted by Year:");
        library.sortByYear();
        for (Media item : library.getAll()) System.out.println(item);

        System.out.println("\n Sorted by Rating:");
        library.sortByRating();
        for (Media item : library.getAll()) {
        	System.out.println(item);
        }

        System.out.println("\n Searching for 'Inception':");
        try {
            System.out.println(library.searchByTitle("Inception"));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n Searching for non-existent item:");
        try {
            System.out.println(library.searchByTitle("Unknown Media"));
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

