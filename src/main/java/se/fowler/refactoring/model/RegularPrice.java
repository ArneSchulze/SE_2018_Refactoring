package se.fowler.refactoring.model;

public class RegularPrice implements Price {

    public double getAmount(int daysRented) {
        if(daysRented > 2) {
            return 2 + (daysRented - 2) * 1.5;
        }

        return 2;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
