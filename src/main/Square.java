package main;

import static main.ConstantsAndUtils.BEARING_NORTH_RAD;

import static main.ConstantsAndUtils.ONE_EIGHTY;
import static main.ConstantsAndUtils.THREE_SIXTY;
import static main.ConstantsAndUtils.FIVE_FOURTY;
import static main.ConstantsAndUtils.BEARING_SOUTH_RAD;
import static main.ConstantsAndUtils.BEARING_WEST_RAD;
import static main.ConstantsAndUtils.BEARING_EAST_RAD;
import static main.ConstantsAndUtils.RADIUS_EARTH_IN_KM;
import static main.ConstantsAndUtils.degreeToRad;
import static main.ConstantsAndUtils.radansToDegree;
/**
 * This class represents a Square "around" Coordinates.<br>
 * So the a sqare consists of a minimum latitude and longnitude, <br>
 * and a maximum latitude and longnitude.<br>
 * <br>
 * 
 * <u><b>Example:</u><br>
 * </b> Coordinates c1: <br>
 * - distance : <i>d</i><br>
 * - latitude : <i>n</i><br>
 * - longnitude : <i>m</i><br>
 * <br>
 * calculated:<br>
 * -> maxLat : latitude that is d kilometers north of coordinates<br>
 * -> minLat : latitude that is d kilometers south of coordinates<br>
 * -> maxLon : longnitude that is d kilometers east of coordinates<br>
 * -> minLon : longnitude that is d kilometers west of coordinates<br>
 * 
 * <br>
 * Used formulas: https://www.movable-type.co.uk/scripts/latlong.html <br>
 * <br>
 *  

 * @author Etienne Onasch
 *
 */
public class Square {
	
	private final double dist, latRad, lonRad;
	
	private double minLat = 0.0, maxLat = 0.0, minLon = 0.0, maxLon = 0.0;

	
	
	public Square(Coordinates c1, double dist) {
		this.dist = dist;
		latRad = degreeToRad(c1.getLatitude());
		lonRad = degreeToRad(c1.getLongnitude());
		calculate();
	}
	
	private void calculate() {
		maxLat = newLat(dist, BEARING_NORTH_RAD);
		minLat = newLat(dist, BEARING_SOUTH_RAD);
		maxLon = newLon(dist, BEARING_EAST_RAD, newLat(dist, BEARING_EAST_RAD));
		minLon = newLon(dist, BEARING_WEST_RAD, newLat(dist, BEARING_WEST_RAD));
	}
	 
	private double newLat(double distance, double bearingRad) {
		double angularDist = distance / RADIUS_EARTH_IN_KM;
		return Math.asin(Math.sin(latRad) * Math.cos(angularDist) + Math.cos(latRad) * Math.sin(angularDist) * Math.cos(bearingRad));
	}
	
	private double newLon(double distance, double bearingRad, double latR) {
		double angularDist = distance / RADIUS_EARTH_IN_KM; 
		return 
				lonRad + Math.atan2(Math.sin(bearingRad) * Math.sin(angularDist) * Math.cos(latRad), 
						Math.cos(angularDist) - Math.sin(latRad) * Math.sin(latR));
	}
	
	private double normalizeMinusPlus180(double lon) {
		return (lon + FIVE_FOURTY) % THREE_SIXTY - ONE_EIGHTY;
	}
	
	public double getMinLat() {
		return radansToDegree(minLat);
	}
	public double getMaxLat() {
		return radansToDegree(maxLat);
	}
	public double getMinLon() {
		return normalizeMinusPlus180(radansToDegree(minLon));
	}
	public double getMaxLon() {
		return normalizeMinusPlus180(radansToDegree(maxLon));
	}
	
}
