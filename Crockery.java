public class Crockery extends HangHoa{
    Crockery(Integer id ,String name ,Integer quantity , String desription ,Float price , String date ){
        super(id, name, quantity, desription, price, date);
    }
    Crockery(){
        super();
    }
    Crockery(String name ,Integer quantity , String desription ,Float price){
        super(name, quantity, desription, price);
    }
}
