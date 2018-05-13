public class ChildrenPrice implements Price {
    public double getAmount(int daysRented) {
        if(daysRented > 3) {
            return (daysRented - 2) * 1.5;
        }

        return 1.5;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
