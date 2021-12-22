import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class FoodService {
    public static Date changeStringToDate(String StringDay) throws ParseException{
        Date date ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yy");
        date = simpleDateFormat.parse(StringDay);
        return date ;
    }
    public static String changeDateToString(String date){
        String stringDate = null ;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        stringDate = simpleDateFormat.format(date);
        return stringDate;
    }
    public Food getById(int id){
        Food food = new Food();
        for (Food edit : ManageService.listFood){
            if (edit.getId().equals(id)){
                 food = edit ;
                 break ;
            }
        }
        return food;
    }
    public void insert(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Information Food");
        try {
            System.out.print("Enter name : ");
            String name = sc.nextLine();
            System.out.print("Enter PLU : ");
            int id = sc.nextInt();
            System.out.print("Enter Inventory Number : ");
            int quantity = sc.nextInt();
            System.out.print("Enter Desription : ");
            String desription = sc.nextLine();
            System.out.print("Enter Price : ");
            float price = sc.nextFloat();
            String date = sc.nextLine();
            changeStringToDate(date);
            Food food = new Food(id, name, quantity, desription, price , date);
            ManageService.listFood.add(food);
            
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void show() throws ParseException{
        System.out.println("*** List Food ***");
        String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
        System.out.println(header);
        String date ;
        Date now = new Date();
        SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
        date = newDate.format(now);
        for (Food food : ManageService.listFood){
        changeStringToDate(food.getDate());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", food.getName() ,"FSM-", food.getId() , food.getQuantity() , food.getDesription() , food.getPrice(),food.getDate(),date);
        System.out.println(row);
    }
}
    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Edit Food");
        try {
            System.out.print("Enter PLU will edit : ");
            Integer id = sc.nextInt();
            Food food = null;
            
            for (Food edit : ManageService.listFood){
                if (edit.getId().equals(id)){
                    food = edit ;
                     break ;
                }
            }
            if (food == null){
                System.out.println(" PLU does not exist , please re-enter PLU");
            }
            changeStringToDate(food.getDate());
            System.out.println("Information Food ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", food.getName() ,"FSM-", food.getId() , food.getQuantity() , food.getDesription() , food.getPrice(),food.getDate(),date);
            System.out.println(row);

            for (int i = 0 ; i < ManageService.listFood.size() ; i++){
                if (id.equals(ManageService.listFood.get(i).getId())){
                    sc.nextLine();
                    System.out.print("Enter name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Inventory Number : ");
                    int quantity = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Emter Desription : ");
                    String desription = sc.nextLine();

                    System.out.print("Enter Price : ");
                    float price = sc.nextFloat();
                    System.out.print("Enter date : ");
                    sc.nextLine();
                    String dateN = sc.nextLine();
                    changeStringToDate(date);
                    ManageService.listFood.get(i).setName(name);
                    ManageService.listFood.get(i).setQuantity(quantity);
                    ManageService.listFood.get(i).setDesription(desription);
                    ManageService.listFood.get(i).setPrice(price);
                    ManageService.listFood.get(i).setDate(dateN);

                }
            }
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void Delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Delete Food");
        try {
            System.out.print("Enter PLU wanna delete : ");
            Integer id = sc.nextInt();
            Food food = null;
            
            for (Food delete : ManageService.listFood){
                if (delete.getId().equals(id)){
                    food = delete ;
                     break ;
                }
            }
            if (food == null){
                System.out.println(" PLU does not exist , please re-enter PLU");
            }
            System.out.println("Information Food will Delete");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            changeStringToDate(food.getDate());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", food.getName() ,"FSM-", food.getId() , food.getQuantity() , food.getDesription() , food.getPrice(),food.getDate(),date);
            System.out.println(row);
            int delete = -1 ;
            boolean found = false ;
            for (int i = 0 ; i < ManageService.listFood.size() ; i++){
                if (id.equals(ManageService.listFood.get(i).getId())){
                    found = true ;
                    delete = i ;
                    break;
                }
            }
            if ( found = false ){
                System.out.println("PLU does not exist , please re-enter");
            }else {
                ManageService.listFood.remove(delete);
            }
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void exit(){
        System.out.println("*****  Good Bye  *****");
        System.out.println("---> See you again <---");
        System.out.println(" Thank you for using the software ");
        System.exit(0);
    }
    public void find(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Find Food");
        try {
            System.out.print("Enter Price wanna find : ");
            Float price = sc.nextFloat();
            Food food = null;
            for (Food found : ManageService.listFood){
                if (found.getPrice().equals(price)){
                     food = found ;
                     break ;
                }
            }
            if (food == null){
                System.out.println(" Price does not exist , please re-enter Price");
            }
           changeStringToDate(food.getDate());
            System.out.println("Information Price Food ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", food.getName() ,"FSM-", food.getId() , food.getQuantity() , food.getDesription() , food.getPrice(),food.getDate(),date);
            System.out.println(row);

        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void sortId(){
        Collections.sort(ManageService.listFood, (a, b) -> (int) (a.getId() - b.getId()));
        System.out.println("Sort Food by PLU");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sortPriceLow(){
        Collections.sort(ManageService.listFood, (a, b) -> (int) (a.getPrice() - b.getPrice()));
        System.out.println("Sort Food by Price");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sortPriceHigh(){
        Collections.sort(ManageService.listFood, (a, b) -> (int) (b.getPrice() - a.getPrice()));
        System.out.println("Sort Food by Price");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public <a> void sortDate() throws ParseException{
        Collections.sort(ManageService.listFood, (a,b) -> (int) (a.getDate().compareTo("0") - b.getDate().compareTo("0")));;
        System.out.println("Sort Food by Price");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private String getSort(int compareTo) {
        return null;
    }
    public void findPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Find Product");
        try {
            System.out.print("Enter Price wanna find : ");
            Float pricemin = sc.nextFloat();
            HangHoa hanghoa = null;
            System.out.print(" to : ");
            Float pricemax = sc.nextFloat();
            
            System.out.println("Information Price Food ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            for (Float i = pricemin ; i <= pricemax ; i++){
                for (Food found : ManageService.listFood){
                if (i.equals(found.getPrice())){
                    changeStringToDate(found.getDate());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", found.getName() ,"FSM-", found.getId() , found.getQuantity() , found.getDesription() , found.getPrice(),found.getDate(),date);
                    System.out.println(row);
                }
                if(found == null){
                    System.out.println(" Price does not exist , please re-enter Price");
                }
            }
        }
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void findDate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Find Date Food");
        try {
            System.out.print("Enter Date wanna find : ");
            String date = sc.nextLine();
            Food food = null;
            for (Food found : ManageService.listFood){
                changeStringToDate(found.getDate());
                if (found.getDate().equals(date)){
                    food = found ;
                     break ;
                }
            }
            if (food == null){
                System.out.println(" Price does not exist , please re-enter Price");
            }
            System.out.println("Information Input Date Product ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String dateN ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            dateN = newDate.format(now);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", food.getName() ,"FSM-", food.getId() , food.getQuantity() , food.getDesription() , food.getPrice(),food.getDate(),dateN);
            System.out.println(row);
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void findDateForm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Find Input Date Food");
        try {
            System.out.print("Enter Date wanna find : ");
            String daymin = sc.nextLine();
            Food food = null;
            System.out.print(" to : ");
            String daymax = sc.nextLine();
            
            System.out.println("Information Price Food ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            Integer i ;
            for ( i = 0 ; i <= daymax.compareTo(daymin) ; i++){
                for (Food found : ManageService.listFood){
                    if(i.equals(found.getDate().compareTo(daymin))){
                    changeStringToDate(found.getDate());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", food.getName() ,"FSM-", food.getId() , food.getQuantity() , food.getDesription() , food.getPrice(),food.getDate(),date);
                    System.out.println(row);
                if(found == null){
                    System.out.println(" Price does not exist , please re-enter Price");
                }
            }}
        }
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void sumProduct(){
        int sumP = 0 ;
        for (Food sum : ManageService.listFood){
            sumP = sumP + sum.getQuantity() ;
        }
        System.out.println("Total Number of Food in Stock : "+sumP);
    }
    public void sumPrice(){
        Float sumP = (float) 0.0 ;
        for (Food sum : ManageService.listFood){
                sum.setTotal(sum.getPrice()*sum.getQuantity());
                sumP = sumP + sum.getTotal();
        }
        System.out.println("Total Price : "+sumP);
    }
   
    
}