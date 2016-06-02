import math.geom2d.Point2D;
import math.geom2d.polygon.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Point2D[] vertices1 = new Point2D[4];
        vertices1[0] = new Point2D(2,1);
        vertices1[1] = new Point2D(6,1);
        vertices1[2] = new Point2D(6,5);
        vertices1[3] = new Point2D(2,5);

        Point2D[] vertices2 = new Point2D[6];
        vertices2[0] = new Point2D(4,3);
        vertices2[1] = new Point2D(8,3);
        vertices2[2] = new Point2D(8,5);
        vertices2[3] = new Point2D(10,5);
        vertices2[4] = new Point2D(10,7);
        vertices2[5] = new Point2D(4,7);

        Polygon2D polygon2D1 = new SimplePolygon2D(vertices1);
        Polygon2D polygon2D2 = new SimplePolygon2D(vertices2);

        Point2D[] vertices3 = new Point2D[4];
        vertices3[0] = new Point2D(5,2);
        vertices3[1] = new Point2D(7,2);
        vertices3[2] = new Point2D(7,4);
        vertices3[3] = new Point2D(5,4);
        Polygon2D polygon2D3 = new SimplePolygon2D(vertices3);

        Point2D[] vertices4 = new Point2D[4];
        vertices4[0] = new Point2D(1,1);
        vertices4[1] = new Point2D(1,10);
        vertices4[2] = new Point2D(10,10);
        vertices4[3] = new Point2D(10,1);
        Polygon2D polygon2D4 = new SimplePolygon2D(vertices4);

        List<Polygon2D> input = new ArrayList<Polygon2D>(){{
            add(polygon2D1);
            add(polygon2D2);
            add(polygon2D3);
            add(polygon2D4);
        }};*/
        Point2D[] vertices1 = new Point2D[4];
        vertices1[0] = new Point2D(2,2);
        vertices1[1] = new Point2D(8,2);
        vertices1[2] = new Point2D(8,4);
        vertices1[3] = new Point2D(2,4);

        Point2D[] vertices2 = new Point2D[8];
        vertices2[0] = new Point2D(3,3);
        vertices2[1] = new Point2D(4,3);
        vertices2[2] = new Point2D(4,5);
        vertices2[3] = new Point2D(6,5);
        vertices2[4] = new Point2D(6,3);
        vertices2[5] = new Point2D(7,3);
        vertices2[6] = new Point2D(7,6);
        vertices2[7] = new Point2D(3,6);

        Polygon2D polygon2D1 = new SimplePolygon2D(vertices1);
        Polygon2D polygon2D2 = new SimplePolygon2D(vertices2);

        Point2D[] vertices3 = new Point2D[4];
        vertices3[0] = new Point2D(1,1);
        vertices3[1] = new Point2D(5,1);
        vertices3[2] = new Point2D(5,7);
        vertices3[3] = new Point2D(1,7);
        Polygon2D polygon2D3 = new SimplePolygon2D(vertices3);

        /*Point2D[] vertices4 = new Point2D[4];
        vertices4[0] = new Point2D(1,1);
        vertices4[1] = new Point2D(1,10);
        vertices4[2] = new Point2D(10,10);
        vertices4[3] = new Point2D(10,1);
        Polygon2D polygon2D4 = new SimplePolygon2D(vertices4);*/

        List<Polygon2D> input = new ArrayList<Polygon2D>(){{
            add(polygon2D1);
            add(polygon2D2);
            add(polygon2D3);
            //add(polygon2D4);
        }};

        Polygon2D polygon1, polygon2, intersect;
        List<Polygon2D> res;
        polygon1 = input.get(0);
        for (int i=1; i<input.size()-1; i++){
            polygon2 = input.get(i);
            intersect = Polygons2D.intersection(polygon1, polygon2);
            System.out.println(intersect.vertices());
            res = new ArrayList<>();
            if (intersect instanceof SimplePolygon2D){
                res.add(Polygons2D.intersection(intersect, input.get(i + 1)));
            } else {
                for (LinearRing2D p : ((MultiPolygon2D) intersect).contours()) {
                    res.add(Polygons2D.intersection(new SimplePolygon2D(p.vertices()), input.get(i + 1)));
                }
            }
            polygon1 = res.get(0);
            for (int j=1;j<res.size(); j++){
                polygon1 = Polygons2D.union(polygon1, res.get(j));
            }
        }
        System.out.println("RES: "+polygon1.vertices());
    }
}
