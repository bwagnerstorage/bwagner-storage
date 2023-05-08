//2018 UIL Invitational B - Luann
import static java.lang.System.out;
import java.util.*;
import java.io.*;
public class Luann {

	public static void main(String[] args) throws IOException{
		Scanner f=new Scanner(new File("luann.dat"));
		int numCharts=f.nextInt();
		for(int nc=1;nc<=numCharts;nc++) {
			int pairs=f.nextInt();
			
			//Read all the values into an array
			
			int[] allValues=new int[pairs*2];
			for(int i=0;i<allValues.length;i++)  
				allValues[i]=f.nextInt();
			
			//Find the largest y value and use
			//that as the number of rows in the 
			//chart.
			
			int largestYValue=-1;
			for(int i=1;i<allValues.length;i+=2)
				if(allValues[i]>largestYValue)
					largestYValue=allValues[i];
			int rows=largestYValue+2;
			int columns=pairs+2;
			
			char[][] chart=new char[rows][columns];
			
			//Fill with blanks.
			
			for(int i=0;i<rows;i++) 
				for(int j=0;j<columns;j++)
					chart[i][j]=' ';
			
			//Make the y axis.			
			
			char yLabel='1';
			for(int i=rows-3;i>=0;i--) {
				chart[i][0]=yLabel++;
				chart[i][1]='|';
			}
			
			//Make the x axis.
			
			char xLabel='1';
			for(int i=2;i<columns;i++) {
				chart[chart.length-1][i]=xLabel++;
				chart[chart.length-2][i]='_';
			}
			
			//Mark each data point.
			
			int col=2;
			for(int i=1;i<allValues.length;i+=2) {
				int row=(rows-2)-allValues[i];
				chart[row][col]='X';
				col++;				
			}
			
			//Build a string representing the chart.
			
			String chartToString="";
			for(int i=0;i<rows;i++) {
				for(int j=0;j<columns;j++)
					chartToString+=chart[i][j];
				chartToString+="\n";
			}
			out.print(chartToString);			
			out.println("=====");			
		}
	}
}
