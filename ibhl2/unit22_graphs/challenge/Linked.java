import java.util.*;
import java.io.*;

/* The problem description says "two articles, a and b are related means to say that
   there exists a series of links you could click that could get you to the same
   article c starting from article a and article b.
   This program uses an adjacent list representation of a graph to represent
   these relationships. The graph is used to determine if a
   relationship exists between two articles by looking for a common link on
   the path between the two Articles (nodes). Because the data are strings a
   TreeMap is used to implement the adjacent list. I could have used
   Dijkstra's Shortest Path Algorithm, but instead I chose to use the BFS 
   (Breadth First Search) Algorithm. A BFS search by itself will not find the
   shortest path between to nodes in a graph. If, however, while performing the BFS
   you keep track of the node's that were visited from the source node to the
   destination node. You can backtrack this list to determine the shortest path.
*/

public class Linked
{
    private TreeMap<String, LinkedList<String>> adjacentList = new TreeMap();   // Graph - unweight, nondirectional
    private ArrayList<Pair> solution = new ArrayList<>();
    private Scanner input = new Scanner(new File("a_eight.dat"));
    
    public Linked() throws IOException
    {
        int sets = input.nextInt();
        
        for(int s=0; s < sets; s++)
        {
            int nodes = input.nextInt();
            input.nextLine();
            
            for(int i=0; i < nodes; i++)
            {
                buildAdjacentList();   // extract data
            }
            
            int pairs = input.nextInt();

            for(int i = 0; i < pairs; i++)
            {
                boolean done = false;
                String article1 = input.next();
                String article2 = input.next();
                ArrayList<Node> path1 = bfs(adjacentList, article1, article2);   // get path from article1 to article2
                ArrayList<Node> path2 = bfs(adjacentList, article2, article1);   // get path from article2 to article1
                
                if(path1.isEmpty() && path2.isEmpty())  // no relationship between path1 and path2 exists
                {
                    break;
                }
                else if(path1.isEmpty())  // path1 has no article links
                {
                    if(hasRelationship(path2, article1) == false) 
                    {
                        solution.add(new Pair(article1, article2, Integer.MAX_VALUE));
                    }
                    else
                    {
                        int sum = calculateShortestPath(path2, path2.get(path2.size() - 1).id);
                        solution.add(new Pair(article1, article2, sum));
                    }
                }
                else if(path2.isEmpty())  // path2 has no article links
                {
                    if(hasRelationship(path1, article2) == false)
                    {
                        solution.add(new Pair(article1, article2, Integer.MAX_VALUE));
                    }
                    else
                    {
                        int sum = calculateShortestPath(path1, path1.get(path1.size() - 1).id);
                        solution.add(new Pair(article1, article2, sum));
                    }
                }
                else
                {
                    for(int j = 0; j < path1.size() && !done; j++) // traverse source path
                    {       
                        String a1 = path1.get(j).article;
                        for(int x = 0; x < path2.size() && !done; x++) // traverse destination path
                        {
                            String a2 = path2.get(x).article;
                            if(a1.equals(a2))    // found direct relationship
                            {   
                                int sum = calculateShortestPath(path1, path1.get(j).id);  // distance of source path
                                sum += calculateShortestPath(path2, path2.get(x).id);     // distance of dest path
                                solution.add(new Pair(article1, article2, sum));          // sum and to add to solution 
                                done = true;
                            }
                        }
                    }
                }
            }      
            
            Collections.sort(solution);   // sort final list by relationship, then by name
            for(Pair p : solution)
            {
                System.out.println(p.distance + " " + p.article1 + " " + p.article2);
            }
            System.out.println();
        }
    }   
    
    /* This method extracts the articles from the raw data and adds them
       to the adjacentList (graph)
    */
    public void buildAdjacentList()
    {
        String line = input.nextLine();
        if(line.substring(line.length() - 2, line.length() - 1).equals("."))
        {
            line = line.substring(0, line.length() - 1);
        }
        String[] words = line.split(" "); 
        String key = "";
        for(String word : words)
        {
            if(word.endsWith(":"))
            {
                key = word.substring(0, word.length() - 1);
                adjacentList.put(key, new <String>LinkedList());
            }
            if(word.endsWith("@"))
            {
                String endPoint = word.substring(0, word.length() - 1);
                adjacentList.get(key).addLast(endPoint);      
            }        
        }
    }
    
    // Graph - modified breadth-first-search (bfs) algorithm
    public ArrayList<Node>bfs(TreeMap<String, LinkedList<String>> adjacentList, String source, String dest)
    {
    	Queue <Node> queue = new LinkedList<>();           // queues are used with bfs algoritm
    	Map<String, Boolean> visited = new HashMap<>();    // tracks nodes that have been visited
        ArrayList<Node> previousList = new ArrayList<>();  // keeps track of nodes that make up the 
                                                           // shortest path
    	visited.put(source, true);
        int id = 0;
	    Node current = new Node(source, id, -1);
        queue.add(current);   // add source to queue
        
    	while(current != null)   // !queue.isEmpty()
    	{
            // get all of the current nodes 1st level children
            for(String str : adjacentList.get(current.article))
            {             
                // for each child not already visited
				if(visited.get(str) == null || visited.get(str) == false)
				{
							id++;  // assign each node an id
							Node node = new Node(str, id, current.id);  // current id = parent id 
							visited.put(str, true);     // mark visited true
							previousList.add(current);  // add parent node to previous list
							queue.add(node);            // add child node to queue
				}
            }
            
            current = null;
            if(!queue.isEmpty())
            {
                current = queue.remove();
                String a = current.article;
                if(a.equals(dest))             // if destination node reached
                {                              // add it to the queue
                    previousList.add(current); 
                }    
            }

        }
       
        return previousList;
    }  
    
    public boolean hasRelationship(ArrayList<Node> path, String dest)
    {
        boolean relationship = false;
        for(int i = 0; i < path.size() && !relationship; i++)
        {       
            String a = path.get(i).article;
            if(a.equals(dest))
            {   
                relationship = true;
            }
        }
        return relationship; 
    }
    
    public static int calculateShortestPath(ArrayList<Node> path, int id)
    {
        int distance = 0;
        int index = id;
        while(index > 0)
        {
            index = path.get(index).parentId;
            distance++;
        }
        return distance;
    }
}

// This class stores information about an article. 
class Node
{
    String article;
    int id;
    int parentId;
    int distance;
      
    public Node(String a, int id, int p)
    {
        article = a;
        this.id = id;
        parentId = p;
    }
   
    public void setDistance(int d)
    {
        distance = d;
    }
}


// This class is used to store a pair of related Articles and the 
// distance between them.
class Pair implements Comparable
{
    String article1;
    String article2;
    int distance;
    
    public Pair(String a1, String a2, int d)
    {
        article1 = a1;
        article2 = a2;
        distance = d;
    }
    
    // Used to sort the final pairs of related articles. It first determines
    // the ordering of two Articles by comparing their relationships. If they
    // are the same then if compares them by their names.
    public int compareTo(Object obj)
    {
        int result = distance - ((Pair)obj).distance;  // sort by strongest relationship
        if(result == 0)   // if equal
        {
            result = article1.compareTo(((Pair)obj).article1);  // sort by article1 name
            if(result == 0)  // if equal
            {
                result = article2.compareTo(((Pair)obj).article2); // sort  by article2 name
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException
    {
        new Linked();
    }
    
}