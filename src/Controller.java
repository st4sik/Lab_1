

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Class Controller Model Class {link MCustomer}
 * @author STAS
 * @version 1.0
 *
 */
public class Controller {
	MCustomer mc=new MCustomer();
	MOrder mo=new MOrder();
	
	/**
	 * The Function is to add a record in "Order"
	 * @param number Number Order 
	 * @param customer Number Customer
	 * @param date Data
	 * @param summ Amount Order
	 * @param id ID
	 */
	public void addToOrder(int number, int customer, String date, int summ, int id)
	{
		if(this.mc.customer.size()==0)
		{
			System.out.println("Customer is empty.");
			return;
		}
		for(Customer item: this.mc.customer)
		{
			if(item.getId()!=id)
			{
				System.out.println("ID doesn't in Customer.");
				return;
			}
		}
		for(Order item : this.mo.order)
		{
			if(item.getId()==id)
			{
				System.out.println("Error uniqueness.");
				return;
			}
		}
		this.mo.add(number, customer, date, summ, id);
		System.out.println("Record is added.");
	}
	
	/**
	 * The Function is to delete a record in "Order"
	 * @param id ID
	 */
	public void deleteFromOrder(int id)
	{
		if(mo.delete(id))
		{
			System.out.println("Record is deleted.");
		}
		else System.out.println("Record doesn't deleted.");
			
	}
	
	public void changeToOrder(int number, int customer, String date, int summ, int id)
	{
		if (mo.change(number, customer, date, summ, id))
		{
			System.out.println("Record is changed.");
		}
		else System.out.println("Record doesn't changed.");
	}
	/**
	 * The Function is to add a record in "Customer"
	 * @param name Name Customer
	 * @param mobile Phone
	 * @param address Address
	 * @param id ID
	 */
	public void addToCustomer(String name, String mobile, String address, int id)
	{
		for(Customer item: this.mc.customer)
		{
			if(item.getId()==id)
			{
				System.out.println("Error uniqueness.");
				return;
			}
		}
		this.mc.add(name, mobile, address, id);
		System.out.println("Record is added.");
	}
	/**
	 * The Function is to delete a record in "Customer"
	 * @param id ID Customer
	 */
	public void deleteFromCustomer(int id)
	{
		if(mc.delete(id))
		{
			System.out.println("Record is deleted.");
		}
		else System.out.println("Record doesn't deleted.");
		
	}

	public void changeToCustomer(String name, String mobile, String address, int id)
	{
		if (mc.change(name, mobile, address, id))
		{
			System.out.println("Record is changed.");
		}
		else System.out.println("Record doesn't changed.");
	}
	
	/**
	 * The Function is to check duplicates in files.
	 * @throws CheckFileException
	 */
	private void check() throws CheckFileException
	{
		
		Map<Integer,Integer> count=new HashMap<Integer, Integer>();
		Integer s=0;
		for(int i=0;i<this.mo.order.size();i++)
		{
			if(count.containsKey(this.mo.order.get(i).getId())==true)
			{
				s++;
			}
			count.put(this.mo.order.get(i).getId(), s++);
			s=0;	
		}
		
		for(Integer i:count.values())
		{
			if(i>=1)
			{
				throw new CheckFileException();
			}
		}
		
		count=new HashMap<Integer, Integer>();
		s=0;
		for(int i=0;i<this.mc.customer.size();i++)
		{
			if(count.containsKey(this.mc.customer.get(i).getId())==true)
			{
				s++;
			}
			count.put(this.mc.customer.get(i).getId(), s++);
			s=0;	
		}
		
		for(Integer i:count.values())
		{
			if(i==2)
			{
				throw new CheckFileException();
			}
		}	
			
	}
	/**
	 * Save files Order.xml and Customer.xml
	 */
	public void fileSave()
	{
		try
		{
			/*StringBuffer a=new StringBuffer();
			PrintWriter out = new PrintWriter(new File("Customer.txt").getAbsoluteFile());
			for(int i=0;i<mc.customer.size();i++)
			{
				a.append(mc.customer.get(i).getName()+", "+mc.customer.get(i).getMobile()+", "+
							mc.customer.get(i).getAdress()+", "+ mc.customer.get(i).getId()+'\n');	
			}
			out.print(a);
			out.close();
			
			a.setLength(0);
			
			out=new PrintWriter(new File("Order.txt").getAbsoluteFile());
			
			for(int i=0;i<mo.order.size();i++)
			{
				a.append(mo.order.get(i).getNumber()+", "+mo.order.get(i).getCustomer()+", "+
						mo.order.get(i).getDate()+", "+mo.order.get(i).getSumm()+", "+
		                                    mo.order.get(i).getId()+'\n');
			}
			out.print(a);
			out.close();*/
			
			XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
			          new FileOutputStream("Order.xml")));
			encoder.writeObject(this.mo.order);
			encoder.close();
			
			encoder = new XMLEncoder(new BufferedOutputStream(
			          new FileOutputStream("Customer.xml")));
			encoder.writeObject(this.mc.customer);
			encoder.close();				
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}		 	
	}
	
	/**
	 * The Function is to load from Customer.xml and Order.xml to Customer.xml and Order.xml
	 */
	public void fileLoad()
	{
		try
		{
			/*String a;
			BufferedReader reader = new BufferedReader(new FileReader("Customer.txt"));
			while ((a=reader.readLine())!=null)
			{
				String param[]=a.split(", ");
				if(param.length==1)
				{
					reader.close();
					return;
				}
				Add_Customer(param[0], param[1], param[2], Integer.parseInt(param[3]));
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader("Order.txt"));
			
			while ((a=reader.readLine())!=null)
			{
				String param[]=a.split(", ");
				if(param.length==1)
				{
					reader.close();
					return;
				}
				Add_Order(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
						Integer.parseInt(param[4]), Integer.parseInt(param[4]));
			}
			reader.close();*/
			File f1=new File("Order.xml");
			File f2=new File("Customer.xml");
			if (!f1.exists() || !f2.exists())
			{
					System.out.println("File Order.xml or Customer.xml is not found. Reload a program.");
					XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(
					          new FileOutputStream("Order.xml")));
					encoder.writeObject(this.mo.order);
					encoder.close();
					
					encoder = new XMLEncoder(new BufferedOutputStream(
					          new FileOutputStream("Customer.xml")));
					encoder.writeObject(this.mc.customer);
					encoder.close();
					System.exit(-1);
						
			}
			
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("Order.xml"));
			ArrayList<Order> or=(ArrayList<Order>)decoder.readObject();
			this.mo.order=or;
			decoder.close();
			
			decoder = new XMLDecoder(new FileInputStream("Customer.xml"));
			ArrayList<Customer> mc=(ArrayList<Customer>)decoder.readObject();
			this.mc.customer=mc;
			decoder.close();
			
			try
			{
				check();
			}
			catch(CheckFileException e)
			{
				System.out.println(e.toString());
				System.exit(-2);
			}
			
		     
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
			
		}

	}
}
