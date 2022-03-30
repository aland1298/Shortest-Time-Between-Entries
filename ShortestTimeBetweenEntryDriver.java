import java.io.*;
import java.util.*;

/**
 * 
* Driver class parses input file (text.txt) into an array. Which is then passed too 
* a different class to perform the actual calculations which is then returned to print
* to this class.
* <br/><br/>
* <Strong>NOTE:<Strong/> prefill <i>FILE_NAME<i/> before running program.
* @author Alan Dobrzelecki
*
 */
public class ShortestTimeBetweenEntryDriver {
	private static final String FILE_NAME = "!!!ENTER FILE PATH!!!";
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File(FILE_NAME)); 
		String[] times = new String[getFileSize(in)]; 
		
		in = new Scanner(new File(FILE_NAME)); 
		fillArray(times, in);
		
		System.out.println(ShortestTimeBetweenEntryCalc.solve(times));
	}
	
	/**
	 * Returns the size of the file.
	 * @param in - scanner for the file
	 * @return size - the size of the file.
	 */
	public static int getFileSize(Scanner in) {
		int size = 0;
		while(in.hasNextLine()) {
			size++;
			in.next();
		}
		return size;
	}
	
	/**
	 * Fills array. 
	 * @param arr - the array to fill
	 * @param in - the data too fill the array from
	 */
	public static void fillArray(String[] arr, Scanner in) {
		for(int i = 0; in.hasNextLine(); i++) {
			arr[i] = in.next();
		}
	}

}
