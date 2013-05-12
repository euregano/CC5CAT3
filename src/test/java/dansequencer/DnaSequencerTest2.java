package dansequencer;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import dnasequencer.Commons;
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

public class DnaSequencerTest2 {

	private static String FILENAME = "/1.txt";
	private static AnalyzerContext g_context;
	private static char[] g_sequence;
	
	@BeforeClass
	public static void setup(){
		g_context = new AnalyzerContext();
		try {
			g_sequence = Commons.readFile(DnaSequencerTest2.class.getResource(FILENAME).getFile());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Three distinct sequences of "GGG" within any 1000-nucleobases signify an elevated riskto acquiring Tyberius syndrome.
	 * Based on the given DNA segment, is this female at suchrisk?
	 */
	@Test
	public void test11(){
		g_context.setAnalyzer(new TyberiusSyndromAnalyzer());
		Assert.assertTrue((Boolean)g_context.execute(g_sequence));
	}
	
	/**
	 * The sequence "CAG" followed by exactly one "C" or one "G" and then not followed by Tin the next 2 slots signifies brown eyes.
	 * Does this female have brown eyes?
	 * 
	 */
	@Test
	public void test12(){
		g_context.setAnalyzer(new BrownEyesAnalyzer());
		Assert.assertFalse((Boolean)g_context.execute(g_sequence));
	}
	
	
	/**
	 * How many of each nucleobase does this segment have?
	 * Input:
	 * 		a: 248
	 * 		c: 265
	 * 		g: 259
	 * 		t: 228
	 */
	@Test
	public void test13(){
		g_context.setAnalyzer(new NucleobaseCounterAnalyzer());
		NucleobaseCounterContainer ncc = g_context.execute(g_sequence);
		Assert.assertEquals(248, ncc.getAdenin());
		Assert.assertEquals(265, ncc.getCytosin());
		Assert.assertEquals(259, ncc.getGuanin());
		Assert.assertEquals(228, ncc.getThymin());
	}
	
	/**
	 * What's the location of the first occurrence of the sequence "CTAG" in the given segment(assume nucleobases are numbered from 1 to 1000).
	 * First occurrence: 196
	 */
	@Test
	public void test14(){
		g_context.setAnalyzer(new CTAGLocationAnalyzer());
		Assert.assertEquals(196, g_context.execute(g_sequence));
	}
	
	/**
	 * Does this segment have more purines than pyrimidines?
	 * purines: 
	 * 	a		g
	 *  248 + 	259 = 507
	 * pyrimidines
	 *  c		t
	 *  265 + 	228 = 493
	 */
	@Test
	public void test21(){
		g_context.setAnalyzer(new PurinePyrimidineCounterAnalyzer());
		PurinePyrimidineCounterContainer ppcc = g_context.execute(g_sequence);
		Assert.assertTrue(ppcc.getPurine()>ppcc.getPyrimidine());
	}
	
	/**
	 * Four purines followed by four pyrimidines have been shown to have a strong correlationwith the early onset of Frømingen's dischrypsia.
	 * Does this DNA strand show evidence forthis correlation?
	 */
	@Test
	public void test22(){
		g_context.setAnalyzer(new FromingenDischrypsiaAnalyzer());
		Assert.assertTrue((Boolean) g_context.execute(g_sequence));
	}
	
	/**
	 * What's the complementary sequence for the entire 1000-nucleobase segment?
	 */
	@Test
	public void test23(){
		g_context.setAnalyzer(new ComplementarySequenceAnalyzer());
		System.out.println(g_sequence);
		System.out.println(g_context.execute(g_sequence));
	}
}
