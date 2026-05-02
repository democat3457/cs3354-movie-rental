import entity.Customer;
import entity.Rental;
import strategy.pricing.HalfOffCouponDecorator;
import strategy.pricing.OneDollarOffCouponDecorator;

public class Main {
    public static void main(String[] args) {
        Customer c = new Customer("Joe Doe", 58);
        c.addRental(Rental.createChildrensRental("Finding Nemo", 4));
        c.addRental(Rental.createNewReleaseRental("Iron Lung", 2));
        c.addRental(Rental.createRegularRental("Independence Day", 3));
        
        // Combining two coupons: 50% off and then $1 off (if price > $5)
        Rental couponRental = Rental.createRegularRental("The Matrix", 6);
        couponRental.setPricingStrategy(
                new OneDollarOffCouponDecorator( // This coupon wont apply becuase price < $5 after 50% off
                        new HalfOffCouponDecorator(couponRental.getPricingStrategy())
                )
        );
        c.addRental(couponRental);
        
        c.printStatements();

        Customer c2 = new Customer("Colin Wong", 22);
        c2.addRental(Rental.createNewReleaseRental("Project Hail Mary", 1));
        c2.printStatements();
    }
}
