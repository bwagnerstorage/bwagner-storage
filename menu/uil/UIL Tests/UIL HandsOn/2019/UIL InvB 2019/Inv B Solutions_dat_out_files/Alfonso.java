//2019 UIL B Packet - Solution
//Alfonso
public class Alfonso {
    public static void pattern(char A)
    {
        for (char i = A; i <= 'Z'; i+=2) {
            for (char j = i; j <= 'Z'; j+=2) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        for (char i = 'A'; i <= 'Z'; i+=4) {
            pattern(i);
        }
    }
}
