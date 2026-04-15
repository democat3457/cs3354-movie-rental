package strategy.frequentrentalpoint;

import entity.Rental;

public class YouthFrequentRentalPointDecorator implements FrequentRentalPointStrategy {
    private final FrequentRentalPointStrategy _baseStrategy;

    public YouthFrequentRentalPointDecorator(FrequentRentalPointStrategy baseStrategy) {
        this._baseStrategy = baseStrategy;
    }

    @Override
    public int computeFrequentRentalPoints(Rental rental) {
        return this._baseStrategy.computeFrequentRentalPoints(rental) + 1;
    }
}
