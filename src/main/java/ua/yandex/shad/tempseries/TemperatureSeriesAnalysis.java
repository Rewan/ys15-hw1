package ua.yandex.shad.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {    

	public static final double MINIMAL_TEMPERATURE = -273.0;

	private double[] tempsArr;
	private int size = 0;

    public TemperatureSeriesAnalysis() {
        tempsArr = new double[1000];
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
		for(double x: temperatureSeries) {
			if(x < MINIMAL_TEMPERATURE) throw new InputMismatchException();
		}
		
		tempsArr = temperatureSeries.clone();
    }
    
    public double average(){        
        return 0;
    }    
    
    public double deviation(){
        return 0;
    }
    
    public double min(){
        return 0;
    }
     
    public double max(){
        return 0;
    }
    
    public double findTempClosestToZero(){
        return 0;
    }
    
    public double findTempClosestToValue(double tempValue){
        return 0;
}
    
    public double[] findTempsLessThen(double tempValue){
        return null;
    }
    
    public double[] findTempsGreaterThen(double tempValue){
        return null;
    }
    
    public TempSummaryStatistics summaryStatistics(){
        return null;
    }
    
    public int addTemps(double ... temps){
        return 0;
    }
}
