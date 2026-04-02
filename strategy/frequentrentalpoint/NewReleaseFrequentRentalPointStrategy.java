package strategy.frequentrentalpoint;
import entity.Rental;

public class NewReleaseFrequentRentalPointStrategy extends RegularFrequentRentalPointStrategy {
    public int computeFrequentRentalPoints(Rental rental) {
        int points = super.computeFrequentRentalPoints(rental);
        if (rental.getDaysRented() > 1) {
            points += 1;
        }
        return points;
    }
}
