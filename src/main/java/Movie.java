class Movie {
    private final String title;
    private Price price;
    Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }
    Price getPrice() {
        return price;
    }
    void setPrice(Price newPrice) {
        price = newPrice;
    }
    String getTitle(){
        return title;
    }

    double getAmount(int daysRented) {
        return price.getAmount(daysRented);
    }
    int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}