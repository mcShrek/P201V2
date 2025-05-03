import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Movie> movieList = new ArrayList<>();
    private List<Show> showList = new ArrayList<>();

    public List<Movie> getMovieList() {

        return movieList;
    }

    public List<Show> getShowList() {

        return showList;
    }

    public void addMovie(Movie movie) {

        movieList.add(movie);
    }

    public void addShow(Show show) {

        showList.add(show);
    }
    public void loadMovies() {
        Movie matrix = new Movie("The Matrix: Return of the Sith", "matrix", 123, 12);
        Movie inception = new Movie("Inception: Tough Time Never Last", "inception", 250, 14);
        Movie avatar = new Movie("Avatar: The Last Airbender", "avatar", 162, 16);
        movieList.add(matrix);
        movieList.add(inception);
        movieList.add(avatar);
        showList.add(new Show (LocalDate.of(2025, 5, 1), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 5, 1), LocalTime.of(20, 0), inception,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 5, 2), LocalTime.of(17, 0) , avatar,(new Room (2))));
    }
}
