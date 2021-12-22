public class Food extends HangHoa {
    Food(Integer id ,String name ,Integer quantity , String desription ,Float price , String date ){
        super(id, name, quantity, desription, price, date);
    }
    Food(){}
    Food(String name ,Integer quantity , String desription ,Float price){
        super(name, quantity, desription, price);
    }
}
