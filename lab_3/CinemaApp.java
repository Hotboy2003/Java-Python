import java.util.List;
import java.util.Scanner;

public class CinemaApp {
    public static void adminLogin(ListTheaters theaters, Scanner scanner) {
        System.out.print("Введите пароль: ");
        String password = scanner.next();

        if (password.equals("admin123")) {
            System.out.println("Вход выполнен успешно!");
            adminMenu(theaters, scanner);
        } else {
            System.out.println("Непраильный пароль, попробуйте еще раз!");
        }
    }

    public static void adminMenu(ListTheaters theaters, Scanner scanner) {
        while (true) {
            ListTheaters.getTheaters();
            System.out.println("Меню админа");
            System.out.println("1. Добавить кинотеатр");
            System.out.println("2. Добавить кинозал");
            System.out.println("3. Убрать кинозал");
            System.out.println("4. Добавить сеанс");
            System.out.println("5. Убрать сеанс");
            System.out.println("6. Выйти в главное меню");
            System.out.print("Введите свой выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTheater(theaters, scanner);
                    break;
                case 2:
                    addCinemaHall(ListTheaters.getTheater(scanner), scanner);
                    break;
                case 3:
                    removeCinemaHall(ListTheaters.getTheater(scanner), scanner);
                    break;
                case 4:
                    addMovie(ListTheaters.getCinemaHall(ListTheaters.getTheater(scanner),scanner), scanner);
                    break;
                case 5:
                    removeMovie(ListTheaters.getCinemaHall(ListTheaters.getTheater(scanner),scanner), scanner);
                case 6:
                    return;
            }
        }
    }

    public static void addTheater(ListTheaters theaters, Scanner scanner) {
        System.out.println("Введите название кинотеатра");
        String nameTheater = scanner.next();
        Theater theater = new Theater(nameTheater);
        ListTheaters.addTheater(theater);
        System.out.println("Кинотеатр добавлен");
    }

    public static void addCinemaHall(Theater theater, Scanner scanner) {
        System.out.print("Введите номер зала: ");
        int hallNumber = scanner.nextInt();
        System.out.print("Введите количество рядов: ");
        int rowCount = scanner.nextInt();
        System.out.print("Введите количество мест в ряду: ");
        int columnCount = scanner.nextInt();

        CinemaHall cinemaHall = new CinemaHall(hallNumber, rowCount, columnCount);
        theater.addCinemaHall(cinemaHall);
        System.out.println(Theater.cinemaHalls.get(0).toString());
        System.out.println("Кинозал добавлен успешно!");
    }

    public static void removeCinemaHall(Theater theater, Scanner scanner) {
        ListTheaters.getCinemaHalls();
        int hallNumber = scanner.nextInt();
        CinemaHall hallToRemove = null;

        for (CinemaHall cinemaHall : Theater.cinemaHalls) {
            if (CinemaHall.getHallNumber() == hallNumber) {
                hallToRemove = cinemaHall;
                break;
            }
        }

        if (hallToRemove != null) {
            theater.removeCinemaHall(hallToRemove);
            System.out.println("Кинозал удален успешно!");
        } else {
            System.out.println("Кинозал не найден.");
        }
    }

    public static void addMovie(CinemaHall cinemaHall, Scanner scanner) {
        System.out.print("Введите название фильма: ");
        String title = scanner.next();
        System.out.print("Введите время показа фильма: ");
        String time = scanner.next();

        Movie movie = new Movie(title, time);
        CinemaHall.movies.add(movie);
        System.out.println("Фильм добавлен успешно!!");
    }

    public static void removeMovie(CinemaHall cinemaHall, Scanner scanner) {
        System.out.print("Введите название фильма: ");
        String title = scanner.next();

        List<Movie> movies = cinemaHall.getMovies();
        Movie movieToRemove = null;

        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                movieToRemove = movie;
                break;
            }
        }

        if (movieToRemove != null) {
            cinemaHall.removeMovie(movieToRemove);
            System.out.println("Фильм удален успешно!");
        } else {
            System.out.println("Фильм не найден.");
        }
    }

    public static void userLogin(ListTheaters theater, Scanner scanner) {
        while (true) {
            System.out.println("1. Посмотреть все сеансы");
            System.out.println("2. Купить билеты");
            System.out.print("Введите свой выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CinemaApp.getNextMovie(theater, scanner);
                    break;
                case 2:
                    CinemaApp.buyTickets(ListTheaters.getCinemaHall(ListTheaters.getTheater(scanner),scanner), scanner);
                    break;
                case 5:
                    return;
            }
        }
    }

    private static void buyTickets(CinemaHall cinemaHall, Scanner scanner) {
        Theater.displayCinemaHallPlan(cinemaHall);
        System.out.println("Введите ряд: ");
        int row = scanner.nextInt();
        System.out.println("Введите номер места");
        int column = scanner.nextInt();
        CinemaHall.purchaseTicket(row, column);
    }


    private static void getNextMovie(ListTheaters listTheaters, Scanner scanner) {
        for (int i=0; i<ListTheaters.theaters.size(); i++) {
            for (int j=0; j < Theater.cinemaHalls.size(); j++) {
                for (int k=0; k < CinemaHall.movies.size(); k++) {
                    System.out.println(ListTheaters.theaters.get(i).toString() + " " + Theater.cinemaHalls.get(j).toString() + " " + CinemaHall.movies.get(k).toString());
                }
            }
        }
    }
}