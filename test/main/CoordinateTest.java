package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	@Test
	public void testGetDistanceInKM() {
		
		// FAR DISTANCE 1
		
		Coordinates c1 = new Coordinates(-25.0, 160.0);
		Coordinates c2 = new Coordinates(25.0, -160.0);

		// Distance according to
		// https://gps-coordinates.org/distance-between-coordinates.php
		// = 7029.37 KM
		
		double dist = 7029.37;
		//System.out.println(c1.getDistanceInKM(c2));
		
		double calculated = c1.getDistanceInKM(c2);
		// Weniger als 1 % Abweichung
		assertTrue(calculated > (dist * 0.99) && calculated < (dist * 1.01));
		
		// FAR DISTANCE 2
		
		c1 = new Coordinates(-90.0, 0.0);
		c2 = new Coordinates(90.0, 0.0);
		calculated = c1.getDistanceInKM(c2);
		dist = 20015.09;
		// Weniger als 1 % Abweichung
		assertTrue(calculated > (dist * 0.99) && calculated < (dist * 1.01));
		
		// Close Distance 1
		c1 = new Coordinates(33.01, 120.0);
		c2 = new Coordinates(33.02, 120.0);
		calculated = c1.getDistanceInKM(c2);
		dist = 1.11;
		// Weniger als 1 % Abweichung
		assertTrue(calculated > (dist * 0.99) && calculated < (dist * 1.01));

	}
	
	@Test 
	public void testGetDistanceInKM2() {
		// FAR DISTANCE 1
		
				Coordinates c1 = new Coordinates(new Latitude(-25.0), new Longnitude(160));
				Coordinates c2 = new Coordinates(new Latitude(25.0), new Longnitude(-160.0));

				// Distance according to
				// https://gps-coordinates.org/distance-between-coordinates.php
				// = 7029.37 KM
				
				double dist = 7029.37;
				//System.out.println(c1.getDistanceInKM(c2));
				
				double calculated = c1.getDistanceInKM(c2);
				// Weniger als 1 % Abweichung
				assertTrue(calculated > (dist * 0.99) && calculated < (dist * 1.01));
				
				// FAR DISTANCE 2
				
				c1 = new Coordinates(new Latitude(-90.0), new Longnitude(0.0));
				c2 = new Coordinates(new Latitude(90.0), new Longnitude(-0.0));
				calculated = c1.getDistanceInKM(c2);
				dist = 20015.09;
				// Weniger als 1 % Abweichung
				assertTrue(calculated > (dist * 0.99) && calculated < (dist * 1.01));
				
				// Close Distance 1
				c1 = new Coordinates(new Latitude(33.01), new Longnitude(120.0));
				c2 = new Coordinates(new Latitude(33.02), new Longnitude(120.0));
				calculated = c1.getDistanceInKM(c2);
				dist = 1.11;
				// Weniger als 1 % Abweichung
				assertTrue(calculated > (dist * 0.99) && calculated < (dist * 1.01));
	}
	
	@Test
	public void BuenosAiresToSaoNewYork() {
		
		// Koordinaten von www.latlong.net
		// Buenos Aires
		Coordinates buenosAires = new Coordinates(-34.603722, -58.381592);
		// New York
		Coordinates newYork = new Coordinates(40.73, -73.935);
		// Luftline in km laut www.luftlinie.org
		double dist = 8529.7;
		
		double calcDist = buenosAires.getDistanceInKM(newYork);
		// prüfen auf 0.05 % Abweichung von dist
		assertEquals(dist, calcDist, dist * 0.05 / 100.0);
		
	}
	

}
