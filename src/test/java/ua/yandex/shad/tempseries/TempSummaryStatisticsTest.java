package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TempSummaryStatisticsTest {
	
	@Test
	public void testConstructor() {
		TempSummaryStatistics T = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
	}
	
	@Test
	public void testEqualsWithDifferentType() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		String T2 = "1";
		
		assertFalse(T1.equals(T2)); 
	}
	
	@Test
	public void testEqualsWithItself() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		
		assertTrue(T1.equals(T1)); 
	}
	
	@Test
	public void testEqualsWithNull() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		TempSummaryStatistics T2 = null;
		
		assertFalse(T1.equals(T2)); 
	}
	
	@Test
	public void testEqualsWithDifferentAvg() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		TempSummaryStatistics T2 = new TempSummaryStatistics(0.1,0.0,0.0,0.0);
		
		assertFalse(T1.equals(T2)); 
	}
	
	@Test
	public void testEqualsWithDifferentDev() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		TempSummaryStatistics T2 = new TempSummaryStatistics(0.0,0.1,0.0,0.0);
		
		assertFalse(T1.equals(T2)); 
	}
	
	@Test
	public void testEqualsWithDifferentMin() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		TempSummaryStatistics T2 = new TempSummaryStatistics(0.0,0.0,0.1,0.0);
		
		assertFalse(T1.equals(T2)); 
	}
	
	@Test
	public void testEqualsWithDifferentMax() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		TempSummaryStatistics T2 = new TempSummaryStatistics(0.0,0.0,0.0,0.1);
		
		assertFalse(T1.equals(T2)); 
	}
	
	@Test
	public void testEqualsCheck() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		TempSummaryStatistics T2 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		
		assertTrue(T1.equals(T2)); 
	}
	
	@Test(expected = AssertionError.class)
	public void testHashCode() {
		TempSummaryStatistics T1 = new TempSummaryStatistics(0.0,0.0,0.0,0.0);
		T1.hashCode();
	}
}
