import java.util.ArrayList;
import java.util.Scanner;

public class UI{
    protected int selectedAction;
    protected ArrayList<Cinema> cinemas = new ArrayList<>();
    protected String[] actions = {};
    public UI()
    {
        this.selectedAction = 0;
    }
    public UI(ArrayList<Cinema> cinemas)
    {
        this.selectedAction = 0;
        this.cinemas = cinemas;
    }
    public void start(){
        System.out.println("Билетная система запущена!!!\n");
        update();
    }
    public void update(){}
    public void showCreated()
    {
        String result = new String();
        for(int i = 0; i < cinemas.size(); i++)
            result += "Кинотеатр №" + i + "\n" + cinemas.get(i).toString();
        System.out.print(result);
    }
}
