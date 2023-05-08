public class Time {
    private static final int WIDTH = 30;
    private static final int NUM_LINES = WIDTH - 3;
    private static final int LINE_FLIP = NUM_LINES / 2 + 1;
    
    public static void main(String[] args){
        doEnd();
        int dashes = 1;
        for(int i = 1; i <= NUM_LINES; i++){
            for(int j = 0; j < dashes; j++)
                System.out.print("-");
            System.out.print("+");
            int middleDashes = WIDTH - 2 - (dashes * 2);
            for(int j = 0; j < middleDashes; j++)
                System.out.print("-");
            System.out.print("+");
            for(int j = 0; j < dashes; j++)
                System.out.print("-");
            System.out.println();
            dashes = i < LINE_FLIP ? dashes + 1 : dashes - 1;
        }
        doEnd();
    }
    
    
    
    public static void doEnd(){
       for(int i = 0; i < WIDTH; i++)
           System.out.print("+");
       System.out.println();
    }
}
