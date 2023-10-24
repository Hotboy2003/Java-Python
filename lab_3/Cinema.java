import java.util.ArrayList;

public class Cinema {
    private ArrayList<Hall> halls = new ArrayList<>();
    public Cinema()
    {
    }
    public Cinema(ArrayList<Hall> halls)
    {
        this.halls = halls;
    }

    public Cinema(Hall hall)
    {
        this.halls.add(hall);
    }

    public String toString()
    {
        String result = new String();
        for(int i = 0; i < halls.size(); i++)
            result += "\tЗал №" + i + "\n" + halls.get(i).toString();
        return  result;
    }

    public void addHall(Hall hall)
    {
        this.halls.add(hall);
    }
    //public ArrayList<Hall> getHalls() {return this.halls;}
    public Hall getHall(int i) {return this.halls.get(i);}
    public ArrayList<Hall>  getHalls() {return this.halls;}
}
