import java.time.LocalDate;
import java.time.LocalTime;

public class Movie {
    private String movieName;
    private String shortName;
    private int duration;
    private double price;

    public Movie(String movieName, String shortName, int duration, double price) {
        this.movieName = movieName;
        this.shortName = shortName;
        this.duration = duration;
        this.price = price;
    }

    public String getMovieName() {

        return movieName;
    }

    public String getShortName() {
        return shortName;

    }

    public int getDuration() {

        return duration;
    }

    public double getPrice() {

        return price;
    }
    public void setPrice(int price){

        this.price = price;
    }
    @Override
    public String toString() {
        return movieName + " (" + shortName + "), " + duration + " min, " + String.format("%.2f€", price);
    }

}
