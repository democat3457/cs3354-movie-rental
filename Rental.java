public abstract class Rental {
    private final String _movieTitle;
    private final int _daysRented;
    
    public Rental(String movieTitle, int daysRented) {
        _movieTitle = movieTitle;
        _daysRented = daysRented;
    }
    
    public int getDaysRented() {
        return _daysRented;
    }
    
    public String getMovieTitle() {
        return _movieTitle;
    }

    public int computeFrequentRentalPoints() {
        return 1;
    }

    public abstract double computeRentalPrice();
}