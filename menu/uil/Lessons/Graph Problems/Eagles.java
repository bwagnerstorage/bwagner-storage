import java.util.*;
import java.io.*;

public class Eagles 
{
    String[][] map= new String[11][11];
    Map<Node, List<Node>> adjacentList = new HashMap<>();
    int cabin_row;
    int cabin_col;
    Node source;
    
    public Eagles() throws IOException
    {
        Scanner input = new Scanner(new File("eagles.dat"));
        int dataSets = input.nextInt();
        
        while(dataSets-- > 0)
        {
            cabin_row = input.nextInt();
            cabin_col = input.nextInt(); 
            input.nextLine();
       
            
            for(int r = 1; r <= 10; r++)
            {
                String line = input.nextLine();
                String[] row = line.split("");
                for(int c = 1; c <= 10; c++)
                {
                    map[r][c] = row[c-1];
                }
            }
                     
            buildAdjacentList();
            Set<Node> set = adjacentList.keySet();
            Node destination = bfs();
            if(destination != null)
            {
                System.out.println(destination.distance);
            }

        }         
    }
    
    public void buildAdjacentList()
    {
        int vertex = 0;                   // assign each vertex a unique vertex id
    
        for(int r = 1; r <= 10; r++)      // create vertices from the map that 
        {                                 // are not bears or moose
            for(int c = 1; c <= 10; c++)
            {
                String value = map[r][c];
                if(isValid(value))         // string is not "B" or "M"
                {    
                    Node node = new Node(vertex, value, new Location(r,c));
                    adjacentList.put(node, null);
                    if(r == cabin_row && c == cabin_col)    // store cabin node
                        source = node;
                    vertex++;
                }
            }
        }
        
        
        Set<Node> keys = adjacentList.keySet();  // get set of keys 
        for(Node key : keys)
        {
            List<Node> list = new LinkedList<>();  // creat linked list

            for(int n = -1; n <= 1; n++)    // search for child nodes in 8 directional headings
            {
                for(int m = -1; m <= 1; m++)
                {
                    int r = key.loc.row;
                    int c = key.loc.col;
                    if(!(n == 0 && m == 0) && inBounds(r + n, c + m) && isValid(map[r + n][ c + m]))  // child vertex meets qualifications
                    {
                        for(Node key2 : keys) // search vertices to find match with child
                        {
                            if(key2.loc.row == r + n && key2.loc.col == c + m)  // child is not source vertex
                            {
                                list.add(key2);  // add child node to list of children
                            }
                        }
                        
                    }
                }
            }
            adjacentList.put(key, list);     // assign list to current key (source vertex)
        }
                
    }
    
    public boolean inBounds(int row, int col)
    {
        return row >= 1 && col >= 1 && row <= 10 && col <= 10;
    }
        
    public boolean isValid(String value)
    {
        return !value.equals("B") && !value.equals("M");
    }
    
    
    public Node bfs()
    {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[11][11];
        Node current = source;
        queue.add(current);
        visited[cabin_row][cabin_col] = true;
        
        while(!queue.isEmpty())
        {
            current = queue.remove();
            List<Node> children = adjacentList.get(current);
            if(children != null)
            {
                for(Node node : children)
                {
                    if(visited[node.loc.row][node.loc.col] == false)
                    {
                        visited[node.loc.row][node.loc.col] = true;
                        node.distance = current.distance + 1;
                        node.parent = current;   
                        queue.add(node);
                    }
                    if(node.value.equals("E"))  // found eagle
                        return node;
                }
            }
        }
        return null;
        
    }
    
    public static void main(String[] args) throws IOException
    {
        new Eagles();
    }
}

class Node
{
    int vertex;
    Location loc;
    String value;
    int distance;
    Node parent;
    
    public Node(int vertex, String value, Location loc)
    {
        this.vertex = vertex;
        this.value = value;
        this.loc = loc;
        distance = 0;
    }
    
    public void setParent(Node parent)
    {
        this.parent = parent;
    }
}

class Location
{
    int row;
    int col;
    
    public Location(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}
