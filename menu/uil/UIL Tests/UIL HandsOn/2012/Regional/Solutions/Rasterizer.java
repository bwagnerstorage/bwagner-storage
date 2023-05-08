import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Rasterizer {
	
	public static void DrawBox(char color, int x1, int y1, int x2, int y2, boolean fill) {
		for (int x = x1; x <= x2; ++x) {
			for (int y = y1; y <= y2; ++y) {
				if (fill || x == x1 || y == y1 || x == x2 || y == y2) {
					if (x >= 0 && x < image[0].length && y >= 0 && y < image.length)
						image[y][x] = color;
				}
			}
		}
	}
	
	public static void DrawLine(char color, int x1, int y1, int x2, int y2) {
		for (int x = x1; x <= x2; ++x) {
			for (int y = y1; y <= y2; ++y) {
				if (x == x1 || y == y1 || x == x2 || y == y2) {
					if (x >= 0 && x < image[0].length && y >= 0 && y < image.length)
						image[y][x] = color;
				}
			}
		}
	}
	
	public static void DrawCross(char color, int x, int y, int w, int h) {
		// Cross is 2 lines
		--w;
		--h;
		DrawLine(color, x - (w / 2), y, x + (w - (w / 2)), y);
		DrawLine(color, x, y - (h / 2), x, y + (h - (h / 2)));
	}
	
	public static char[][] image = null;
       
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("rasterizer.dat"));
        int numImages = Integer.parseInt(kb.nextLine().trim());
        for (int i = 0; i < numImages; ++i) {
        	if (i != 0)
        		System.out.println();
        	
        	String line = kb.nextLine().trim();
        	String[] sizes = line.split(" ");
        	final int width = Integer.parseInt(sizes[0]);
        	final int height = Integer.parseInt(sizes[1]);
        	
        	image = new char[height][width];
        	for (int h = 0; h < height; ++h) {
        		for (int w = 0; w < width; ++w) {
        			image[h][w] = '.';
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
        			boolean fill = values[6].equals("Y");
        			
        			DrawBox(color, x1, y1, x2, y2, fill);
        		}
        		else if (values[0].equals("LINE")) {
        			int x1 = Integer.parseInt(values[2]);
        			int y1 = Integer.parseInt(values[3]);
        			int x2 = Integer.parseInt(values[4]);
        			int y2 = Integer.parseInt(values[5]);
        			
        			DrawLine(color, x1, y1, x2, y2);
        		}
        		else if (values[0].equals("CROSS")) {
        			int x = Integer.parseInt(values[2]);
        			int y = Integer.parseInt(values[3]);
        			int w = Integer.parseInt(values[4]);
        			int h = Integer.parseInt(values[5]);
        			
        			DrawCross(color, x, y, w, h);
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

