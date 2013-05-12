package dnasequencer.analyzer.impl;

import static dnasequencer.analyzer.AnalyzerCommon.isPurine;
import static dnasequencer.analyzer.AnalyzerCommon.isPyramidine;
import dnasequencer.analyzer.IAnalyzer;
import dnasequencer.data.PurinePyrimidineCounterContainer;

/**
 * Does this segment have more purines than pyrimidines?
 *  
 * @author Eugen Meissner
 *
 */
public class PurinePyrimidineCounterAnalyzer implements IAnalyzer<PurinePyrimidineCounterContainer>{

	private PurinePyrimidineCounterContainer ppcc;

	public PurinePyrimidineCounterContainer execute(char[] sequence) {
		int length = sequence.length;
		int purine = 0,
			pyramidine = 0;
		
		for(int i=0; i<length; i++){
			if(isPurine(sequence[i])) purine++;
			else if(isPyramidine(sequence[i])) pyramidine++;
		}
		
		return (ppcc = new PurinePyrimidineCounterContainer(purine,pyramidine));
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Occurrence of Purine and Pyrimidine:").append("\n")
			.append(ppcc.toString());
		return sb.toString();
	}
	

}
