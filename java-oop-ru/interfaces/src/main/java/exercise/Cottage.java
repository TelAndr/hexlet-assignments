package exercise;

// BEGIN
public class Cottage implements Home { // , Comparable<Cottage>
	private double area;
	private int floorCount;
	Cottage(double area, int floorCount) {
		this.area = area;
		this.floorCount = floorCount;
	}
	
	public String toString() {
		return floorCount + " этажный коттедж площадью " + area + " метров";
	}
	
	@Override
	public double getArea() {
		return area;
	}
	
	@Override
	public int compareTo(Home another) {
		int compFeature;
		if (area > another.getArea())
			compFeature = 1;
		else if (area == another.getArea())
			compFeature = 0;
		else 
			compFeature = -1;
		return compFeature;
	}
}
// END
