package main;
import static main.Constants.MAX_LON;
import static main.Constants.MIN_LON;
/**
 * Longitude measures how far east or west of the prime meridian a place is
 * located. The prime meridian runs through Greenwich, England. Longitude
 * measurements range from 0° to (+/–)180°.
 * <br> Value will be normalized
 */
public class Longnitude {
	private final double lon;
	
	/**
	 * Constructor for a Longnitude instance. 
	 * @param lon the double value for this longnitude value. Will be interpreted as degree.
	 */
	public Longnitude(double lon) {
		this.lon = lon < MIN_LON ? MIN_LON : lon > MAX_LON ? MAX_LON : lon;
	}
	
	public double getLon() {
		return lon;
	}
	
}
