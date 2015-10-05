package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
	
    public static final double EPSILON = 0.00001;

	private final double avgTemp;
	private final double devTemp;
	private final double minTemp;
	private final double maxTemp;
	
	public TempSummaryStatistics(double avg, double dev, 
			double min, double max) {
		avgTemp = avg;
		devTemp = dev;
		minTemp = min;
		maxTemp = max;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		TempSummaryStatistics statistics = (TempSummaryStatistics) obj;
		
		if (Math.abs(avgTemp - statistics.getAvgTemp()) >= EPSILON) {
			return false;
		}
		
		if (Math.abs(devTemp - statistics.getDevTemp()) >= EPSILON) {
			return false;
		}
		
		if (Math.abs(minTemp - statistics.getMinTemp()) >= EPSILON) {
			return false;
		}
		
		if (Math.abs(maxTemp - statistics.getMaxTemp()) >= EPSILON) {
			return false;
		}
		
		return true;
	}
	
	public double getAvgTemp() {
		return this.avgTemp;
	}
	
	public double getDevTemp() {
		return this.devTemp;
	}
	
	public double getMinTemp() {
		return this.minTemp;
	}
	
	public double getMaxTemp() {
		return this.maxTemp;
	}
	
	public int hashCode() {
		assert false : "hashCode not designed";
		return 42; // any arbitrary constant will do
	}
}
