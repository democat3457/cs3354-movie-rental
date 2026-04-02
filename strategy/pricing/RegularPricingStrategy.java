package strategy.pricing;
import entity.Rental;

public class RegularPricingStrategy implements RentalPricingStrategy {
    public double computeRentalPrice(Rental rental) {
        double amount = 2;
        if (rental.getDaysRented() > 2) {
            amount += (rental.getDaysRented() - 2) * 1.5;
        }
        return amount;
    }
}
