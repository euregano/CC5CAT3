package dnasequencer.analyzer.impl;

import dnasequencer.analyzer.IAnalyzer;


/**
 * The class computes the location of ctag.
 * 
 * What's the location of the first occurrence of the sequence "CTAG" in the given segment(assume nucleobases are numbered from 1 to 1000).
 * 
 * @author Eugen Meissner
 *
 */
public class CTAGLocationAnalyzer implements IAnalyzer<Integer> {

	private Integer index = -1;
	
	public Integer execute(char[] sequence) {
		int length = sequence.length;
		int index = -1;
		for(int i=0; i<length; i++){
			if(isCTAG(i, sequence)){
				index = i;
				break;
			}
		}
		this.index = index==-1?index:index+1;
		return this.index;
	}
	
	/**
	 * @param i - current position
	 * @param sequence - char array with dna sequence 'ctag'
	 * @return true if there is a 'ctag' sequence at position i to i+2 otherwise false
	 */
	private boolean isCTAG(int i, char[] sequence){
		if(i+3>=sequence.length) return false;
		return sequence[i]=='c' && sequence[i+1]=='t' && sequence[i+2]=='a' && sequence[i+3]=='g';
	}

	@Override
	public String toString(){
		return "First occurrence of 'ctag':"+index;
	}
}
