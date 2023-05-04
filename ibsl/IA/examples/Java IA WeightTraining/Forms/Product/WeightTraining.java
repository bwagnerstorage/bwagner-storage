package org.bwagner;

import java.util.*;
import java.io.*;

/*
   This class is the programs user interface. It is responsible for interacting
   with the user through a menu system. It contains the program’s main method.
*/

public class WeightTraining
{
    //instance variables
    private MaxDatabase max;   // needed to communicate with the database
    private Scanner keyboard;
    private boolean modified = false; // tracks whether database needs to be saved

    // constructor
    public WeightTraining()
    {
        max = new MaxDatabase();
        keyboard = new Scanner(System.in);

        mainMenu();
    }

    /*
       This is the main menu for the program. All interaction with the user
       originates from this menu.
    */
    public void mainMenu()
    {
        int ans = 0;

        do
        {
            System.out.println();
            System.out.println("======================");
            System.out.println("       Main Menu   ");
            System.out.println("======================");
            System.out.println("  1. Add Player");
            System.out.println("  2. Update Player Maxes");
            System.out.println("  3. View List of Player Names");
            System.out.println("  4. View a Player's Maxes");
            System.out.println("  5. Delete Players");
            System.out.println("  6. Print");
            System.out.println("  7. Closeout School Year");
            System.out.println("  8. Save");
            System.out.println("  9. Exit");

            ans = validateIntegerInput("Selection -->");
            System.out.println();
            if(ans == 1)
                addPlayer();
            if(ans == 2)
                updatePlayers();
            if(ans == 3)
                viewAllPlayers();
            if(ans == 4)
                searchForPlayer();
            if(ans == 5)
                delete();
            if(ans == 6)
                print();
            if(ans == 7)
                closeOutYear();
            if(ans == 8)
            {
                saveDataFile();
                modified = false;
            }
        }
        while(ans != 9);

        if(ans == 9)
        {
            if(modified == true)
            {
                System.out.println();
                System.out.println("Caution: you have made changes to the database.");
                System.out.print("Would like to Save[y/n]?");
                String response = keyboard.next();
                if(response.equalsIgnoreCase("y"))
                {
                    saveDataFile();
                }
            }
        }

        System.out.println();
        System.out.println("Good Bye!");
        System.out.println();
        System.exit(0);       // close terminal window
    }

    /*
       This method allows the user to enter an integer value. It then verifies
       that the input value is an integer. If it is not an integer the method
       prompts the user to re-enter the value again.
       @return the input value
       @param prompt the input prompt
    */
    public int validateIntegerInput(String prompt)
    {
        int ans = 0;
        boolean flag;

        do
        {
            flag = true;
            System.out.print(prompt);  // display input prompt
            if(keyboard.hasNextInt())  // if input is an integer
            {
                ans = keyboard.nextInt();
            }
            else  // not an integer
            {
                System.out.println("Invalid Entry. Try again.");
                flag = false;
            }
            keyboard.nextLine();      // clear buffer
        }
        while(flag == false);

        return ans;
    }

    /*
       This method validates that the parameter week is between
       1 <= week <= 10. If it is not it requires the user to enter
       a valid number.
       @param the week value(1-10)
    */
    public int validateWeekNum(int week)
    {
        while(week < 1 || week > 10)
        {
            week = validateIntegerInput("Enter Program Week (1-10) -->");
        }

        return week;
    }

    /*
       This method prompts the user to enter a player's info and then adds
       the player to the database.
    */
    public void addPlayer()
    {
        String ans = "";

        do
        {
            System.out.println("====================");
            System.out.println("     Add Player");
            System.out.println("====================");
            System.out.print("Enter Player Name (lastname, firstname)-->");
            String name = keyboard.nextLine();
            int classification = validateIntegerInput("Enter Player Classification (9,10,11,12)-->");
            while(classification < 9 || classification > 12)
            {
                classification = validateIntegerInput("Enter Player Classification (9,10,11,12)-->");
            }
            int bench = validateIntegerInput("Enter Bench Max -->");
            int squat = validateIntegerInput("Enter Squat Max -->");
            int incline = validateIntegerInput("Enter Incline Max -->");
            int power = validateIntegerInput("Enter Power Clean Max -->");

            max.addPlayer(new Player(name, bench, squat, incline, power, classification));  // add player to database
            modified = true;
            System.out.println();
            System.out.print("Add another player[Y/N]?");

            ans = keyboard.nextLine();
        }
        while(ans.equalsIgnoreCase("y"));
    }

    /*
       This method allows a user to modify all players or single player
       max values.
    */

    public void updatePlayers()
    {
        System.out.println("=======================");
        System.out.println("   Update Players Max");
        System.out.println("=======================");
        System.out.println("1. Update a Player's Max");
        System.out.println("2. Update All Players' Max");
        int ans = validateIntegerInput("Selection -->");

        if(ans == 1)
        {
            String response = "";
            do
            {
                System.out.println();
                System.out.print("Enter Player Name (lastname, firstname)-->");
                String name = keyboard.nextLine();
                Player player = max.searchByName(name);
                if(player == null)
                {
                    System.out.println("Sorry," + name + " is not in database.");
                }
                else
                {
                     System.out.println(player);
                     System.out.println();

                     int bench = validateIntegerInput("Enter new Bench Max -->");
                     int squat = validateIntegerInput("Enter new Squat Max -->");
                     int incline = validateIntegerInput("Enter new Incline Max -->");
                     int power = validateIntegerInput("Enter new Power Clean Max -->");

                     player.setBenchMax(bench);
                     player.setSquatMax(squat);
                     player.setInclineMax(incline);
                     player.setPowerMax(power);

                     modified = true;

                     System.out.println();
                     System.out.print("Update Another Player[Y/N]-->");
                     response = keyboard.nextLine();
                }
            }
            while(response.equalsIgnoreCase("y"));
        }
        if(ans == 2)
        {
            updateAllMaxes();
            modified = true;
        }
    }

    /* This method is a helper method for updatePlayers. It allows
       the user to update max values for all players.
    */
    private void updateAllMaxes()
    {
        for(Player player: max.getPlayers())
        {
            System.out.println();
            System.out.println("Current Player's Maxes");
            System.out.println("--------------------");
            System.out.println(player);
            System.out.println();
            int bench = validateIntegerInput("Enter new Bench Max -->");
            int squat = validateIntegerInput("Enter new Squat Max -->");
            int incline = validateIntegerInput("Enter new Incline Max -->");
            int power = validateIntegerInput("Enter new Power Clean Max -->");

            player.setBenchMax(bench);
            player.setSquatMax(squat);
            player.setInclineMax(incline);
            player.setPowerMax(power);
        }
    }

    /* This method allows the user to remove a player from the database or
       clear the database of all players.
    */
    public void delete()
    {
        System.out.println("====================");
        System.out.println("   Delete Player");
        System.out.println("====================");
        System.out.println("  1. Delete a Player");
        System.out.println("  2. Clear Database");
        int ans = validateIntegerInput("Selection -->");

        if(ans == 1)
        {
           System.out.println();
           System.out.print("Enter Player Name (lastname, firstname)-->");
           String name = keyboard.nextLine();
           Player player = max.searchByName(name);
           if(player == null)
           {
               System.out.println("Sorry," + name + " is not in database.");
           }
           else
           {
               System.out.println("Found the following player:");
               System.out.println(player);
               System.out.print("Are you sure you want to delete this player[Y/N]?");
               String response = keyboard.nextLine();
               if(response.equalsIgnoreCase("y"))
               {
                  max.deletePlayer(player);
                  modified = true;
                  System.out.println("Player Deleted!");
               }
               else
               {
                   System.out.println("Player Not Deleted!");
               }
           }
        }
        if(ans == 2)
        {
            System.out.print("This process will delete all players. Continue[Y/N]?");
            String response = keyboard.nextLine();
            if(response.equalsIgnoreCase("y"))
            {
               max.clearDatabase();
               modified = true;
               System.out.println("Entire Database Deleted");
            }
            else
            {
                System.out.println("Database Not Deleted");
            }
        }
    }

    /*
       This method displays a list in alphabetical of all players in the
       database. It displays each player's name and classification.
    */
    public void viewAllPlayers()
    {
        System.out.println("=====================");
        System.out.println("   View All Players");
        System.out.println("=====================");

        ArrayList<Player> list = max.sortPlayersByName();

        for(int i = 0; i < list.size(); i++)
        {
            System.out.println((i+1) + "." + list.get(i).getName() + " " + list.get(i).getClassification());
        }
         System.out.println();
    }

    /* This method searches the database by player name. If the player is found
       it displays the Player's exercise maxes.
    */
    public void searchForPlayer()
    {
        System.out.println("=====================");
        System.out.println("  Search For Player");
        System.out.println("=====================");
        System.out.print("Enter Player Name (lastname, firstname)-->");
        String name = keyboard.nextLine();

        Player player = max.searchByName(name);
        if(player == null)
        {
            System.out.println("Sorry, \"" + name + "\" is not in database.");
        }
        else
        {
            System.out.println(player);
        }
    }

    /* This method allows the user to print two documents.
       1. A player or players workout program.
       2. A list of players organized in groups of four by
          their bench max.
    */
    public void print()
    {
        System.out.println("=====================");
        System.out.println("       Print");
        System.out.println("=====================");
        System.out.println("1. Print Weight Lifting Program");
        System.out.println("2. Print PlayerGroups");
        int ans = validateIntegerInput("Selection -->");

        if(ans == 1)
        {
            printWeightLiftingProgram();
        }
        if(ans == 2)
        {
            int size = validateIntegerInput("Enter size of groups -->");
            PrintGroups print = new PrintGroups(max.createGroups(size));
         /* ArrayList<Group> groups = max.createGroups(size);
            for(Group group : groups)
            {
                for(Player player : group.getGroup())
                {
                    if(player != null)
                       System.out.println(player.getName()+ " "+player.getBenchMax());
                }
                System.out.println();
            }
         */
        }
    }

    /*
       This method is a helper method for print. It prints weight lifting
       workout programs.
    */
    private void printWeightLiftingProgram()
    {
        System.out.println("==============================");
        System.out.println(" Print Weight Lifting Program");
        System.out.println("==============================");
        System.out.println("1. Print a Player");
        System.out.println("2. Print All Players");
        int ans = validateIntegerInput("Selection -->");

        if(ans == 1)
        {
            String response = "";
            do
            {
                System.out.print("Enter Player Name (lastname, firstname)-->");
                String name = keyboard.nextLine();
                int week = validateIntegerInput("Enter Program Week (1-10) -->");
                week = validateWeekNum(week);
                Player player = max.searchByName(name);
                if(player != null)
                {
                    PrintWeightProgram print = new PrintWeightProgram(player, week);
                }
                else
                {
                    System.out.println("Player not Found");
                }
                System.out.println();
                System.out.print("Print another player[Y/N]?");
                response = keyboard.nextLine();
            }
            while(response.equalsIgnoreCase("y"));
        }
        if(ans == 2)
        {
            int week = validateIntegerInput("Enter Program Week (1-10) -->");
            validateWeekNum(week);
            PrintWeightProgram print = new PrintWeightProgram(max.getPlayers(), week);
        }
    }

    /*
        This method updates the database by deleting all seniors and promoting all
        underclassmen to the next grade level.
    */
    public void closeOutYear()
    {
        System.out.println("=======================");
        System.out.println(" Closeout School Year");
        System.out.println("=======================");
        System.out.println("Caution: This feature will remove all seniors from the database");
        System.out.println("and promote underclassmen to the next grade level.");
        System.out.println();
        System.out.print("Are you sure you would like to continue[y/n]?");
        String ans = keyboard.next();
        if(ans.equalsIgnoreCase("y"))
        {
            ArrayList <Player> list = max.getPlayers();
            int i = 0;
            while(i < list.size())
            {
                Player player = list.get(i);
                if(player.getClassification() == 12)
                {
                    list.remove(i);
                }
                else
                {
                    i++;
                    player.setClassification(player.getClassification() + 1);
                }
            }
            modified = true;
            System.out.println();
            System.out.println("Closeout Complete!");
            System.out.println();
        }
    }

    /*
       This method saves the database to the data file.
    */
    public void saveDataFile()
    {
        System.out.println("=====================");
        System.out.println("   Save Data File");
        System.out.println("=====================");

        max.saveFile();
    }

    /*
        This is the program's main menu.
    */
    public static void main(String[] args)
    {
        WeightTraining app = new WeightTraining();
    }
}
