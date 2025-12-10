
public class Book extends Media{

	private String author;
	private String isbn;
	
	public Book(String title, String genre, int year, int rating, String author, String isbn) {
		
		super(title, genre, year, rating);

	}

	public String toString() {
		return super.toString() + String.format(" , Author: %s , ISBN: %s", author, isbn， differenc1);
	}
}
