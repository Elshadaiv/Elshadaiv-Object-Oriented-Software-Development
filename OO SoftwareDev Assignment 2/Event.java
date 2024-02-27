
/**
 * Write a description of class Event here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Event
{
    //Adding the getters and setters 
    private String Comedianname;
    private String Dayofweek;
    private String time;
    private int Tickets;
    private int SurpiseTickets;
    private int cancelledTickets;
    private int SupriseTickets;
    public Event()
    {
        this.Comedianname = "";
        this.Dayofweek = "";
        this.time = "";
        this.Tickets = 0;
        
        
        
    }
    
    public Event(String Comedian, String Dayofweek, String time, int Tickets )
    {
        this.Comedianname = Comedian;
        this.Dayofweek = Dayofweek;
        this.time = time;
        this.Tickets = Tickets;
        
        
        
    }
    
    public String getComedianname()
    {
        return this.Comedianname;
    }
    
    public String getDayofweek()
    {
        return this.Dayofweek;
    }
    
    public String getTime()
    {
        return this.time;
    }
    
    public int getTickets()
    {
        return this.Tickets;
    }
    
    public int getSupriseTickets()
    {
        return 30 - this.Tickets;
    }
    
    public int getTicketsAvaliable()
    {
        return 50 - this.Tickets;
    }
    
    public void cancelledTickets(int cancelledTickets)
    {
         this.cancelledTickets -= Tickets;
    }
    
    public int getcancelledTickets()
    {
        return this.Tickets;
    }
    
    public void setComedianname (String Comedianname)
    {
        this.Comedianname = Comedianname;
    }
    
    public void setDayofweek (String Dayofweek)
    {
        this.Dayofweek = Dayofweek;
    }
    
    public void setTime (String time)
    {
        this.time = time;
    }
    
    public void setTickets(int Tickets)
    {
        this.Tickets += Tickets;
    }
    
        
    
    
    
    
    public String toString()
    {
        return "\nEvent details.." + "\n" +
        "Comedian name : " + this.Comedianname + "\n" +
        "The day it's on : " + this.Dayofweek + "\n" + 
        "The time of day it's on : " + this.time + "\n" +
        " You've brought : " + this.Tickets + " Tickets  " + "\n";
    }

        
}
