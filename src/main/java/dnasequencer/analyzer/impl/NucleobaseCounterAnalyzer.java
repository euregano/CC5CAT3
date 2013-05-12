package dnasequencer.analyzer.impl;

import dnasequencer.analyzer.IAnalyzer;
import dnasequencer.data.NucleobaseCounterContainer;

/**
 * This class counts the occurrence of each nucleobase in a given sequence.
 * 
 * @author Eugen Meissner
 *
 */
public class NucleobaseCounterAnalyzer implements IAnalyzer<NucleobaseCounterContainer> {

	private NucleobaseCounterContainer ncc;

	public NucleobaseCounterContainer execute(char[] sequence) {
		int length = sequence.length;
		int g = 0,
			c = 0,
			a = 0,
			t = 0;
		
		for(int i=0; i<length; i++){
			if(sequence[i]=='g') g++;
			else if(sequence[i]=='c') c++;
			else if(sequence[i]=='a') a++;
			else if(sequence[i]=='t') t++;
		}
		
		return (ncc = new NucleobaseCounterContainer(g,c,a,t));
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Occurrence of Nucleobases:").append("\n")
			.append(ncc.toString());
		return sb.toString();
	}
	
}
