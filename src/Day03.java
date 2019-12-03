import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Day03 extends Day {
    Map<Point, Integer> points1;
    Map<Point, Integer> points2;


    public Day03() {
        Scanner input = getInput();
        String[] line1 = input.nextLine().split(",");
        String[] line2 = input.nextLine().split(",");
        points1 = getPoints(line1);
        points2 = getPoints(line2);
    }

    @Override
    Object problem1() {
        return points1.keySet().stream()
                .filter(points2::containsKey)
                .mapToInt(p -> Math.abs(p.x) + Math.abs(p.y))
                .min()
                .getAsInt();


    }

    @Override
    Object problem2() {
        return points1.entrySet().stream()
                .filter(p -> points2.containsKey(p.getKey()))
                .mapToInt(p -> p.getValue() + points2.get(p.getKey()))
                .min()
                .getAsInt();
    }


    private Map<Point, Integer> getPoints(String[] lines) {
        Map<Point, Integer> points = new HashMap<>();
        int x = 0, y = 0, distance = 0;
        for (String s : lines) {
            char c = s.charAt(0);
            int i = Integer.parseInt(s.substring(1));
            int end;
            switch (c) {
                case 'U':
                    end = y + i;
                    while (y < end) {
                        y++;
                        distance++;
                        points.put(new Point(x, y), distance);
                    }
                    break;
                case 'D':
                    end = y - i;
                    while (y > end) {
                        y--;
                        distance++;
                        points.put(new Point(x, y), distance);
                    }
                    break;
                case 'R':
                    end = x + i;
                    while (x < end) {
                        x++;
                        distance++;
                        points.put(new Point(x, y), distance);
                    }
                    break;
                case 'L':
                    end = x - i;
                    while (x > end) {
                        x--;
                        distance++;
                        points.put(new Point(x, y), distance);
                    }
                    break;
            }
        }

        return points;
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


}
