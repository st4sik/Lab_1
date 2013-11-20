import java.util.ArrayList;
import java.util.List;


public class MCustomer {
	ArrayList<Customer> customer=new ArrayList<Customer>();
	
	public void setCustomer(Customer customer)
	{
		this.customer.add(customer);
	}
	
	public List<Customer> getCustomer()
	{
		return customer;
	}
	
	public void add(String name, String mobile, String address, int id)
	{
		Customer cus=new Customer();
		cus.setAddress(address);
		cus.setMobile(mobile);
		cus.setName(name);
		cus.setId(id);
		this.customer.add(cus);
		
	}
	
	public boolean delete(int id)
	{
		for(int i=0;i<this.customer.size();i++)
		{
			if(this.customer.get(i).getId()==id)
			{
				this.customer.remove(i);
				return true;
			}	
		}
		return false;
	}
	
	public boolean change(String name,String mobile, String address, int id)
	{
		for (int i=0;i<this.customer.size();i++)
		{
			if(this.customer.get(i).getId()==id)
			{
				this.customer.get(i).setAddress(address);
				this.customer.get(i).setMobile(mobile);
				this.customer.get(i).setName(name);
				return true;
			}
		}
		return false;
	}

}
