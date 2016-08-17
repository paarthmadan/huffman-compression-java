
public class Node implements Comparable<Node>{

	int frequency;
	Node left;
	Node right;
	char symbol;
	
	public Node(char symbol, int frequency, Node left, Node right){
		this.symbol = symbol;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeaf(){
		if(left == null && right == null){
			return true;
		}
		return false;
	}
	
	public int compareTo(Node other){
		return this.frequency - other.frequency;
	}
	
	public char getSymbol(){
		return symbol;
	}
	
	public int getFrequency(){
		return frequency;
	}
	

}
