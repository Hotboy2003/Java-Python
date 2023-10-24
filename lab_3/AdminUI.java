import java.util.ArrayList;
import java.util.Scanner;

public class AdminUI extends UI{
    public AdminUI()
    {
        super();
    }
    public AdminUI(ArrayList<Cinema> cinemas)
    {
        super(cinemas);
    }
    private String[] actions = {"Добавить кинотеатр", "Добавить зал в кинотеатр", "Задать конфигурацию кресел"
            ,"Создать сеанс фильма", "Завершить работу программы"};

    public void printActions() {
        System.out.println("Для выбора действия введите номер операции:");
        for(int i =0; i < this.actions.length; i++)
            System.out.println(i+". " + actions[i]);
        System.out.println();
    }

    @Override
    public void update() {
        super.update();
        Scanner in = new Scanner(System.in);
        while(actions[selectedAction] != "Завершить работу программы") {
            showCreated();
            printActions();
            while(true) {
                try {
                    selectedAction = Integer.parseInt(in.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Некорректный ввод");
                }
            }
            switch(selectedAction)
            {
                case 0:
                    addCinema(new Cinema());
                    break;
                case 1:
                    addHall(in);
                    break;
                case 2:
                    setSeatsConfigurationForHall(in);
                    break;
                case 3:
                    addSession(in);
                    break;
                default:
                    break;
            }
        }
    }
    public void addCinema(Cinema cinema)
    {
        this.cinemas.add(cinema);
    }

    public void addHall(Scanner in)
    {
        System.out.print("\nВведите номер кинотеатра из списка доступных: ");
        for(int i = 0; i < cinemas.size(); i++)
        {
            System.out.println("Кинотеатр №" + i);
        }
        int selectedCinema = 0;
        while(true) {
            try {
                selectedCinema = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        cinemas.get(selectedCinema).addHall(new Hall());
    }
    public void setSeatsConfigurationForHall(Scanner in)
    {
        System.out.println("\nВведите номер кинотеатра и зала из списка доступных: ");
        showCreated();
        int numOfCinema=0, numOfHall=0, numOfRows =0, numOfCols=0 ;
        while(true) {
            try {
                numOfCinema = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        while(true) {
            try {
                numOfHall = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        System.out.print("\nВведите количество рядов в зале: ");
        while(true) {
            try {
                numOfRows = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        System.out.print("\nВведите максимальное число мест в ряду: ");
        while(true) {
            try {
                numOfCols = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        boolean[][] configuration = new boolean[numOfRows][numOfCols];
        for(int i = 0; i < numOfRows; i++)
        {
            System.out.print("\nВведите конфигурацию мест в " + i + " ряду с помощью 1(есть место) и 0(нет места): ");
            for(int j = 0; j < numOfCols; j++)
            {
                configuration[i][j] = Integer.parseInt(in.next()) == 1;
            }
        }
        cinemas.get(numOfCinema).getHall(numOfHall).setSeatsConfiguration(configuration);
    }
    public void addSession(Scanner in)
    {
        System.out.println("\nВведите номер кинотеатра и зала из списка доступных: ");
        showCreated();
        int numOfCinema=0, numOfHall=0;
        while(true) {
            try {
                numOfCinema = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        while(true) {
            try {
                numOfHall = Integer.parseInt(in.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Некорректный ввод");
            }
        }
        String name = "", begin = "", end = "";
        System.out.println("Введите название фильма, его начало и конец в формате dd.MM.y,HH:mm");
        name = in.next();
        begin = in.next();
        end = in.next();
        if(!cinemas.get(numOfCinema).getHall(numOfHall).addSession(name,begin,end))
            System.out.println("Сеанс пересекается по времени с другим сеансом в этом зале!");
    }
}

