public class ChildrensRental extends Rental {

    public ChildrensRental(String movieTitle, int daysRented) {
        super(movieTitle, daysRented);
    }

    @Override
    public double getRentalPrice() {
        double amount = 1.5;
        if (this.getDaysRented() > 3) {
            amount += (this.getDaysRented() - 3) * 1.5;
        }
        return amount;
    }
}
