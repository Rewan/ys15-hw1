package ua.yandex.shad.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
	public static final double EPSILON = 0.00001;
	public static final double MINIMAL_TEMPERATURE = -273.0;

	private double[] tempsArr;
	private int size;

	public boolean checkArrayForOutOfRange(double ... temps) {
		for (double x: temps) {
			if (x < MINIMAL_TEMPERATURE) {
				return  true;
			}
		}
		
		return false;
	}
	
	public void checkInputMistmach(double ... temps) {
		if (checkArrayForOutOfRange(temps)) {
			throw new InputMismatchException();
		}
	}
	
	public boolean checkEmpty() {
		return size == 0;
	}
	
	public void checkIllegalArgument() {
		if (checkEmpty()) {
			throw new IllegalArgumentException();
		}
	}
	
	public TemperatureSeriesAnalysis(double[] temperatureSeries) {
		checkInputMistmach(temperatureSeries);
		tempsArr = temperatureSeries.clone();
		size = temperatureSeries.length;
		
		if (temperatureSeries.length == 0) {
			tempsArr = new double[1];
		}
    }
	
    public TemperatureSeriesAnalysis() {
        tempsArr = new double[1];
		size = 0;
    }
    
    
    public double average() {
		checkIllegalArgument();
		
		double sum = 0.0;
		for (int i = 0; i < size; i++) {
			sum += tempsArr[i];
		}
		
		double ans = sum/size;
        return ans;
    }    
    
    public double deviation() {
        checkIllegalArgument();
		
		double averageTemp = average();
		
		double sum = 0.0;
		for (int i = 0; i < size; i++) {
			double x = tempsArr[i] - averageTemp;
			sum += x*x;
		}
		
		double ans = Math.sqrt(sum/size);
        return ans;
    }
    
    public double min() {
        checkIllegalArgument();
		
		double min = tempsArr[0];
		
		for (int i = 1; i < size; i++) {
			if (tempsArr[i] < min) {
				min = tempsArr[i];
			}
		}
		
        return min;
    }
     
    public double max() {
        checkIllegalArgument();
		
		double max = tempsArr[0];
		
		for (int i = 1; i < size; i++) {
			if (tempsArr[i] > max) {
				max = tempsArr[i];
			}
		}
		
        return max;
    }
    
    public double findTempClosestToZero() {
        checkIllegalArgument();
		
		double ans = tempsArr[0];
		
		for (int i = 1; i < size; i++) {
			if (Math.abs(tempsArr[i] - Math.abs(ans)) < EPSILON) {
				ans = tempsArr[i];
			}
			if (Math.abs(tempsArr[i]) < Math.abs(ans)) {
				ans = tempsArr[i];
			}
		}
		
		return ans;
    }
    
	public void addToTemps(double tempValue) {
		for (int i = 0; i < size; i++) {
			tempsArr[i] += tempValue;
		}
	}
	
    public double findTempClosestToValue(double tempValue) {
        checkIllegalArgument();
		
		addToTemps(-tempValue);
		double ans = findTempClosestToZero() + tempValue;
		addToTemps(tempValue);
        
		return ans;
	}
    
    public double[] findTempsLessThen(double tempValue) {
		checkIllegalArgument();
		
		double[] arr = new double[tempsArr.length];
		int arrSize = 0;
		for (int i = 0; i < size; i++) {
			if (tempsArr[i] < tempValue) {
				arr[arrSize++] = tempsArr[i];
			}
		}
		
		double[] ans = new double[arrSize];
		
		if (arrSize == 0) {
			return new double[0];
		}
		
		System.arraycopy(arr, 0, ans, 0, arrSize);
        return ans;
    }
    
    public double[] findTempsGreaterThen(double tempValue) {
		double[] less = findTempsLessThen(tempValue);
		
		if (less.length == 0) {
			return tempsArr.clone();
		}
		
		if (less.length == tempsArr.length) {
			return new double[0];
		}
		
		double[] ans = new double[tempsArr.length - less.length];
		int ansSize = 0;
		
		for (int i = 0; i < size; i++) {
			boolean was = false;
			for (int j = 0; j < less.length; j++) {
				if (Math.abs(tempsArr[i] - less[j]) < EPSILON) {
					was = true;
					break;
				}
			}
			if (!was) {
				ans[ansSize++] = tempsArr[i];
			}
		}
		
        return ans;
    }
    
    public TempSummaryStatistics summaryStatistics() {
		checkIllegalArgument();
		
		double avg = average();
		double dev = deviation();
		double min = min();
		double max = max();
		
		TempSummaryStatistics ans = 
			new TempSummaryStatistics(avg, dev, min, max);
		
        return ans;
    }
    
    public int addTemps(double ... temps) {
		checkInputMistmach(temps);
		
		if (temps.length + size > tempsArr.length) {
			int n = tempsArr.length;
			
			while (n < temps.length+size) {
				n *= 2;
			}
			
			double[] old = new double[tempsArr.length];
			System.arraycopy(tempsArr, 0, old, 0, tempsArr.length);
			
			tempsArr = new double[n];
			System.arraycopy(old, 0, tempsArr, 0, old.length);
		}
		
		if (temps.length > 0) {
			System.arraycopy(temps, 0, 
				tempsArr, size, temps.length);
		
			size += temps.length;
		}
		
        return size;
    }
}
