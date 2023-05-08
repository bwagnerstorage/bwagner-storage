
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Treasure {
    public static final Scanner key = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        Scanner s = new Scanner(new File("treasure.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        for(int i = 1; i <= numSets; i++){
            int numSteps = s.nextInt();
            s.nextLine();
            char[][] map = getMap(s);
            int[] startLocation = findJack(map);
            System.out.println(maxTreasure(map, startLocation[0], startLocation[1], numSteps));
        }
        s.close();
    }

    private static int maxTreasure(char[][] map, int row, int col,
            int numSteps) {
        // no more steps?
        if(numSteps < 0)
            return 0;
        else if(row < 0 || row == map.length || col < 0 || col == map[0].length)
            return 0;
        else{
            //System.out.print("row: " + row + ", col: "  + col + " , this spot: " + map[row][col] + ", steps left " + numSteps);
            //key.nextLine();
            int treasureInThisSpot = -1;
            int result = 0;
            if(map[row][col] != '.' ){
                    treasureInThisSpot = map[row][col] - '0';
                    map[row][col] = '.';
                    result += treasureInThisSpot;
            }
            numSteps--;
            int up = maxTreasure(map, row - 1, col, numSteps);
            int down = maxTreasure(map, row + 1, col, numSteps);
            int right = maxTreasure(map, row, col + 1, numSteps);
            int left = maxTreasure(map, row, col - 1, numSteps);
            //System.out.print("up: " + up + ", down: " + down + ", right: " + right + ", left: " + left);
            //key.nextLine();
            result += Math.max(up, Math.max(down, Math.max(right, left)));
            // put it back in case we get here via another path
            if( treasureInThisSpot != -1)
                map[row][col] = (char)('0' + treasureInThisSpot);
            return result;
        }
    }

    private static int[] findJack(char[][] map) {
        int[] result = new int[2];
        for(int c = 0; c < map[0].length; c++){
            if(map[0][c] == '*'){
                result[1] = c;
            }
            else if(map[map.length - 1][c] == '*'){
                result = new int[]{map.length - 1, c};
            }
        }
        for(int r = 0; r < map.length; r++){
            if(map[r][0] == '*'){
                result[0] = r;
            }
            else if(map[r][map[0].length - 1] == '*'){
                result = new int[]{r, map[0].length - 1};
            }
        }
        map[result[0]][result[1]] = '.';
        return result;
    }

    private static char[][] getMap(Scanner s) {
        int rows = s.nextInt() + 2;
        s.nextLine();
        char[][] result = new char[rows][];
        for(int i = 0; i < result.length; i++)
            result[i] = s.nextLine().toCharArray();
        return result;
    }
}
