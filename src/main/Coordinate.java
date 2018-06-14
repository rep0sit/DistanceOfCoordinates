package main;

/**
 * 
 * @author Etienne Onasch, Nelli Welker
 *
 */
public class Coordinate {

	/**
	 * Latitude measures how far north or south of the equator a place is located.
	 * The equator is situated at 0°, the North Pole at 90° north (or 90°, because a
	 * positive latitude implies north), and the South Pole at 90° south (or –90°).
	 * Latitude measurements range from 0° to (+/–)90°.
	 * 
	 * Deutsch: Laengengrad
	 */
	private final double longnitude;

	/**
	 * Latitude measures how far north or south of the equator a place is located.
	 * The equator is situated at 0°, the North Pole at 90° north (or 90°, because a
	 * positive latitude implies north), and the South Pole at 90° south (or –90°).
	 * Latitude measurements range from 0° to (+/–)90°.
	 * 
	 * Deutsch: Breitengrad
	 */
	private final double latitude;
	
	public Coordinate(double longnitude, double latitude) {
		this.latitude = latitude;
		this.longnitude = longnitude;
	}

	public double getLongnitude() {
		return longnitude;
	}

	public double getLatitude() {
		return latitude;
	}
	
	
	
	
	

}
