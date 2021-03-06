package se.fowler.refactoring.model;

public interface Price {

    double getAmount(int daysRented);

    int getFrequentRenterPoints(int daysRented);
}
