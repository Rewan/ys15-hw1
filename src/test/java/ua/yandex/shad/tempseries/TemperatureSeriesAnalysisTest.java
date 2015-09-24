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
    public void testAverage() {
        double[] temperatureSeries = {1.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
        
    }
    
}
