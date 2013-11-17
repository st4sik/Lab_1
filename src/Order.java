
public class Order {
	private int number;
	private int customer;
	private String date;
	private int summ;
	private int id;
	public void setNumber(int number)
	{
		this.number=number;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public void setCustomer(int customer)
	{
		this.customer=customer;
	}
	
	public void setDate(String date)
	{
		this.date=date;
	}
	
	public void setSumm (int summ)
	{
		this.summ=summ;
	}
	
	
	public int getNumber()
	{
		return this.number;
	}
	
	public int getCustomer()
	{
		return this.customer;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public int getSumm ()
	{
		return this.summ;
	}
	
	public int getId()
	{
		return this.id;
	}
}
