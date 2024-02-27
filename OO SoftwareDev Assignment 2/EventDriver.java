import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class EventDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EventDriver
{
    
    ArrayList<Event> list;
    final int SIZE=1;
    public EventDriver()
    {
        list = new ArrayList<Event>();

        System.out.print("\f");

        add5EventsToList();
        
        menu();

        displayEvent();
    }
     // adding the array
    public void add5EventsToList()
    {
        Scanner scan = new Scanner (System.in);
        String Comedianname="";
        String Dayofweek="";
        String time = "";
        int Tickets = 0;
        Event anEvent = null;
        
        for(int count = 0; count < SIZE; count++)
        {
          Comedianname = inputComedianName(count);
          
          Dayofweek = inputDayofweek(count);
          
          time = inputtime(count);
        
          Tickets = inputTickets(count);
          
          
          
          
          anEvent = new Event(Comedianname, Dayofweek, time, Tickets);
          list.add(anEvent);
          
          System.out.print("\f");
          
          
            
        }
        
        
    }
      //Inputing the Comedian name
    public String inputComedianName(int num)
    {
        String name;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Comediean Name ");
        name = scan.nextLine();
        return name;
    }
    // inputting the day of week
    public String inputDayofweek(int num)
    {
        String dayofweek;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the day of week ");
        dayofweek = scan.nextLine();
        return dayofweek;
    }
    //inputitng the time
    public String inputtime (int num)
    {
        String time;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the time of day he's preforming. Is it Evening or Late night ");
        time = scan.nextLine();
        return time;
    }
    // inputting the tickets they wish to buy
    public int inputTickets (int num)
    {
        int tickets;
        Scanner scan = new Scanner(System.in);
        System.out.print("How many tickets you wish to get ");
        tickets = scan.nextInt();
        return tickets;
    }
    
    
   //adding the menu
    public void menu()
    {
       
        int option;
        Scanner scan = new Scanner(System.in);
        Event e = null;
        do
        {
            System.out.print("Choose between 1-5");

            System.out.print(" 1) Buy tickets for an event");
            System.out.print(" 2) Cancel tickets for an event");
            System.out.print(" 3) Display full event schudule");
            System.out.print(" 4) Suprise event");
            System.out.print(" 5) Exit");
            option = scan.nextInt();
            
            if (option < 0 || option > 5)
            {
                System.out.println("Reput a valid number in");
                option = scan.nextInt();
               

            }
            else if (option == 1) //buy ticket
            {
                buyTickets();
            }
            else if (option == 2) //cancel ticket
            {
                cancelTickets();
            }
            else if (option == 3) // displaying full event
            {
                displayfullevent();
            }
            else if (option == 4) // suprise event
            {
                supriseEvent();
            }

            else if (option == 5) // exit
            {
                exitSystem();
            }      
        }while (option < 0 || option > 5);
     
    }

    public void buyTickets()
    {
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);

    
        String Dayofweek;
        String Comedianname;
        

        int tickets = 0;
        
        
         Event Evente = null; 
        boolean found = false;


        System.out.println("Please enter the comedian name.");
        Comedianname = scan.nextLine();
        
         System.out.print("Enter the day of week ");
         Dayofweek = scan.nextLine();
        
              for (Event e : list)
            {
                if( Comedianname.equalsIgnoreCase (e.getComedianname()) && Dayofweek.equalsIgnoreCase (e.getDayofweek()))
                {   
                    System.out.println("This event has been found");
                    System.out.println("How many tickets you'd like to buy");
                    tickets = scan.nextInt();
                    e.setTickets(tickets);
                    
                    scan.nextLine();
                    e.setTickets(tickets);
                    System.out.println("Perfect you've bought " + e.getTickets() + " for this event");
                    found = true;
                    menu();
                    
                    if (e.getTickets() > (e.getTicketsAvaliable()))
                    {
                        System.out.println("There is no more tickets for this event");
                        System.out.print("\f");
                        menu();
                    }
                    
                }
                else
                {
                
                }
            
            }
            
            
      
    }

        public void cancelTickets()
        {
            System.out.print("\f");
            Scanner scan = new Scanner(System.in);
            
            
            Event Evente = null;
            int cancelTickets;
            int tickets;
            String Comedianname;
            for (Event e : list)
            {
            System.out.println(" Which comedian do you wish to cancel for ");
            Comedianname = scan.nextLine();
            
            System.out.println(" And how many tickets you wish to refund ");
            cancelTickets = scan.nextInt();
            
           
            
            
            
            
            System.out.println(" Perfect! you've refund tickets for " + e.getComedianname() + " thank you ");
            
            menu();
        }
            
            
}
    
        

        public void displayfullevent()
        {
            System.out.print("\f");
            Scanner scan = new Scanner(System.in);
            int option;

        for(Event e : list)
        {
            System.out.println(e.toString());
        }
        
            System.out.println(" Press 5 to leave this menu");

            option = scan.nextInt();
         System.out.print("\f");
            do{
            if (option == 5)
            {
                menu();
            }
            else if(option < 5 || option > 5)
            {
               System.out.println("Please enter the correct number"); 
            }
        }while (option < 5 || option > 5);
    }

        public void supriseEvent()
        {
            System.out.print("\f");
            Scanner scan = new Scanner(System.in);
            int choice;
        
            int tickets = 0;
            

            boolean found = false;

            System.out.println("There's a surpise event!!!....");
            System.out.println("Kevin is perfoming  on Thursday but theres only 30 tickets left!");
            System.out.println("Do you wish to buy the limited time tickets? 1 for Yes or 2 for no");
            
            choice = scan.nextInt();
            for (Event e : list)
            {
            if (choice == 1)
            {
            
                    System.out.println("How many tickets you'd like to buy");
                    tickets = scan.nextInt();
                    
                    System.out.println("Perfect you've bought " +  e.getSupriseTickets() +  " for this event ");
                    found = true;
                    menu();
                    
                    if (e.getTickets() > (e.getSupriseTickets()))
                    {
                        System.out.println("There is no more tickets for this event");
                        System.out.print("\f");
                        menu();
                    }
                }
                else if (choice == 2)
                {
                    System.out.print("\f");
                    menu();
                }
        }
    }

        public void exitSystem()
        {
            System.out.print("\f");
            Scanner scan = new Scanner(System.in);
            
            int option;
            System.out.println("Do you wish to leave? 1 to stay or 2 to leave");
            
            option = scan.nextInt();
            System.out.print("\f");
            
            
            
            do{
                if (option == 1)
                {
                    menu();
                    
                }
                else
                {
                    
                }
                if(option == 2)
                {
                   System.out.println("Goodbye");

                }
                else
                {
                    
                }
            }while (option < 1 || option > 3);
        }

        public void displayEvent()
        {
            System.out.println("\n\nDisplay details for the " + list.size() + " event ");
            for (Event e : list)
            {
                System.out.println("\n" + e.toString());
            }
        }

        public static void main(String[] args)
        {
            new EventDriver();
        }

}



