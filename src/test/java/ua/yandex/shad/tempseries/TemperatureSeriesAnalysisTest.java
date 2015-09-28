package ua.yandex.shad.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {
    
	@Test
	public void testTemperatureSeriesAnalysisCreationWithEmptyConstructor() {
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis();
	}
	
	@Test(expected = InputMismatchException.class)
	public void testTemperatureSeriesAnalysisCreationWithListWithElementOuOfRange() {
		double[] temps = {1.0, -274.0, -3.0, 352.0};
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis(temps);
	}
	
	@Test
	public void testTemperatureSeriesAnalysisCreationWithEmptyList() {
		double[] temps = {};
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis(temps);
	}
	
	@Test
	public void testTemperatureSeriesAnalysisCreationWithNotEmptyList() {
		double[] temps = {1.0, -273.0, -3.0, 352.0};
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis(temps);
	}
	
	@Test
	public void testAddTempsWithEmptyArgs() {
		double[] startTemps = {10.0, -270.0, -3.0, 352.0};
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis(startTemps);
		int expResult = 4;
		int result = T.addTemps();
		assertEquals(expResult, result);
	}
	
	@Test(expected = InputMismatchException.class)
	public void testAddTempsWithListWithElementOutOfRange() {
		double[] startTemps = {10.0, -270.0, -3.0, 352.0};
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis(startTemps);
		double[] temps =  {1.0, -274.0};
		int result = T.addTemps(temps);
	}
	
	@Test
	public void testAddTempsWitNormalList() {
		double[] startTemps = {10.0, -270.0, -3.0, 352.0};
		TemperatureSeriesAnalysis T = new TemperatureSeriesAnalysis(startTemps);
		int expResult = 8;
		double[] temps =  {52.0, -234.0, 34.3, -61.0};
		int result = T.addTemps();
		assertEquals(expResult, result);
	}
	
    @Test
    public void testAverage() {
        double[] temperatureSeries = {1.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
        
    }
    
}
