/**
 * Created by storo on 6/2/2016.
 */
public class Edge {
    private Point point1;
    private Point point2;

    public Edge(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }
}
