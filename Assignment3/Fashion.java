


public class Fashion
{
    public double size;
    public String brand;
    public String colour;
    public int StockAvailable;
    public double price;
    public int AvailableNewStock;
    
    public Fashion()
    {
        this.size = 0;
        this.brand = " ";
        this.colour = " ";
        this.StockAvailable = 0;
        this.price = 0;
    }
    
    public Fashion (double size, String brand, String colour, int StockAvailable, double price)
    {
        this.size = size;
        this.brand = brand;
        this.colour = colour;
        this.StockAvailable = StockAvailable;
        this.price = price;
    }
    
    public double getsize()
    {
        return this.size;
    }
    
    public String getbrand()
    {
        return this.brand;
    }
    
    public String getcolour()
    {
        return this.colour;
    }
    
    public int getStockAvailable()
    {
        return this.StockAvailable;
    }
    
    public double getprice()
    {
        return this.price;
    }
    
    public void setsize(double size)
    {
        this.size = size;
    }
    
    public void setbrand(String brand)
    {
        this.brand = brand;
    }
    
    public void setcolour(String colour)
    {
        this.colour = colour;
    }
    
    public void setStockAvailable(int Stock)
    {
        this.StockAvailable = Stock;
    }
    
    public void setprice(double price)
    {
        this.price = price;
    }
    
    public void getAvailableNewStock()
    {
     this.AvailableNewStock = StockAvailable;
    }
    
    
    public String toString()
    {
        return "\nsize: " + this.size + " " + "\nbrand: " + this.brand + " " + "\ncolour: " + this.colour + " " + "\nprice: " + this.price + " " + "\nStock Available: " + this.StockAvailable;
    }
}
