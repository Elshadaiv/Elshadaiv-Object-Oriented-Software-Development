public class Repository {

	private int value; // storing the number as an integer.
	private boolean printedInt;
	public Repository()
	{
		this.value = 0;
		this.printedInt = false;
	}
	
	public synchronized int getvalue()
	{
		return value;
	}
	
	public synchronized void setvalue(int value)
	{
		this.value = value;
		this.printedInt = false; // Value is set it ill mar as not printed
	}
	
	public synchronized boolean isPrintedInt()
	{
		return printedInt;
	}
	
	public synchronized void setPrintedInt (boolean printedInt)
	{
		this.printedInt = printedInt;
	}

} // getting and setting the values.
