package strategy.pricing;
import entity.Rental;

public class NewReleasePricingStrategy implements RentalPricingStrategy {
    public double computeRentalPrice(Rental rental) {
        return rental.getDaysRented() * 3;
    }
}
