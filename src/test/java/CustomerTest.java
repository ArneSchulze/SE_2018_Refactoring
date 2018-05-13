import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testStatements() {
        Movie testMovie = new Movie("testTitle", Movie.NEW_RELEASE);
        int testDaysRented = 2;
        Rental testRental = new Rental(testMovie, testDaysRented);

        Customer testCustomer = new Customer("testCustomer");
        testCustomer.addRental(testRental);

        String expected = "Rental Record for testCustomer\n\tTitle\t\tDays\tAmount\n\ttestTitle\t\t2\t6.0\nAmount owed is 6.0\nYou earned 2 frequent renter points";
        assertEquals(expected, testCustomer.statement());

        Rental testRental1 = new Rental(testMovie, testDaysRented);
        testCustomer.addRental(testRental1);
        String expected1 = "Rental Record for testCustomer\n\tTitle\t\tDays\tAmount\n\ttestTitle\t\t2\t6.0\n\ttestTitle\t\t2\t6.0\nAmount owed is 12.0\nYou earned 4 frequent renter points";

        assertEquals(expected1, testCustomer.statement());

        Movie testMovie2 = new Movie("testTitle", Movie.NEW_RELEASE);
        int testDaysRented1 = -1;
        Rental testRental2 = new Rental(testMovie2, testDaysRented1);

        Customer testCustomer1 = new Customer("testCustomer");
        testCustomer1.addRental(testRental2);

        String expected2 = "Rental Record for testCustomer\n\tTitle\t\tDays\tAmount\n\ttestTitle\t\t-1\t-3.0\nAmount owed is -3.0\nYou earned 1 frequent renter points";

        assertEquals(expected2, testCustomer1.statement());
    }
}
