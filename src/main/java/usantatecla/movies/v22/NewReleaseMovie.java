package usantatecla.movies.v22;

public class NewReleaseMovie extends Movie {

	private static final double CHARGE = 3;
	private static final int DAYS_RENTED_THRESHOLD = 1;
	private static final int FREQUENT_RENTER_POINTS = 2;

	public NewReleaseMovie(String title) {
		super(title);
	}

	@Override
	public double getCharge(int daysRented) {
		return NewReleaseMovie.CHARGE;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return daysRented > NewReleaseMovie.DAYS_RENTED_THRESHOLD ? NewReleaseMovie.FREQUENT_RENTER_POINTS : NewReleaseMovie.DAYS_RENTED_THRESHOLD;
	}
}