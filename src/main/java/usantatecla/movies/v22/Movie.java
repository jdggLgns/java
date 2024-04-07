package usantatecla.movies.v22;

public abstract class Movie {

	private final String title;

	public Movie(String title) {
		this.title = title;
	}

	public abstract double getCharge(int daysRented);

	public abstract int getFrequentRenterPoints(int daysRented);

	public String getTitle() {
		return title;
	}

}