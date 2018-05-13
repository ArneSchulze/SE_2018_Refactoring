package se.fowler.refactoring.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testGetAmount() {
        final String title = "test";
        final Price price = new RegularPrice();
        final Movie movie = new Movie(title, price);
        final int daysRented = 2;
        final Rental rental1 = new Rental(movie, daysRented);

        assertEquals(movie.getAmount(daysRented), rental1.getAmount());

        final Rental rental2 = new Rental(null, daysRented);

        assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                rental2.getAmount();
            }
        });
    }

    @Test
    void testGetFrequentRenterPoints() {
        final String title = "test";
        final Price price = new RegularPrice();
        final Movie movie = new Movie(title, price);
        final int daysRented = 2;
        final Rental rental1 = new Rental(movie, daysRented);

        assertEquals(movie.getFrequentRenterPoints(daysRented), rental1.getFrequentRenterPoints());

        final Rental rental2 = new Rental(null, daysRented);

        assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                rental2.getFrequentRenterPoints();
            }
        });
    }

    @Test
    void testRentalInstantiation() {
        final String title = "test";
        final Price price = new RegularPrice();
        final Movie movie = new Movie(title, price);
        final int daysRented = 2;
        final Rental rental1 = new Rental(movie, daysRented);

        assertEquals(movie, rental1.getMovie());
        assertEquals(daysRented, rental1.getDaysRented());

        final Rental rental2 = new Rental(null, daysRented);

        assertNull(rental2.getMovie());
    }
}
