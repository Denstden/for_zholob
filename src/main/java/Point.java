
public class Point implements Comparable<Point>{
    double x;
    double y;
    boolean mark = false;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point o) {
        if (x>o.x) return 1;
        if (x<o.x) return -1;

        if (y>o.y) return 1;
        if (y<o.y) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "["+x+", "+y+"]";
    }
}
