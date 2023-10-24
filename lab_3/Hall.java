import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;

public class Hall{
    protected boolean[][] seatsConfiguration = new boolean[0][0];
    private ArrayList<Session> schedule = new ArrayList<>();
    public Hall()
    {
    }
    public Hall(boolean[][] seatsConfiguration)
    {
        this.seatsConfiguration = seatsConfiguration;
    }

    public String toString()
    {
        String result = "";
        for(Session session : schedule)
        {
            result += "\t\t" + session.toString();
        }
        return result;
    }

    public void setSeatsConfiguration(boolean[][] seatsConfiguration)
    {
        this.seatsConfiguration = seatsConfiguration;
    }

    public boolean checkIfPossibleAndAddSession(Session session)
    {
        for(Session s : this.schedule)
            if(session.isIntersects(s))
                return false;
        this.schedule.add(session);
        return true;
    }

    public ArrayList<Session> getSessions() {return this.schedule;}
    public Session getSession(int i) {return this.schedule.get(i);}
    public boolean addSession(String name, String begin, String end){

        if(name == "") return false;

        Session newSession = new Session(name,begin,end,seatsConfiguration);
        for(Session session : schedule)
            if(newSession.isIntersects(session))
                return false;
        schedule.add(newSession);

        return true;
    }

}
