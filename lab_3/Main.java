import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static int In() {
        String truepassword = "qwerty123";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите роль для входа:");
        System.out.println("1. Админ");
        System.out.println("2. Пользователь");
        int i = scanner.nextInt();
        if (i == 1)
        {
            System.out.println("Введите пароль: ");
            String password = scanner.next();
            if (!Objects.equals(password, truepassword))
            {
                System.out.println("Неверный пароль. Возвращаю вас в главное меню");
                return (0);
            } else {
                return (1);
            }

        } else if (i == 2) {
           return (2);
        } else {
            System.out.println("Неверный ввод! Возвращаю вас в главное меню!");
            return (0);
        }
    }


    public static void main(String[] args)
    {

        ArrayList<Cinema> cinemas = new ArrayList<>();
        boolean[][] seatsConfiguration =
                {{true,true,true,true,true}, {false,true,true,true,false}, {false, false, true, false, false}}   ;
        Hall hall = new Hall(seatsConfiguration);
        Cinema cinema = new Cinema(hall);
        AdminUI aui = new AdminUI(cinemas);

        UserUI uui = new UserUI(cinemas);

        int i = 0;
        while (i == 0)
        {
            i = In();
        }

        if (i == 1)
        {
            aui.addCinema(cinema);
            aui.start();
        } else {
            uui.start();
        }
    }
}