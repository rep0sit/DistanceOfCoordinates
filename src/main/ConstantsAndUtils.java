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
	public static final double ZERO = 0.0;
	public static final double NINETY = 90.0;
	public static final double ONE_EIGHTY = 2.0 * NINETY;
	public static final double TWO_SEVENTY = 3.0 * NINETY;
	public static final double THREE_SIXTY = 2.0 * ONE_EIGHTY;
	public static final double FIVE_FOURTY = 2.0 * TWO_SEVENTY;

	public static final double MIN_LAT = -NINETY;
	public static final double MAX_LAT = NINETY;
	
	public static final double MIN_LON = -ONE_EIGHTY;
	public static final double MAX_LON = ONE_EIGHTY;
	
	public static final double BEARING_NORTH = ZERO;
	public static final double BEARING_SOUTH = ONE_EIGHTY;
	public static final double BEARING_WEST = TWO_SEVENTY;
	public static final double BEARING_EAST = NINETY;
	
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
		return degree * Math.PI / ONE_EIGHTY;
	}
	
	public static double radansToDegree(double radans) {
		return radans * ONE_EIGHTY / Math.PI;
	}
	
	
}
