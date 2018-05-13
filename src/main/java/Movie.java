public class Movie {
    private String title;
    private Price price;
    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price newPrice) {
        price = newPrice;
    }
    public String getTitle (){
        return title;
    }

    public double getAmount(int daysRented) {
        return price.getAmount(daysRented);
    }
    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}