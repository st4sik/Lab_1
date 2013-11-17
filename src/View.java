
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class View {

	public static void main(String[] argv)
	{
		try
		{
			String command="";
			Controller c=new Controller();
			c.FileLoad();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while (command!="Exit")
			{
				System.out.println("����� �������: Help. ������� �������: \n");
				command=in.readLine();
			
				if(command.equals("Add_Customer"))
				{
					System.out.println("��������, �������, �����, ID\n");
					String comm=in.readLine();
					String param[]=comm.split(", ");
					c.Add_Customer(param[0], param[1], param[2], Integer.parseInt(param[3]));
					System.out.println("������ ���������");
				}
			
				if(command.equals("Add_Order"))
				{
					System.out.println("�����, ��������, ����, ����� ������, ID ");
					String comm=in.readLine();
					String param[]=comm.split(", ");
					c.Add_Order(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
						Integer.parseInt(param[4]), Integer.parseInt(param[4]));
					System.out.println("������ ���������");
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
										c.mc.getCustomer().get(i).getAdress()+"\t"+c.mc.getCustomer().get(i).getId());
				}
			
				if(command.equals("Commit"))
				{
					c.FileSave();
					System.out.println("������ ���������");
				}
			
				if(command.equals("Delete_Order"))
				{
					System.out.println("������� ID: ");
					int id=Integer.parseInt(in.readLine());
					c.Delete_Order(id);
				}
				if(command.equals("Delete_Customer"))
				{
					System.out.println("������� ID: ");
					int id=Integer.parseInt(in.readLine());
					c.Delete_Customer(id);
				}
				
				if(command.equals("Change_Order"))
				{
					System.out.println("�����, ��������, ����, ����� ������, ID\n");
					String comm=in.readLine();
					String param[]=comm.split(", ");
					c.Change_Order(Integer.parseInt(param[0]), Integer.parseInt(param[1]),param[2], 
							Integer.parseInt(param[3]), Integer.parseInt(param[4]));
				}
			
				if(command.equals("Change_Customer"))
				{
					System.out.println("��������, �������, �����, ID\n");
					String comm=in.readLine();
					String param[]=comm.split(", ");
					c.Change_Customer(param[0], param[1], param[2], Integer.parseInt(param[3]));
				}
				
				if(command.equals("Help"))
				{
					System.out.println(
							"Add_Order - ���������� ������ � ������� \"������\"\n"+
							"Add_Customer - ���������� ������ � ������� \"���������\"\n"+
							"Change_Order - �������� ������ � ������� \"������\"\n"+
							"Change_Customer - �������� ������ � ������� \"���������\"\n"+
							"Delete_Order - ������� ������ � ������� \"������\"\n"+
							"Delete_Customer - ������� ������ � ������� \"���������\"\n"+
							"Print_Order - �������� ������� \"������\"\n"+
							"Print_Customer - �������� ������� \"���������\"\n"+
							"Commit - ��������� ��������� ����");
					}
				}
			} 
		catch (IOException e)
		{
			System.out.println(e.toString());
		}	
	}
}
