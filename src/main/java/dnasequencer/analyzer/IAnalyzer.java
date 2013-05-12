package dnasequencer.analyzer;


/**
 * This is the method definition for an analyzer.
 * 
 * @author Eugen Meissner
 *
 */
public interface IAnalyzer<T> {

	/**
	 * This method executes the analyzing process.
	 * 
	 * @param sequence - An array of chars with the dna sequence
	 * @return result of the analyzer
	 */
	public T execute(char[] sequence);
	
}
