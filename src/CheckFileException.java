/**
 * Exception to check for duplicates in files.
 * @author s.ryabokon
 *
 */
public class CheckFileException extends Exception {
	public String toString()
	{
		return "Duplicates are in files.";
	}
}
