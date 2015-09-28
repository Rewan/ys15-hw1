package ua.yandex.shad.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {    

	public static final double MINIMAL_TEMPERATURE = -273.0;

	private double[] tempsArr;
	private int size;

	public boolean checkArrayForOutOfRange(double ... temps) {
		for(double x: temps) {
			if(x < MINIMAL_TEMPERATURE) return  true;
		}
		
		return false;
	}
	
    public TemperatureSeriesAnalysis() {
        tempsArr = new double[1000];
		size = 0;
    }
    
    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
		if(checkArrayForOutOfRange(temperatureSeries)) throw new InputMismatchException();
		
		tempsArr = temperatureSeries.clone();
		size = temperatureSeries.length;
    }
    
    public double average() {        
        return 0;
    }    
    
    public double deviation() {
        return 0;
    }
    
    public double min() {
        return 0;
    }
     
    public double max() {
        return 0;
    }
    
    public double findTempClosestToZero() {
        return 0;
    }
    
    public double findTempClosestToValue(double tempValue) {
        return 0;
}
    
    public double[] findTempsLessThen(double tempValue) {
        return null;
    }
    
    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }
    
    public TempSummaryStatistics summaryStatistics() {
        return null;
    }
    
    public int addTemps(double ... temps) {
		if(checkArrayForOutOfRange(temps)) throw new InputMismatchException();
		
		if(temps.length+size>tempsArr.length) {
			
		}
		
        return this.size;
    }
}
