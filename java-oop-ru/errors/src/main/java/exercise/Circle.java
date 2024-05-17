package exercise;

// BEGIN
public class Circle {
	private Point curPoint;
	private int radius;
	Circle(Point inpPoint, int inpRadius) {
		curPoint = inpPoint;
		radius = inpRadius;
	}
	public int getRadius() {
		return radius;
	}
	public double getSquare() throws NegativeRadiusException{
		if (radius >= 0) {
			return Math.PI * radius * radius;
		} else {
			throw new NegativeRadiusException("error code 1", "Input cannot be null or empty"); //throw NegativeRadiusException;
		}
	}
}
// END
