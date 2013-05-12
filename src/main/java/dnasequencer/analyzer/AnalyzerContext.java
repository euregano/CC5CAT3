package dnasequencer.analyzer;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the analyzer context, in which the DNA analyzer can be set.
 * 
 * @author Eugen Meissner
 *
 */
public class AnalyzerContext {

	private List<IAnalyzer<?>> analyzers;
	private IAnalyzer<?>  analyzer = null;
	
	/**
	 * A Constructor.
	 */
	public AnalyzerContext(){
		analyzers = new ArrayList<IAnalyzer<?>>();
	}
	
	/**
	 * Add a analyzer to this context.
	 * 
	 * @param analyzer
	 */
	public void addAnalyzer(IAnalyzer<?> analyzer){
		analyzers.add(analyzer);
	}
	
	/**
	 * This method sets the analyzer for a given index number, if the index exists.
	 * 
	 * @param analyzer
	 */
	public void setAnalyzer(int index){
		if(index<analyzers.size())
			this.analyzer = analyzers.get(index);
	}
	

	/**
	 * This method sets the analyzer.
	 * 
	 * @param analyzer
	 */
	public void setAnalyzer(IAnalyzer<?> analyzer){
		this.analyzer = analyzer;
	}
	
	/**
	 * @return - a list of the available analyzer
	 */
	public List<IAnalyzer<?>> getAnalyzers(){
		return analyzers;
	}
	
	/**
	 * This method sets the analyzer by a given class.
	 * 
	 * @param analyzer
	 */
	public void setAnalyzer(Class<? extends IAnalyzer<?>> cls){
		for(IAnalyzer<?> analyzer : analyzers){
			if(analyzer.getClass().equals(cls.getClass())){
				this.analyzer = analyzer;
				break;
			}
		}
	}
	
	/**
	 * This method executes the analysing process.
	 * 
	 * @param sequence - a dna sequence in form of chars
	 * @return result of the analyzer
	 */
	@SuppressWarnings("unchecked")
	public <T> T execute(char[] sequence){
		return (T) analyzer.execute(sequence);
	}
	
	@Override
	public String toString(){
		return analyzer.toString();
	}

}
