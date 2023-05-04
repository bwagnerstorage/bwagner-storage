package org.bwagner;

import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.util.*;

/*
   This class is responsible for interacting with the printer and printing a 
   list of Groups.
*/

public class PrintGroups extends JFrame implements Printable
{
    final static int RECORD_SIZE = 8;  // data plus 2 blank lines after record
                                       // and 2 lines for header

    private ArrayList <Group> groups;  // stores workout groups to be printed
    private String[] textLines;        // stores each line of data to be printed per record
    private int[] pageBreaks;          // array of page break line positions

    /*
       @param list an ArrayLis of Groups
    */
    public PrintGroups(ArrayList<Group> list) // prints all groups
    {
        setVisible(false);       //don't show gui window
        
        groups = list;

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
            }
         }
    }
    /*
        Prepares the data for printing by filling the textLines array with all
        the data from the array of groups into string format.
    */
    private void initTextLines()
    {
        if (textLines == null)
        {

            int numLines=groups.size() * RECORD_SIZE;
            textLines = new String[numLines];
            int groupCount = 1;
            for (int i=0;i < numLines; i+=RECORD_SIZE)
            {
                Group group = (groups.get(i/RECORD_SIZE));
                //Group group = groups.get(groupCount-1);
                Player[] players = group.getGroup();
                
                textLines[i]   = String.format("%s%d%n","Group", groupCount);
                textLines[i+1] = String.format("%s%n","----------");
                int j = 2;
                for(; j <= group.getGroupSize()+1; j++)
                {
                    if(players[j-2] != null)
                       textLines[i+j] = String.format("%-22s%s%d%n", players[j-2].getName(), "Bench Max = ", players[j-2].getBenchMax());
                }
                textLines[i+j] = "\n";
                textLines[i+j+1] = "\n";
                
                if(i % RECORD_SIZE == 0 || group.getGroupSize() < 4)
                {
                    groupCount++;
                }
            }
            
        }
    }

    @Override
   public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException
   {
        Font font = new Font("Consolas", Font.PLAIN, 14);
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
            if(textLines[line] != null)
               g.drawString(textLines[line], 0, y);
        }
        
    

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

}










