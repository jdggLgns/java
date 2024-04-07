package usantatecla.movies.v22;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void withoutRentalsTest() {
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName)
                .totalAmount(0).frequentRenterPoints(0).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental1DayTest() {
        Movie movie = new RegularMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);

    }

    @Test
    public void regularRental2DayTest() {
        Movie movie = new RegularMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void regularRental3DayTest() {
        Movie movie = new RegularMovie("movieName");
        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 3.5)
                .totalAmount(3.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental1DayTest() {
        Movie movie = new NewReleaseMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 3)
                .totalAmount(3).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental2DayTest() {
        Movie movie = new NewReleaseMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void newReleaseRental3DayTest() {
        Movie movie = new NewReleaseMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental1DayTest() {
        Movie movie = new ChildrenMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental3DayTest() {
        Movie movie = new ChildrenMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void childrensRental4DayTest() {
        Movie movie = new ChildrenMovie("movieName");

        Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
        String customerName = "customerName";
        Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName).movie(movie.getTitle(), 6)
                .totalAmount(6).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void rentalTest() {
        String customerName = "customerName";
        Customer customer = new Customer(customerName);

        String regularMovieName = "regularMovieName";
        Movie regularMovie = new RegularMovie(regularMovieName);
        Rental regularRental = new Rental(regularMovie, 10);
        customer.addRental(regularRental);

        String newReleaseMovieName = "newReleaseMovieName";
        Movie newReleaseMovie = new NewReleaseMovie(newReleaseMovieName);
        Rental newReleaseRental = new Rental(newReleaseMovie, 10);
        customer.addRental(newReleaseRental);

        String childrensMovieName = "childrensMovieName";
        Movie childrensMovie = new ChildrenMovie(childrensMovieName);
        Rental childrensRental = new Rental(childrensMovie, 10);
        customer.addRental(childrensRental);

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customerName)
                .movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
                .totalAmount(32).frequentRenterPoints(4).build();
        assertEquals(result, statement);
    }


}
