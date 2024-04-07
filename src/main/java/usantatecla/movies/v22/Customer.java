package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private final String name;
	
	private final List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		return "Rental Record for " + this.getName() + "\n" + rentals.stream()
				.map(rental -> "\t" + rental.getTitle() + "\t" + rental.getCharge() + "\n")
				.reduce("", String::concat) +
				"Amount owed is " + this.getTotalCharge() + "\n" +
				"You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
	}

	private double getTotalCharge() {
		return rentals.stream().mapToDouble(Rental::getCharge).sum();
	}

	private int getTotalFrequentRenterPoints() {
		return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
	}
}
