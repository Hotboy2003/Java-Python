import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Session {
    private int[][] seatsSoldOut = new int[0][0];
    private Date begin = new Date();
    private Date end = new Date();

    private String name = "";

    public String toString()
    {
        return (name + " " + new SimpleDateFormat("dd.MM.y,HH:mm").format(begin)
                + " " + new SimpleDateFormat("dd.MM.y,HH:mm").format(end) + "\n");
    }
    public String getName() {return this.name;}
    public Date getBeginDate() {return this.begin;}

    public Session(String name, String begin, String end, boolean[][] seatsConfiguration){
        try{
            DateFormat df = new SimpleDateFormat("dd.MM.y,HH:mm");
            this.begin = df.parse(begin);
            this.end = df.parse(end);
            this.name = name;
            this.seatsSoldOut = new int[seatsConfiguration.length][seatsConfiguration[0].length];
            for(int i = 0; i < seatsConfiguration.length; i++)
                for(int j = 0; j < seatsConfiguration[0].length; j++)
                    this.seatsSoldOut[i][j] = (seatsConfiguration[i][j] ? 0 : -1);
        }
        catch(ParseException exception)
        {
            exception.printStackTrace();
        }
    }
    private String modifyDateLayout(String inputDate) throws ParseException{
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(inputDate);
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }
    public boolean isIntersects(Session other)
    {
        boolean result = false;
        if(this.begin.toString().substring(0,10).equals(other.begin.toString().substring(0,10)))
            if(this.begin.getTime() >= other.begin.getTime() && this.begin.getTime() <=  other.end.getTime()
                    || this.end.getTime() >= other.begin.getTime() && this.end.getTime() <= other.end.getTime())
            {
                result = true;
            }
        return result;
    }

    public boolean thereAreFreeSeats()
    {
        if(seatsSoldOut != null)
            for(int[] row : seatsSoldOut)
                for(int seat : row)
                    if(seat == 0) return true;
        return false;
    }

    public String getHallPlanForSession()
    {
        String result = " ";
        for(int i = 0; i < seatsSoldOut[0].length; i++)
            result += " " + i;
        result += "\n";
        for(int i = 0; i < seatsSoldOut.length; i++)
        {
            result += i + " ";
            for (int j = 0; j < seatsSoldOut[0].length; j++)
            {
                if(seatsSoldOut[i][j] == -1) result += "# ";
                else if(seatsSoldOut[i][j] == 0) result += "С ";
                else result += "З ";
            }
            result += "\n";
        }
        return result;
    }

    public boolean buyTicket(int row, int col)
    {
        if(row >= seatsSoldOut.length || col >= seatsSoldOut[0].length) return false;
        else if(seatsSoldOut[row][col] == -1 || seatsSoldOut[row][col] == 1)  return false;
        else seatsSoldOut[row][col] = 1;
        return true;
    }
}
