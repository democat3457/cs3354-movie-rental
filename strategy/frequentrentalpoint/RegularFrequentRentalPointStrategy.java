package strategy.frequentrentalpoint;

import entity.Rental;

public class RegularFrequentRentalPointStrategy implements FrequentRentalPointStrategy {
    @Override
    public int computeFrequentRentalPoints(Rental rental) {
        return 1;
    }
}
