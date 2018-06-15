package main;

public class DOC {
	
	
	
	public static void main(String[] args) {
		String errString1 = "Program DOC needs four arguments. (integer or float)"
				+ "\nFirst Argument: latitude of first coordinates in degree. "
				+ "\nSecond Argument: longnitude of first coordinates in degree."
				+ "\nThird Argument: latitude of second coordinates in degree"
				+ "\nFourth Argument: longnitude of second coordinates in degree";
		
		String errString2 = "All four values (lat1, lon1, lat2, lon2) must be integer or float!";
		
		
		double lat1 = 0.0, lon1 = 0.0, lat2 = 0.0, lon2 = 0.0;
		
		
		
		if(args.length != 4) {
			throw new IllegalArgumentException(errString1);
			
		}
		
		try {
			lat1 = Double.parseDouble(args[0]);
			lon1 = Double.parseDouble(args[1]);
			lat2 = Double.parseDouble(args[2]);
			lon2 = Double.parseDouble(args[3]);
		
		}catch(NullPointerException npe) {
			npe.printStackTrace();
			System.exit(0);
			
		}catch(NumberFormatException nfe) {
			System.out.println(errString2);
			System.exit(0);
		}
		
		
		Coordinates c1 = new Coordinates(lat1, lon1);
		Coordinates c2 = new Coordinates(lat2, lon2);
		double dist = c1.getDistanceInKM(c2);
		
		
		System.out.println("Distance between");
		System.out.println("A : " + lat1 + ", " + lon1);
		System.out.println("B : " + lat2 + ", " + lon2);
		System.out.println("---------------------------------------");
		System.out.println(dist + " KM");
		
		

		
		
	}
}
