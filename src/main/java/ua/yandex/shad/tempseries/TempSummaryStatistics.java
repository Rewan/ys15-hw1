package ua.yandex.shad.tempseries;

public class TempSummaryStatistics {
    public final double avgTemp;
	public final double devTemp;
	public final double minTemp;
	public final double maxTemp;
	public final static double EPSILON = 0.00001;
	
	public TempSummaryStatistics(double avg, double dev, double min, double max) {
		avgTemp = avg;
		devTemp = dev;
		minTemp = min;
		maxTemp = max;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		TempSummaryStatistics statistics = (TempSummaryStatistics) obj;
		
		if(Math.abs(avgTemp - statistics.avgTemp) >= EPSILON) {
			return false;
		}
		
		if(Math.abs(devTemp - statistics.devTemp) >= EPSILON) {
			return false;
		}
		
		if(Math.abs(minTemp - statistics.minTemp) >= EPSILON) {
			return false;
		}
		
		if(Math.abs(maxTemp - statistics.maxTemp) >= EPSILON) {
			return false;
		}
		
		return true;
	}
}
