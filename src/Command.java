import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class Command
 * @author STAS
 *
 */
public class Command {

	private String command;
	private Controller c=new Controller();
	
	public void Command()
	{
		this.command=command;
		
	}
	void setCommand(String command)
	{
		this.command=command;
		
	}
	void fileLoad()
	{
		this.c.fileLoad();
	}
	void addCustomer(BufferedReader in) throws IOException
	{
		System.out.println("Name, Phone, Address, ID\n");
		String comm=in.readLine();
		String param[]=comm.split(", ");
		this.c.addToCustomer(param[0], param[1], param[2], Integer.parseInt(param[3]));
	}
	
	void addOrder(BufferedReader in) throws IOException
	{
		System.out.println("Number Order, Number Customer, Date, Amount Order, ID ");
		String comm=in.readLine();
		String param[]=comm.split(", ");
		this.c.addToOrder(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
				Integer.parseInt(param[3]), Integer.parseInt(param[4]));
	}
	
	void printOrder()
	{
		for(int i=0;i<c.mo.getOrder().size();i++)
			System.out.println(this.c.mo.getOrder().get(i).getNumber()+"\t"+this.c.mo.getOrder().get(i).getCustomer()+
					"\t"+this.c.mo.getOrder().get(i).getDate()+"\t"+this.c.mo.getOrder().get(i).getSumm()+"\t"+
					this.c.mo.getOrder().get(i).getId());
	}
	
	void printCustomer()
	{
		for(int i=0;i<c.mc.getCustomer().size();i++)
			System.out.println(c.mc.getCustomer().get(i).getName()+"\t"+c.mc.getCustomer().get(i).getMobile()+"\t"+
					c.mc.getCustomer().get(i).getAddress()+"\t"+c.mc.getCustomer().get(i).getId());
	}
	
	void commit()
	{
		c.fileSave();
		System.out.println("Records are saved.");
	}
	
	void deleteOrder(BufferedReader in) throws IOException
	{
		System.out.println("Enter the ID: ");
		int id=Integer.parseInt(in.readLine());
		c.deleteFromOrder(id);
	}
	
	void deleteCustomer(BufferedReader in)throws IOException
	{
		System.out.println("Enter the ID: ");
		int id=Integer.parseInt(in.readLine());
		c.deleteFromCustomer(id);
	}
	
	void changeOrder(BufferedReader in) throws IOException
	{
		System.out.println("Number Order, Number Customer, Date, Amount Order, ID\n");
		String comm=in.readLine();
		String param[]=comm.split(", ");
		c.changeToOrder(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
				Integer.parseInt(param[3]), Integer.parseInt(param[4]));
	}
	
	void changeCustomer(BufferedReader in) throws IOException
	{
		System.out.println("Name, Phone, Address, ID\n");
		String comm=in.readLine();
		String param[]=comm.split(", ");
		c.changeToCustomer(param[0], param[1], param[2], Integer.parseInt(param[3]));
	}
	
	void help()
	{
		System.out.println(
				"Add_Order - adding a record to the table \"Order\"\n"+
				"Add_Customer - adding a record to the table \"Customer\"\n"+
				"Change_Order - change a record to the table \"Order\"\n"+
				"Change_Customer - change a record to the table \"Customer\"\n"+
				"Delete_Order - delete a record to the table \"Order\"\n"+
				"Delete_Customer - change a record to the table \"Customer\"\n"+
				"Print_Order - print \"Order\"\n"+
				"Print_Customer - print \"Customer\"\n"+
				"Commit - save the changes\n"+
				"Exit - exit");
	}
	void run()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			switch(command)
			{
			case "Add_Customer": {this.addCustomer(in);break;}
			case "Print_Order": {this.printOrder();break;}
			case "Add_Order": {this.addOrder(in);break;}
			case "Print_Customer": {this.printOrder();break;}
			case "Commit":{this.commit();break;}
			case "Delete_Order": {this.deleteOrder(in);break; }
			case "Delete_Customer": {this.deleteCustomer(in); break;}
			case "Change_Order": {this.changeOrder(in); break;}
			case "Change_Customer": {this.changeCustomer(in);break;}
			case "Help": {this.help();break;}
			}
			/*if(command.equals("Add_Customer"))
			{
				this.addCustomer(in);
			}
		
			if(command.equals("Add_Order"))
			{
				this.addOrder(in);
			}
	
			if(command.equals("Print_Order"))
			{
				this.printOrder();
			}
			
			if(command.equals("Print_Customer"))
			{
				this.printCustomer();
			}
	
			if(command.equals("Commit"))
			{
				this.commit();
			}
	
			if(command.equals("Delete_Order"))
			{
				this.deleteOrder(in);
			}
			
			if(command.equals("Delete_Customer"))
			{
				deleteCustomer(in);
			}
		
			if(command.equals("Change_Order"))
			{
				this.changeOrder(in);
			}
	
			if(command.equals("Change_Customer"))
			{
				this.changeCustomer(in);
			}
		
			if(command.equals("Help"))
			{
				this.help();
			}*/
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
	}
}
