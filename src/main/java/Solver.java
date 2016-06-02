import java.util.ArrayList;
import java.util.List;

public class Solver {
    private static final double EPSILON = 0.00001;
    private List<Point> points;
    private boolean direction = true;

    public Solver(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public List<Point> solve(){
        List<Point> edges = new ArrayList<>();
        Edge edge;
        int i=0;
        int currentIndex = 0;
        Point prev = points.get(i++);
        prev.mark = true;
        Point current = null;
        edges.add(prev);

        while (i < points.size()){
            if (i%2==1){
                if (currentIndex%2==0){
                    current = points.get(++currentIndex);
                } else{
                    current = points.get(--currentIndex);
                }
            } else{
                current = findNearestPoint(prev);
                currentIndex = points.indexOf(current);
            }
            current.mark = true;
            //edge = new Edge(prev, current);
            //System.out.println(edge);
            edges.add(current);
            prev = current;
            i++;
        }
        /*edges.add(new Edge(edges.get(edges.size()-1).getPoint2(), edges.get(0).getPoint1()));*/
        return edges;
    }

    private Point findNearestPoint(Point current) {
        Point result = null;
        Double minDistance = Double.MAX_VALUE;
        for (Point point: points){
            if (point.equals(current) || point.mark) continue;
            if (Math.abs(current.y - point.y)<EPSILON){
                if (direction){
                    double dist = point.x - current.x;
                    if (dist<0) continue;
                    if (minDistance > dist){
                        minDistance = dist;
                        result = point;
                    }
                } else {
                    double dist = current.x - point.x;
                    if (dist<0) continue;
                    if (minDistance > dist){
                        minDistance = dist;
                        result = point;
                    }
                }
            }
        }
        if (result == null){
            if (!direction){
                return null;
            }
            direction = false;
            return findNearestPoint(current);
        } else{
            return result;
        }
    }
}
