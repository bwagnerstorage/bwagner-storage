import java.util.*;
import java.io.*;
import java.awt.Point;

public class Platform
{

    private static int[][] steps =
    {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    private static Map<Character, int[]> slides;

    static
    {
            slides = new HashMap<Character, int[]>();

            slides.put('^', steps[0]);
            slides.put('v', steps[1]);
            slides.put('>', steps[2]);
            slides.put('<', steps[3]);
    }

    public static void main(String args[]) throws IOException
    {
            Scanner scan = new Scanner(new File("platform.dat"));

            int t = scan.nextInt();

            while (t-- > 0)
            {
                    int n = scan.nextInt();
                    int m = scan.nextInt();

                    char[][] grid = new char[n][m];
                    for (int i = 0; i < n; ++i)
                    {
                            String line = scan.next();
                            for (int j = 0; j < m; ++j)
                            {
                                    grid[i][j] = line.charAt(j);
                            }
                    }

                    Map<Point, List<Point>> graph = buildGraph(grid);
                    printGraph(graph);
                    boolean success = bfs(new Point(0, 0), new Point(n - 1, m - 1), graph);
                    System.out.println(success ? "YES" : "NO");
            }

            scan.close();
    }

    public static void printGraph(Map<Point, List<Point>> graph)
    {
        Set<Point> points = graph.keySet();
        for(Point p : points)
        {
            System.out.print(p.x + "," + p.y + "-->");
            List<Point> list = graph.get(p);
            for(Point p2 : list)
            {
                System.out.print(p2.x + "," + p2.y + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static boolean bfs(Point start, Point end, Map<Point, List<Point>> graph)
    {
            Queue<Point> q = new LinkedList<Point>();
            Set<Point> visited = new HashSet<Point>();

            q.add(start);
            visited.add(start);

            while (!q.isEmpty())
            {
                    Point p = q.poll();

                    if (p.equals(end))
                    {
                            return true;
                    }

                    for (Point child : graph.get(p))
                    {
                            if (!visited.contains(child))
                            {
                                    q.add(child);
                                    visited.add(child);
                            }
                    }
            }

            return false;
    }

    public static Point slideTo(Point p, char[][] grid)
    {
            char c = grid[p.x][p.y];

            if (c == '.')
            {
                    return null;
            }

            if (c == 'x')
            {
                    return p;
            }

            int row = p.x;
            int col = p.y;

            do
            {
                    row += slides.get(c)[0];
                    col += slides.get(c)[1];
            }
            while (grid[row][col] == '.' || grid[row][col] == c);

            return slideTo(new Point(row, col), grid);
    }

    public static boolean isValid(char[][] grid, int row, int col)
    {
            return row >= 0 && col >= 0 && row < grid.length && col < grid[row].length;
    }

    public static Map<Point, List<Point>> buildGraph(char[][] grid)
    {
            Map<Point, List<Point>> graph = new HashMap<Point, List<Point>>();

            for (int i = 0; i < grid.length; ++i)
            {
                    for (int j = 0; j < grid[i].length; ++j)
                    {
                            if (grid[i][j] != '.')
                            {
                                    graph.put(new Point(i, j), new ArrayList<Point>());
                            }

                            if (grid[i][j] == 'x')
                            {
                                    for (int[] step : steps)
                                    {
                                            int row = i + step[0];
                                            int col = j + step[1];

                                            if (isValid(grid, row, col) && grid[row][col] != '.')
                                            {
                                                    graph.get(new Point(i, j)).add(new Point(row, col));
                                            }
                                    }
                            }
                            else if (grid[i][j] != '.')
                            {
                                    graph.get(new Point(i, j)).add(slideTo(new Point(i, j), grid));
                            }
                    }
            }

            return graph;
    }
}
