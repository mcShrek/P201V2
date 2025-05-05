import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Movie> movieList = new ArrayList<>();
    private List<Show> showList = new ArrayList<>();
    private List<Tarif> tarifList = new ArrayList<>();

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
    public void loadTarifs() {
            tarifList.add(TarifFactory.createTarif("normal"));
            tarifList.add(TarifFactory.createTarif("discounted"));
    }
    public List<Tarif> getTarifList() {
        return tarifList;
    }
    public void loadMovies() {
        Movie matrix = new Movie("The Matrix Resurrections", "matrix", 148, 12);
        Movie starWars = new Movie("Star Wars: The Force Awakens ", "star wars", 136, 14);
        Movie avatar = new Movie("Avatar: The Way of Water", "avatar", 190, 16);
        Movie avengers = new Movie("Avengers: Infinity War", "avengers", 149, 14);
        movieList.add(matrix);
        movieList.add(starWars);
        movieList.add(avatar);
        movieList.add(avengers);

        //May
        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 5, 7), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 5, 8), LocalTime.of(18, 30) , matrix,(new Room(1))));


        showList.add(new Show (LocalDate.of(2025, 5, 4), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 5, 4), LocalTime.of(20, 0), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(20, 0), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(20, 0), starWars,(new Room(2))));

        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(21, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(17, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(22, 30), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 5, 7), LocalTime.of(21, 0), avatar,(new Room (3))));

        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(13, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(17, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 5), LocalTime.of(21, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(13, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(17, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 6), LocalTime.of(21, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 7), LocalTime.of(13, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 7), LocalTime.of(17, 30), avengers,(new Room(4))));
        showList.add(new Show (LocalDate.of(2025, 5, 7), LocalTime.of(21, 30), avengers,(new Room(4))));

        //June

        showList.add(new Show (LocalDate.of(2025, 6, 5), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 6, 6), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 6, 7), LocalTime.of(18, 30) , matrix,(new Room(1))));

        showList.add(new Show (LocalDate.of(2025, 6, 4), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 6, 4), LocalTime.of(20, 0), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 6, 5), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 6, 5), LocalTime.of(20, 0), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 6, 6), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 6, 6), LocalTime.of(20, 0), starWars,(new Room(2))));

        showList.add(new Show (LocalDate.of(2025, 6, 5), LocalTime.of(21, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 6, 6), LocalTime.of(17, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 6, 6), LocalTime.of(21, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 6, 7), LocalTime.of(21, 0), avatar,(new Room (3))));


        //July

        showList.add(new Show (LocalDate.of(2025, 7, 5), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 7, 6), LocalTime.of(18, 30) , matrix,(new Room(1))));
        showList.add(new Show (LocalDate.of(2025, 7, 7), LocalTime.of(18, 30) , matrix,(new Room(1))));

        showList.add(new Show (LocalDate.of(2025, 7, 4), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 7, 4), LocalTime.of(20, 0), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 7, 5), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 7, 5), LocalTime.of(20, 0), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 7, 6), LocalTime.of(16, 30), starWars,(new Room(2))));
        showList.add(new Show (LocalDate.of(2025, 7, 6), LocalTime.of(20, 0), starWars,(new Room(2))));

        showList.add(new Show (LocalDate.of(2025, 7, 5), LocalTime.of(21, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 7, 6), LocalTime.of(17, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 7, 6), LocalTime.of(21, 0), avatar,(new Room (3))));
        showList.add(new Show (LocalDate.of(2025, 7, 7), LocalTime.of(21, 0), avatar,(new Room (3))));
    }
}
