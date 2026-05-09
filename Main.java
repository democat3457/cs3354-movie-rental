import entity.Customer;
import entity.Rental;
import entity.Transaction;
import strategy.pricing.HalfOffCouponDecorator;
import strategy.pricing.OneDollarOffCouponDecorator;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Joe Doe", 58);

        // Combining two coupons: 50% off and then $1 off (if price > $5)
        Rental couponRental = Rental.createRegularRental("The Matrix", 6);
        couponRental.setPricingStrategy(
                new OneDollarOffCouponDecorator( // This coupon won't apply because price < $5 after 50% off
                        new HalfOffCouponDecorator(couponRental.getPricingStrategy())
                )
        );

        // Transaction with 4 rentals -> earns 20 bonus points (Policy B)
        Transaction t1 = new Transaction(c);
        t1.addRental(Rental.createChildrensRental("Finding Nemo", 4));
        t1.addRental(Rental.createNewReleaseRental("Iron Lung", 2));
        t1.addRental(Rental.createRegularRental("Independence Day", 3));
        t1.addRental(couponRental);
        c.addTransaction(t1);
        c.printStatements();

        // Transaction with college-age customer -> earns extra bonus point on each rental
        Customer c2 = new Customer("Colin Wong", 21);
        // Single rental transaction
        Transaction t2 = new Transaction(c2);
        t2.addRental(Rental.createNewReleaseRental("Project Hail Mary", 1));
        c2.addTransaction(t2);
        c2.printStatements();

        // Demonstrating free movie redemption (Policy C: 10 points -> free movie)
        Customer c3 = new Customer("Jane Smith", 30);
        // Add a transaction so Jane earns at least 10 points (4 rentals = 20 bonus points)
        Transaction t3 = new Transaction(c3);
        t3.addRental(Rental.createRegularRental("Mamma Mia", 1));
        t3.addRental(Rental.createRegularRental("The Wizard of Oz", 1));
        t3.addRental(Rental.createRegularRental("Ghostbusters", 1));
        t3.addRental(Rental.createRegularRental("Mary Poppins", 1));
        c3.addTransaction(t3);

        // Free movie: apply via customer's redeemed points
        Rental freeRental = Rental.createRegularRental("Inception", 3);
        c3.redeemFreeMovie(freeRental);

        Transaction t4 = new Transaction(c3);
        t4.addRental(freeRental);
        t4.addRental(Rental.createNewReleaseRental("Dune", 3));
        c3.addTransaction(t4);
        c3.printStatements();
    }
}
