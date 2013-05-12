package dnasequencer.data;

/**
 * Data container for nucleobase counter.
 * 
 * @author Eugen Meissner
 *
 */
public class NucleobaseCounterContainer {

	private int guaning; 
	private int cytosin;
	private int adenin;
	private int thymin;

	public NucleobaseCounterContainer(int guaning, int cytosin, int adenin, int thymin){
		this.guaning = guaning;
		this.cytosin = cytosin;
		this.adenin = adenin;
		this.thymin = thymin;
	}

	/**
	 * @return the number of guanin
	 */
	public int getGuanin() {
		return guaning;
	}

	/**
	 * @return the number of cytosin
	 */
	public int getCytosin() {
		return cytosin;
	}

	/**
	 * @return the number of adenin
	 */
	public int getAdenin() {
		return adenin;
	}

	/**
	 * @return the number of thymin
	 */
	public int getThymin() {
		return thymin;
	}
	
	@Override
	public String toString(){
		return "[Guanin:"+guaning+",Cytosin:"+cytosin+",Thymin:"+thymin+",Adenin:"+adenin+"]";
	}
	
}
