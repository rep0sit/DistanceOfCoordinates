package main;

import static main.ConstantsAndUtils.MAX_LAT;
import static main.ConstantsAndUtils.MAX_LON;
import static main.ConstantsAndUtils.MIN_LAT;
import static main.ConstantsAndUtils.MIN_LON;
import static main.ConstantsAndUtils.RADIUS_EARTH_IN_KM;
import static main.ConstantsAndUtils.degreeToRad;

/**
 * 
 * PRECONDITION:<br>
 * <br>
 * First Value is latitude:<br>
 * must be >= -90 and <= 90 <br>
 * <br>
 * Second Value is longnitude:<br>
 * must be >= -180 and <= 180 <br>
 * <br>
 * 
 * Every entry out of this bounds will be normalized:<br>
 * <br>
 * For example the pair of values (-91, 181) will be normalized to (-90,180)<br>
 * the pair of values (91, -181) will be normalized to (90, -180)
 * 
 * 
 * 
 * @author Etienne Onasch
 * 
 */
public class Coordinates {

	/**
	 * Latitude measures how far north or south of the equator a place is located.
	 * The equator is situated at 0°, the North Pole at 90° north (or 90°, because a
	 * positive latitude implies north), and the South Pole at 90° south (or –90°).
	 * Latitude measurements range from 0° to (+/–)90°.
	 * 
	 * 
	 */
	private final double latitude;

	/**
	 * Longitude measures how far east or west of the prime meridian a place is
	 * located. The prime meridian runs through Greenwich, England. Longitude
	 * measurements range from 0° to (+/–)180°.
	 */
	private final double longnitude;

	public Coordinates(double latitude, double longnitude) {
		this.latitude = latitude < MIN_LAT ? MIN_LAT : latitude > MAX_LAT ? MAX_LAT : latitude;
		this.longnitude = longnitude < MIN_LON ? MIN_LON : longnitude > MAX_LON ? MAX_LON : longnitude;
	}

	public Coordinates(Latitude lat, Longnitude lon) {
		this(lat.getVal(), lon.getVal());
	}

	/**
	 * Distance in km between two points (coordinates) on earth. <br>
	 * <br>
	 * dist_km = 6371 * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) *
	 * cos(lon2 - lon1))
	 * 
	 * The equotation gives the length of the large arc between two points (lat1,
	 * lon1) and (lat2, lon2) on a sphere with a radius of 6371 km. Since earth is
	 * no perfect sphere, this is just an approximation, which is especially
	 * suitable for greater distances.
	 * 
	 * 
	 * 
	 * @param other
	 *            the other coordinates
	 * @return distance between two coordinates in km.
	 */
	public double getDistanceInKM(Coordinates other) {

		double lon1 = degreeToRad(longnitude);
		double lat1 = degreeToRad(latitude);

		double lon2 = degreeToRad(other.getLongnitude());
		double lat2 = degreeToRad(other.getLatitude());

		return RADIUS_EARTH_IN_KM
				* Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
	}

	public Square getSquareOf(double kilometers) {
		return null;
	}

	/**
	 *Determines if two coordinates are in a certain distance to each other.
	 * 
	 * @param other
	 *            the other coordinates
	 * @param radius
	 *           the method will determine if the other coordinates are within the radius
	 *           around this coordinates
	 * @return returns true if the distance between the two coordinates is smaller or equals
	 * 			the given radius, false otherwise.
	 */
	public boolean isInRadius(Coordinates other, double radius) {
		return getDistanceInKM(other) <= radius;
	}

	/**
	 * Returns the longnitude of this coordinates
	 * 
	 * @return longnitude of this coordinates
	 */
	public double getLongnitude() {
		return longnitude;
	}

	/**
	 * Returns the latitude of this coordinates
	 * 
	 * @return latitude of this coordinates
	 */
	public double getLatitude() {
		return latitude;
	}

}
