package entity;

import strategy.frequentrentalpoint.TenDollarBonusPointDecorator;
import strategy.frequentrentalpoint.YouthFrequentRentalPointDecorator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final List<Rental> _rentals;
    private final Customer _customer;
    private double totalPrice = 0.0;
    private int totalPoints = 0;

    public Transaction(Customer customer) {
        _rentals = new ArrayList<>();
        _customer = customer;
    }

    public void addRental(Rental rental) {
        // Apply extra rental point decorator for customers aged 18-22
        if (_customer.getAge() >= 18 && _customer.getAge() <= 22 && rental.computeRentalPrice() > 0) {
            rental.setFrequentRentalPointStrategy(
                    new YouthFrequentRentalPointDecorator(rental.getFrequentRentalPointStrategy()));
        }
        // Apply 10 bonus points decorator for $10+ rentals
        if (rental.computeRentalPrice() >= 10) {
            rental.setFrequentRentalPointStrategy(
                    new TenDollarBonusPointDecorator(rental.getFrequentRentalPointStrategy()));
        }
        _rentals.add(rental);
        totalPrice += rental.computeRentalPrice();
        totalPoints += rental.computeFrequentRentalPoints();
    }

    public List<Rental> getRentals() {
        return _rentals;
    }

    public double computeTotalPrice() {
        return totalPrice;
    }

    public int computeTotalPoints() {
        int points = totalPoints;
        // 20 bonus points for 4+ rentals in a transaction
        if (_rentals.size() >= 4) {
            points += 20;
        }
        return points;
    }
}
