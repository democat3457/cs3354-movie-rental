package strategy.frequentrentalpoint;

import entity.Rental;

public class TenDollarBonusPointDecorator implements FrequentRentalPointStrategy {
    private final FrequentRentalPointStrategy _baseStrategy;

    public TenDollarBonusPointDecorator(FrequentRentalPointStrategy baseStrategy) {
        this._baseStrategy = baseStrategy;
    }

    @Override
    public int computeFrequentRentalPoints(Rental rental) {
        return _baseStrategy.computeFrequentRentalPoints(rental) + 10;
    }
}
