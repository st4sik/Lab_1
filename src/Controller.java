

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Представляет собой Класс-контроллер для работы с Model Class {link MCustomer}
 * @author STAS
 * @version 1.0
 *
 */
public class Controller {
	MCustomer mc=new MCustomer();
	MOrder mo=new MOrder();
	
	/**
	 * Функция для добавление записи в сущность "Order"
	 * @param number Номер заказа
	 * @param customer Номер заказчика
	 * @param date Дата
	 * @param summ Сумма заказа
	 * @param id ID
	 */
	public void Add_Order(int number, int customer, String date, int summ, int id)
	{
		for(Order item : this.mo.order)
		{
			if(item.getId()==id)
			{
				System.out.println("Ошибка уникальности");
				return;
			}
		}
		this.mo.Add(number, customer, date, summ, id);
		System.out.println("Запись добавлена");
	}
	
	/**
	 * Фунция для удаление записи в сущности "Order"
	 * @param id ID
	 */
	public void Delete_Order(int id)
	{
		if(mo.Delete(id))
		{
			System.out.println("Запись удалена.");
		}
		else System.out.println("Запись неудалена.");
			
	}
	
	public void Change_Order(int number, int customer, String date, int summ, int id)
	{
		if (mo.Change(number, customer, date, summ, id))
		{
			System.out.println("Запись изменена.");
		}
		else System.out.println("Запись неизменена.");
	}
	/**
	 * Фунция для добавления записи в сущность "Customer"
	 * Параметр @param name Имя заказчика
	 * @param mobile Телефон
	 * @param address Адрес
	 * @param id ID
	 */
	public void Add_Customer(String name, String mobile, String address, int id)
	{
		for(Customer item: this.mc.customer)
		{
			if(item.getId()==id)
			{
				System.out.println("Ошибка уникальности");
				return;
			}
		}
		this.mc.Add(name, mobile, address, id);
		System.out.println("Запись добавлена");
	}
	/**
	 * Фунция для удаления записи в сущности "Customer"
	 * @param id ID Заказчика
	 */
	public void Delete_Customer(int id)
	{
		if(mc.Delete(id))
		{
			System.out.println("Запись удалена.");
		}
		else System.out.println("Запись неудалена.");
		
	}

	public void Change_Customer(String name, String mobile, String address, int id)
	{
		if (mc.Change(name, mobile, address, id))
		{
			System.out.println("Запись изменена.");
		}
		else System.out.println("Запись неизменена.");
	}
	
	private void Check() throws CheckFileException
	{
		/*ID, Значение*/
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
	 * Сохранить сущности в файлы Customer.txt и Order.txt
	 */
	public void FileSave()
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
			          new FileOutputStream("Custom.xml")));
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
	 * Фунция для загрузки файла Customer.txt в сущность "Customer" и загрузки файла Order.txt в сущность "Order"
	 */
	public void FileLoad()
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
			XMLDecoder decoder = new XMLDecoder(new FileInputStream("Order.xml"));
			ArrayList<Order> or=(ArrayList<Order>)decoder.readObject();
			this.mo.order=or;
			decoder.close();
			
			decoder = new XMLDecoder(new FileInputStream("Custom.xml"));
			ArrayList<Customer> mc=(ArrayList<Customer>)decoder.readObject();
			this.mc.customer=mc;
			decoder.close();
			
			try
			{
				Check();
			}
			catch(CheckFileException e)
			{
				System.out.println(e.toString());
				System.exit(-1);
			}
			
		     
		}
		catch(IOException e)
		{
		 System.out.println(e.toString());
		}

	}
}
