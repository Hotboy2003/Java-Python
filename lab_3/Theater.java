import java.util.ArrayList;
import java.util.List;

class Theater {
    private final String name;
    protected static ArrayList<CinemaHall> cinemaHalls;

    public Theater(String nameTheater) {
        this.name = nameTheater;
        cinemaHalls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCinemaHall(CinemaHall cinemaHall) {
        cinemaHalls.add(cinemaHall);
    }

    public void removeCinemaHall(CinemaHall cinemaHall) {
        cinemaHalls.remove(cinemaHall);
    }



    @Override
    public String toString() {
        return "Theater name: " + name;
    }

    public static void displayCinemaHallPlan(CinemaHall cinemaHall) {
        System.out.println("План зала: 0 - свободно, X - занято");
        List<List<Seat>> seats = cinemaHall.getSeats();
        for (List<Seat> row : seats) {
            for (Seat seat : row) {
                if (seat.isOccupied()) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}