

public class Clothes extends Fashion
{
    
    
    public Clothes()
    {
        super();
    }
    
    public Clothes(double size, String brand, String colour, int StockAvailable, double price)
    {
        super(size, brand, colour, StockAvailable, price);

    }
    
    
    public String toString()
    {
        String result = " ";
        
        result = super.toString() + " " ;
        
        return result;
    }
}

