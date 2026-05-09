package entity;

import java.util.ArrayList;

import strategy.frequentrentalpoint.YouthFrequentRentalPointDecorator;

public class Customer {
    private final String _name;
    private final int _age;
    private final ArrayList<Rental> _rentals = new ArrayList<>();
    private double _totalAmount = 0;
    private int _totalFrequentRenterPoints = 0;

    public Customer(String name, int age) {
        _name = name;
        _age = age;
    }

    public void printStatements() {
        System.out.println("----" + getName() + "'s Statement" + "----");
        System.out.println("---Regular Statement---");
        System.out.println(generateStatement());
        System.out.println();
        System.out.println("---XML Statement---");
        System.out.println(generateXMLStatement());
        System.out.println();
    }

    public void addTransaction(Transaction transaction) {
        _rentals.addAll(transaction.getRentals());
        _totalAmount += transaction.computeTotalPrice();
        _totalFrequentRenterPoints += transaction.computeTotalPoints();
    }

    public void redeemFreeMovie(Rental rental) throws IllegalStateException {
        if (_totalFrequentRenterPoints >= 10) {
            // Implemented this way to ensure frequent rental points must be taken away
            _totalFrequentRenterPoints -= 10;
            rental.setPricingStrategy(r -> 0); // Set price to 0 with an anonymous strategy with a lambda
            rental.setFrequentRentalPointStrategy(r -> 0); // This transaction shouldn't receive any frequent rental
            // points before decorators
        } else {
            throw new IllegalStateException("Customer does not have enough points for a free movie");
        }
    }

    public String getName() {
        return _name;
    }

    public int getAge() {
        return _age;
    }

    public ArrayList<Rental> getRentals() {
        return _rentals;
    }

    public double getTotalAmount() {
        return _totalAmount;
    }

    public int getTotalFrequentRenterPoints() {
        return _totalFrequentRenterPoints;
    }

    public String generateStatement() {
        StringBuilder result = new StringBuilder("entity.Rental Record for " + getName() + "\n");

        for (Rental rental : _rentals) {
            // show figures for this rental
            result
                    .append("\t")
                    .append(rental.getStringRepresentation())
                    .append("\n");
        }

        // add footer lines
        result.append("Amount owed is $").append(_totalAmount).append("\n");
        result.append("You earned ").append(_totalFrequentRenterPoints).append(" frequent renter points!");
        return result.toString();
    }

    public String generateXMLStatement() {
        StringBuilder result = new StringBuilder("<statement>\n");
        result.append("\t<name> ").append(getName()).append(" </name>\n");

        for (Rental rental : _rentals) {
            String rentalXml = rental
                    .getXmlRepresentation()
                    .replaceAll("(?m)^", "\t"); // Add indentation to match statement indentation
            result.append(rentalXml).append("\n");
        }

        result.append("\t<amountOwed> ").append(_totalAmount).append(" </amountOwed>\n");
        result.append("\t<frequentRenterPoints> ").append(_totalFrequentRenterPoints)
                .append(" </frequentRenterPoints>\n");
        result.append("</statement>\n");
        return result.toString();
    }
}
