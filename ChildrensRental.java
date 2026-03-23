public class ChildrensRental extends Rental {

    public ChildrensRental(String movieTitle, int daysRented) {
        super(movieTitle, daysRented);
    }

    @Override
    public double computeRentalPrice() {
        double amount = 1.5;
        if (getDaysRented() > 3) {
            amount += (getDaysRented() - 3) * 1.5;
        }
        return amount;
    }
}
