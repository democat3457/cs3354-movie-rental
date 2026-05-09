package strategy.frequentrentalpoint;
import entity.Rental;

public interface FrequentRentalPointStrategy {
    int computeFrequentRentalPoints(Rental rental);
}
