import entity.Customer;
import entity.Rental;
import entity.Transaction;
import strategy.pricing.HalfOffCouponDecorator;
import strategy.pricing.OneDollarOffCouponDecorator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Joe Doe", 58);

        // Combining two coupons: 50% off and then $1 off (if price > $5)
        Rental couponRental = Rental.createRegularRental("The Matrix", 6);
        couponRental.setPricingStrategy(
                new OneDollarOffCouponDecorator( // This coupon wont apply becuase price < $5 after 50% off
                        new HalfOffCouponDecorator(couponRental.getPricingStrategy())
                )
        );

        // Transaction with 4 rentals -> earns 20 bonus points (Policy B)
        Transaction t1 = new Transaction(List.of(
                Rental.createChildrensRental("Finding Nemo", 4),
                Rental.createNewReleaseRental("Iron Lung", 2),
                Rental.createRegularRental("Independence Day", 3),
                couponRental
        ));
        c.addTransaction(t1);

        c.printStatements();

        Customer c2 = new Customer("Colin Wong", 22);
        // Single rental transaction
        Transaction t2 = new Transaction(List.of(
                Rental.createNewReleaseRental("Project Hail Mary", 1)
        ));
        c2.addTransaction(t2);
        c2.printStatements();

        // Demonstrating free movie redemption (Policy C: 10 points -> free movie)
        Customer c3 = new Customer("Jane Smith", 30);
        // Add a transaction so Jane earns at least 10 points (4 rentals = 20 bonus points)
        c3.addTransaction(new Transaction(List.of(
                Rental.createRegularRental("Movie 1", 1),
                Rental.createRegularRental("Movie 2", 1),
                Rental.createRegularRental("Movie 3", 1),
                Rental.createRegularRental("Movie 4", 1)
        )));

        // Free movie: apply via customer's redeemed points
        Rental freeRental = Rental.createRegularRental("Inception", 3);
        c3.redeemFreeMovie(freeRental);

        Transaction t3 = new Transaction(List.of(
                freeRental,
                Rental.createNewReleaseRental("Dune", 3)
        ));
        c3.addTransaction(t3);
        c3.printStatements();
    }
}
