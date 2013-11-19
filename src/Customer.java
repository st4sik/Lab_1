/**
 * ������w������ ����� �������� "��������".
 * @author STAS����
 * @version 1.0
 */
public class Customer {
	
	/** ��� ���������. */
	private String name;
	/** �������. */
	private String mobile;
	/** �����. */
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
	 * �������������� ���� {@link Customer#mobile}
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
