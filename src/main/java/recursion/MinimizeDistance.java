package recursion;

import java.util.Arrays;

public class MinimizeDistance {

    static class Point implements Comparable<Point> {
        int x, y;
        int distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = 0;
        }

        @Override
        public int compareTo(Point other) {
            if (this.distance == other.distance) {
                if (this.x == other.x)
                    return Integer.compare(this.y, other.y);
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int manhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    public static Point minimizeDistance(int[][] segments) {
        int n = segments.length;
        Point[] points = new Point[2 * n];

        for (int i = 0; i < n; i++) {
            int x1 = segments[i][0];
            int y1 = segments[i][1];
            int x2 = segments[i][2];
            int y2 = segments[i][3];
            points[2 * i] = new Point(x1, y1);
            points[2 * i + 1] = new Point(x2, y2);
        }

        Arrays.sort(points, (a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });

        for (int i = 1; i < 2 * n; i += 2) {
            points[i].distance = manhattanDistance(points[i - 1], points[i]);
        }

        Arrays.sort(points);

        return points[0];
    }

    public static void main(String[] args) {
        int[][] segments = {{4, 2, 4, 5}, {3, 3, 5, 3}, {0,3,0,4}};
        Point result = minimizeDistance(segments);
        System.out.println("Point with minimized distance: (" + result.x + ", " + result.y + ")");
    }
}