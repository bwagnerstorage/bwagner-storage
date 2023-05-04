import java.util.*;

public class CalculatorManager 
{
    public static void main(String[] args) 
    {
        Calculator calc = new Calculator();
        
        menu(calc);
    }
    
    public static void menu(Calculator calc)
    {
        Scanner keyboard = new Scanner(System.in);
        double answer = 0;
        int ans = 0;
        do 
        {
            System.out.println("");
            System.out.println("Arithmetic Menu");
            System.out.println("---------------");
            System.out.println("1. add");
            System.out.println("2. subtract");
            System.out.println("3. multiply");
            System.out.println("4. divide");
            System.out.println("5. EXIT");
            System.out.print("Select[1-5] -->");
            System.out.println();
            ans = keyboard.nextInt();
            
            if(ans > 4)
            {
                System.exit(0);
            }
            
            calc.input();

            if(ans == 1)
            {
                answer = calc.add();
            }

            if(ans == 2)
            {
                answer = calc.subtract();
            }

            if(ans == 3)
            {
                answer = calc.multiply();
            }

            if(ans == 4)
            {
                answer = calc.divide();
            }
            
            System.out.println();
            System.out.println("=======================");
            System.out.println("    Answer = " + answer);
            System.out.println("=======================");
            System.out.println();
        }
        while(ans < 5);
    }
}
