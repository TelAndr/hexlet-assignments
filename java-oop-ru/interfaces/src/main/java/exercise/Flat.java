package exercise;

// BEGIN
public class Flat implements Home { // , Comparable<Flat>
	private double area;
	private double balconyArea;
	private int floor;
	Flat(double area, double balconyArea, int floor) {
		this.area = area;
		this.balconyArea = balconyArea;
		this.floor = floor;
	}
	@Override
	public double getArea() {
		return area + balconyArea;
	}
	
	public String toString() {
		return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
	}
	
	@Override
	public int compareTo(Home another) {
		int compFeature;
		if (getArea() > another.getArea())
			compFeature = 1;
		else if (getArea() == another.getArea())
			compFeature = 0;
		else 
			compFeature = -1;
		return compFeature;
	}
}
// END
