import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       /* Point point1 = new Point(2, 2);
        Point point2 = new Point(2, 4);
        Point point3 = new Point(4, 4);
        Point point4 = new Point(4, 6);
        Point point5 = new Point(6, 2);
        Point point6 = new Point(6, 3);
        Point point7 = new Point(6, 4);
        Point point8 = new Point(6, 6);
        Point point9 = new Point(8, 3);
        Point point10 = new Point(8, 4);*/
        Point point1 = new Point(4, 2);
        Point point2 = new Point(10, 4);
        Point point3 = new Point(8, 2);
        Point point4 = new Point(6, 6);
        Point point5 = new Point(2, 4);
        Point point6 = new Point(6, 4);
        Point point7 = new Point(4, 6);
        Point point8 = new Point(4, 3);
        Point point9 = new Point(2, 2);
        Point point10 = new Point(10, 2);
        Point point11 = new Point(8, 3);
        Point point12 = new Point(4, 4);
        /*Point point1 = new Point(2, 1);
        Point point2 = new Point(6, 1);
        Point point3 = new Point(3, 2);
        Point point4 = new Point(4, 2);
        Point point5 = new Point(2, 4);
        Point point6 = new Point(3, 4);
        Point point7 = new Point(3, 5);
        Point point8 = new Point(4, 5);
        Point point9 = new Point(5, 5);
        Point point10 = new Point(6, 5);
        Point point11 = new Point(5, 6);
        Point point12 = new Point(6, 6);
        Point point13 = new Point(2, 7);
        Point point14 = new Point(3, 7);
        Point point15 = new Point(2, 8);
        Point point16 = new Point(6, 8);*/

        List<Point> points = new ArrayList<>();
        points.add(point10);
        points.add(point6);
        points.add(point7);
        points.add(point1);
        points.add(point2);
        points.add(point5);
        points.add(point3);
        points.add(point8);
        points.add(point9);
        points.add(point4);
        points.add(point11);
        points.add(point12);
       /* points.add(point13);
        points.add(point14);
        points.add(point15);
        points.add(point16);*/
        Collections.sort(points);
        System.out.println(points);
        Solver solver = new Solver(points);
        List<Edge> edges = solver.solve();
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }
}
