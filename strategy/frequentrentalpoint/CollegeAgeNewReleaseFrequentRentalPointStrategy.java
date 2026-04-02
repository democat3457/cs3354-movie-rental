package strategy.frequentrentalpoint;

import entity.Rental;

public class CollegeAgeNewReleaseFrequentRentalPointStrategy extends NewReleaseFrequentRentalPointStrategy {
    public int computeFrequentRentalPoints(Rental rental) {
        return 2;
    }
}
