package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {
	
	private static final double DELTA = 0.001;

	@Test
	public void testGetMinLat() {
		Coordinates alpha = new Coordinates(45.0, 8.0);
		Coordinates bravo = new Coordinates(44.0, 8.0);
		double dist = alpha.getDistanceInKM(bravo);
		Square s = new Square(alpha, dist);
		
		assertEquals(s.getMinLat(), bravo.getLatitude(), DELTA);
		
		alpha = new Coordinates(0.0, 8.0);
		bravo = new Coordinates(-1.0, 8.0);
		dist = alpha.getDistanceInKM(bravo);
		s = new Square(alpha, dist);
		
		
		assertEquals(s.getMinLat(), bravo.getLatitude(), DELTA);
		
		
		alpha = new Coordinates(-90.0, 0.0);
		bravo = new Coordinates(-89.0, 0.0);
		dist = alpha.getDistanceInKM(bravo);
		s = new Square(alpha, dist);
		
		
		assertEquals(s.getMinLat(), bravo.getLatitude(), DELTA);
		
		
		
	}

	@Test
	public void testGetMaxLat() {
		Coordinates alpha = new Coordinates(45.0, 8.0);
		Coordinates bravo = new Coordinates(46.0, 8.0);
		double dist = alpha.getDistanceInKM(bravo);
		Square s = new Square(alpha, dist);
		
		assertEquals(s.getMaxLat(), bravo.getLatitude(), DELTA);
		
		alpha = new Coordinates(-90.0, 0.0);
		bravo = new Coordinates(-89.0, 0.0);
		dist = alpha.getDistanceInKM(bravo);
		s = new Square(alpha, dist);
		
		assertEquals(s.getMaxLat(), bravo.getLatitude(), DELTA);
	}

	@Test
	public void testGetMinLon() {
		Coordinates alpha = new Coordinates(0.0, -179.5);
		Coordinates bravo = new Coordinates(0.0, 179.5);
		double dist = alpha.getDistanceInKM(bravo);
		Square s = new Square(alpha, dist);
	
		assertEquals(s.getMinLon(), bravo.getLongnitude(), DELTA);
		
		
		
	}

	@Test
	public void testGetMaxLon() {
		Coordinates alpha = new Coordinates(0.0, 179.5);
		Coordinates bravo = new Coordinates(0.0, -179.5);
		double dist = alpha.getDistanceInKM(bravo);
		Square s = new Square(alpha, dist);
	
		assertEquals(s.getMaxLon(), bravo.getLongnitude(), DELTA);
		
		alpha = new Coordinates(0.0, 33.3);
		bravo = new Coordinates(0.0, 34.3);
		dist = alpha.getDistanceInKM(bravo);
		s = new Square(alpha, dist);
	
		assertEquals(s.getMaxLon(), bravo.getLongnitude(), DELTA);
	}

}
