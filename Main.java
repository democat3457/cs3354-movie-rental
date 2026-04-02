import entity.Customer;
import entity.Rental;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Joe Doe");
        c.addRental(Rental.createChildrensRental("Finding Nemo", 4));
        c.addRental(Rental.createNewReleaseRental("Iron Lung", 2));
        c.addRental(Rental.createRegularRental("Independence Day", 3));
        c.printStatements();

        Customer c2 = new Customer("Colin Wong");
        c2.addRental(Rental.createCollegeAgeNewReleaseRental("Project Hail Mary", 1));
        c2.printStatements();
    }
}
