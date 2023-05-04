package org.bwagner;

import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.*;

/*
    This class provides methods that communicate with a printer. It can print a 
    weekly workout program for every player.
*/

public class PrintWeightProgram extends JFrame implements Printable
{
    final static int RECORD_SIZE = 9;  // data plus 2 blank lines after record

    private ArrayList <Player> players;   // stores list of Players
    private String[] textLines;  // stores each line to be printed per record
    private int week;            //week to be printed
    private Player player;
    private int[] pageBreaks;   // array of page break line positions
    private int[] weekReps;     // stores number of reps for week

    int[][] repNum = {{10,8,8}, //how many times they are doing that weight for that day
                       {8,6,4},
                       {4,4,2},
                       {2,2,1},
                      {10,10,10},
                      {10,8,8},
                       {8,6,4},
                       {4,4,2},
                       {2,2,1},
                       {1,1,1}};

    /*
        @param list ArrayList of players
        @param w the workout program week
    */
    public PrintWeightProgram(ArrayList<Player> list, int w) // prints all players
    {
        players =  list;
	week = w;
        setVisible(false);       //don't show gui window

	weekReps = new int[3];

        for(int c = 0; c < 3; c++)
        {
            weekReps[c] = repNum[week-1][c];
        }
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        double margin = 72/2;        // half inch margin
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
            - margin * 2);
        pf.setPaper(paper);
         
        job.setPrintable(this, pf);

         boolean ok = job.printDialog();
         if (ok)
         {
             try
             {
                  job.print();
             }
             catch (PrinterException ex)
             {
                // The job did not successfully complete
                System.out.println("Printing Error");
             }
         }
    }
    
    /*
       @param p a Player to be printed
       @param w workout program week
    */
    public PrintWeightProgram(Player p, int w) //prints one student
    {
    	player = p;
    	week = w;
        setVisible(false);       //don't show gui window
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        PageFormat pf = job.defaultPage();
        Paper paper = new Paper();
        double margin = 72/2;        // half inch margin
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
            - margin * 2);
        pf.setPaper(paper);
         
        job.setPrintable(this, pf);
        boolean ok = job.printDialog();

        weekReps = new int[3];

        for(int c = 0; c < 3; c++)
        {
            weekReps[c] = repNum[week-1][c];
        }
    	

         if (ok)
         {
             try
             {
                  job.print();
             }
             catch (PrinterException ex)
             {
                // The job did not successfully complete
             }
         }
    }
    
    /*
        Prepares the data for printing by filling the textLines array with all
        the data from the array of players into string format.
    */ 
    private void initTextLines()
    {
        if (textLines == null)
        {
            if(players == null)
            {
                int numLines= RECORD_SIZE;
                textLines = new String[numLines];

                textLines[0] = String.format("%-16s%s%n","Name:", player.getName());
                textLines[1] = String.format("%-16s%s%n","Program Week:", week);
                textLines[2] = String.format("%-16s%s%d%s%d%s%d%s%d%n","Current Maxes:", "Bench - ", player.getBenchMax(),"  Squat - ", player.getSquatMax(),"  Incline - ", player.getInclineMax(),"  Power Clean - ", player.getPowerMax());
                textLines[3] = "-------------------------------------------------------------------------------------------------------";
                textLines[4] = String.format("%-8s%d%s%d%s%d%n","Reps: ",weekReps[0],", ",weekReps[1],", ",weekReps[2]);
                textLines[5] = String.format("%-8s%d%s%-16s%d%n","Squat: ", WeightLiftingProgram.calculateSquat(player.getSquatMax(), week),"          ","Power Clean:", WeightLiftingProgram.calculatePowerClean(player.getPowerMax(), week));
                textLines[6] = String.format("%-8s%d%s%-16s%d%n","Bench: ", WeightLiftingProgram.calculateBench(player.getBenchMax(), week),"          ","Incline: " , WeightLiftingProgram.calculateIncline(player.getInclineMax(), week));
                textLines[7] = "\n";
                textLines[8] = "\n";
            }
            else
            {
                int numLines=players.size() * RECORD_SIZE;
                textLines = new String[numLines];
                for (int i=0;i<numLines;i+=RECORD_SIZE)
                {
                    Player aPlayer = (players.get(i/RECORD_SIZE));
                    textLines[i]   = String.format("%-16s%s%n","Name:", aPlayer.getName());
                    textLines[i+1] = String.format("%-16s%s%n","Program Week:", week);
                    textLines[i+2] = String.format("%-16s%s%d%s%d%s%d%s%d%n","Current Maxes:", "Bench - ", aPlayer.getBenchMax(),"  Squat - ", aPlayer.getSquatMax(),"  Incline - ", aPlayer.getInclineMax(),"  Power Clean - ", aPlayer.getPowerMax());
                    textLines[i+3] = "-------------------------------------------------------------------------------------------------------";
                    textLines[i+4] = String.format("%-8s%d%s%d%s%d%n","Reps: ",weekReps[0],", ",weekReps[1],", ",weekReps[2]);
                    textLines[i+5] = String.format("%-8s%d%s%-16s%d%n","Squat: ", WeightLiftingProgram.calculateSquat(aPlayer.getSquatMax(), week),"          ","Power Clean:", WeightLiftingProgram.calculatePowerClean(aPlayer.getPowerMax(), week));
                    textLines[i+6] = String.format("%-8s%d%s%-16s%d%n","Bench: ", WeightLiftingProgram.calculateBench(aPlayer.getBenchMax(), week),"          ","Incline: " , WeightLiftingProgram.calculateIncline(aPlayer.getInclineMax(), week));
                    textLines[i+7] = "\n";
                    textLines[i+8] = "\n";
                }
            }
        }
    }

    @Override
   public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException
   {
        Font font = new Font("Consolas", Font.PLAIN, 12);
        g.setFont(font);
        
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null)
        {
            initTextLines();
            int linesPerPage = (int)(pf.getImageableHeight()/lineHeight);
            int recordsPerPage = linesPerPage/RECORD_SIZE;
            int numRecords = textLines.length/RECORD_SIZE; 
            int numBreaks = (numRecords * RECORD_SIZE) / linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b=0; b<numBreaks; b++)
            {
                pageBreaks[b] = (b+1)* recordsPerPage * RECORD_SIZE;
            }
        }

        if (pageIndex > pageBreaks.length)
        {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         */
        int y = 0;
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex-1];
        int end   = (pageIndex == pageBreaks.length)
                         ? textLines.length : pageBreaks[pageIndex];
        for (int line=start; line<end; line++)
        {
            y += lineHeight;
            g.drawString(textLines[line], 0, y);
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

}










