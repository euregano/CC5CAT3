package dnasequencer.analyzer.impl;

import static dnasequencer.analyzer.AnalyzerCommon.getComplementary;
import dnasequencer.analyzer.IAnalyzer;

/**
 * This class computes the complementary sequence.
 * 
 * @author Eugen Meissner
 *
 */
public class ComplementarySequenceAnalyzer implements IAnalyzer<String>{

	private String cSequence = "";
	private String sequence = "";
	
	public String execute(char[] sequence) {
		int length = sequence.length;
		char[] dca = new char[length];
		
		for(int i=0; i<length; i++){
			dca[length-1-i] = getComplementary(sequence[i]);
		}
		
		cSequence = String.copyValueOf(dca);
		this.sequence = String.copyValueOf(sequence);
		
		return cSequence;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Original Sequence:").append("\n")
			.append(sequence).append("\n")
			.append("Complementary Sequence:").append("\n")
			.append(cSequence);
		return sb.toString();
	}
}
