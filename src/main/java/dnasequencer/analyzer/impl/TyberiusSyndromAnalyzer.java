package dnasequencer.analyzer.impl;

import dnasequencer.Commons;
import dnasequencer.analyzer.IAnalyzer;


/**
 * Three distinct sequences of "GGG" within any 1000-nucleobases signify an elevated risk to acquiring Tyberius syndrome. 
 * 
 * @author Eugen Meissner
 *
 */
public class TyberiusSyndromAnalyzer implements IAnalyzer<Boolean> {

	private int counter = 0;
	
	public Boolean execute(char[] sequence) {
		int length = sequence.length;
		for(int i=0; i<length; i++){
			if(sequence[i]=='g'){
				if(isGGG(i,sequence) && isDistinct(i+3, sequence)){
					counter++;
				}
				i+=5;
			}
		}
		
		return isTyberius();
	}
	
	/**
	 * This method checks if there is a sequence of 'ggg'
	 * 
	 * @param i - the position in the char array
	 * @param sequence - a char array-
	 * @return true if there is a sequence otherwise false
	 */
	private boolean isGGG(int i, char[] sequence){
		if(i+2>=sequence.length) return false;
		return sequence[i]=='g' & sequence[i+1]=='g' & sequence[i+2]=='g';
	}
	
	/**
	 * @param i - current position
	 * @param sequence - char array with dna sequence 'ctag'
	 * @return true if there is no 'ggg' sequence at position i to i+2 or true if i+2 is greater than the sequence length otherwise false
	 */
	private boolean isDistinct(int i, char[] sequence){
		return !isGGG(i, sequence) || i+2>=sequence.length;
	}
	
	private boolean isTyberius(){
		return counter>=3;
	}

	@Override
	public String toString(){
		return "Tyberius Syndrom:"+Commons.toYesNo(isTyberius());
	}
}
