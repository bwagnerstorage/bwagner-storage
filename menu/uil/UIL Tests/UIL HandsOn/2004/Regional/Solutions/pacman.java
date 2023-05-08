import java.io.*;
import java.math.*;

class maze_square {
   public char square_type;
   public int min_moves;
   public int min_power_moves;
}

public class pacman {

   /* Define the possible square types */
   static final char SQR_REGULAR = '.';
   static final char SQR_PACMAN = 'C';
   static final char SQR_GHOST = 'A';
   static final char SQR_POWER = '@';
   static final char SQR_EXIT = 'X';
   static final char SQR_WALL = '#';

   /* Define special value for move count */
   static final int MOVE_INFINITE = 10000;

   public static void main(String args[]) {
      int total_mazes;
      maze_square maze[][] = new maze_square[10][10];
      UILFileReader input = new UILFileReader("pacman.dat");

      /* Allocate the maze classes */
      for (int row=0; row<10; row++) {
         for (int col=0; col<10; col++) {
            maze[row][col] = new maze_square();
         }
      }

      /* Read the total number of mazes */
      total_mazes = input.readInt();

      /* Process that many mazes */
      for (int dataset=0; dataset<total_mazes; dataset++) {
         int size, moves;
         boolean maze_solvable, done;

         /* Read in this maze's size */
         size = input.readInt();

         /* Read in the maze and init move counts */
         for (int row=0; row<size; row++) {
            input.skipWhite(true);
            for (int col=0; col<size; col++) {
               maze[row][col].square_type = input.readChar();
               maze[row][col].min_moves = MOVE_INFINITE;
               maze[row][col].min_power_moves = MOVE_INFINITE;
               if (maze[row][col].square_type == SQR_PACMAN) {
                  maze[row][col].min_moves = 0;
               }
            }
         }
         input.skipWhite(true);

         // Now we'll do a loop for each move that PacMan can make.
         // For each move, we'll determine which new squares PacMan can
         // get to both with and without eating a power pellet.  If we
         // see that PacMan could hit the exit on a move, then we're done.
         // If we don't make any progress on a move, then we're also done.
         maze_solvable = true;
         done = false;
         for (moves=1; done==false; moves++) {
            boolean move_made;

            move_made = false;

            for (int row=0; row<size; row++) {
               for (int col=0; col<size; col++) {
                  boolean best_move = false;
                  boolean best_power_move = false;
                  int min_prev_moves;

                  /* PacMan can never move "onto" a wall */
                  if (maze[row][col].square_type == SQR_WALL) continue;

                  /* Figure out if PacMan could move here */
                  if (maze[row][col].square_type != SQR_GHOST) {
                     min_prev_moves = MOVE_INFINITE;
                     min_prev_moves = Math.min(min_prev_moves, maze[row][col-1].min_moves);
                     min_prev_moves = Math.min(min_prev_moves, maze[row][col+1].min_moves);
                     min_prev_moves = Math.min(min_prev_moves, maze[row-1][col].min_moves);
                     min_prev_moves = Math.min(min_prev_moves, maze[row+1][col].min_moves);
                     if (min_prev_moves + 1 < maze[row][col].min_moves &&
                         min_prev_moves != moves) {
                        /* This is the best regular move so far */
                        move_made = true;
                        maze[row][col].min_moves = moves;
                        /* If this is a power pellet, we may start power moves */
                        if (maze[row][col].square_type == SQR_POWER &&
                            (min_prev_moves + 1 < maze[row][col].min_power_moves)) {
                           maze[row][col].min_power_moves = min_prev_moves + 1;
                        }
                     }
                  }

                  /* Figure out if PacMan could move here with a power move */
                  min_prev_moves = MOVE_INFINITE;
                  min_prev_moves = Math.min(min_prev_moves, maze[row][col-1].min_power_moves);
                  min_prev_moves = Math.min(min_prev_moves, maze[row][col+1].min_power_moves);
                  min_prev_moves = Math.min(min_prev_moves, maze[row-1][col].min_power_moves);
                  min_prev_moves = Math.min(min_prev_moves, maze[row+1][col].min_power_moves);
                  if (min_prev_moves + 1 < maze[row][col].min_power_moves &&
                      min_prev_moves != moves) {
                     /* This is the best power move so far */
                     move_made = true;
                     maze[row][col].min_power_moves = moves;
                  }

                  /* Check to see if we just moved to the exit */
                  if (maze[row][col].square_type == SQR_EXIT &&
                      (maze[row][col].min_moves != MOVE_INFINITE ||
                       maze[row][col].min_power_moves != MOVE_INFINITE)) {
                     done = true;
                  }
               }
            }

            /* Check to see if the exit is unreachable */
            if (!move_made) {
               maze_solvable = false;
               done = true;
            }
         }

         /* Display the results */
         if (maze_solvable) {
            System.out.println("PacMan can escape in " + (moves - 1) + " moves.");
         }
         else {
            System.out.println("PacMan should retire.");
         }
      }
   }
}
