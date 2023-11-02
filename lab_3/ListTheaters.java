import java.util.ArrayList;
import java.util.Scanner;

public class ListTheaters {
    protected static ArrayList<Theater> theaters;


    public ListTheaters() {
        theaters = new ArrayList<>();
    }
    public static void addTheater(Theater theater) {
        theaters.add(theater);
    }

    public static void getCinemaHalls() {
        System.out.println("Список доступных кинозалов: ");
        int i = 0;
        for (CinemaHall cinemaHall : Theater.cinemaHalls) {
            System.out.println(i + ". " + CinemaHall.getHallNumber());
            i++;
        }
    }

    public static CinemaHall getCinemaHall(Theater theater, Scanner scanner) {
        ListTheaters.getCinemaHalls();
        int hallNumber = scanner.nextInt();
        return Theater.cinemaHalls.get(hallNumber);
    }

    public static void getTheaters () {
        System.out.println("Список доступных кинотеатров: ");
        int i = 0;
        for (Theater theater : theaters) {
            System.out.println(i + ". " + theater.getName());
            i++;
        }
    }

    public static Theater getTheater(Scanner scanner) {
        ListTheaters.getTheaters();
        int theaterNumber = scanner.nextInt();
        System.out.println(theaters.get(theaterNumber).toString());
        return theaters.get(theaterNumber);
    }
}
