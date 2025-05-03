import java.time.LocalDate;
import java.time.LocalTime;

public class Movie {
    private String movieName;
    private String shortName;
    private int duration;

    public Movie(String movieName, String shortName, int duration) {
        this.movieName = movieName;
        this.shortName = shortName;
        this.duration = duration;
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
}
