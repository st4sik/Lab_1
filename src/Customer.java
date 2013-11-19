/**
 * Предстwавляет собой сущность "Заказчик".
 * @author STASСтас
 * @version 1.0
 */
public class Customer {
	
	/** Имя заказчика. */
	private String name;
	/** Телефон. */
	private String mobile;
	/** Адрес. */
	private String address;
	/** ID. */
	private int id;
	
	public void setId(int id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	/**
	 * 
	 * Инициализирует поле {@link Customer#mobile}
	 * @see Customer
	 */
	public void setMobile(String mobile)
	{
		this.mobile=mobile;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public String getMobile()
	{
		return this.mobile;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public int getId()
	{
		return this.id;
	}
}
