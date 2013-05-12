package dnasequencer.analyzer;

/**
 * This class provides common helper methods for the analyzer.
 * 
 * @author Eugen Meissner
 *
 */
public class AnalyzerCommon {
	
	/**
	 * 
	 * @param c
	 * @return true if c is a purine otherwise false
	 */
	public static boolean isPurine(char c){
		return c == 'a' || c == 'g';
	}
	
	/**
	 * 
	 * @param c
	 * @return true if c is a pyramidine otherwise false
	 */
	public static boolean isPyramidine(char c){
		return c == 't' || c == 'c';
	}
	
	/**
	 * 
	 * @param c - a nucelobase
	 * @return the complementary for the given nucleobase
	 */
	public static char getComplementary(char c){
		char comp = ' ';
		switch(c){
			case 'a' : comp = 't'; break;
			case 't' : comp = 'a'; break;
			case 'c' : comp = 'g'; break;
			case 'g' : comp = 'c'; break;
			default: break;
		}
		return comp;
	}
	
}
