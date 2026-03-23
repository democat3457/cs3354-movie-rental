public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Joe Doe");
        c.addRental(new ChildrensRental("Finding Nemo", 4));
        c.addRental(new NewReleaseRental("Iron Lung", 2));
        System.out.println(c.generateStatement());
        System.out.println(c.generateXMLStatement());
    }
}
