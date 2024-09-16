

public class Publisher extends Thread {

	
	private Repository res;
	
	public Publisher(Repository res)
	{
		this.res = res;
	}
	
	
	public void PublisherAct()
	{
		int i;
		
		for(i = 0; i < 5; i++) //creates the run from 0-5 count
		{
			synchronized (res){
			while (res.isPrintedInt()){ // This will wait if the number already has been printed
				try {
					res.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
				System.out.println("The Publisher is : " + res.getvalue()); // get the value and display it
				res.setPrintedInt(false);
				res.notify(); //this notify the other threads that the number has now been updated
			}
		}
	}

	public static void main (String[] args)
	{
		Repository res = new Repository();
		Counter counter = new Counter(res);
		Publisher publisher = new Publisher(res);
		//creating the objects in the main method to start threading
		counter.start();
		publisher.start();
		//run the counter and publisher
		try {
			counter.join();
			publisher.join();
		} catch (InterruptedException e )
		{
			e.printStackTrace();
		}
		System.out.println("Thread is Finished"); // display this message when the thread is finished
	}


	public void run()
	{
		PublisherAct();
	}
	
	}