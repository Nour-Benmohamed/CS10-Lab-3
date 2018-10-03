import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
/**
 * 
 * @author Nour Benmohamed
 * problem set 3 
 * 5/3/2018
 * 
 *
 */

public class letter {
	//these two mins will be the extracted two trees with the smallest freqency value in the root
	protected BinaryTree<typeE> Min1 ; 
	protected BinaryTree<typeE> Min2 ;
	// this pq is what is going to be used to create the huffman code tree
	protected PriorityQueue<BinaryTree<typeE>> pq;
	protected String pathsofar = "";
	// this map will hold every character and its code
	protected Map<Character, String> charactercode;
	protected BinaryTree<typeE> huffman;
	
	
	// constructor
	public letter() {
		pq = new PriorityQueue<BinaryTree<typeE>>((BinaryTree<typeE> T1, BinaryTree<typeE> T2) -> T1.getData().getN()-T2.getData().getN());
		Min1 = new BinaryTree<typeE>(null);
		Min2 = new BinaryTree<typeE>(null);
		
	}
	
// letter is the type passed onto the binary tree nodes
	// will have method that builds the code tree
// will have method that traverses the tree and returns a map with the code words
	 /**
	  *
	  * @param fmap this method takes the frequency map as parameter and creates a huffman code tree
	  * the huffman tree will be the only element in the pq
	  */
	public void Queue(Map<Character, Integer> fmap) {
		//TODO create a root node of each caracter as a binary tree type and add it to the queue
		Set<Character> keys = fmap.keySet();
		for (Character c : keys) {
			typeE data = new typeE(c,fmap.get(c));
			BinaryTree<typeE> root= new BinaryTree<typeE>(data);
			pq.add(root);
		}
		while (pq.size()>1) {
			Min1 = pq.remove();
			Min2 = pq.remove();
			typeE data = new typeE('x',Min1.getData().getN()+Min2.getData().getN());
			BinaryTree<typeE> root = new BinaryTree<typeE>(data,Min1,Min2);
			pq.add(root);
		}
		huffman= pq.remove();
		//System.out.println(huffman);

	}
	
	/**
	 * this method returns a tree of the codes of each character in the text
	 * 
	 */
	
	public void codeMap() {		
		charactercode = new TreeMap<Character, String>();
		pathsofar="";
		addToMap(huffman, charactercode, pathsofar);	
		System.out.println(charactercode);
	}
	public void addToMap (BinaryTree<typeE> T, Map<Character, String> charactercode, String pathsofar) {
		/**
		 * this is a helper function to traverse the tree and get all the codes and add them to a map
		 */
		//System.out.println("method called");
		if (T.isLeaf()) {
			charactercode.put( T.getData().getC(), pathsofar);
			//System.out.println( T.getData().getC()+pathsofar);
		}
		
			if (T.hasLeft()) {		
				addToMap(T.getLeft(), charactercode,pathsofar+"0");
				//System.out.println(pathsofar);
			}
			if (T.hasRight()) {
				addToMap(T.getRight(), charactercode,pathsofar+"1");
			}			
		
	}
	
	// code map getter 
	
	public  Map<Character, String> getCharactercodes(){
		return charactercode;
	}
	
	// gets the huffman code tree
	
	public BinaryTree<typeE> getCodeTree(){
		return huffman;
	}
	
			
}
