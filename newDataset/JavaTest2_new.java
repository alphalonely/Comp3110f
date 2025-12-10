import java.util.*;

public class DigitalLibrary<T extends Media> {
    private List<T> collection = new ArrayList<>();

    public void addMedia(T item) {
        collection.add(item);
    }

    public boolean removeMedia(T item) {
        return collection.remove(item);
    }

        public List<T> filterByGenre(String genre) throws ItemNotFoundException {
        List<T> result = new ArrayList<>();
        for (T item : collection) {
            if (item.getGenre().equalsIgnoreCase(genre)) result.add(item);
        }
        
        return result;
    }


    public T searchByTitle(String title) throws ItemNotFoundException {
        for (T item : collection) {
            if (item.getTitle().equalsIgnoreCase(title)) return item;
        }
        throw new ItemNotFoundException("Media with title \"" + title + "\" not found.");
    }


    public List<T> recommendByRating(int minRating) {
        List<T> result = new ArrayList<>();
        for (T item : collection) {
            if (item.getRating() >= minRating) result.add(item);
        }
        return result;
    }

    // Sorting by title
    public void sortByTitle() {
        collection.sort(Comparator.comparing(Media::getTitle));
    }

    // Sorting by year
    public void sortByYear() {
        collection.sort(Comparator.comparingInt(Media::getYear));
    }

    // Sorting by rating
    public void sortByRating() {
        collection.sort(Comparator.comparingInt(Media::getRating).reversed());
    }

    public List<T> getAll() {
        return new ArrayList<>(collection);
    }
}
