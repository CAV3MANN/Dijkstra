package objectOriented;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joshua
 */
public class Dijkstra {
    
    private String fileLoc;
    private Vertex[] vList;
    private int amountOfVertices;
    
    public static String fileLoc1 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\NineDirected.csv";
    public static String fileLoc2 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\HundredUnDirected.csv";
    public static String fileLoc3 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\HundredDirected.csv";
    public static String fileLoc4 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\TwentyFiveDirected.csv";

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    
    /*
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        //Vector<Vertex> vList = new Vector<Vertex>();
        
        //String line;
        
              
        computePaths(vList[0]);
        //for (Vertex v : vList)
	{
	    System.out.println("Distance to " + vList[vList.length-1] + ": " + vList[vList.length-1].getMinDistance());
	    List<Vertex> path = getShortestPathTo(vList[vList.length-1]);
	    System.out.println("Path: " + path);
	}
        
       
    }
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
    
    public Vertex[] getVertexList()
    {
        return vList;
    }
    
    public int getAmountOfVertices()
    {
        return amountOfVertices;
    }
    
    public Vertex getSourceVertex()
    {
        return vList[0];
    }
    
    public Vertex getLastVertex()
    {
        return vList[vList.length-1];
    }
    
      
}
