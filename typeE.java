import java.util.*;
/**
 * 
 * 
 * @author Nour Benmohamed
 * problem set 3 
 * 5/3/2018
 *
 */

public class typeE {
		protected Character c = null;
		protected Integer n;
		//TODO write a class that stores both the caracter and the frequency
		//constructor passes the freq to freq and letter to letter, letter should be innitialized to null
		public typeE (Character c , Integer n) {
			this.c=c;
			this.n=n;
		}
		public Integer getN() {
			return n;
		}
		public Character getC() {
			return c;
		}
		public String toString() {
			return Integer.toString(n)+' ' +Character.toString(c);
		}
		
		
}