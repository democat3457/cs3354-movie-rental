package strategy.pricing;

import entity.Rental;

public abstract class CouponDecorator implements RentalPricingStrategy {
    protected final RentalPricingStrategy _baseStrategy;

    public CouponDecorator(RentalPricingStrategy baseStrategy) {
        this._baseStrategy = baseStrategy;
    }

    @Override
    public abstract double computeRentalPrice(Rental rental);
}
