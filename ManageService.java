import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageService {
    public static List<Food> listFood = new ArrayList<Food>();
    public static List<Electric> listElectric = new ArrayList<Electric>();
    public static List<Crockery> listCrockery = new ArrayList<Crockery>();
    public static List<Customer> listperson = new ArrayList<Customer>();
    public static void menuActive(){
        System.out.println("\n------------------- List ----------------");
        System.out.println("1. Add Product");
        System.out.println("2. Show List Product");
        System.out.println("3. Edit Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Buy ( Maintenance in Progress )");
        System.out.println("6. Show List Person ( Maintenance in Progress )");
        System.out.println("7. Find Product by Price");
        System.out.println("8. Sort Product by PLU");
        System.out.println("9. Sort Product by Price Low - High");
        System.out.println("10. Sort Product by Price High - Low");
        System.out.println("11. Find Product by Price ... to ...");
        System.out.println("12. Find Product by Date ");
        System.out.println("13. Find Product by Date form ... to ...");
        System.out.println("14. Sort by Date");
        System.out.println("15. Total Number of Products in Inventory");
        System.out.println("16. Total Price ");
        System.out.println("17. Back");
    }
    public static void menu(){
        System.out.println("\n------------------- List ----------------");
        System.out.println("1. Food");
        System.out.println("2. Electric");
        System.out.println("3. Crockery");
        System.out.println("4. Exit");
    }
    public static void inventoryFood(){
        listFood.add(new Food(1,"King Crap",2000,"Fresh",(float) 750,"19/11/2021"));
        listFood.add(new Food(2,"Salmon",1500,"Fresh",(float) 520,"20/11/2021"));
        listFood.add(new Food(3,"Pork",7000,"Fresh",(float) 230,"21/11/2021"));
        listFood.add(new Food(4,"Beef",3000,"Fresh",(float) 480,"22/11/2021"));
        listFood.add(new Food(5,"Lamb",700,"Fresh",(float) 610,"23/11/2021"));
        listFood.add(new Food(6,"Goat Meat",250,"Fresh",(float) 340,"24/11/2021"));
        listFood.add(new Food(7,"Tuna",1200,"Fresh",(float) 670,"25/11/2021"));
        listFood.add(new Food(8,"Mackerel",2800,"Fresh",(float) 495,"26/11/2021"));
        listFood.add(new Food(9,"Flounder",420,"Fresh",(float) 890,"27/11/2021"));
        listFood.add(new Food(10,"Rouper Fish",150,"Fresh",(float) 1150,"28/11/2021"));
        listFood.add(new Food(11,"Premium Beef",50,"Fresh",(float) 1780,"29/11/2021"));
    }
    public static void inventoryElectric(){
        listElectric.add(new Electric(1,"Washing Machine",35,"Fresh",(float) 7650,"22/11/2021"));
        listElectric.add(new Electric(2,"Rinked Machine",20,"Fresh",(float) 5420,"23/11/2021"));
        listElectric.add(new Electric(3,"Fridge",15,"Fresh",(float) 9950,"24/11/2021"));
        listElectric.add(new Electric(4,"Television",45,"Fresh",(float) 13400,"25/11/2021"));
        listElectric.add(new Electric(5,"Microwave",22,"Fresh",(float) 4730,"26/11/2021"));
        listElectric.add(new Electric(6,"Steam Fan",10,"Fresh",(float) 9999,"27/11/2021"));
        listElectric.add(new Electric(7,"Air-Conditioner",58,"Fresh",(float) 24050,"28/11/2021"));
        listElectric.add(new Electric(8,"Hot and Cold Water Machine",7,"Fresh",(float) 8700,"29/11/2021"));
        listElectric.add(new Electric(9,"Air Purifier",28,"Fresh",(float) 2380,"30/11/2021"));
        listElectric.add(new Electric(10,"Water Purifier",14,"Fresh",(float) 2990,"19/11/2021"));
        listElectric.add(new Electric(11,"Laptop",85,"Fresh",(float) 17950,"18/11/2021"));
        listElectric.add(new Electric(12,"Lamp",100,"Fresh",(float) 570,"17/11/2021"));
    }
    public static void inventoryCrockery(){
        listCrockery.add(new Crockery(1,"Porcelain Spoon",875,"Fresh",(float) 25,"11/11/2021"));
        listCrockery.add(new Crockery(2,"Porcelain Cup",1120,"Fresh",(float) 18,"25/11/2021"));
        listCrockery.add(new Crockery(3,"Porcelain Plate",550,"Fresh",(float) 37,"14/11/2021"));
        listCrockery.add(new Crockery(4,"Ceramic Bowl",640,"Fresh",(float) 23,"23/11/2021"));
        listCrockery.add(new Crockery(5,"Porcelain Vase",80,"Fresh",(float) 2240,"28/11/2021"));
        listCrockery.add(new Crockery(6,"Porcelain Teapot",15,"Fresh",(float) 699,"16/11/2021"));
        listCrockery.add(new Crockery(7,"Porcelain Chopstick Holders",880,"Fresh",(float) 10,"07/11/2021"));
        listCrockery.add(new Crockery(8,"Ceramic Pots",5,"Fresh",(float) 1365,"09/11/2021"));
        listCrockery.add(new Crockery(9,"Porcelain Ashtray",15,"Fresh",(float) 85,"01/11/2021"));
        listCrockery.add(new Crockery(10,"Porcelain Piggy Bank",10,"Fresh",(float) 65,"21/11/2021"));

    }
    public  static void listCustomer(){
        listperson.add(new Customer(1, "Lê Quang Đại Dĩ", "0929860265", "dile8861@gmail.com"));
    }
    public static void activemenuFood(){
        int function = 0 ;
        inventoryFood();
        do{
            menuActive();
            try {
                
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Selection : ");
                function = sc.nextInt();
                FoodService foodserice = new FoodService();
                ListofCustomers listofCustomers = new ListofCustomers();
                switch(function){
                    case 1 : 
                    foodserice.insert();
                    break;
                    case 2 : 
                    foodserice.show();
                    break;
                    case 3 : 
                    foodserice.update();
                    break;
                    case 4 : 
                    foodserice.Delete();
                    break;
                    case 5 : 
                    listofCustomers.buyFood();
                    break;
                    case 6 : 
                    listofCustomers.showFood();
                    break;
                    case 7 :
                    foodserice.find();
                    break;
                    case 8 :
                    foodserice.sortId();
                    break;
                    case 9 :
                    foodserice.sortPriceLow();
                    break;
                    case 10 :
                    foodserice.sortPriceHigh();
                    break;
                    case 11 : 
                    foodserice.findPrice();
                    break ;
                    case 12 : 
                    foodserice.findDate();
                    break ;
                    case 13 : 
                    foodserice.findDateForm();
                    break ;
                    case 14 : 
                    foodserice.sortDate();
                    break ;
                    case 15 : 
                    foodserice.sumProduct();
                    break ;
                    case 16 : 
                    foodserice.sumPrice();
                    break ;
                    case 17 : 
                    foodserice.exit();
                    break ;
                }
            } catch(InputMismatchException ei){
                System.out.println("You entered it wrong , please re-enter ");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(function != 17);
    }
    public static void activemenuElectric(){
        int function = 0 ;
        do{
            menuActive();
            inventoryElectric();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Selection : ");
                function = sc.nextInt();
                ElectricService electricService = new ElectricService();
                ListofCustomers listofCustomers = new ListofCustomers();
                switch(function){
                    case 1 : 
                    electricService.insert();
                    break;
                    case 2 : 
                    electricService.show();
                    break;
                    case 3 : 
                    electricService.update();
                    break;
                    case 4 : 
                    electricService.Delete();
                    break;
                    case 5 : 
                    listofCustomers.buyElectric();
                    break;
                    case 6 : 
                    listofCustomers.showElectric();
                    break;
                    case 7 :
                    electricService.find();
                    break;
                    case 8 :
                    electricService.sortId();
                    break;
                    case 9 :
                    electricService.sortPriceLow();
                    break;
                    case 10 :
                    electricService.sortPriceHigh();
                    break;
                    case 11 : 
                    electricService.findPrice();
                    break ;
                    case 12 : 
                    electricService.findDate();
                    break ;
                    case 13 : 
                    electricService.findDateForm();
                    break ;
                    case 14 : 
                    electricService.sortDate();
                    break ;
                    case 15 : 
                    electricService.sumProduct();
                    break ;
                    case 16 : 
                    electricService.sumPrice();
                    break ;
                    case 17 : 
                    electricService.exit();
                    break ;
                }
            } catch(InputMismatchException ei){
                System.out.println("You entered it wrong , please re-enter ");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(function != 17);
    }
    public static void activemenuCrockery(){
        int function = 0 ;
        do{
            menuActive();
            inventoryCrockery();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Selection : ");
                function = sc.nextInt();
                CrockeryService crockeryService = new CrockeryService();
                ListofCustomers listofCustomers = new ListofCustomers();
                switch(function){
                    case 1 : 
                    crockeryService.insert();
                    break;
                    case 2 : 
                    crockeryService.show();
                    break;
                    case 3 : 
                    crockeryService.update();
                    break;
                    case 4 : 
                    crockeryService.Delete();
                    break;
                    case 5 : 
                    listofCustomers.buyCrockery();
                    break;
                    case 6 : 
                    listofCustomers.showElectric();
                    break;
                    case 7 :
                    crockeryService.find();
                    break;
                    case 8 :
                    crockeryService.sortId();
                    break;
                    case 9 :
                    crockeryService.sortPriceLow();
                    break;
                    case 10 :
                    crockeryService.sortPriceHigh();
                    break;
                    case 11 : 
                    crockeryService.findPrice();
                    break ;
                    case 12 : 
                    crockeryService.findDate();
                    break ;
                    case 13 : 
                    crockeryService.findDateForm();
                    break ;
                    case 14 : 
                    crockeryService.sortDate();
                    break ;
                    case 15 : 
                    crockeryService.sumProduct();
                    break ;
                    case 16 : 
                    crockeryService.sumPrice();
                    break ;
                    case 17 : 
                    crockeryService.exit();
                    break ;
                }
            } catch(InputMismatchException ei){
                System.out.println("You entered it wrong , please re-enter ");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(function != 17);
    }
}
    









    
    

