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
	
	void Command()
	{
		this.command=command;
		c.fileLoad();
		
	}
	void setCommand(String command)
	{
		this.command=command;
	}
	
	void Run()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			if(command.equals("Add_Customer"))
			{
				System.out.println("Name, Phone, Address, ID\n");
				String comm=in.readLine();
				String param[]=comm.split(", ");
				c.addToCustomer(param[0], param[1], param[2], Integer.parseInt(param[3]));
			}
		
			if(command.equals("Add_Order"))
			{
				System.out.println("Number Order, Number Customer, Date, Amount Order, ID ");
				String comm=in.readLine();
				String param[]=comm.split(", ");
				c.addToOrder(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
						Integer.parseInt(param[3]), Integer.parseInt(param[4]));
			
			}
	
			if(command.equals("Print_Order"))
			{
				for(int i=0;i<c.mo.getOrder().size();i++)
					System.out.println(c.mo.getOrder().get(i).getNumber()+"\t"+c.mo.getOrder().get(i).getCustomer()+
							"\t"+c.mo.getOrder().get(i).getDate()+"\t"+c.mo.getOrder().get(i).getSumm()+"\t"+
									c.mo.getOrder().get(i).getId());
			}
			
			if(command.equals("Print_Customer"))
			{
				for(int i=0;i<c.mc.getCustomer().size();i++)
					System.out.println(c.mc.getCustomer().get(i).getName()+"\t"+c.mc.getCustomer().get(i).getMobile()+"\t"+
							c.mc.getCustomer().get(i).getAddress()+"\t"+c.mc.getCustomer().get(i).getId());
			}
	
			if(command.equals("Commit"))
			{
				c.fileSave();
				System.out.println("Records are saved.");
			}
	
			if(command.equals("Delete_Order"))
			{
				System.out.println("Enter the ID: ");
				int id=Integer.parseInt(in.readLine());
				c.deleteFromOrder(id);
			}
			
			if(command.equals("Delete_Customer"))
			{
				System.out.println("Enter the ID: ");
				int id=Integer.parseInt(in.readLine());
				c.deleteFromCustomer(id);
			}
		
			if(command.equals("Change_Order"))
			{
				System.out.println("Number Order, Number Customer, Date, Amount Order, ID\n");
				String comm=in.readLine();
				String param[]=comm.split(", ");
				c.changeToOrder(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
						Integer.parseInt(param[3]), Integer.parseInt(param[4]));
			}
	
			if(command.equals("Change_Customer"))
			{
				System.out.println("Name, Phone, Address, ID\n");
				String comm=in.readLine();
				String param[]=comm.split(", ");
				c.changeToCustomer(param[0], param[1], param[2], Integer.parseInt(param[3]));
			}
		
			if(command.equals("Help"))
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
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
	}
}
