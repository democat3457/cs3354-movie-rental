package entity;

import strategy.frequentrentalpoint.TenDollarBonusPointDecorator;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final List<Rental> _rentals;

    public Transaction(List<Rental> rentals) {
        _rentals = new ArrayList<>(rentals);
        // Apply 10 bonus points decorator for $10+ rentals
        for (Rental rental : _rentals) {
            rental.setFrequentRentalPointStrategy(
                    new TenDollarBonusPointDecorator(rental.getFrequentRentalPointStrategy())
            );
        }
    }

    public List<Rental> getRentals() {
        return _rentals;
    }

    public double computeTotalPrice() {
        double total = 0;
        for (Rental rental : _rentals) {
            total += rental.computeRentalPrice();
        }
        return total;
    }

    public int computeTotalPoints() {
        int points = 0;
        for (Rental rental : _rentals) {
            points += rental.computeFrequentRentalPoints();
        }
        // 20 bonus points for 4+ rentals in a transaction
        if (_rentals.size() >= 4) {
            points += 20;
        }
        return points;
    }
}
