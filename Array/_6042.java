package Array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _6042 {
    public int countLatticePoints(int[][] circles) {
        Set<Point> points = new HashSet<>();
        for (int[] circle : circles){
            int x = circle[0];
            int y = circle[1];
            int r = circle[2];
            for (int i = x - r; i <= x + r; i++){
                for (int j = 0; j <= r; j++){
                    if (isOut(x, y, i, y + j, r))break;
                    points.add(new Point(i, y + j));
                    points.add(new Point(i, y - j));
                }
            }
        }
        return points.size();
    }

    private boolean isOut(int x, int y, int newX, int newY, int r){
        return (newX - x) * (newX - x) +(newY - y) * (newY - y) > r * r;
    }

    class Point{
        public int x;
        public int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    @Test
    public void test(){
        int[][] arrs = {{2,2,1}};
        System.out.println(countLatticePoints(arrs));
    }
}
