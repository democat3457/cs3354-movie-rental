public class RegularRental extends Rental {
    public RegularRental(String movieTitle, int daysRented) {
        super(movieTitle, daysRented);
    }

    @Override
    public double getRentalPrice() {
        double amount = 2;
        if (getDaysRented() > 2) {
            amount += (getDaysRented() - 2) * 1.5;
        }
        return amount;
    }
}
