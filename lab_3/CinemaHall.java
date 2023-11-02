import java.util.ArrayList;
import java.util.List;

class CinemaHall {
    private static int hallNumber;
    private int rowCount;
    private int columnCount;
    private static List<List<Seat>> seats;
    protected static ArrayList<Movie> movies;

    public CinemaHall(int hallNumber, int rowCount, int columnCount) {
        this.hallNumber = hallNumber;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.movies = new ArrayList<>();
        this.seats = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            List<Seat> rowSeats = new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                rowSeats.add(new Seat(i, j));
            }
            seats.add(rowSeats);
        }
    }

    public static int getHallNumber() {
        return hallNumber;
    }

    public List<List<Seat>> getSeats() {
        return seats;
    }

//    public boolean isSeatOccupied(int row, int column) {
//        return seats.get(row).get(column).isOccupied();
//    }
//
//    public void setSeatOccupied(int row, int column, boolean occupied) {
//        seats.get(row).get(column).setOccupied(occupied);
//    }

    public static void purchaseTicket(int row, int column) {
        Seat seat = seats.get(row).get(column);
        if (!seat.isOccupied()) {
            seat.setOccupied(true);
            System.out.println("Билет на место " + row + "-" + column + " успешно приобретен.");
        } else {
            System.out.println("Место " + row + "-" + column + " уже занято.");
        }
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Cinema hall name: " + hallNumber; // замените name на соответствующее поле класса
    }
}