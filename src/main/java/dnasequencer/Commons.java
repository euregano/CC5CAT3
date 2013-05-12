package dnasequencer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class provides common methods.
 * 
 * @author Eugen Meissner
 *
 */
public class Commons {

	/**
	 * This method reads a file and returns the file content as char array.
	 * Furthermore the method do not read the line termination char '\n'.
	 * 
	 * @param pathname
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static char[] readFile(String pathname) throws FileNotFoundException{
		File file = new File(pathname);
		String str = "";		
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
			str+=scanner.nextLine();
		}
		return str.toLowerCase().toCharArray();
	}
	
	/**
	 * This method prints yes if b is true otherwise 'no'.
	 * 
	 * @param b - a boolean
	 * @return 'yes' if b is true otherwise 'no'.
	 */
	public static String toYesNo(boolean b){
		return b?"yes":"no";
	}
}
