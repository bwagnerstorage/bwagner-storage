import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Jean 
{
    public Jean() throws IOException
    {
        Scanner input = new Scanner(new File("jean.dat"));
        int dataSets = input.nextInt();
        while(dataSets-- > 0)
        {
            TreeMap<String, String[]> graph = new TreeMap<>();
            
            int numStops = input.nextInt();
            input.nextLine();
            
            for(int i = 0; i < numStops; i++)
            {
                String line = input.nextLine();
                String[] array = line.split(" -> ");
                String stop = array[0];
                String[] connections = array[1].split(" ");

                graph.put(stop, connections);
            }
            findSourcesAndSinks(graph);      
        }
    }
    
    public final void findSourcesAndSinks(TreeMap<String, String[]> graph)
    {
        Set<String> stops = graph.keySet();
        TreeSet<String> sources = new TreeSet<>();
        TreeSet<String> sinks = new TreeSet<>();
        
        for(String stop : stops)
        {
            String[] stopsTo = graph.get(stop);
            int numStopsTo = stopsTo.length;
            boolean hasConnectionFrom = false;
            
            for(String anotherStop : stopsTo)
            {
                String[] stopsFrom = graph.get(anotherStop);
            
                if(stopsFrom != null)
                {  
                    for(String s : stopsFrom)
                    {
                        if(s.equals("NONE"))
                            sinks.add(anotherStop);
                        else if(s.equals(stop))
                            hasConnectionFrom = true;    
                    }  
                    if(numStopsTo > 0 && hasConnectionFrom == false) 
                    {
                        if(!stop.equals(anotherStop))
                           sources.add(stop);
                    }
                }
            }
        }    
        print(sources, sinks);
    }
    public void print(TreeSet<String> sources,  TreeSet<String> sinks)
    {
        System.out.print("Sources: ");
        if(sources.size() == 0)
            System.out.println("None");
        else
        {
            for(String s : sources)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        
        System.out.print("Sinks: ");
        if(sinks.size() == 0)
            System.out.println("None");
        else
        {
            for(String s : sinks)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }    
    }
    
    public static void main(String[] args) throws IOException
    {
        Jean app = new Jean();
    }
}
