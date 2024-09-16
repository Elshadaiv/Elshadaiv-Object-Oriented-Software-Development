import java.util.Scanner;

public class Counter extends Thread {

	private Repository res;


public Counter(Repository res)
{
	this.res = res;
}


public void CounterAct()
{
	int i;
	for(i = 0; i < 5; i++) // creates the run from 0-5 count
	{
		synchronized (res) {
			while (res.isPrintedInt()) { // This will wait if the number already has been printed
			try {
				res.wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			}
			
			
			res.setvalue(res.getvalue() + 1);
			System.out.println("The counter is : " + res.getvalue()); // displays this message with getting the values into the counter.
			res.setPrintedInt(true); // changes the false into a true.
			res.notify(); //this notify the other threads that the number has now been updated
		}
	}

}

public void run()
{
	CounterAct(); // run the thread
}

}