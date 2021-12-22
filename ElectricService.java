import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ElectricService {
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
    public static Electric getById(int id){
        Electric electric = new Electric();
        for (Electric edit : ManageService.listElectric){
            if (edit.getId().equals(id)){
                electric = edit ;
                 break ;
            }
        }
        return electric;
    }
    public void insert(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Information Electric");
        try {
            sc.nextLine();
            System.out.print("Enter name : ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.print("Enter PLU : ");
            int id = sc.nextInt();
            System.out.print("Enter Inventory Number : ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Desription : ");
            String desription = sc.nextLine();
            System.out.print("Enter Price : ");
            float price = sc.nextFloat();
            System.out.print("Enter date : ");
            sc.nextLine();
            String date = sc.nextLine();
            changeStringToDate(date);
            Electric electric = new Electric(id, name, quantity, desription, price , date);
            ManageService.listElectric.add(electric);
            
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void show() throws ParseException{
        System.out.println("*** List Electric ***");
        String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
        System.out.println(header);
        String date ;
        Date now = new Date();
        SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
        date = newDate.format(now);
        for (Electric electric : ManageService.listElectric){
        changeStringToDate(electric.getDate());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),date);
        System.out.println(row);
    }
}
    public void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Edit Electric");
        try {
            System.out.print("Enter PLU will edit : ");
            Integer id = sc.nextInt();
            Electric electric = null;
            
            for (Electric edit : ManageService.listElectric){
                if (edit.getId().equals(id)){
                    electric = edit ;
                     break ;
                }
            }
            if (electric == null){
                System.out.println(" PLU does not exist , please re-enter PLU");
            }
            changeStringToDate(electric.getDate());
            System.out.println("Information Electric ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),date);
            System.out.println(row);

            for (int i = 0 ; i < ManageService.listElectric.size() ; i++){
                if (id.equals(ManageService.listElectric.get(i).getId())){
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
                    ManageService.listElectric.get(i).setName(name);
                    ManageService.listElectric.get(i).setQuantity(quantity);
                    ManageService.listElectric.get(i).setDesription(desription);
                    ManageService.listElectric.get(i).setPrice(price);
                    ManageService.listElectric.get(i).setDate(dateN);

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
        System.out.println("Delete Electric");
        try {
            System.out.print("Enter PLU wanna delete : ");
            Integer id = sc.nextInt();
            Electric electric = null;
            
            for (Electric delete : ManageService.listElectric){
                if (delete.getId().equals(id)){
                    electric = delete ;
                     break ;
                }
            }
            if (electric == null){
                System.out.println(" PLU does not exist , please re-enter PLU");
            }
            System.out.println("Information Electric will Delete");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            changeStringToDate(electric.getDate());
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),date);
            System.out.println(row);
            int delete = -1 ;
            boolean found = false ;
            for (int i = 0 ; i < ManageService.listElectric.size() ; i++){
                if (id.equals(ManageService.listElectric.get(i).getId())){
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
        System.out.println("Find Electric");
        try {
            System.out.print("Enter Price wanna find : ");
            Float price = sc.nextFloat();
            Electric electric = null;
            for (Electric found : ManageService.listElectric){
                if (found.getPrice().equals(price)){
                     electric = found ;
                     break ;
                }
            }
            if (electric == null){
                System.out.println(" Price does not exist , please re-enter Price");
            }
           changeStringToDate(electric.getDate());
            System.out.println("Information Price Electric ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),date);
            System.out.println(row);
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    public void sortId(){
        Collections.sort(ManageService.listElectric, (a, b) -> (int) (a.getId() - b.getId()));
        System.out.println("Sort Electric by PLU");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sortPriceLow(){
        Collections.sort(ManageService.listElectric, (a, b) -> (int) (a.getPrice() - b.getPrice()));
        System.out.println("Sort Electric by Price");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sortPriceHigh(){
        Collections.sort(ManageService.listElectric, (a, b) -> (int) (b.getPrice() - a.getPrice()));
        System.out.println("Sort Electric by Price");
        try {
            show();
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public <a> void sortDate() throws ParseException{
        Collections.sort(ManageService.listElectric, (a,b) -> (int) (a.getDate().compareTo("0") - b.getDate().compareTo("0")));;
        System.out.println("Sort Electric by Price");
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
        System.out.println("Find Electric");
        try {
            System.out.print("Enter Price wanna find : ");
            Float pricemin = sc.nextFloat();
            Electric electric = null;
            System.out.print(" to : ");
            Float pricemax = sc.nextFloat();
            
            System.out.println("Information Price Electric ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            for (Float i = pricemin ; i <= pricemax ; i++){
                for (Electric found : ManageService.listElectric){
                if (i.equals(found.getPrice())){
                    changeStringToDate(found.getDate());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),date);
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
        System.out.println("Find Date Electric");
        try {
            System.out.print("Enter Date wanna find : ");
            String date = sc.nextLine();
            Electric electric = null;
            for (Electric found : ManageService.listElectric){
                changeStringToDate(found.getDate());
                if (found.getDate().equals(date)){
                    electric = found ;
                     break ;
                }
            }
            if (electric== null){
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
            String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),dateN);
            System.out.println(row);
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void findDateForm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Find Input Date Electric");
        try {
            System.out.print("Enter Date wanna find : ");
            String daymin = sc.nextLine();
            Electric electric = null;
            System.out.print(" to : ");
            String daymax = sc.nextLine();
            
            System.out.println("Information Price Electric ");
            String header = String.format("%5s%35s%30s%20s%20s%20s%20s" , "Name" , "PLU" , "Inventory Number" , "Desription" , "Price" ,"Input Date","Today");
            System.out.println(header);
            String date ;
            Date now = new Date();
            SimpleDateFormat newDate = new SimpleDateFormat("dd/MM/yyyy");
            date = newDate.format(now);
            Integer i ;
            for ( i = 0 ; i <= daymax.compareTo(daymin) ; i++){
                for ( Electric found : ManageService.listElectric){
                    if(i.equals(found.getDate().compareTo(daymin))){
                    changeStringToDate(found.getDate());
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    String row = String.format("%5s%32s%d%20d%30s%20.2f%22s%20s", electric.getName() ,"ESM-", electric.getId() , electric.getQuantity() , electric.getDesription() , electric.getPrice(),electric.getDate(),date);
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
        for ( Electric sum : ManageService.listElectric){
            sumP = sumP + sum.getQuantity() ;
        }
        System.out.println("Total Number of Electric in Stock : "+sumP);
    }
    public void sumPrice(){
        Float sumP = (float) 0.0 ;
        for (Electric sum : ManageService.listElectric){
                sum.setTotal(sum.getPrice()*sum.getQuantity());
                sumP = sumP + sum.getTotal();
        }
        System.out.println("Total Price : "+sumP);
    }
   
    
}
