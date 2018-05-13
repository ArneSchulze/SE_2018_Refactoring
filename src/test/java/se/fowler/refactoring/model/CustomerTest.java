package se.fowler.refactoring.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    protected void testStatements() {
        final Movie movie = new Movie("testTitle", new NewReleasePrice());
        final int daysRented = 1;
        final Rental rental = new Rental(movie, daysRented);

        final Customer customer1 = new Customer("test");
        customer1.addRental(rental);

        String expected1 = "se.fowler.refactoring.model.Rental Record for test\n\tTitle\t\tDays\tAmount\n\ttestTitle\t\t1\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points";
        assertEquals(expected1, customer1.statement());

        final Customer customer2 = new Customer("test");

        String expected2 = "se.fowler.refactoring.model.Rental Record for test\n\tTitle\t\tDays\tAmount\nAmount owed is 0.0\nYou earned 0 frequent renter points";

        assertEquals(expected2, customer2.statement());

        final Customer customer3 = new Customer("test");
        customer3.addRental(null);

        assertThrows(NullPointerException.class, new Executable() {
            public void execute() throws Throwable {
                customer3.statement();
            }
        });
    }
}
