import java.util.*;

import java.io.*;

/**
 * 
 * @author Nour Benmohamed
 *this is very inspired by the file input demo I found in the day 13 notes
 *problem set 3 
 *5/3/2018
 *
 */

public class compression {
	protected static Map<Character, Integer> characterFreq;
	protected static letter Letter;
	protected PriorityQueue<BinaryTree<typeE>> pq;
	protected BufferedBitWriter bitOutput;
	protected boolean bit;
	protected String pathName;
	protected String compressedPathName;
	protected BufferedReader input;

	
	public compression (String name, String compressedName){
		
		// constructor 
		
		characterFreq = new TreeMap<Character, Integer>();
		Letter = new letter();
		pathName = name;
		compressedPathName=compressedName;	
		
	}
	
	
	public  void characterCount (Character c) {
		/**
		 * this class makes a map of the character frequencies in the text.
		 * it modifies characterFreq map instance variable
		 */
		if (characterFreq.containsKey(c)) {
			//TODO makes a map of the caracters as keys and frequency as values 
			characterFreq.put(c, characterFreq.get(c)+1);
		}
		else {
			characterFreq.put(c,1);
		}		
	}
	 
	
	public  void compress() {
		/**
		 * this class will take care of opening the file, and doing the rest of the compression
		 */
		
	try {
	
		input = new BufferedReader(new FileReader(pathName)); // add name of file
		bitOutput = new BufferedBitWriter(compressedPathName);
	
	}
	catch (FileNotFoundException e) {
		System.out.println("cannot open file");
	}
	//reading the file
		try {
			int cI;
			Character c;
			Map<Character, String> codes;
			String code;
			/**
			 * this while loop will go thru all the character of the text file to create the frequency map
			 */
			while ((cI= input.read()) != -1 ) {
				
				c=(char)(cI);
				//System.out.println("read '"+c+"'");
				characterCount (c);	
			}
			System.out.println(characterFreq);
			Letter.Queue(characterFreq);
			Letter.codeMap();
			/**
			 * this while loop will go thru all the characters again and using the code tree will write into a new file the binary codes of each character
			 * basically write out the compressed file
			 */
			codes = Letter.getCharactercodes();
			System.out.println("got here");
			input = new BufferedReader(new FileReader(pathName)); // add name of file

			while ((cI= input.read()) != -1 ) {	
				c = new Character((char)(cI));
				code= codes.get(c);
				System.out.println("code is" + code);
				
				for (int i=0; i< code.length(); i++) {
					if (code.charAt(i)=='1') {
						bitOutput.writeBit(true);
					}
					else {
						bitOutput.writeBit(false);
					}
					
				}
				
			}
				
		}
		catch (IOException e) {
			System.out.println("IO error while reading");
			
		}
		//closing the file
		finally {
			try {
				input.close();
				bitOutput.close();
		
			}
			catch  (IOException e) {
				System.out.println("cannot close file");
			}
		}
		
		
	
	}
}
