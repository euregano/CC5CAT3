package dnasequencer.analyzer.impl;

import static dnasequencer.analyzer.AnalyzerCommon.isPurine;
import static dnasequencer.analyzer.AnalyzerCommon.isPyramidine;
import dnasequencer.Commons;
import dnasequencer.analyzer.IAnalyzer;

/**
 * Four purines followed by four pyrimidines have been shown to have a strong correlationwith the early onset of Frømingen's dischrypsia. 
 * 
 * @author Eugen Meissner
 *
 */
public class FromingenDischrypsiaAnalyzer implements IAnalyzer<Boolean> {

	private boolean is = false;
	
	public Boolean execute(char[] sequence) {
		int length = sequence.length;
		for(int i=0; i<length; i++){
			if(isFourPurines(i, sequence) && isFourPyrimidines(i+4,sequence)){
				is = true;
				break;
			}
		}
		
		return is;
	}
	
	/**
	 * @param i - current position
	 * @param sequence - char array with dna sequence 'ctag'
	 * @return true if there are four purines at position i to i+3 otherwise false
	 */
	public boolean isFourPurines(int i, char[] sequence){
		if(i+3>=sequence.length) return false;
		return isPurine(sequence[i]) && isPurine(sequence[i+1]) && isPurine(sequence[i+2]) && isPurine(sequence[i+3]);
	}
	
	/**
	 * @param i - current position
	 * @param sequence - char array with dna sequence 'ctag'
	 * @return true if there four pyrimidines at position i to i+2 otherwise false
	 */
	private boolean isFourPyrimidines(int i, char[] sequence){
		if(i+3>=sequence.length) return false;
		return isPyramidine(sequence[i]) && isPyramidine(sequence[i+1]) && isPyramidine(sequence[i+2]) && isPyramidine(sequence[i+3]);
	}
	
	@Override
	public String toString(){
		return "Has Frømingen's dischrypsia:"+Commons.toYesNo(is);
	}
	
}
