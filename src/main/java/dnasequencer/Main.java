package dnasequencer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

import dnasequencer.analyzer.AnalyzerContext;
import dnasequencer.analyzer.IAnalyzer;
import dnasequencer.analyzer.impl.BrownEyesAnalyzer;
import dnasequencer.analyzer.impl.CTAGLocationAnalyzer;
import dnasequencer.analyzer.impl.ComplementarySequenceAnalyzer;
import dnasequencer.analyzer.impl.FromingenDischrypsiaAnalyzer;
import dnasequencer.analyzer.impl.NucleobaseCounterAnalyzer;
import dnasequencer.analyzer.impl.PurinePyrimidineCounterAnalyzer;
import dnasequencer.analyzer.impl.TyberiusSyndromAnalyzer;

/**
 * The main class.
 * 
 * @author Eugen Meissner
 *
 */
public class Main {
	
	private static AnalyzerContext context = new AnalyzerContext();
	private static char[] sequence = new char[0];
	private static int EXIT_SUCCESS = 0;
	private static int EXIT_FAILURE = -1;
	
	/**
	 * This method checks the arguments and inits the context.
	 * 
	 * @param args
	 */
	private static void checkArgsAndInitContext(String[] args){
		if(args.length!=1){
			System.out.println("Usage: dnasequencer [file]");
			System.exit(EXIT_FAILURE);
		} else {
			try {
				sequence = Commons.readFile(args[0]);
				context = new AnalyzerContext();
			} catch (FileNotFoundException e) {
				System.out.println("File '"+args[0]+"' not found!");
				System.exit(EXIT_FAILURE);
			}
		}
	}
	
	private static void addAnalyzers(){
		context.addAnalyzer(new BrownEyesAnalyzer());
		context.addAnalyzer(new ComplementarySequenceAnalyzer());
		context.addAnalyzer(new CTAGLocationAnalyzer());
		context.addAnalyzer(new FromingenDischrypsiaAnalyzer());
		context.addAnalyzer(new NucleobaseCounterAnalyzer());
		context.addAnalyzer(new PurinePyrimidineCounterAnalyzer());
		context.addAnalyzer(new TyberiusSyndromAnalyzer());
	}
	
	private static void listAnalyzer(){
		System.out.println("Please select the Analyzer:");
		List<IAnalyzer<?>> analyzers = context.getAnalyzers();
		for(int i=0; i<analyzers.size(); i++){
			System.out.println(analyzers.get(i).getClass().getSimpleName()+" - "+i);
		}
	}
	
	private static void runtime(){
		try {
			receiveAndProcessUserInput();
		} catch (Exception e) {
			System.out.println("It is not a valid number!");
		}

		runtime();
	}
	
	private static void receiveAndProcessUserInput() throws Exception{
		System.out.print("Please select:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sline = br.readLine();
		if(sline.compareTo("list")==0){
			listAnalyzer();
		} else if(sline.compareTo("exit")==0){
			System.exit(EXIT_SUCCESS);
		} else {
			int index = Integer.valueOf(sline);
			context.setAnalyzer(index);
			context.execute(sequence);
			System.out.println("");
			System.out.println(context.toString());
		}
	}
	
	public static void main(String[] args) {		
		checkArgsAndInitContext(args);
		addAnalyzers();
		listAnalyzer();
		runtime();
	}

}
