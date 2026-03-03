public abstract class Rental {
    private final String movieTitle;
    private int   _daysRented;
    
    public Rental(String movieTitle, int daysRented) {
        this.movieTitle = movieTitle;
        _daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return _daysRented;
    }
    
    public String getMovieTitle() {
        return movieTitle;
    }

    public abstract double getRentalPrice();

    public abstract int getFrequentRentalPointContribution();
}