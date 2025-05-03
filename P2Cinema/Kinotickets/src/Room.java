import java.util.ArrayList;
import java.util.List;

public class Room  implements Comparable<Room>{
    private int roomNumber;
    private List<Show> shows;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public List<Show> getShows() {
        return shows;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    public int compareTo(Room other) {
        return Integer.compare(this.roomNumber, other.roomNumber);
    }

    public String toString() {
        return "Room " + roomNumber;
}

}