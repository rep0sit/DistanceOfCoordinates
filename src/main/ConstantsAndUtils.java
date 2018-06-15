package main;
/**
 * 
 * @author Etienne Onasch
 *
 */
final class ConstantsAndUtils {
	private ConstantsAndUtils() {}
	// Constants
	public static final double RADIUS_EARTH_IN_KM = 6371.0;
	
	public static final double MIN_LAT = -90.0;
	public static final double MAX_LAT = 90.0;
	
	public static final double MIN_LON = -180.0;
	public static final double MAX_LON = 180.0;
	
	public static final double BEARING_NORTH = 0.0;
	public static final double BEARING_SOUTH = 180.0;
	public static final double BEARING_WEST = 270.0;
	public static final double BEARING_EAST = 90.0;
	
	public static final double BEARING_NORTH_RAD = degreeToRad(BEARING_NORTH);
	public static final double BEARING_SOUTH_RAD = degreeToRad(BEARING_SOUTH);
	public static final double BEARING_WEST_RAD = degreeToRad(BEARING_WEST);
	public static final double BEARING_EAST_RAD = degreeToRad(BEARING_EAST);
	
	//Utils
	
	/**
	 * Calculate radans from degree
	 * @param degree value of degree
	 * @return the value in radans
	 */
	public static double degreeToRad(double degree) {
		return degree * Math.PI / 180.0;
	}
	
	public static double radansToDegree(double radans) {
		return radans * 180 / Math.PI;
	}
	
	
}
