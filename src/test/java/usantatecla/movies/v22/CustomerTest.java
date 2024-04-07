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
    public void chargeForRegularMovie1DayTest() {
        Movie movie = new RegularMovie("Regular Movie");
        Rental rental = new Rental(movie, 1);
        Customer customer = new Customer("Customer Name");
        customer.addRental(rental);

        String statement = customer.statement();
        String result = new StatementBuilder().customerName(customer.getName()).movie(movie.getTitle(), 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void chargeForNewReleaseMovie2DaysTest() {
        Movie movie = new NewReleaseMovie("New Release Movie");
        Rental rental = new Rental(movie, 2);
        Customer customer = new Customer("Customer Name");
        customer.addRental(rental);

        String statement = customer.statement();
        String result = new StatementBuilder().customerName(customer.getName()).movie(movie.getTitle(), 3)
                .totalAmount(3).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void frequentRenterPointsForNewRelease2DaysTest() {
        Movie newReleaseMovie = new NewReleaseMovie("New Release Movie");
        Rental newReleaseRental = new Rental(newReleaseMovie, 2);
        Customer customer = new Customer("Customer Name");
        customer.addRental(newReleaseRental);

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customer.getName()).movie(newReleaseMovie.getTitle(), newReleaseMovie.getCharge(2))
                .totalAmount(newReleaseMovie.getCharge(2)).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void frequentRenterPointsForNewRelease1DayTest() {
        Movie newReleaseMovie = new NewReleaseMovie("New Release Movie");
        Rental newReleaseRental = new Rental(newReleaseMovie, 1);

        Customer customer = new Customer("Customer Name");
        customer.addRental(newReleaseRental);

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customer.getName()).movie(newReleaseMovie.getTitle(), newReleaseMovie.getCharge(1))
                .totalAmount(newReleaseMovie.getCharge(1)).frequentRenterPoints(1).build();
        assertEquals(result, statement);
    }

    @Test
    public void frequentRenterPointsForNewRelease3DaysTest() {
        Movie newReleaseMovie = new NewReleaseMovie("New Release Movie");
        Rental newReleaseRental = new Rental(newReleaseMovie, 3);

        Customer customer = new Customer("Customer Name");
        customer.addRental(newReleaseRental);

        String statement = customer.statement();

        String result = new StatementBuilder().customerName(customer.getName()).movie(newReleaseMovie.getTitle(), newReleaseMovie.getCharge(3))
                .totalAmount(newReleaseMovie.getCharge(3)).frequentRenterPoints(2).build();
        assertEquals(result, statement);
    }

    @Test
    public void statementFormatTest() {
        Customer customer = new Customer("Customer Name");
        Movie regularMovie = new RegularMovie("Regular Movie");
        Movie newReleaseMovie = new NewReleaseMovie("New Release Movie");
        Movie childrenMovie = new ChildrenMovie("Children Movie");

        customer.addRental(new Rental(regularMovie, 3));
        customer.addRental(new Rental(newReleaseMovie, 1));
        customer.addRental(new Rental(childrenMovie, 4));

        String statement = customer.statement();

        String result = new StatementBuilder()
                .customerName(customer.getName())
                .movie(regularMovie.getTitle(), regularMovie.getCharge(3))
                .movie(newReleaseMovie.getTitle(), newReleaseMovie.getCharge(1))
                .movie(childrenMovie.getTitle(), childrenMovie.getCharge(4))
                .totalAmount(
                        regularMovie.getCharge(3) +
                                newReleaseMovie.getCharge(1) +
                                childrenMovie.getCharge(4))
                .frequentRenterPoints(
                        regularMovie.getFrequentRenterPoints(3) +
                                newReleaseMovie.getFrequentRenterPoints(1) +
                                childrenMovie.getFrequentRenterPoints(4)).build();

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
