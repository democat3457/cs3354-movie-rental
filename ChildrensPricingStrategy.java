public class ChildrensPricingStrategy implements RentalPricingStrategy {
    public double computeRentalPrice(Rental rental) {
        double amount = 1.5;
        if (rental.getDaysRented() > 3) {
            amount += (rental.getDaysRented() - 3) * 1.5;
        }
        return amount;
    }
}
