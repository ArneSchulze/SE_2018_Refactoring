package se.fowler.refactoring.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    protected void testGetAmount() {
        final Price price = new RegularPrice();
        final Movie movie1 = new Movie("testTitle", price);
        final int daysRented = 2;

        assertEquals(price.getAmount(daysRented), movie1.getAmount(daysRented));

        final Movie movie2 = new Movie(null, null);

        assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                movie2.getAmount(2);
            }
        });
    }

    @Test
    protected void testGetFrequentRenterPoints() {
        final Price price = new RegularPrice();
        final Movie movie1 = new Movie("testTitle", price);
        final int daysRented = 2;

        assertEquals(price.getFrequentRenterPoints(daysRented), movie1.getFrequentRenterPoints(daysRented));

        final Movie movie2 = new Movie(null, null);

        assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                movie2.getFrequentRenterPoints(2);
            }
        });
    }

    @Test
    protected void testMovieInstantiation() {
        final String title = "test";
        final Price price = new RegularPrice();
        final Movie movie1 = new Movie(title, price);

        assertEquals(title, movie1.getTitle());
        assertEquals(price, movie1.getPrice());

        final Movie movie2 = new Movie(null, null);

        assertNull(movie2.getPrice());
        assertNull(movie2.getTitle());

        movie2.setPrice(price);

        assertEquals(price, movie2.getPrice());
    }
}
