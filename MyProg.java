import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class MyProg {
	private static int base; /// parse digits using this base;
	private static Scanner user_input;
	
	/**
	 * 
	 * @param args argument list
	 */
	public static void main(String[] args) {
		base = 10;
		user_input = new Scanner(System.in); // set default 
		if(parseArgs(args)){
			String text = user_input.next();
			System.out.println(getSum(text,base));		
		}
				
	}
	
	/**
	 * Sets key variables in myProg according to arguments. Exits with code -1 
	 * if file parameter set with no valid filepath
	 * @param args arguments array
	 */
	public static boolean parseArgs(String [] args){
		// iterate arguments
		for( int i = 0; i< args.length; i++){
			switch (args[i]){
				case "-f" :
					if (i<args.length-1){
						try {
							// reset if found
							user_input = new Scanner(new File(args[++i])); 
						} catch (FileNotFoundException e) {
							System.err.println("File not found, "
									+ "ensure that filepath is specified and "
									+ "correct");
						}	
					}else{
						System.err.println("filename not specified");
						return false;
					}
					break;
				case "-x" :
					base = 16;
					break;
				case "": break;
				default : 
					System.err.println("\""+args[i] + "\" is not a valid arg");
			}
		}
		return true;
	}
	/**
	 * Takes in a string, iterates each character and comes up with a sum. 
	 * ignores any unparsable characters.
	 * @param str string to read digits from
	 * @param base base to be parsed in
	 * @return
	 */
	public static long getSum(String str, int base){
		long sum = 0;
		// iterate each character in str
		for(char digit : str.toCharArray()){
			int num = 0;
			try{
				// parse digit using base
				num =Integer.parseInt(""+digit,base);
			}catch(NumberFormatException e){
				// ignore unparsable chars
			}
			sum += num;
		}
		return sum;
		
	}
}

