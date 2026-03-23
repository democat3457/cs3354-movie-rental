import java.util.ArrayList;

public class Customer {
    private final String _name;
    private final ArrayList<Rental> _rentals = new ArrayList<>();
    private double totalAmount          = 0;
    private int    frequentRenterPoints = 0;
    
    public Customer(String name) {
        _name = name;
    }
    
    public void addRental(Rental arg) {
        _rentals.add(arg);
        totalAmount += arg.computeRentalPrice();
        frequentRenterPoints += arg.computeFrequentRentalPoints();
    }
    
    public String getName() {
        return _name;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }
    
    public String generateStatement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        
        for (Rental rental : _rentals) {
            // show figures for this rental
            result
                    .append("\t")
                    .append(rental.getMovieTitle())
                    .append("\t")
                    .append(rental.computeRentalPrice())
                    .append("\n");
        }
        
        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
        return result.toString();
    }

    public String generateXMLStatement() {
        StringBuilder result = new StringBuilder("<statement>\n");
        result.append("\t<name> ").append(getName()).append(" </name>\n");
        
        for (Rental rental : _rentals) {
            result.append("\t<rental>\n");
            result.append("\t\t<movie> ").append(rental.getMovieTitle()).append(" </movie>\n");
            result.append("\t\t<price> ").append(rental.computeRentalPrice()).append(" </price>\n");
            result.append("\t</rental>\n");
        }
        
        result.append("\t<amountOwed> ").append(totalAmount).append(" </amountOwed>\n");
        result.append("\t<frequentRenterPoints> ").append(frequentRenterPoints).append(" </frequentRenterPoints>\n");
        result.append("</statement>\n");
        return result.toString();
    }
}
