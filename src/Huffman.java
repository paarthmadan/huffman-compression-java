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
		
		String [] dictionaryKeys = new String[R];
		createKeys(dictionaryKeys, root, "");
		
		for(int i = 0; i < dictionaryKeys.length; i++){
			if(!(dictionaryKeys[i] == null)){
				System.out.println((char)(i) + ": " + dictionaryKeys[i]);
			}
		}
		
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
		
		while(pq.size() > 1){
			Node right = pq.remove();
			Node left = pq.remove();
			Node parent = new Node('\0', left.getFrequency() + right.getFrequency(), left, right);
			pq.add(parent);
		}
		
		return pq.poll();
	}
	
	public static void createKeys(String [] keys, Node current, String key){
		if(current.isLeaf()){
			keys[current.getSymbol()] = key;
		}else{
			createKeys(keys, current.left, key + "0");
			createKeys(keys, current.right, key + "1");
		}
	}
	
}
