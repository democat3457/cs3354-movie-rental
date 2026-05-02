package strategy.pricing;

import entity.Rental;

public class OneDollarOffCouponDecorator implements RentalPricingStrategy {
    private final RentalPricingStrategy _baseStrategy;

    public OneDollarOffCouponDecorator(RentalPricingStrategy baseStrategy) {
        this._baseStrategy = baseStrategy;
    }

    @Override
    public double computeRentalPrice(Rental rental) {
        double price = this._baseStrategy.computeRentalPrice(rental);
        if (price > 5.0) {
            return price - 1.0;
        }
        return price;
    }
}
