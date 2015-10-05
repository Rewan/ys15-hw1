package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    
	@Test
	public void testTemperatureSeriesAnalysisCreationWithEmptyConstructor() {
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
	}
	
	@Test(expected = InputMismatchException.class)
	public void testTemperatureSeriesAnalysisCreationWithListWithElementOuOfRange() {
		double[] temps = {1.0, -274.0, -3.0, 352.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temps);
	}
	
	@Test
	public void testTemperatureSeriesAnalysisCreationWithEmptyList() {
		double[] temps = {};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temps);
	}
	
	@Test
	public void testTemperatureSeriesAnalysisCreationWithNotEmptyList() {
		double[] temps = {1.0, -273.0, -3.0, 352.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temps);
	}
	
	@Test(expected = InputMismatchException.class)
	public void testAddTempsWithListWithElementOutOfRange() {
		double[] startTemps = {10.0, -70.0, -3.0, 352.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
		double[] temps =  {1.0, -274.0};
		int result = seriesAnalysis.addTemps(temps);
	}
	
	@Test
	public void testAddTempsWithAddingEmptyList() {
		double[] startTemps = {11.0, -220.0, 33.0, -32.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
		int expResult = 4;
		int result = seriesAnalysis.addTemps();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testAddTempsWithAddingNormalList() {
		double[] startTemps = {10.0, -270.0, -3.0, 352.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
		int expResult = 8;
		double[] temps =  {52.0, -234.0, 34.3, -61.0};
		int result = seriesAnalysis.addTemps(temps);
		assertEquals(expResult, result);
	}
	
	@Test
	public void testAddTempsWithAddingListWithLengthBiggerThenStartArray() {
		double[] startTemps = {-10.0, 274.0};
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
		int expResult = 6;
		double[] temps =  {-52.0, 23.0, 34.3, -61.0};
		int result = seriesAnalysis.addTemps(temps);
		assertEquals(expResult, result);
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyList() {
        double[] startTemps = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        seriesAnalysis.average();
    }
	
    @Test
    public void testAverageWithNormalListCheck() {
        double[] startTemps = {1.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyList() {
        double[] startTemps = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        seriesAnalysis.deviation();
    }
	
    @Test
    public void testDeviationWithNormalListCheck() {
        double[] startTemps = {1.0, -5.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 3.6055512754;
        double actualResult = seriesAnalysis.deviation();
        
        assertEquals(expResult, actualResult, 0.00001);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyList() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.min();
    }
	
    @Test
    public void testMinWithNormalListCheck() {
        double[] startTemps = {1234.0, -25.0, -261.0, 52.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = -261.0;
        double actualResult = seriesAnalysis.min();
        
        assertEquals(expResult, actualResult, 0.00001); 
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyList() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.max();
    }
	
    @Test
    public void testMaxWithNormalListCheck() {
        double[] startTemps = {14.0, -25.0, 1261.0, -252.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 1261.0;
        double actualResult = seriesAnalysis.max();
        
        assertEquals(expResult, actualResult, 0.00001); 
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyList() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToZero();
    }
	
    @Test
    public void testFindTempClosestToZeroWithNormalListCheck() {
        double[] startTemps = {4.0, -25.0, 11.0, -12.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 4.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001); 
    }
	
	@Test
    public void testFindTempClosestToZeroWithListWithPositiveAndNegativeElementsThatHaveEqualAbsCheck() {
        double[] startTemps = {-25.0, -2.0, 2.0, 25.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 2.0;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        
        assertEquals(expResult, actualResult, 0.00001); 
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyList() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempClosestToValue(0.0);
    }
	
    @Test
    public void testFindTempClosestToValueWithNormalListCheck() {
        double[] startTemps = {5.0, -24.0, 12.0, -11.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 5.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(1.0);
        
        assertEquals(expResult, actualResult, 0.00001); 
    }
	
	@Test
    public void testFindTempClosestToValueWithListWithLesserAndGreaterElementsThatHaveEqualDeltaCheck() {
        double[] startTemps = {0.0, 10.0, 20.0, 30.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double expResult = 20.0;
        double actualResult = seriesAnalysis.findTempClosestToValue(15.0);
        
        assertEquals(expResult, actualResult, 0.00001); 
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyList() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsLessThen(0.0);
    }
	
	@Test
	public void testFindTempsLessThenWithNormalListCheck() {
		double[] startTemps = {41.0, -11.0, 10.0, 123.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double[] expResult = {-11.0};
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);
        
        assertArrayEquals(expResult, actualResult, 0.00001); 
	}
	
	@Test
	public void testFindTempsLessThenWithNullAnswerCheck() {
		double[] startTemps = {5.1, 11.0, 321.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double[] expResult = null;
        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);
        
        assertArrayEquals(expResult, actualResult, 0.00001); 
	}
	
	@Test
	public void testFindTempsLessThenWithListWithBorderElementCheck() {
		double[] startTemps = {56.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double[] expResult = null;
        double[] actualResult = seriesAnalysis.findTempsLessThen(56.0);
        
        assertArrayEquals(expResult, actualResult, 0.00001); 
	}
	
	@Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyList() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.findTempsGreaterThen(0.0);
    }
	
	@Test
	public void testFindTempsGreaterThenWithNormalListCheck() {
		double[] startTemps = {-63.1, -14.0, 83.0, 285.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double[] expResult = {83.0, 285.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(15.0);
        
        assertArrayEquals(expResult, actualResult, 0.00001); 
	}
	
	@Test
	public void testFindTempsGreaterThenWithNullAnswerCheck() {
		double[] startTemps = {-25.0, 15.0, -200.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double[] expResult = null;
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(16.0);
        
        assertArrayEquals(expResult, actualResult, 0.00001); 
	}
	
	@Test
	public void testFindTempsGreaterThenWithListWithBorderElementCheck() {
		double[] startTemps = {-270.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        double[] expResult = {-270.0};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-270.0);
		
        assertArrayEquals(expResult, actualResult, 0.00001); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSummaryStatisticsWithEmptyList() {
		TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.summaryStatistics();
	}
	
	@Test
	public void testSummaryStatisticsWithNormalListCheck() {
		double[] startTemps = {-5.0, 1.0, -1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(startTemps);
        TempSummaryStatistics expResult = new TempSummaryStatistics(0.0, 3.6055512754, -5.0, 5.0);
        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();
		
		assertEquals(expResult,actualResult);
	}
}
