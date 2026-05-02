package strategy.pricing;

import entity.Rental;

public class HalfOffCouponDecorator implements RentalPricingStrategy {
    private final RentalPricingStrategy _baseStrategy;

    public HalfOffCouponDecorator(RentalPricingStrategy baseStrategy) {
        this._baseStrategy = baseStrategy;
    }

    @Override
    public double computeRentalPrice(Rental rental) {
        return this._baseStrategy.computeRentalPrice(rental) * 0.5;
    }
}
