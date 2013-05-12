package dnasequencer.data;

/**
 * Data container for purine and pyrimidine counter
 * 
 * @author Eugen Meissner
 *
 */
public class PurinePyrimidineCounterContainer {

	private int purine;
	private int pyrimidine;
	
	public PurinePyrimidineCounterContainer(int purine, int pyramidine){
		this.purine = purine;
		this.pyrimidine = pyramidine;
	}
	
	/**
	 * @return get Purine
	 */
	public int getPurine() {
		return purine;
	}
	/**
	 * @return get Pyrimidine
	 */
	public int getPyrimidine() {
		return pyrimidine;
	}
	
	@Override
	public String toString(){
		return "[Purine:"+purine+",Pyrimidine:"+pyrimidine+"]";
	}
}
