package objectOriented;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Joshua Miller
 */
public class Dijkstra {
    
    private final String fileLoc;
    private final Vertex[] vList;
    private int amountOfVertices;
    
    public static final String NineDirectedPath = "/adjMatrixFiles/NineDirected.csv";
    public static final String HundredUnDirectedPath = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\HundredUnDirected.csv";
    public static final String HundredDirectedPath = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\HundredDirected.csv";
    public static final String TwentyFiveDirectedPath = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\TwentyFiveDirected.csv";

    /**
     * The constructor takes in the file location of the adjacency matrix
     * and generates a list of vertices with all corresponding edges.
     * @param pFileLoc: String
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Dijkstra(String pFileLoc) throws FileNotFoundException, IOException
    {
        fileLoc = pFileLoc;
        
        amountOfVertices = 0;
        int currentVertex = 0;
        int currentTarget = 0;
        
        
        

        FileReader file = new FileReader(fileLoc);
        Scanner inFile = new Scanner(file);

        Scanner line = new Scanner(inFile.nextLine());
        line.useDelimiter(",");

        while(line.hasNext())
        {
            line.next();
            amountOfVertices++;
        }
        
        
        vList = new Vertex[amountOfVertices];

        for(int i = 0; i < vList.length;i++)
        {
            vList[i] = new Vertex("V"+(i+1));
        }
        
        inFile.close();
        file.close();
        
        file = new FileReader(fileLoc);
        inFile = new Scanner(file);
        
        while(inFile.hasNextLine())
        {
            line = new Scanner(inFile.nextLine());
            line.useDelimiter(",");
            
            while(line.hasNextDouble())
            {
                double weight = line.nextDouble();
                
                if(weight != 0)
                {
                    vList[currentVertex].addEdge(vList[currentTarget], weight);
                }
        
                currentTarget++;
            }
            currentTarget = 0;
            currentVertex++;
        }
    }
    
    /**
     * This follows Dijsktra's algorithm in the way that:
     * 1) First, all weights (L) of all vertices are set to posInifity (see Vertex.java)
     * 2) The weight (L) of the initial vertex is set to 0
     * 3) tList (T) is initialized with the source vertex in it.
     * 4) It then looks at the adjacent vertices and changes their weights (L) to be
     *      the minimum of the comparison between their current weight and the weight
     *      of the path leading to it.
     * 5) The vertex in question is then removed from the vList (T)
     * @param source: Vertex  
     */
    public void computePaths(Vertex source)
    {
        source.setMinDistance(0);
        
        LinkedList<Vertex> tList = new LinkedList<>();
        //The Vertex 
      	tList.add(source);
 
	while (!tList.isEmpty()) {
	    Vertex u = tList.poll();
 
            // Visit each edge exiting u
            u.getAdjacencyList().stream().forEach((e) -> 
            {
                Vertex v = e.getTarget();
                double weight = e.getWeight();
                double distanceThroughU = u.getMinDistance() + weight;
                
                if (distanceThroughU < v.getMinDistance()) {
                    tList.remove(v);
                    v.setMinDistance(distanceThroughU);
                    v.setPrevious(u);
                    tList.add(v);
                }
            });
        }
    }
    
    /**
     * This must be used AFTER computePaths(target) was ran.
     * It returns a list representing all of the Vertices that
     * are part of the shortest path that leads to the target.
     * It does this by stepping to the previous vertex of each
     * vertex until it reaches the source. If the source ever changes,
     * computePaths(target) must be reran.
     * @param target: Vertex
     * @return LinkedList
     */
    public LinkedList<Vertex> getShortestPathTo(Vertex target)
    {
        LinkedList<Vertex> minPath = new LinkedList<>();
        
        for (Vertex vertex = target; vertex != null; vertex = vertex.getPrevious())
            minPath.add(vertex);
        
        Collections.reverse(minPath);
        
        return minPath;
    }
    
    /**
     * Returns a list of all of the vertices that were
     * generated from instantiation.
     * @return Vertex[] 
     */
    public Vertex[] getVertexList()
    {
        return vList;
    }
    
    /**
     * Returns the amount of vertices that were 
     * generated during instantiation.
     * @return integer 
     */
    public int getAmountOfVertices()
    {
        return amountOfVertices;
    }
    
    /**
     * Returns the vertex that was selected as the source.
     * @return Vertex 
     */
    public Vertex getSourceVertex()
    {
        return vList[0];
    }
    
    /**
     * Returns the vertex that was added to the vertex
     * list last.
     * @return Vertex 
     */
    public Vertex getLastVertex()
    {
        return vList[vList.length-1];
    }
    
      
}
