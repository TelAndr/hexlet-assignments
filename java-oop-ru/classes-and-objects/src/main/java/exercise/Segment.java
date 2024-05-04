package exercise;

// BEGIN

public class Segment {
	private int x1, y1;
	private int x2, y2;
	//private Point firstPoint(x1, y1);
        Point firstPoint = new Point(x1, x2);
	//private Point secondPoint(x2, y2);
        Point secondPoint = new Point(x2, y2);
        
	public Segment(Point firstPoint, Point secondPoint) {
		this.firstPoint = firstPoint;
		this.secondPoint = secondPoint;
	}
	public Point getBeginPoint() {
		return firstPoint;
	}
	public Point getEndPoint() {
		return secondPoint;
	}
	public Point getMidPoint() {
		//Point midPoint((x1 + x2) / 2, (y1 + y2) / 2);
                //Point midPoint = new Point((x1 + x2) / 2, (y1 + y2) / 2);
		//return midPoint;
                //return new Point((x1 + x2) / 2, (y1 + y2) / 2);
				return new Point((firstPoint.getX() + secondPoint.getX()) / 2,
						(firstPoint.getY() + secondPoint.getY()) / 2);
	}
};
// END
