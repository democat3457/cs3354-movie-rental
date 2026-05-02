package strategy.pricing;

import entity.Rental;

public class HalfOffCouponDecorator extends CouponDecorator {

    public HalfOffCouponDecorator(RentalPricingStrategy baseStrategy) {
        super(baseStrategy);
    }

    @Override
    public double computeRentalPrice(Rental rental) {
        return super._baseStrategy.computeRentalPrice(rental) * 0.5;
    }
}
