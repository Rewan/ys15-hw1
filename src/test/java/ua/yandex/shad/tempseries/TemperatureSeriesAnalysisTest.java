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
}
