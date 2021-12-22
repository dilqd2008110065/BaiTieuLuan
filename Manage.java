import java.util.InputMismatchException;
import java.util.Scanner;

public class Manage {
    public static void main(String[] args) {
        ManageService managesService = new ManageService();
        managesService.inventoryFood();
        int function = 0 ;
        do{
            managesService.menu();
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Selection : ");
                function = sc.nextInt();
                switch(function){
                    case 1 : 
                    managesService.menuActive();
                    managesService.activemenuFood();
                    break;
                    case 2 : 
                    managesService.menuActive();
                    managesService.inventoryElectric();
                    managesService.activemenuElectric();
                    break;
                    case 3 : 
                    managesService.menuActive();
                    managesService.inventoryCrockery();
                    managesService.activemenuCrockery();
                    break;
                    case 4 : 
                    break;
                }
            } catch(InputMismatchException ei){
                System.out.println("You entered it wrong , please re-enter ");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(function != 4);
    }
    
}
