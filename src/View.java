
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class View {

	public static void main(String[] argv)
	{
		try
		{
			String command="";
			Command comm=new Command();
			comm.fileLoad();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while (!command.equals("Exit"))
			{
				System.out.println("Manual: Help. Enter the command: \n");
				command=in.readLine();
				comm.setCommand(command);
				comm.run();		
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
