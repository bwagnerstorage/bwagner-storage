import java.util.*;
import java.io.*;
import java.awt.*;

public class Paint {
    private static final char[] OPEN_DOORS = {'-'};
    private static final char[] WALLS_AND_CLOSED_DOORS = {'X', '='};
    private static final int[][] dirs =
        { {-1, 0, 1, 0}, {0, 1, 0, -1} };

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("paint.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        int lines;
        String[] tempLines;
        char[][] map;
        boolean[][] beenThere;
        for(int i = 0; i < numSets; i++){
            lines = s.nextInt();
            s.nextLine();
            tempLines = new String[lines];
            for(int j = 0; j < lines; j++){
                tempLines[j] = s.nextLine();
            }
            map = formMap(tempLines);
            Point start = getStart(tempLines);
            beenThere = new boolean[map.length][maxRowLength(map)];
            char[][] originalMap = makeCopyOfMap(map);
            paint(map, originalMap, beenThere, start.y, start.x);
            show(map);
            System.out.println(paintNeeded(map));
            System.out.println();
        }
        s.close();
    }

    private static char[][] makeCopyOfMap(char[][] map) {
        char[][] result = new char[map.length][];
        for(int row = 0; row < map.length; row++){
            result[row] = map[row].clone();

        }
        return result;
    }

    private static int maxRowLength(char[][] map) {
        int max = 0;
        for(int r = 0; r < map.length; r++)
            max = map[r].length > max ? map[r].length : max;
        return max;
    }

    private static void paint(char[][] map,
                              char[][] originalMap,
                              boolean[][] beenThere,
                              int row,
                              int col) {
        //if I am out of bounds, return
        if(row < 0 || row >= map.length || col < 0 || col >= map[row].length)
            return;
        //if I have been here before, return
        if( beenThere[row][col] )
            return;
        //mark that I have been here
        beenThere[row][col] = true;
        //if this is a wall or closed door, return
        char c = originalMap[row][col];
        if( c == 'X' || c == '=')
            return;
        //should I mark this with a C or a W?
        if( c == '-' || borders(originalMap, row, col, OPEN_DOORS))
            map[row][col] = 'C';
        else if( borders(originalMap, row, col, WALLS_AND_CLOSED_DOORS) )
            map[row][col] = 'W';
        else
            map[row][col] = 'C';
        // move up, right, down, and left to explore the area
        for(int i = 0; i < dirs[0].length; i++){
            paint(map, originalMap, beenThere, row + dirs[0][i], col + dirs[1][i]);
        }
    }

    private static boolean borders(char[][] map, int row, int col, char[] targets) {
        boolean isOpen = false;
        int r, c;
        for(int i = 0; i < dirs[0].length && !isOpen; i++){
            r = row + dirs[0][i];
            c = col + dirs[1][i];
            if( r >= 0 && r < map.length && c >= 0 && c < map[r].length){
                for(int j = 0; j < targets.length; j++)
                    if( targets[j] == map[r][c] )
                        isOpen = true;
            }
        }
        return isOpen;
    }

    private static Point getStart(String[] map) {
        for(int r = 0; r < map.length; r++){
            if( map[r].contains("*") )
                return new Point(map[r].indexOf('*'), r);
        }
        return null;
    }

    private static char[][] formMap(String[] tempLines) {
        char[][] result = new char[tempLines.length][];
        int limit;
        for(int r = 0; r < tempLines.length; r++){
            limit = tempLines[r].length();
            result[r] = new char[limit];
            for(int c = 0; c < limit; c++)
                result[r][c] = tempLines[r].charAt(c);
        }
        return result;
    }

    public static void show(char[][] map){
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[r].length; c++)
                System.out.print( map[r][c]);
            System.out.println();
        }
    }

    public static int paintNeeded(char[][] map){
        double accum = 0;
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[r].length; c++){
                if( map[r][c] == 'W' )
                    accum += 2;
                else if( map[r][c] == 'C' )
                    accum += 1;
            }
        }
        return (int)Math.ceil(accum / 10.0);
    }


}
