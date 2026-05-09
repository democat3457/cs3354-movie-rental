package strategy.frequentrentalpoint;

import entity.Rental;

public class TenDollarBonusPointDecorator implements FrequentRentalPointStrategy {
    private final FrequentRentalPointStrategy _baseStrategy;

    public TenDollarBonusPointDecorator(FrequentRentalPointStrategy baseStrategy) {
        this._baseStrategy = baseStrategy;
    }

    @Override
    public int computeFrequentRentalPoints(Rental rental) {
        int points = _baseStrategy.computeFrequentRentalPoints(rental);
        if (rental.computeRentalPrice() >= 10) {
            points += 10;
        }
        return points;
    }
}
