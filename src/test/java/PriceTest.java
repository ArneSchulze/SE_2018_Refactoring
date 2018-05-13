import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceTest {

    @Test
    void testGetRegularCharge() {
        Price price = new RegularPrice();

        double expected1 = 2;
        assertEquals(expected1, price.getAmount(1));

        double expected2 = 3.5;
        assertEquals(expected2, price.getAmount(3));

        double expected3 = 2;
        assertEquals(expected3, price.getAmount(-1));
        assertEquals(expected3, price.getAmount(0));
    }

    @Test
    void testChildrenCharge() {
        Price price = new ChildrenPrice();

        double expected1 = 1.5;
        assertEquals(expected1, price.getAmount(1));

        double expected2 = 3;
        assertEquals(expected2, price.getAmount(4));

        double expected3 = 1.5;
        assertEquals(expected3, price.getAmount(-1));
        assertEquals(expected3, price.getAmount(0));
    }

    @Test
    void testNewReleasePrice() {
        Price price = new NewReleasePrice();

        double expected1 = 3;
        assertEquals(expected1, price.getAmount(1));

        double expected2 = 6;
        assertEquals(expected2, price.getAmount(2));

        double expected3 = -3;
        assertEquals(expected3, price.getAmount(-1));

        double expected4 = 0;
        assertEquals(expected4, price.getAmount(0));
    }

    @Test
    void testFrequentRenterPoints() {
        Price regular = new RegularPrice();
        Price children = new ChildrenPrice();
        Price newRelease = new NewReleasePrice();

        int expected1 = 1;
        assertEquals(expected1, regular.getFrequentRenterPoints(1));
        assertEquals(expected1, regular.getFrequentRenterPoints(0));
        assertEquals(expected1, regular.getFrequentRenterPoints(-1));

        assertEquals(expected1, children.getFrequentRenterPoints(1));
        assertEquals(expected1, children.getFrequentRenterPoints(0));
        assertEquals(expected1, children.getFrequentRenterPoints(-1));

        assertEquals(expected1, newRelease.getFrequentRenterPoints(1));
        assertEquals(expected1, newRelease.getFrequentRenterPoints(0));
        assertEquals(expected1, newRelease.getFrequentRenterPoints(-1));

        int expected2 = 2;

        assertEquals(expected2, newRelease.getFrequentRenterPoints(2));
    }
}
