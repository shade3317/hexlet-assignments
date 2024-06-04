package exercise;


// BEGIN
public class Circle {
    private Point center;
    private int   radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        } else {
            return Math.PI * (double) radius * (double) radius;
        }
    }
}
// END
