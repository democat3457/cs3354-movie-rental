public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Joe Doe");
        c.addRental(Rental.createChildrensRental("Finding Nemo", 4));
        c.addRental(Rental.createNewReleaseRental("Iron Lung", 2));
        c.addRental(Rental.createRegularRental("Independence Day", 3));

        System.out.println("---Regular Statement---");
        System.out.println(c.generateStatement());
        System.out.println();
        System.out.println("---XML Statement---");
        System.out.println(c.generateXMLStatement());
    }
}
