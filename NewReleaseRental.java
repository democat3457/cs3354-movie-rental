public class NewReleaseRental extends Rental {

    public NewReleaseRental(String movieTitle, int daysRented) {
        super(movieTitle, daysRented);
    }

    @Override
    public double getRentalPrice() {
        return this.getDaysRented() * 3;
    }
}
