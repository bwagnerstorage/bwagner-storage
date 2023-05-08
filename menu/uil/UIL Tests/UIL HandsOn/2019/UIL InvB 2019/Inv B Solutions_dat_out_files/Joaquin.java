//2019 UIL B Packet - Solution
//Joaquin
import java.io.File;
import java.util.Scanner;
public class Joaquin {
    public static String mat[][];
    public static void sol2(int a)
    {

        for (int i = 0; i < a/2+1; i+=2) {

            for (int j = i; j <a-i; j++) {
            mat[j][i] = "X";
            mat[i][j] = "X";
            mat[a-1-i][j] = "X";
            mat[j][a-1-i] = "X";                
            }
        }
    }
    public static void display()
    {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == null)
                    System.out.print (" ");
                System.out.print(mat[i][j]);;
            }
            System.out.println("");
            
        }
    }
    public static void make(int a)
    {
        mat = new String[a][a];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] =" ";
            }
        }
    }
   
    public static void main(String[] args) throws Exception{
        Scanner file = new Scanner(new File("joaquin.dat"));
        int dataset = file.nextInt();
        for (int i = 0; i < dataset; i++) {
                int next = file.nextInt();
                make(next);
                sol2(next);
                display();
                System.out.println("--------------------");
        }
    }
}
