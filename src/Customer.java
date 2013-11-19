/**
 * Class Customer
 * @author STAS—Ú‡Ò
 * @version 1.0
 */
public class Customer {
	
	/** Name Customer. */
	private String name;
	/** Phone. */
	private String mobile;
	/** Address. */
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
	 * Initialization a field {@link Customer#mobile}
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
