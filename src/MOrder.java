import java.util.ArrayList;
import java.util.List;


public class MOrder {
	
ArrayList<Order> order=new ArrayList<Order>();
	
	public void setOrder(Order order)
	{
		this.order.add(order);
	}
	
	public List<Order> getOrder()
	{
		return order;
	}
	
	public void add(int number, int customer, String date, int summ, int id)
	{
		Order order=new Order();
		order.setNumber(number);
		order.setCustomer(customer);
		order.setDate(date);
		order.setSumm(summ);
		order.setId(id);
		this.order.add(order);	
	}
	
	public boolean delete(int id)
	{
		for(int i=0;i<this.order.size();i++)
		{
			if(this.order.get(i).getId()==id)
			{
				this.order.remove(i);
				return true;
			}	
		}
		return false;
	}
	
	public boolean change(int number, int customer, String date, int summ, int id)
	{
		for (int i=0;i<this.order.size();i++)
		{
			if(this.order.get(i).getId()==id)
			{
				this.order.get(i).setNumber(number);
				this.order.get(i).setCustomer(customer);
				this.order.get(i).setDate(date);
				this.order.get(i).setSumm(summ);
				this.order.get(i).setId(id);
				return true;
			}
		}
		return false;
	}

}
