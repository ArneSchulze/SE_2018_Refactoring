package se.fowler.refactoring.model;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name){
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        StringBuilder result = new StringBuilder("se.fowler.refactoring.model.Rental Record for " + name + "\n");
        result.append("\tTitle\t\tDays\tAmount\n");

        for (Rental rental: rentals) {
            result
                    .append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t\t")
                    .append(rental.getDaysRented())
                    .append("\t")
                    .append(String.valueOf(rental.getAmount()))
                    .append("\n");
        }
        //add footer lines
        result
                .append("Amount owed is ")
                .append(String.valueOf(getTotalCharge()))
                .append("\nYou earned ")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append(" frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental: rentals) {
            result += rental.getAmount();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental: rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}
    