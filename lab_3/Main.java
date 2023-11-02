import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListTheaters theaters = new ListTheaters();

        while (true) {
            System.out.println("1. Вход для админа");
            System.out.println("2. Вход для пользователя");
            System.out.println("3. Выход");
            System.out.print("Введите цифру своего выбора: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CinemaApp.adminLogin(theaters, scanner);
                    break;
                case 2:
                     CinemaApp.userLogin(theaters, scanner);
                     break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
