public class NewReleaseRental extends Rental {

    public NewReleaseRental(String movieTitle, int daysRented) {
        super(movieTitle, daysRented);
    }

    @Override
    public double computeRentalPrice() {
        return this.getDaysRented() * 3;
    }

    @Override
    public int computeFrequentRentalPoints() {
        int points = super.computeFrequentRentalPoints();
        if (this.getDaysRented() > 1) {
            points += 1;
        }
        return points;
    }
}
