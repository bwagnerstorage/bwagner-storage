import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Depth {
	
	public static void DrawBox(char color, int x1, int y1, int x2, int y2, float z, boolean fill) {
		for (int x = x1; x <= x2; ++x) {
			for (int y = y1; y <= y2; ++y) {
				if (fill || x == x1 || y == y1 || x == x2 || y == y2) {
					if (x >= 0 && x < image[0].length && y >= 0 && y < image.length) {
						if (z <= imageDepth[y][x] && z >= 0.0f) {
							image[y][x] = color;
							imageDepth[y][x] = z;
						}
					}
				}
			}
		}
	}
	
	public static void DrawLine(char color, int x1, int y1, int x2, int y2, float z) {
		for (int x = x1; x <= x2; ++x) {
			for (int y = y1; y <= y2; ++y) {
				if (x == x1 || y == y1 || x == x2 || y == y2) {
					if (x >= 0 && x < image[0].length && y >= 0 && y < image.length) {
						if (z <= imageDepth[y][x] && z >= 0.0f) {
							image[y][x] = color;
							imageDepth[y][x] = z;
						}
					}
				}
			}
		}
	}
	
	public static void DrawDiamond(char color, int x, int y, int s, float z, boolean fill) {
		// Top part
		for (int i = 0; i < s; ++i) {
			int width = i * 2 + 1;
			int curY = y - (s - i);
			for (int curX = x - i; curX < (x - i + width); ++curX) {
				if (curX >= 0 && curX < image[0].length && curY >= 0 && curY < image.length) {
					if (z <= imageDepth[curY][curX] && z >= 0.0f) {
						if (fill || curX == (x - i) || curX == (x - i + width - 1)) {
							image[curY][curX] = color;
							imageDepth[curY][curX] = z;
						}
					}
				}
			}
		}
		
		// Center line
		for (int i = 0; i < (s * 2 + 1); ++i) {
			if (x - s + i >= 0 && x - s + i < image[0].length && y >= 0 && y < image.length) {
				if (z <= imageDepth[y][x - s + i] && z >= 0.0f) {
					if (fill || i == 0 || i == (s * 2)) {
						image[y][x - s + i] = color;
						imageDepth[y][x - s + i] = z;
					}
				}
			}
		}
		
		// Bottom part
		for (int i = 0; i < s; ++i) {
			int width = (s * 2 + 1) - (i * 2);
			int curY = y + i + 1;
			for (int curX = x - s + 1 + i; curX < (x - s + 1 + i + width - 2); ++curX) {
				if (curX >= 0 && curX < image[0].length && curY >= 0 && curY < image.length) {
					if (z <= imageDepth[curY][curX] && z >= 0.0f) {
						if (fill || curX == (x - s + 1 + i) || curX == (x - s + 1 + i + width - 3)) {
							image[curY][curX] = color;
							imageDepth[curY][curX] = z;
						}
					}
				}
			}
		}
	}
	
	public static char[][] image = null;
	public static float[][] imageDepth = null;
       
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("depth.dat"));
        int numImages = Integer.parseInt(kb.nextLine().trim());
        for (int i = 0; i < numImages; ++i) {
        	if (i != 0)
        		System.out.println();
        	
        	String line = kb.nextLine().trim();
        	String[] sizes = line.split(" ");
        	final int width = Integer.parseInt(sizes[0]);
        	final int height = Integer.parseInt(sizes[1]);
        	
        	image = new char[height][width];
        	imageDepth = new float[height][width];
        	for (int h = 0; h < height; ++h) {
        		for (int w = 0; w < width; ++w) {
        			image[h][w] = '.';
        			imageDepth[h][w] = 1.0f;
        		}
        	}
        	
        	line = kb.nextLine().trim();
        	while (!line.equals("END")) {
        		String[] values = line.split(" ");
        		
        		char color = values[1].charAt(0);
        		if (values[0].equals("BOX")) {
        			int x1 = Integer.parseInt(values[2]);
        			int y1 = Integer.parseInt(values[3]);
        			int x2 = Integer.parseInt(values[4]);
        			int y2 = Integer.parseInt(values[5]);
        			float z = Float.parseFloat(values[6]);
        			boolean fill = values[7].equals("Y");
        			
        			DrawBox(color, x1, y1, x2, y2, z, fill);
        		}
        		else if (values[0].equals("LINE")) {
        			int x1 = Integer.parseInt(values[2]);
        			int y1 = Integer.parseInt(values[3]);
        			int x2 = Integer.parseInt(values[4]);
        			int y2 = Integer.parseInt(values[5]);
        			float z = Float.parseFloat(values[6]);
        			
        			DrawLine(color, x1, y1, x2, y2, z);
        		}
        		else if (values[0].equals("DIAMOND")) {
        			int x = Integer.parseInt(values[2]);
        			int y = Integer.parseInt(values[3]);
        			int s = Integer.parseInt(values[4]);
        			float z = Float.parseFloat(values[5]);
        			boolean fill = values[6].equals("Y");
        			
        			DrawDiamond(color, x, y, s, z, fill);
        		}
        		
        		line = kb.nextLine().trim();
        	}
        	
        	for (int h = 0; h < height; ++h) {
        		for (int w = 0; w < width; ++w) {
        			System.out.print(image[h][w]);
        		}
        		
        		System.out.println();
        	}
        }
    }    
}

