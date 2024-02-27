
public class Shoes extends Fashion
{
    public String bio;
    
    public Shoes()
    {
        super();
        this.bio = " ";
    }
    
    public Shoes(double size, String brand, String colour, int StockAvailable, double price)
    {
        super(size, brand, colour, StockAvailable, price);
        this.bio = bio;
    }
    
    public String getbio()
    {
        return this.bio;
    }
    
    public void setbio(String bio)
    {
        this.bio = bio;
    }
    
    public String toString()
    {
        String result = " ";
        
        result = super.toString() + " " + "\nbio: " + this.bio;
        
        return result;
    }
}
