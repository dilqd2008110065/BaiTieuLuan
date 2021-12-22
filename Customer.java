import java.util.ArrayList;
import java.util.List;
public class Customer {
    private Integer id;
	private String customerName;
	private String phone;
	private String email;
	
	private List<CustomerDetail> personDetails = new ArrayList<CustomerDetail>();
	
	
	public Customer(Integer id, String customerName, String phone, String email) {
		this.id = id;
		this.customerName = customerName;
		this.phone = phone;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<CustomerDetail> getPersonDetails() {
        return personDetails;
    }
    public void setPersonDetails(List<CustomerDetail> personDetails) {
        this.personDetails = personDetails;
    }
    

    
}
