import java.util.Map;

import java.util.TreeMap;

/**
 * @author Nour Benmohamed
 * problemset 3
 * 5/3/2018
 *
 */
public class ps3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//protected Map<Character, Integer> characterFreq = new TreeMap<Character, Integer>();
		// TODO Auto-generated method stub
		String file= "test1";
		 compression test = new compression ("inputs/"+file+".txt","inputs/"+file+"_compressed.txt");
		test.compress();
		 decompression test_out = new decompression (test.Letter.getCodeTree(), "inputs/"+file+"_compressed.txt", "inputs/"+file+"_decompressed.txt" );
		test_out.decompress(test.Letter.getCodeTree());

	}
	

}
