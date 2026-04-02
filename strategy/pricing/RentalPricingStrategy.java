package strategy.pricing;
import entity.Rental;

public interface RentalPricingStrategy {
    double computeRentalPrice(Rental rental);
}
