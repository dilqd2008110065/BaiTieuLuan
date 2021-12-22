import java.util.InputMismatchException;
import java.util.Scanner;
public class ListofCustomers {
    
    public void buyFood(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Buy Product");
        try {
            System.out.print("Order code : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name : ");
            String customerName = sc.nextLine();
            System.out.print("Number Phone : ");
            String phone = sc.nextLine();
            System.out.print("Email : ");
            String email = sc.nextLine();
            Customer person = new Customer(id, customerName, phone, email);
            Integer productId = -1 ;
            while(true){
                sc = new Scanner(System.in);
                System.out.print("Enter PLU : ");
                productId = sc.nextInt();
                if (productId.equals(-1)){
                    break;
                }
                System.out.print("Enter Number Product : ");
                int quantity = sc.nextInt();
                Food food = null ;
                for (Food check : ManageService.listFood){
                    if(food.getId().equals(productId)){
                        food = check ;
                        break ;
                    }
                if (food == null){
                    System.out.println("PLU product does not exist ");
                }
                    CustomerDetail personDetail = new CustomerDetail();
                    personDetail.setId(1);
                    personDetail.setOrderId(person.getId());
                    personDetail.setPrice(food.getPrice());
                    personDetail.setProductId(productId);
                    personDetail.setQuantity(quantity);

                    person.getPersonDetails().add(personDetail);
                }
            }
            ManageService.listperson.add(person);
        } catch(InputMismatchException ei){
            System.out.println("You entered it wrong  , please re-enter ");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }}
        public void buyElectric(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Buy Product");
            try {
                System.out.print("Order code : ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name : ");
                String customerName = sc.nextLine();
                System.out.print("Number Phone : ");
                String phone = sc.nextLine();
                System.out.print("Email : ");
                String email = sc.nextLine();
                Customer person = new Customer(id, customerName, phone, email);
                Integer productId = -1 ;
                while(true){
                    sc = new Scanner(System.in);
                    System.out.print("Enter PLU : ");
                    productId = sc.nextInt();
                    if (productId.equals(-1)){
                        break;
                    }
                    System.out.print("Enter Number Product : ");
                    int quantity = sc.nextInt();
                    Electric electric = null ;
                    for (Electric check : ManageService.listElectric){
                        if(electric.getId().equals(productId)){
                            electric = check ;
                            break ;
                        }
                    if (electric == null){
                        System.out.println("PLU product does not exist ");
                    }
                        CustomerDetail personDetail = new CustomerDetail();
                        personDetail.setId(1);
                        personDetail.setOrderId(person.getId());
                        personDetail.setPrice(electric.getPrice());
                        personDetail.setProductId(productId);
                        personDetail.setQuantity(quantity);
    
                        person.getPersonDetails().add(personDetail);
                    }
                }
                ManageService.listperson.add(person);
            } catch(InputMismatchException ei){
                System.out.println("You entered it wrong  , please re-enter ");
            } catch(Exception e){
                System.out.println(e.getMessage());
            }}
            public void buyCrockery(){
                Scanner sc = new Scanner(System.in);
                System.out.println("Buy Product");
                try {
                    System.out.print("Order code : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name : ");
                    String customerName = sc.nextLine();
                    System.out.print("Number Phone : ");
                    String phone = sc.nextLine();
                    System.out.print("Email : ");
                    String email = sc.nextLine();
                    Customer person = new Customer(id, customerName, phone, email);
                    Integer productId = -1 ;
                    while(true){
                        sc = new Scanner(System.in);
                        System.out.print("Enter PLU : ");
                        productId = sc.nextInt();
                        if (productId.equals(-1)){
                            break;
                        }
                        System.out.print("Enter Number Product : ");
                        int quantity = sc.nextInt();
                        Crockery crockery = null ;
                        for (Crockery check : ManageService.listCrockery){
                            if(crockery.getId().equals(productId)){
                                crockery = check ;
                                break ;
                            }
                        if (crockery == null){
                            System.out.println("PLU product does not exist ");
                        }
                            CustomerDetail personDetail = new CustomerDetail();
                            personDetail.setId(1);
                            personDetail.setOrderId(person.getId());
                            personDetail.setPrice(crockery.getPrice());
                            personDetail.setProductId(productId);
                            personDetail.setQuantity(quantity);
        
                            person.getPersonDetails().add(personDetail);
                        }
                    }
                    ManageService.listperson.add(person);
                } catch(InputMismatchException ei){
                    System.out.println("You entered it wrong  , please re-enter ");
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }

    }
    public void showFood(){
        System.out.println("*** List Person ***");
        String header = String.format("%s%15s%30s%30s" , "ID" , "Name" , "Number Phone" , "Email" );
        System.out.println(header);
        FoodService foodService = new FoodService();
        for (Customer buying : ManageService.listperson){
            String row = String.format("%d%15s%20s%30s", buying.getId() ,buying.getCustomerName() , buying.getPhone() ,buying.getEmail());
           System.out.println(row);
           String personDetailHeader = String.format("%30s%10s%30s%30s" , "Number" , "Name Product" , "Price" , "Number" );
           System.out.println(personDetailHeader);
           int i = 1 ;
           for (CustomerDetail PD : buying.getPersonDetails()){
               Food food = foodService.getById(PD.getOrderId());
               String personDetailRow = String.format("%30s%10s%30s%30s" , i , food.getName() , PD.getPrice() , PD.getQuantity() );
               System.out.println(personDetailRow);
               i++;
           }}}

           public void showElectric(){
            System.out.println("*** List Person ***");
            String header = String.format("%s%15s%30s%30s" , "ID" , "Name" , "Number Phone" , "Email" );
            System.out.println(header);
            ElectricService electricService = new ElectricService();
            for (Customer buying : ManageService.listperson){
                String row = String.format("%d%15s%20s%30s", buying.getId() ,buying.getCustomerName() , buying.getPhone() ,buying.getEmail());
               System.out.println(row);
               String personDetailHeader = String.format("%30s%10s%30s%30s" , "Number" , "Name Product" , "Price" , "Number" );
               System.out.println(personDetailHeader);
               int i = 1 ;
               for (CustomerDetail PD : buying.getPersonDetails()){
                   Electric electric = ElectricService.getById(PD.getOrderId());
                   String personDetailRow = String.format("%30s%10s%30s%30s" , i , electric.getName() , PD.getPrice() , PD.getQuantity() );
                   System.out.println(personDetailRow);
                   i++;
               }
    
        }
    }
    public void showCrockery(){
        System.out.println("*** List Person ***");
        String header = String.format("%s%15s%30s%30s" , "ID" , "Name" , "Number Phone" , "Email" );
        System.out.println(header);
        CrockeryService crockeryService = new CrockeryService();
        for (Customer buying : ManageService.listperson){
            String row = String.format("%d%15s%20s%30s", buying.getId() ,buying.getCustomerName() , buying.getPhone() ,buying.getEmail());
           System.out.println(row);
           String personDetailHeader = String.format("%30s%10s%30s%30s" , "Number" , "Name Product" , "Price" , "Number" );
           System.out.println(personDetailHeader);
           int i = 1 ;
           for (CustomerDetail PD : buying.getPersonDetails()){
               Crockery crockery = CrockeryService.getById(PD.getOrderId());
               String personDetailRow = String.format("%30s%10s%30s%30s" , i , crockery.getName() , PD.getPrice() , PD.getQuantity() );
               System.out.println(personDetailRow);
               i++;
           }

    }}}
