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

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        //Vector<Vertex> vList = new Vector<Vertex>();
        Vertex[] vList;
        //String line;
        int amountOfVertices = 0;
        int currentVertex = 0;
        int currentTarget = 0;
        
        String fileLoc1 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\NineDirected.csv";
        String fileLoc2 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\HundredUnDirected.csv";
        String fileLoc3 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\HundredDirected.csv";
        String fileLoc4 = "C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\adjMatrixFiles\\TwentyFiveDirected.csv";
        

        FileReader file = new FileReader(fileLoc3);
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
        
        file = new FileReader(fileLoc3);
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
              
        computePaths(vList[0]);
        //for (Vertex v : vList)
	{
	    System.out.println("Distance to " + vList[vList.length-1] + ": " + vList[vList.length-1].getMinDistance());
	    List<Vertex> path = getShortestPathTo(vList[vList.length-1]);
	    System.out.println("Path: " + path);
	}
        
        /*
        for(Vertex v: vList)
            System.out.println(v.edgeListToString());
                */
    }
    
    /**
     * This follows Dijsktra's algorithm in the way that:
     * 1) First, all weights (L) of all vertices are set to posInifity (see Vertex.java)
     * 2) The weight (L) of the initial vertex is set to 0
     * 3) vList (T) is initialized with the source vertex in it.
     * 4) It then looks at the adjacent vertices and changes their weights (L) to be
     *      the minimum of the comparison between their current weight and the weight
     *      of the path leading to it.
     * 5) The vertex in question is then removed from the vList (T)
     * @param source: Vertex  
     */
    public static void computePaths(Vertex source)
    {
        source.setMinDistance(0);
        
        LinkedList<Vertex> vList = new LinkedList<>();
        //The Vertex 
      	vList.add(source);
 
	while (!vList.isEmpty()) {
	    Vertex u = vList.poll();
 
            // Visit each edge exiting u
            u.getAdjacencyList().stream().forEach((e) -> 
            {
                Vertex v = e.getTarget();
                double weight = e.getWeight();
                double distanceThroughU = u.getMinDistance() + weight;
                
                if (distanceThroughU < v.getMinDistance()) {
                    vList.remove(v);
                    v.setMinDistance(distanceThroughU);
                    v.setPrevious(u);
                    vList.add(v);
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
    public static LinkedList<Vertex> getShortestPathTo(Vertex target)
    {
        LinkedList<Vertex> minPath = new LinkedList<>();
        
        for (Vertex vertex = target; vertex != null; vertex = vertex.getPrevious())
            minPath.add(vertex);
        
        Collections.reverse(minPath);
        
        return minPath;
    }
}
