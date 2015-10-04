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
		
		if(temperatureSeries.length == 0) {
			tempsArr = new double[1];
		}
    }
    
    public double average() {
		if(size==0) throw new IllegalArgumentException();
		
		double sum = 0.0;
		for(int i = 0; i < size; i++) {
			sum += tempsArr[i];
		}
		
		double ans = sum/size;
        return ans;
    }    
    
    public double deviation() {
        if(size==0) throw new IllegalArgumentException();
		
		double averageTemp = average();
		
		double sum = 0.0;
		for(int i = 0; i < size; i++) {
			sum += (tempsArr[i] - averageTemp)*(tempsArr[i] - averageTemp);
		}
		
		double ans = Math.sqrt((sum/size));
        return ans;
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
		if(checkArrayForOutOfRange(temps)) 
			throw new InputMismatchException();
		
		if(temps.length+size>tempsArr.length) {
			
			int n = tempsArr.length;
			
			while(n < temps.length+size) {
				n *= 2;
			}
			
			double[] old = new double[tempsArr.length];
			System.arraycopy(tempsArr, 0, old, 0, tempsArr.length);
			
			tempsArr = new double[n];
			System.arraycopy(old, 0, tempsArr, 0, old.length);
		}
		
		if(temps.length > 0) {
			System.arraycopy(temps, 0, tempsArr, size, temps.length);
		
			size += temps.length;
		}
		
        return size;
    }
}
