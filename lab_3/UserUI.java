import java.text.SimpleDateFormat;
import java.util.*;

public class UserUI extends UI{

    private String[] actions = {"Получить данные о ближайшем показе фильма", "Купить билет на фильм"};

    private HashMap<String, int[]> films = new HashMap<String,  int[]>();

    public UserUI() {
        super();
    }

    public UserUI(ArrayList<Cinema> cinemas) {
        super(cinemas);
        int numOfCinema=0,numOfHall=0,numOfSession=0;
        Date minDate = new Date();
        for(Cinema cinema : cinemas)
        {
            for (Hall hall : cinema.getHalls())
            {
                for (Session session : hall.getSessions())
                {
                    if(session.thereAreFreeSeats()) {
                        if (!films.containsKey(session.getName()))
                            films.put(session.getName(), new int[]{numOfCinema, numOfHall, numOfSession});
                        else if (minDate.getTime() > session.getBeginDate().getTime()) {
                            films.put(session.getName(), new int[]{numOfCinema, numOfHall, numOfSession});
                            minDate = session.getBeginDate();
                        }
                        numOfSession++;
                    }
                }
                numOfHall++;
            }
            numOfCinema++;
        }
    }

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
                    getDataAboutFilm(in);
                    break;
                case 1:
                    buyTicket(in);
                    break;
                default:
                    break;
            }
        }
    }

    public void getDataAboutFilm(Scanner in)
    {
        System.out.println("Введите название фильма из списка доступных: ");
        showFilms();
        String filmName = in.next();
        if(films.containsKey(filmName))
        {
            int[] way = films.get(filmName);
            String date = new
                    SimpleDateFormat("dd.MM.y,HH:mm").format(cinemas.get(way[0]).getHall(way[1]).getSession(way[2]).getBeginDate());
            System.out.println("Ближайший сеанс фильма " + filmName + " будет в Кинотеатре №"
                    + way[0] +", Зал №" + way[1] + ", начало в " + date + "\n");
        }
        else
            System.out.println("Введено неверное название фильма!");
    }

    public void buyTicket(Scanner in)
    {
        System.out.println("Введите название фильма из списка доступных: ");
        showFilms();
        String filmName = in.next();
        if(films.containsKey(filmName))
        {
            int[] way = films.get(filmName);
            System.out.println("План зала для указанного сеанса: ");
            printHallPlanForSession(way);
            System.out.print("Укажите номер ряда и номер места, которое желаете приобрести: ");
            int row = 0, col = 0;
            while(true) {
                try {
                    row = Integer.parseInt(in.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Некорректный ввод");
                }
            }
            while(true) {
                try {
                    col = Integer.parseInt(in.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Некорректный ввод");
                }
            }
            if(cinemas.get(way[0]).getHall(way[1]).getSession(way[2]).buyTicket(row, col))
                System.out.println("Билет приобретён!");
            else
                System.out.println("Выбранное место недоступно для покупки!");
        }
        else
            System.out.println("Введено неверное название фильма!");
    }
    public void printHallPlanForSession(int[] way)
    {
        System.out.println(cinemas.get(way[0]).getHall(way[1]).getSession(way[2]).getHallPlanForSession());
    }
    public void showFilms()
    {
        for(String filmName : films.keySet())
            System.out.println(filmName);
    }


}
