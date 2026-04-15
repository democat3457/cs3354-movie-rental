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

    public void addRental(Rental rental) {
        if (_age >= 18 && _age <= 22) {
            rental.setFrequentRentalPointStrategy(
                    new YouthFrequentRentalPointDecorator(rental.getFrequentRentalPointStrategy()));
        }
        _rentals.add(rental);
        _totalAmount += rental.computeRentalPrice();
        _totalFrequentRenterPoints += rental.computeFrequentRentalPoints();
    }

    public String getName() {
        return _name;
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
