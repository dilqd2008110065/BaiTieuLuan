public class Electric extends HangHoa {
    Electric(Integer id ,String name ,Integer quantity , String desription ,Float price , String date ){
       super(id, name, quantity, desription, price, date);
    }
    Electric(){}
    Electric(String name ,Integer quantity , String desription ,Float price){
        super(name, quantity, desription, price);
    }
}
