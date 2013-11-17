

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * ������������ ����� �����-���������� ��� ������ � Model Class {link MCustomer}
 * @author STAS
 * @version 1.0
 *
 */
public class Controller {
	MCustomer mc=new MCustomer();
	MOrder mo=new MOrder();
	
	/**
	 * ������� ��� ���������� ������ � �������� "Order"
	 * @param number ����� ������
	 * @param customer ����� ���������
	 * @param date ����
	 * @param summ ����� ������
	 * @param id ID
	 */
	public void Add_Order(int number, int customer, String date, int summ, int id)
	{
		this.mo.Add(number, customer, date, summ, id);
	}
	
	/**
	 * ������ ��� �������� ������ � �������� "Order"
	 * @param id ID
	 */
	public void Delete_Order(int id)
	{
		if(mo.Delete(id))
		{
			System.out.println("������ �������.");
		}
		else System.out.println("������ ���������.");
			
	}
	
	public void Change_Order(int number, int customer, String date, int summ, int id)
	{
		if (mo.Change(number, customer, date, summ, id))
		{
			System.out.println("������ ��������.");
		}
		else System.out.println("������ ����������.");
	}
	/**
	 * ������ ��� ���������� ������ � �������� "Customer"
	 * �������� @param name ��� ���������
	 * @param mobile �������
	 * @param address �����
	 * @param id ID
	 */
	public void Add_Customer(String name, String mobile, String address, int id)
	{
		this.mc.Add(name, mobile, address, id);
	}
	/**
	 * ������ ��� �������� ������ � �������� "Customer"
	 * @param id ID ���������
	 */
	public void Delete_Customer(int id)
	{
		if(mc.Delete(id))
		{
			System.out.println("������ �������.");
		}
		else System.out.println("������ ���������.");
		
	}

	public void Change_Customer(String name, String mobile, String address, int id)
	{
		if (mc.Change(name, mobile, address, id))
		{
			System.out.println("������ ��������.");
		}
		else System.out.println("������ ����������.");
	}
	
	public void FileSave()
	{
		try
		{
			StringBuffer a=new StringBuffer();
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
			out.close();	
		
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}		 	
	}
	
	/**
	 * ������ ��� �������� ����� Customer.txt � �������� "Customer" � �������� ����� Order.txt � �������� "Order"
	 */
	public void FileLoad()
	{
		try
		{
			String a;
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
			reader.close();
		}
		catch(IOException e)
		{
		 System.out.println(e.toString());
		}

	}
}
