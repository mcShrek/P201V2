import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ticket {

    private int room;
    private Tarif tarif;
    private Show show;

    public Ticket(Show show, int room, Tarif tarif) { // Room room zu int room geändert
        this.show = show;
        this.room = room;
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return ("Ticket\n" + show.toString() +
                "Room: " + room + "\n"
                + "Tarif: " + tarif.getName());
    }
}
