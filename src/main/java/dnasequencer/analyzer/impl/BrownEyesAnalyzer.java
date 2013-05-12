package dnasequencer.analyzer.impl;

import dnasequencer.Commons;
import dnasequencer.analyzer.IAnalyzer;


/**
 * The sequence "CAG" followed by exactly one "C" or one "G" and then not followed by T in the next 2 slots signifies brown eyes.
 *
 * @author Eugen Meissner
 *
 */
public class BrownEyesAnalyzer implements IAnalyzer<Boolean>{
		
	private boolean is;

	public Boolean execute(char[] sequence) {
		int length = sequence.length;
		for(int i=0; i<length; i++){
			if(isCAG(i, sequence) && isCorG(sequence[i+3]) && isNotT(i+4, sequence)){
				is = true;
				break;
			}
		}
		
		return is;
	}
	
	/**
	 * @param i - current position
	 * @param sequence - char array with dna sequence 'ctag'
	 * @return true if there is 'cag' sequence at position i to i+2 otherwise false
	 */
	private boolean isCAG(int i, char[] sequence){
		if(i+2>=sequence.length) return false;
		return (sequence[i]=='c' && sequence[i+1]=='a' && sequence[i+2]=='g');
	}
	

	/**
	 * 
	 * @param c - a char which represents nucleobase
	 * @return true if the given char is c or g otherwise false
	 */
	private boolean isCorG(char c){
		return c == 'c' || c == 'g';
	}

	/**
	 * @param i - current position
	 * @param sequence - char array with dna sequence 'ctag'
	 * @return true if there is no t at position i and i+1 otherwise false. 
	 */
	private boolean isNotT(int i, char[] sequence){
		if(i+1>=sequence.length) return false;
		return sequence[i]!='t' && sequence[i+1]!='t';
	}
	
	@Override
	public String toString(){
		return "BrownEyes:"+Commons.toYesNo(is);
	}
}
