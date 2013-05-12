package dansequencer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dnasequencer.analyzer.AnalyzerContext;
import dnasequencer.analyzer.impl.BrownEyesAnalyzer;
import dnasequencer.analyzer.impl.CTAGLocationAnalyzer;
import dnasequencer.analyzer.impl.ComplementarySequenceAnalyzer;
import dnasequencer.analyzer.impl.FromingenDischrypsiaAnalyzer;
import dnasequencer.analyzer.impl.NucleobaseCounterAnalyzer;
import dnasequencer.analyzer.impl.PurinePyrimidineCounterAnalyzer;
import dnasequencer.analyzer.impl.TyberiusSyndromAnalyzer;
import dnasequencer.data.NucleobaseCounterContainer;
import dnasequencer.data.PurinePyrimidineCounterContainer;

public class DnaSequencerTest1 {

	private AnalyzerContext context;
	
	@Before
	public void onSetup(){
		context = new AnalyzerContext();
	}
	
	/**
	 * Three distinct sequences of "GGG" within any 1000-nucleobases signify an elevated risk to acquiring Tyberius syndrome. 
	 */
	@Test
	public void isTyberiusSyndrom(){
		context.setAnalyzer(new TyberiusSyndromAnalyzer());
		char[] sequence = "gggcatgggcatggg".toCharArray();
		Boolean bool = context.execute(sequence);
		Assert.assertTrue(bool);
	}
	
	@Test
	public void isNotTyberiusSyndrom(){
		context.setAnalyzer(new TyberiusSyndromAnalyzer());
		char[] sequence = "gggcatgggcatggggggcat".toCharArray();
		Boolean bool = context.execute(sequence);
		Assert.assertFalse(bool);
	}
	
	/**
	 * The sequence "CAG" followed by exactly one "C" or one "G" and then not followed by T in the next 2 slots signifies brown eyes.
	 */
	@Test
	public void isBrownEyes(){
		context.setAnalyzer(new BrownEyesAnalyzer());
		char[] sequence = "cagcaa".toCharArray();
		Boolean bool = context.execute(sequence);
		Assert.assertTrue(bool);
		sequence = "caggaa".toCharArray();
		bool = context.execute(sequence);
		Assert.assertTrue(bool);
	}
	
	@Test
	public void isNotBrownEyes(){
		context.setAnalyzer(new BrownEyesAnalyzer());
		char[] sequence = "cagtaa".toCharArray();
		Boolean bool = context.execute(sequence);
		Assert.assertFalse(bool);
		sequence = "cagaaa".toCharArray();
		bool = context.execute(sequence);
		Assert.assertFalse(bool);
		sequence = "cagcta".toCharArray();
		bool = context.execute(sequence);
		Assert.assertFalse(bool);
		sequence = "cagcat".toCharArray();
		bool = context.execute(sequence);
		Assert.assertFalse(bool);
		sequence = "caggta".toCharArray();
		bool = context.execute(sequence);
		Assert.assertFalse(bool);
		sequence = "caggat".toCharArray();
		bool = context.execute(sequence);
		Assert.assertFalse(bool);
	}
	
	@Test
	public void nucleoCounterAnalyzer(){
		context.setAnalyzer(new NucleobaseCounterAnalyzer());
		char[] sequence = "cagtaggttt".toCharArray();
		NucleobaseCounterContainer dnc = context.execute(sequence);
		Assert.assertEquals(1, dnc.getCytosin());
		Assert.assertEquals(2, dnc.getAdenin());
		Assert.assertEquals(3, dnc.getGuanin());
		Assert.assertEquals(4, dnc.getThymin());
	}
	
	
	@Test
	public void isCTAGLocation(){
		context.setAnalyzer(new CTAGLocationAnalyzer());
		String str = "acacaccacatgtactaggcgctcg";
		char[] sequence = str.toCharArray();
		Integer di = context.execute(sequence);
		Assert.assertEquals(str.indexOf("ctag")+1, di.intValue());
	}
	
	@Test
	public void isNotCTAGLocation(){
		context.setAnalyzer(new CTAGLocationAnalyzer());
		String str = "acacaccacatgtagcgctcg";
		char[] sequence = str.toCharArray();
		Integer di = context.execute(sequence);
		Assert.assertEquals(str.indexOf("ctag"), di.intValue());
	}
	
	
	@Test
	public void purinePyramidineCounter(){
		context.setAnalyzer(new PurinePyrimidineCounterAnalyzer());
		char[] sequence = "acgtagtagc".toCharArray();
		PurinePyrimidineCounterContainer dppc = (PurinePyrimidineCounterContainer) context.execute(sequence);
		Assert.assertEquals(6, dppc.getPurine());
		Assert.assertEquals(4, dppc.getPyrimidine());
	}
	
	@Test
	public void isFromingenDischrpsia(){
		context.setAnalyzer(new FromingenDischrypsiaAnalyzer());
		char[] sequence = "aaaactctctcacaaggacttc".toCharArray();
		Boolean db = context.execute(sequence);
		Assert.assertTrue(db);
	}
	
	@Test
	public void isNotFromingenDischrpsia(){
		context.setAnalyzer(new FromingenDischrypsiaAnalyzer());
		char[] sequence = "cttcagga".toCharArray();
		Boolean db = context.execute(sequence);
		Assert.assertFalse(db);
	}
	
	@Test
	public void computeComplementarySequence(){
		context.setAnalyzer(new ComplementarySequenceAnalyzer());
		char[] sequence = "ttac".toCharArray();
		String dca = context.execute(sequence);
		Assert.assertEquals("gtaa",dca);
	}
	
}
