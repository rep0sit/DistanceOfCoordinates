package main;
import static main.ConstantsAndUtils.MAX_LON;
import static main.ConstantsAndUtils.MIN_LON;
/**
 * Longitude measures how far east or west of the prime meridian a place is
 * located. The prime meridian runs through Greenwich, England. Longitude
 * measurements range from 0° to (+/–)180°.
 * <br> Value will be normalized
 */
public class Longnitude implements LatLonInterface{
	private final double lon;
	
	/**
	 * Constructor for a Longnitude instance. 
	 * @param lon the double value for this longnitude value. Will be interpreted as degree.
	 */
	public Longnitude(double lon) {
		this.lon = lon < MIN_LON ? MIN_LON : lon > MAX_LON ? MAX_LON : lon;
	}
	
	@Override
	public double getVal() {
		return lon;
	}
	
}
