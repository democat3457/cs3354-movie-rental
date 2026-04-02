public interface FrequentRentalPointStrategy {
    default int computeFrequentRentalPoints(Rental rental) {
        return 1;
    }
}
