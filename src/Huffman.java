import java.util.PriorityQueue;
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
		
		Node root = buildTree(frequency);
			
	}
	
	public static Node buildTree(int [] frequency){
		//Create priority queue for nodes
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(char i = 0; i < frequency.length; i++){
			if(frequency[i] > 0){
				//create leaf nodes, and add it to the priority queue
				pq.add(new Node(i, frequency[i], null, null));
			}
		}
		
		System.out.println(pq.toString());
		
		
		return pq.poll();
	}
	
}
