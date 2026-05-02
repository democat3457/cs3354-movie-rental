package strategy.pricing;

import entity.Rental;

public class OneDollarOffCouponDecorator extends CouponDecorator {

    public OneDollarOffCouponDecorator(RentalPricingStrategy baseStrategy) {
        super(baseStrategy);
    }

    @Override
    public double computeRentalPrice(Rental rental) {
        double price = super._baseStrategy.computeRentalPrice(rental);
        if (price > 5.0) {
            return price - 1.0;
        }
        return price;
    }
}
