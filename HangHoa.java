import java.util.InputMismatchException;
import java.util.Scanner;

public class HangHoa {
    private Integer id ;
    private String name ;
    private Integer quantity;
    private String desription;
    private Float price;
    private String date ;
    private Integer sort;
    private Float total;
    HangHoa(Integer id ,String name ,Integer quantity , String desription ,Float price , String date ){
        this.id = id ;
        this.name = name ;
        this.quantity = quantity ;
        this.desription = desription ;
        this.price = price ;
        this.date = date ;
    }
    HangHoa(){}
    HangHoa(String name ,Integer quantity , String desription ,Float price){
        this.name = name ;
        this.quantity = quantity ;
        this.desription = desription ;
        this.price = price ;
    }
    public Float getTotal() {
        return total ;
    }
    public void setTotal(Float total) {
        this.total = total;
    }

    public int getSort() {
        return sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getDesription() {
        return desription;
    }
    public void setDesription(String desription) {
        this.desription = desription;
    }
    public Integer getId() {
       return id;
   }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    
    
    
    
}

