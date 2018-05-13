package se.fowler.refactoring.model;

public class Rental {
    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    protected int getDaysRented() {
        return daysRented;
    }

    protected Movie getMovie() {
        return movie;
    }

    protected double getAmount() {
        return movie.getAmount(daysRented);
    }

    protected int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}