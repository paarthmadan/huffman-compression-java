import java.util.Scanner;

public class Huffman {
	
	//represents the total number of characters in the ASCII alphabet
	private final static int R = 256;
	
	public static void main(String [] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string or file, that needs to be compressed:");
		
		String line = input.nextLine();
		char [] characters = line.toCharArray();
		
		
		int [] frequency = new int[R];
		
		for(int i = 0 ; i < characters.length; i++){
			frequency[characters[i]]++;
		}
			
	}
	
}
