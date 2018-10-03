import java.util.*;
import java.io.*;

	/**
	 * 
	 * @author Nour Benmohamed
	 *this is very inspired by the file input demo I found in the day 13
	 */

public class decompression {
	protected BufferedBitWriter bitOutput;
	protected String compressedPathName;
	protected String decompressedPathName;
	protected BufferedWriter output; 
	protected BinaryTree<typeE> node;
	protected boolean bit;
	protected String code;
	protected BufferedBitReader bitInput;

	
		// constructor 
		public decompression (BinaryTree<typeE> T,String name,String dename) {
			compressedPathName= name;
			node= T;
			decompressedPathName = dename;
		}
		/**
		 * this method takes the huffman tree and decodes the compressed file 
		 * @param T
		 */	
		public void decompress(BinaryTree<typeE> T) {

			char c;	
			
		try {
		System.out.println(compressedPathName);
		bitInput = new BufferedBitReader(compressedPathName);
		System.out.println(decompressedPathName);
		output =   new BufferedWriter(new FileWriter(decompressedPathName));
		
		}
		catch (FileNotFoundException e) {
			System.out.println("cannot open file");
			
		}
		catch (IOException e) {
			System.out.println("IO exception");
		}
		//reading the file
			try {
				// this while loop will go thru the tree until it reaches a leaf and write out that character
				node = T;
				while (bitInput.hasNext()) {
					  bit = bitInput.readBit();
					  System.out.println(bit);
					  if (bit == true) {
						  //System.out.println("got here1");
						  //System.out.println(bit);
						  node=node.getRight();
						  if (node.isLeaf()) {
							  ///System.out.println("got here2");

							  c = node.getData().getC();
							  //System.out.println("got here3");

							  output.write(c);
							  node=T;
							  System.out.println(c);
						  }
						  
							  
							 // System.out.println("got here4");

						  
						  
					  }
					  else if (bit == false) {
						  node=node.getLeft();
						  System.out.println("got here5");

						  if (node.isLeaf()) {
							  System.out.println("got here6");

							  c = node.getData().getC();
							  output.write(c);
							  node=T;
							  System.out.println(c);

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
					output.close();
					bitInput.close();
			
				}
				catch  (IOException e) {
					System.out.println("cannot close file");
				}
			}
}
}
