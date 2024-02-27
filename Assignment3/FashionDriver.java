import java.util.ArrayList;
import java.util.Scanner;

public class FashionDriver
{
    ArrayList<Fashion> products;
    public FashionDriver()
    {
        products = new ArrayList<Fashion>();

        menu();
        
    }

    public static void main (String[] args )
    {
        new FashionDriver();
    }

    public void menu()
    {
        int option;
        Scanner scan = new Scanner(System.in);
        System.out.print("\f");
        
        do
        {
            System.out.println("\nFarFashionFealz - Stock Control. ");
            System.out.println(" 1. Customer shop menu ");
            System.out.println(" 2. Staff shop menu ");
            System.out.println(" 3. Exit ");

            System.out.println(" Please choose ");

            option = scan.nextInt();

            if (option < 0 || option > 3)
            {
                System.out.println("Reput a valid number in");
                option = scan.nextInt();

            }
            else if (option == 1) 
            {
                customermenu();
            }
            else if (option == 2) 
            {
                staffmenuPassword();
            }
            else if (option == 3) 

            {
                exit();
            }      
        } while (option < 0 || option > 3);
    }

    public int getcustomermenu()
    {
        Scanner scan = new Scanner(System.in);
        int option;
        do
        {
            option = scan.nextInt();
        } while(option < 0|| option > 3);
        return option;

    }

    public void customermenu()
    {
        int menuchoice = 0;
        System.out.print("\f");
        Scanner scan = new Scanner(System.in);
        do
        {
            System.out.println("\n1 Clothes products");
            System.out.println("2. Shoes products");
            System.out.println("3. Purchase Clothes");
            System.out.println("4. Purcahse Shoes");
            System.out.println("5. Return to menu");

            System.out.println("Please choose");

            menuchoice = scan.nextInt();

            if (menuchoice == 1)
            {
                displayClothes();
            }
            else if (menuchoice == 2) 
            {
                displayshoes();
            }
            else if (menuchoice == 3)
            {
                buyclothes();
            }
            else if (menuchoice == 4)
            {
                buyshoes();
            }
            else if (menuchoice == 5)
            {
                menu();
            }

        }while(menuchoice < 0 || menuchoice > 6);
    }

    public void displayClothes()
    {
        int number = 1;
        Clothes c;
        boolean ClothesFound = false;
        System.out.println("\nDisplaying Clothing products");
        for (Fashion f : products)
        {
            if (f instanceof Clothes)
            {
                System.out.println("\nClothes:" + number);
                c = (Clothes) f;
                System.out.print(f.toString());
                number ++;
            }
        }
        if (!ClothesFound)
        {
            System.out.println("We're sorry! There's no Clothes in stock ");
        }
    }

    public void displayshoes()
    {
        int number = 1;
        Shoes s;
        boolean ShoesFound = false;
        System.out.println("\nDisplaying Shoes products");
        for (Fashion f : products)
        {
            if (f instanceof Clothes)
            {
                System.out.println("\nShoes:" + number);
                s = (Shoes) f;
                System.out.print(f.toString());
                number ++;
            }
        }
        if (!ShoesFound)
        {
            System.out.println("We're sorry! There's no Shoes in stock ");
        }
    }

    public void buyclothes()
    {
        System.out.print("\f");
        
        String Clothes;
        double size;
        String brand;
        String colour;
        int StockAvailable;
        double price;
        String bio;
        int pieces = 0;
        int AvailableNewStock;

        Scanner scan = new Scanner(System.in);
        boolean clothesStock = false;

        for ( Fashion f : products)
        {
            if (f instanceof Clothes && f.getStockAvailable() > 0)
            {
                clothesStock = true;
            }
        }
        if (!clothesStock)
        {
            System.out.println("We're sorry! There's no Clothes in stock ");
            menu();
        }

        System.out.println("Pick a clothing product from the list of products available and be sure to include all relevant details");
        System.out.println("Size: EU");
        size = scan.nextDouble();
        scan.nextLine();

        System.out.println("Price: €");
        price = scan.nextDouble();
        scan.nextLine();

        System.out.println("Colour: ");
        colour = scan.nextLine();

        System.out.println("Brand: ");
        brand = scan.nextLine();

        Clothes c;

        for (Fashion buy : products)
        {
            if (buy instanceof Clothes)
            {
                c = (Clothes) buy;
                if (size == (buy.getsize()) && price == (buy.getprice()) && colour.equalsIgnoreCase(buy.getcolour()) && brand.equalsIgnoreCase(buy.getbrand()))
                {
                    System.out.println("How many pieces of clothing would you like to buy?");
                    pieces = scan.nextInt();
                }
                if(buy.getStockAvailable() == 0)
                {
                    System.out.println("Out of stock");
                    System.out.println("Redirecting to customer menu");
                    menu();

                }
                else if (pieces <= buy.getStockAvailable() && buy.getStockAvailable() > 0)
                {
                    System.out.println("Processing transaction.... You've purchased " + pieces + " pieces of clothing");
                    System.out.println("Thank you ");
                    AvailableNewStock = buy.getStockAvailable() - pieces; 
                    buy.setStockAvailable(AvailableNewStock);
                }
                else if (pieces > buy.getStockAvailable())
                {
                    System.out.println("Insufficient amount available");
                }

            }
        }
    }

    public void buyshoes()
    {
        System.out.print("\f");
        
        String shoes;
        double size;
        double price;
        String colour;
        String bio;
        String brand;
        int pairs;
        int AvailableNewStock;

        Scanner scan = new Scanner(System.in);

        boolean shoesStock = false;

        for ( Fashion f : products)
        {
            if (f instanceof Shoes && f.getStockAvailable() > 0)
            {
                shoesStock = true;
            }
        }
        

        System.out.println("Pick a shoe from the list of products available and be sure to include all relevant details");
        System.out.println("Size: EU");
        size = scan.nextDouble();
        scan.nextLine();

        System.out.println("Price: €");
        price = scan.nextDouble();
        scan.nextLine();

        System.out.println("Colour: ");
        colour = scan.nextLine();

        System.out.println("Brand: ");
        brand = scan.nextLine();

        Shoes s;
        for (Fashion buy : products)
        {
            if (buy instanceof Shoes)
            {
                s = (Shoes) buy;
                if (size == (buy.getsize()) && price == (buy.getprice()) && colour.equalsIgnoreCase(buy.getcolour()) && brand.equalsIgnoreCase(buy.getbrand()))
                {
                    System.out.println("How many pairs of shoes would you like to buy?");
                    pairs = scan.nextInt();

                    if(buy.getStockAvailable() == 0)
                    {
                        System.out.println("Out of stock");
                        System.out.println("Redirecting to customer menu");  
                        menu();
                    }
                    else if (pairs <= buy.getStockAvailable() && buy.getStockAvailable() > 0)
                    {
                        System.out.println("Processing transaction.... You've purchased " + pairs + " of this shoe");
                        System.out.println("Thank you ");
                        AvailableNewStock = buy.getStockAvailable() - pairs; 
                        buy.setStockAvailable(AvailableNewStock);
                    }

                    else if (pairs > buy.getStockAvailable())
                    {
                        System.out.println("Insufficient amount available");
                    }
                }
            }
        }
    }

    public int getstaffmenu()
    {
        Scanner scan = new Scanner(System.in);
        int option;
        do
        {
            option = scan.nextInt();
        } while(option < 0|| option > 3);
        return option;

    }
    
    public void staffmenuPassword()
    {
        System.out.print("\f");
        
        String username;
        
        int staffmenupass;
        
        do
        {
           int option; 
        
           Scanner scan = new Scanner(System.in);
           
           System.out.println("In order to access the staff menu, please input the following correct details");
           
           
           
           System.out.println("Please enter your password");
           staffmenupass = getstaffmenu();
           
           if (staffmenupass == 0000) 
           {
               staffmenu();
           }
           else if (staffmenupass < 0000 || staffmenupass > 0000)
           {
               System.out.println("Incorrect. Please try again");
           }
           

        }while(staffmenupass < 0000 || staffmenupass > 0000);
    }

    public void staffmenu()
    {     
        System.out.print("\f");
        
        int menuchoice = 0;
        do
        {

            int option;

            Scanner scan = new Scanner(System.in);

            System.out.println("Welcome to the Staff menu! ");
            System.out.println("1. Add a new pair of shoes to the list of products");
            System.out.println("2. Add a new pair of clothing to the list of products");
            System.out.println("3. Update stock level for existing shoes or clothes delivery");
            System.out.println("4. Exit Staff menu");

            System.out.println("Please choose a number");

            menuchoice = scan.nextInt();

            if (menuchoice == 1)
            {
                addshoes();
            }
            else if (menuchoice == 2) 
            {
                addclothes();
            }
            else if (menuchoice == 3)
            {
                updatestock();
            }
            else if (menuchoice == 4)
            {
                menu();
            }
        } while(menuchoice < 0 || menuchoice > 5);
    }    

    public void addshoes()
    {
        
        System.out.print("\f");
        
        String Shoes;
        double size;
        String brand;
        String colour;
        int StockAvailable = 0;
        double price;
        String bio;

        Scanner scan = new Scanner(System.in);

        Fashion ShoesM1;

        System.out.println("Creating shoes for the list of products");

        System.out.println("Add Size: EU");
        size = scan.nextDouble();
        scan.nextLine();

        System.out.println("Add Price: €");
        price = scan.nextDouble();
        scan.nextLine();

        System.out.println("Add Colour: ");
        colour = scan.nextLine();

        System.out.println("Add Brand: ");
        brand = scan.nextLine();

        System.out.println("Add Bio: ");
        bio = scan.nextLine();

        ShoesM1 = new Shoes (size, brand, colour, StockAvailable, price);

        products.add(ShoesM1);

    }

    public void addclothes()
    {
        System.out.print("\f");
        
        String clothes;
        double size;
        String brand;
        String colour;
        int StockAvailable = 0;
        double price;
        String bio;

        Scanner scan = new Scanner(System.in);

        Fashion ClothesM1;

        System.out.println("Creating clothes for the list of products");

        System.out.println("Add Size: EU");
        size = scan.nextDouble();
        scan.nextLine();

        System.out.println("Add Price: €");
        price = scan.nextDouble();
        scan.nextLine();

        System.out.println("Add Colour: ");
        colour = scan.nextLine();

        System.out.println("Add Brand: ");
        brand = scan.nextLine();

        ClothesM1 = new Clothes (size, colour, brand,StockAvailable, price);
        products.add(ClothesM1);
    }
    
    public void updatestock()
    {
         System.out.print("\f");
            
        String Fashion;
        double size;
        String brand;
        String colour;
        double price;
        String bio;
        int StockAvailable;
        int NewAvailableStock;
        int updatedstock;

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the item you wish to update");
        Fashion = scan.nextLine();

        if(Fashion.equalsIgnoreCase("Clothes"))
        {
            Clothes c;
            int number = 1;
            System.out.println("Displaying Clothing products");

            for ( Fashion f : products)
            {
                if(f instanceof Clothes)
                {
                    System.out.println("\nClothes" + number);
                    System.out.print(f.toString());
                    number ++;
                }

            }
        
            System.out.println("Choose the clothing piece you would like to update");

            System.out.println("Add Size: EU");
            size = scan.nextDouble();
            scan.nextLine();

            System.out.println("Add Price: €");
            price = scan.nextDouble();
            scan.nextLine();

            System.out.println("Add Colour: ");
            colour = scan.nextLine();

            System.out.println("Add Brand: ");
            brand = scan.nextLine();

            System.out.println("Add Bio: ");
            bio = scan.nextLine();

            for (Fashion f : products)
            {
                if (f instanceof Clothes)
                {
                    c = (Clothes) f;
                    if(size == (f.getsize()) && brand.equalsIgnoreCase(f.getbrand()) && price == (f.getprice()) && colour.equalsIgnoreCase(f.getcolour()))
                    {
                        System.out.println("How much stock has been delivered?");
                        NewAvailableStock = scan.nextInt();
                        updatedstock = NewAvailableStock + f.getStockAvailable();
                        f.setStockAvailable(updatedstock);
                        System.out.println("Stock updated");
                        menu();

                    }
                

                else if(Fashion.equalsIgnoreCase("Shoes"))
                {
                    Shoes s;
                    System.out.println("Display shoe products");
                    
                    
                        if ( f instanceof Shoes)
                        {
                            System.out.println("\nShoes" + number);
                            System.out.print(f.toString());
                            number ++;

                        }
                    
                
        
                    System.out.println("Choose the shoe products you would like to update");

                    System.out.println("Add Size: EU");
                    size = scan.nextDouble();
                    scan.nextLine();

                    System.out.println("Add Price: €");
                    price = scan.nextDouble();
                    scan.nextLine();

                    System.out.println("Add Colour: ");
                    colour = scan.nextLine();

                    System.out.println("Add Brand: ");
                    brand = scan.nextLine();

                    System.out.println("Add Bio: ");
                    bio = scan.nextLine();

            
                

                
                    if (f instanceof Shoes)
                    {
                        s = (Shoes) f;
                        if(size == (f.getsize()) && brand.equalsIgnoreCase(f.getbrand()) && price == (f.getprice()) && colour.equalsIgnoreCase(f.getcolour()))
                        {
                            System.out.println("How much stock has been delivered?");
                            NewAvailableStock = scan.nextInt();
                            updatedstock = NewAvailableStock + f.getStockAvailable();
                            f.setStockAvailable(updatedstock);
                            System.out.println("Stock updated");
                            menu();

                        }
                    }
                }
            }
        
    

                else if (!Fashion.equalsIgnoreCase("Clothes") && !Fashion.equalsIgnoreCase("Shoes"))
            {
                System.out.println("Please rechoose a valid product");
                System.out.println("Returning to staff menu");
                staffmenu();
            }
        }
     }
    }
                               
                
                
    public void exit()
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
                   System.out.println("Goodbye and thank you for shopping at FashionFealz!");

                }
                else
                {
                    
                }
            }while (option < 1 || option > 3);
        }
        }


