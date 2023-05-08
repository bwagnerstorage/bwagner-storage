import static java.lang.System.*;
import java.io.*;
import java.util.*;
import java.awt.Point;

public class Riley {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner data = new Scanner(new File("riley.dat"));
		int n = data.nextInt();
		while ( n-- > 0 ) {
			ArrayList<Double> clusters = new ArrayList<Double>();
			int rows = data.nextInt();
			int cols = data.nextInt();
			int [][] grid = new int[rows+2][cols+2];
			int sum = 0;
			for (int r = 1; r <= rows; r++) {
				for (int c = 1; c <= cols; c++) {
					grid[r][c] = data.nextInt();
					sum += grid[r][c];
				}
			}
			// at this point sum is overall total
			// stored in arraylist as negative to get descending sort later
			clusters.add(-sum * 25 / 100.0);
			LinkedList<Point> q = new LinkedList<Point>();
			Point p;
			int pr, pc;
			for (int r = 1; r <= rows; r++) {
				for (int c = 1; c <= cols; c++) {
					if (grid[r][c] > 0) {  // start cluster
						q.add(new Point(r,c));
						sum = grid[r][c];
						grid[r][c] = -1;
						while (q.size() > 0) {
							p = q.removeFirst();
							pr = p.x;
							pc = p.y;
							if (grid[pr+1][pc] > 0) {
								q.add(new Point(pr+1,pc));
								sum += grid[pr+1][pc];
								grid[pr+1][pc] = -1;
							}
							if (grid[pr+1][pc+1] > 0) {
								q.add(new Point(pr+1,pc+1));
								sum += grid[pr+1][pc+1];
								grid[pr+1][pc+1] = -1;
							}
							if (grid[pr][pc+1] > 0) {
								q.add(new Point(pr,pc+1));
								sum += grid[pr][pc+1];
								grid[pr][pc+1] = -1;
							}
							if (grid[pr-1][pc+1] > 0) {
								q.add(new Point(pr-1,pc+1));
								sum += grid[pr-1][pc+1];
								grid[pr-1][pc+1] = -1;
							}
							if (grid[pr-1][pc] > 0) {
								q.add(new Point(pr-1,pc));
								sum += grid[pr-1][pc];
								grid[pr-1][pc] = -1;
							}
							if (grid[pr-1][pc-1] > 0) {
								q.add(new Point(pr-1,pc-1));
								sum += grid[pr-1][pc-1];
								grid[pr-1][pc-1] = -1;
							}
							if (grid[pr][pc-1] > 0) {
								q.add(new Point(pr,pc-1));
								sum += grid[pr][pc-1];
								grid[pr][pc-1] = -1;
							}
							if (grid[pr+1][pc-1] > 0) {
								q.add(new Point(pr+1,pc-1));
								sum += grid[pr+1][pc-1];
								grid[pr+1][pc-1] = -1;
							}
						}
						// cluster complete
						// stored in arraylist as negative to get descending sort later
						clusters.add(-sum * 25 / 100.0);
					}
				}
			}
			clusters.sort(null);  // ascending sort works because acres are negative
			while (clusters.size() > 0)
				out.printf("%4.2f acres\n", -clusters.remove(0));
			out.println("============");
		}
		data.close();
	}
}
