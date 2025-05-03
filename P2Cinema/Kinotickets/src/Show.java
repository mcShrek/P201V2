import java.time.LocalDate;
import java.time.LocalTime;

public class Show {

    private LocalDate date;
    private LocalTime startTime;
    private Movie movie;
    private Room room;

    public Show(LocalDate date, LocalTime startTime, Movie movie, Room room ) {
        this.date = date;
        this.startTime = startTime;
        this.movie = movie;
        this.room = room;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }
    public Room getRoom(){
        return room;
    }
    @Override
    public String toString() {
        return "Name: " + movie.getMovieName() + "  --  Start time(entrance starts 10min before): " + getStartTime() + "  --  Duration: " + movie.getDuration()+ " min\n";

    }
}
