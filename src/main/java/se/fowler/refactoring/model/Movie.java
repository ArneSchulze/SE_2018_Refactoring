package se.fowler.refactoring.model;

public class Movie {
    private final String title;
    private Price price;

    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }

    protected Price getPrice() {
        return price;
    }

    protected void setPrice(Price newPrice) {
        price = newPrice;
    }

    protected String getTitle(){
        return title;
    }

    protected double getAmount(int daysRented) {
        return price.getAmount(daysRented);
    }

    protected int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}