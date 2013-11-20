
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class View {

	public static void main(String[] argv)
	{
		try
		{
			String command="";
			/*Controller c=new Controller();
			c.FileLoad();*/
			Command comm=new Command();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while (!command.equals("Exit"))
			{
				System.out.println("Manual: Help. Enter the command: \n");
				command=in.readLine();
				comm.setCommand(command);
				comm.Run();
				
			}
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		catch (NullPointerException e)
		{
			System.out.println(e.toString());
			System.exit(-1);
		}
	}
}
