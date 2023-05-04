
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

// The algorithm uses a dfs on an adjacentMatrix graph with an added if
// statement inside the nested loops that finds the adjacent matrix with
// the smallest weight (distance) for the current vertex.
// The program also utilizes 2 HashMaps as lookup tables for the city
// name or city (vertex #)

public class Lauren
{
	public static void main(String [] args) throws FileNotFoundException 
        {
            Scanner f = new Scanner(new File("lauren.dat"));
            int N = f.nextInt(); f.nextLine();
            while(N-- > 0) 
            {
                int numCities = f.nextInt();f.nextLine();
                
                // create two maps so city can be looked up by either name or vertex number
                HashMap<String, Integer> citiesLookup = new HashMap<String, Integer>();
                HashMap<Integer, String> cities = new HashMap<Integer, String>();
                
                for(int i = 0; i < numCities; i ++) 
                {
                    String city = f.nextLine();
                    cities.put(i, city);
                    citiesLookup.put(city, i);
                }
                int adjMatrix[][] = new int[numCities][numCities];   // define adjacent matrix (graph)
                
                int numLinks = f.nextInt(); f.nextLine();

                for(int i = 0; i < numLinks; i ++) 
                {
                    String city1 = f.next();
                    String city2 = f.next();
                    int distance = f.nextInt();
                    //System.out.println(city1 + " " + city2);
                    
                    // matrix is undirected so the distance between the two cities is placed in corresponding matrix locations.
                    adjMatrix[citiesLookup.get(city1)][citiesLookup.get(city2)] = distance;
                    adjMatrix[citiesLookup.get(city2)][citiesLookup.get(city1)] = distance;
                }
                //System.out.println("the citys are visited as follows");
                TravelingSalesman travelingSalesman = new TravelingSalesman();
                ArrayList<Integer> solution = travelingSalesman.travel(adjMatrix);    // get solution
               
                String ans = "";
                for(int i : solution)
                {
                    ans += cities.get(i) + " => ";
                }
                ans = ans.substring(0, ans.length() - 4);
                
                System.out.println(ans);                 // print solution      
            }
	}
}
 
class TravelingSalesman
{
    private int numberOfNodes;
    private Stack<Integer> stack;  // a stack is used with a dfs
 
    public TravelingSalesman()
    {
        stack = new Stack<Integer>();  
    }
 
    public ArrayList<Integer> travel(int adjacencyMatrix[][])
    {
        numberOfNodes = adjacencyMatrix[0].length;
        boolean[] visited = new boolean[numberOfNodes];
        visited[0] = true;
        stack.push(0);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        //System.out.print(1 + "\t");
        ArrayList<Integer> solution = new ArrayList<Integer>();      // holds solution set
        solution.add(0);
        
        while (!stack.isEmpty())
        {
            element = stack.peek();   // retrieve index of vertex on top of stack
            i = 0;
            min = Integer.MAX_VALUE;
            while (i < numberOfNodes)  // visit all adjacent nodes of current vertex and find the
            {                           // one that has the smallest weight (distance)
                if (adjacencyMatrix[element][i] > 0 && visited[i] == false)  // if this adjacent vertex has not
                {                                                        // been visited yet
                    if (min > adjacencyMatrix[element][i])  // if adjacent vertex's distance is less than INF
                    {
                        min = adjacencyMatrix[element][i];  // assign its distance to min
                        dst = i;                            // assign its index to dst
                        minFlag = true;                     // set minFlag to true
                    }
                }
                i++;   // advance to next adjacent vertex
            }
            if (minFlag)  // if found adjacent vertex with smaller distance
            {
                visited[dst] = true;               // set adjacent vertex to visited
                stack.push(dst);                // add adjacent vertex's index to stack
                //System.out.print(dst + "\t");
                solution.add(dst);              // add adjacent vertex's index to solution set
                minFlag = false;                // reset minFlag
                continue;                       // don't pop stack, go to next loop iteration
            }
            stack.pop();    // advance to next vertex in stack
        }
        return solution;
    }   
}