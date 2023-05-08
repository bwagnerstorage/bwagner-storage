import java.io.*;
import java.util.*;


public class Mipmapping
{
    static final int MASK_A = 0xff000000;
    static final int MASK_R = 0x00ff0000;
    static final int MASK_G = 0x0000ff00;
    static final int MASK_B = 0x000000ff;
    
    static final int SHIFT_A = 24;
    static final int SHIFT_R = 16;
    static final int SHIFT_G = 8;
    static final int SHIFT_B = 0;
    
    public static int ShiftAndMaskOut(int shift, int mask, int value)
    {
        return (value & mask) >>> shift;
    }
    
    public static int CreateTexel(int A, int R, int G, int B)
    {
        return      A << SHIFT_A
                |   R << SHIFT_R
                |   G << SHIFT_G
                |   B << SHIFT_B;
    }
    
    public static boolean IsPow2(int val)
    {
        return  2 == val || 4 == val || 8 == val || 16 == val || 32 == val ||
                64 == val || 128 == val || 256 == val || 512 == val || 1024 == val ||
                2048 == val;
    }
    
    public static void Print(int[] texels, int width, int height)
    {
        for (int h = 0; h < height; ++h)
        {
            for (int w = 0; w < width; ++w)
            {
                if (w != 0)
                    System.out.print(" ");
                
                // Is this too tricky?
                System.out.printf("0x%08x", texels[width*h + w]);
            }
            
            System.out.println();
        }
    }
    
    public static int[] MipMapify(int[] inTexels, int width, int height)
    {
        int newWidth = width >>> 1;
        int newHeight = height >>> 1;
        int[] outTexels = new int[newWidth * newHeight];
        
        for (int h = 0; h < height; h += 2)
        {
            int destH = h / 2;
            for (int w = 0; w < width; w += 2)
            {
                int destW = w / 2;
                
                int t00 = inTexels[h*width + w];
                int t01 = inTexels[h*width + w + 1];
                int t10 = inTexels[(h+1)*width + w];
                int t11 = inTexels[(h+1)*width + w + 1];
                
                int A = ( ShiftAndMaskOut(SHIFT_A, MASK_A, t00) +
                          ShiftAndMaskOut(SHIFT_A, MASK_A, t01) +
                          ShiftAndMaskOut(SHIFT_A, MASK_A, t10) +
                          ShiftAndMaskOut(SHIFT_A, MASK_A, t11) 
                        ) / 4;
                
                int R = ( ShiftAndMaskOut(SHIFT_R, MASK_R, t00) +
                          ShiftAndMaskOut(SHIFT_R, MASK_R, t01) +
                          ShiftAndMaskOut(SHIFT_R, MASK_R, t10) +
                          ShiftAndMaskOut(SHIFT_R, MASK_R, t11) 
                        ) / 4;
                
                int G = ( ShiftAndMaskOut(SHIFT_G, MASK_G, t00) +
                          ShiftAndMaskOut(SHIFT_G, MASK_G, t01) +
                          ShiftAndMaskOut(SHIFT_G, MASK_G, t10) +
                          ShiftAndMaskOut(SHIFT_G, MASK_G, t11) 
                        ) / 4;
                
                int B = ( ShiftAndMaskOut(SHIFT_B, MASK_B, t00) +
                          ShiftAndMaskOut(SHIFT_B, MASK_B, t01) +
                          ShiftAndMaskOut(SHIFT_B, MASK_B, t10) +
                          ShiftAndMaskOut(SHIFT_B, MASK_B, t11) 
                        ) / 4;
                
                outTexels[newWidth * destH + destW] = CreateTexel(A, R, G, B);
            }
        }
        
        return outTexels;
    }
    
    public static void ReadTexture(Scanner kb)
    {
        int height = kb.nextInt();
        int width = kb.nextInt();
        
        int[] texels = new int[width * height];
        for (int i = 0; i < width * height; ++i)
        {
            // Java won't let you read in an integer who's sign flag is set (ie 0x80000000)
            // so you have to read it in in parts and or them together
            String strNext = kb.next("0x[a-fA-F0-9]{8}").substring(2);
            texels[i] = Integer.parseInt(strNext.substring(0, 4), 16) << 16 | 
                        Integer.parseInt(strNext.substring(4), 16);
        }
        
        if (IsPow2(width) && IsPow2(height))
        {
            int[] curTexels = texels;
            while (1 < width && 1 < height)
            {
                // Calculate and print mip
                curTexels = MipMapify(curTexels, width, height);
                
                width = width >> 1;
                height = height >> 1;
        
                Print(curTexels, width, height);
            }
        }
        else
        {
            System.out.print("NO REDUCTION POSSIBLE\n");
        }
        
        System.out.println();
    }
    
    
    public static void main(String args[]) throws IOException
    {
        // Parse each line in the file
        Scanner kb = new Scanner(new File("mipmapping.dat"));
        
        // Number of textures
        int numTex = Integer.parseInt(kb.nextLine());
        for (int i = 0; i < numTex; ++i)
        {
            ReadTexture(kb);
        }
    }
}
