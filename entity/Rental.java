package entity;

import strategy.frequentrentalpoint.CollegeAgeNewReleaseFrequentRentalPointStrategy;
import strategy.frequentrentalpoint.FrequentRentalPointStrategy;
import strategy.frequentrentalpoint.NewReleaseFrequentRentalPointStrategy;
import strategy.frequentrentalpoint.RegularFrequentRentalPointStrategy;
import strategy.pricing.ChildrensPricingStrategy;
import strategy.pricing.NewReleasePricingStrategy;
import strategy.pricing.RegularPricingStrategy;
import strategy.pricing.RentalPricingStrategy;

public class Rental {
    private final String _movieTitle;
    private final int _daysRented;
    private final RentalPricingStrategy _pricingStrategy;
    private final FrequentRentalPointStrategy _frequentRentalPointStrategy;
    
    private Rental(String movieTitle, int daysRented, RentalPricingStrategy pricingStrategy, FrequentRentalPointStrategy frequentRentalPointStrategy) {
        _movieTitle = movieTitle;
        _daysRented = daysRented;
        _pricingStrategy = pricingStrategy;
        _frequentRentalPointStrategy = frequentRentalPointStrategy;
    }

    public static Rental createRegularRental(String movieTitle, int daysRented) {
        return new Rental(movieTitle, daysRented, new RegularPricingStrategy(), new RegularFrequentRentalPointStrategy());
    }

    public static Rental createNewReleaseRental(String movieTitle, int daysRented) {
        return new Rental(movieTitle, daysRented, new NewReleasePricingStrategy(), new NewReleaseFrequentRentalPointStrategy());
    }

    public static Rental createChildrensRental(String movieTitle, int daysRented) {
        return new Rental(movieTitle, daysRented, new ChildrensPricingStrategy(), new RegularFrequentRentalPointStrategy());
    }

    public static Rental createCollegeAgeNewReleaseRental(String movieTitle, int daysRented) {
        return new Rental(movieTitle, daysRented, new ChildrensPricingStrategy(), new CollegeAgeNewReleaseFrequentRentalPointStrategy());
    }

    public int getDaysRented() {
        return _daysRented;
    }
    
    public String getMovieTitle() {
        return _movieTitle;
    }

    public String getStringRepresentation() {
        return getMovieTitle() + "\t$" + computeRentalPrice();
    }

    public String getXmlRepresentation() {
        return "<rental>\n" +
                "\t<movie> " + getMovieTitle() + " </movie>\n" +
                "\t<price> " + computeRentalPrice() + " </price>\n" +
                "</rental>";
    }

    public int computeFrequentRentalPoints() {
        return _frequentRentalPointStrategy.computeFrequentRentalPoints(this);
    }

    public double computeRentalPrice() {
        return _pricingStrategy.computeRentalPrice(this);
    }
}