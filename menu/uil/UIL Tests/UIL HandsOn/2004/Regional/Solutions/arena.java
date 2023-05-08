import java.io.*;

public class arena {

   /* Define constants for each line in a battle input set */
   static final int F1ATTACK = 0;
   static final int F1BLOCK = 1;
   static final int F2ATTACK = 2;
   static final int F2BLOCK = 3;

   public static void main(String args[]) {
      int total_battles;
      int fight_info[][] = new int[4][];
      UILFileReader input = new UILFileReader("arena.dat");

      for (int i=0; i<4; i++) {
          fight_info[i] = new int[5];
      }

      /* Read the total number of battles */
      total_battles = input.readInt();

      /* Process that many battles */
      for (int battle=0; battle<total_battles; battle++) {
         int f1_health, f2_health;

         /* Read in the attack/block info for one battle */
         for (int line=0; line<4; line++) {
            for (int round=0; round<5; round++) {
               fight_info[line][round]=input.readInt();
            }
         }

         /* Simulate the battle, one round at a time */
         f1_health = f2_health = 5;
         for (int round=0; round<5; round++) {

            /* Do fighter #1 damage, if any */
            if (fight_info[F1ATTACK][round] != fight_info[F2BLOCK][round]) {
               f2_health -= 2;
            }

            /* Do fighter #2 damage, if any */
            if (fight_info[F2ATTACK][round] != fight_info[F1BLOCK][round]) {
               f1_health -= 2;
            }

            /* If either fighter is out, the battle's over */
            if (f1_health <= 0 || f2_health <= 0) break;
         }

         /* Display the results of the battle */
         if ((f1_health <= 0 && f2_health <= 0) ||
             (f1_health == f2_health)) {
            System.out.println("This battle ended in a draw!");
         }
         else if (f1_health > f2_health) {
            System.out.println("Fighter 1 is the victor!");
         }
         else {
            System.out.println("Fighter 2 is the victor!");
         }
      }
   }
}
