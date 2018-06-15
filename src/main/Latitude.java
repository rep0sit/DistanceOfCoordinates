package main;
import static main.ConstantsAndUtils.MAX_LAT;
import static main.ConstantsAndUtils.MIN_LAT;

/**
 * Latitude measures how far north or south of the equator a place is located.
 * The equator is situated at 0°, the North Pole at 90° north (or 90°, because a
 * positive latitude implies north), and the South Pole at 90° south (or –90°).
 * Latitude measurements range from 0° to (+/–)90°.
 * <br> Value will be normalized
 *
 * @author Etienne Onasch
 *
 */
public class Latitude implements LatLonInterface{
	private final double lat;
	/**
	 * Constructor for a Latitude instance.<br>
	 * 
	 * @param lat the double value for this latitude value. Will be interpreted as degree.
	 */
	public Latitude(double lat) {
		this.lat = lat < MIN_LAT ? MIN_LAT : lat > MAX_LAT ? MAX_LAT : lat;
	}
	
	@Override
	public double getVal() {
		return lat;
	}
}
