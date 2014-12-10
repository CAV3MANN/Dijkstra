package objectOriented;

import java.util.LinkedList;

/**
 *@author Joshua Miller
 * 
 */
public class Vertex implements Comparable<Vertex>
{
   
    private final String name;
    private final LinkedList<Edge> adjList;
    private double minDistance = Double.POSITIVE_INFINITY;
    private Vertex prev;
    
    /**
     * This is the constructor. Takes in a String to
     * represent the vertex with a name.
     * @param pName: String   
     */
    public Vertex(String pName)
    {
        this.adjList = new LinkedList<>();
        name = pName;
    }
    
    /**
     * Returns the name of the vertex
     * @return String
     */
    @Override
    public String toString()
    {
        return name;
    }
    
    /**
     * This returns the min value of a comparison between this
     * vertex and another's minimum traveled weight.
     * @param other: Vertex 
     * @return integer
     */
    @Override
    public int compareTo(Vertex other) 
    {
        return Double.compare(minDistance, other.minDistance); 
    }
    
    /**
     * This adds an edge to the edge list
     * @param target: Vertex 
     * @param weight: double  
     */
    public void addEdge(Vertex target, double weight)
    {
        adjList.add(new Edge(target, weight));
    }
    
    /**
     * This adds an edge to the edge list
     * @param pEdge: Edge  
     */
    public void addEdge(Edge pEdge)
    {
        adjList.add(pEdge);
    }
    
    /**
     * This returns the minimum distance associated
     * with getting to this vertex
     * @return double 
     */
    public double getMinDistance()
    {
        return minDistance;
    }
    
    /**
     * This sets the minimum weight associated
     * with getting to this vertex
     * @param pMin: double  
     */
    public void setMinDistance(double pMin)
    {
        minDistance = pMin;
    }
    
    /**
     * This gets the previous vertex
     * @return Vertex 
     */
    public Vertex getPrevious()
    {
        return prev;
    }
    
    /**
     * This sets the previous vertex
     * @param pPrevious: Vertex  
     */
    public void setPrevious(Vertex pPrevious)
    {
        prev = pPrevious;
    }
    
    /**
     * This returns the list of edges in Vector form
     * @return LinkedList
     */
    public LinkedList<Edge> getAdjacencyList()
    {
        return adjList;
    }
    
    /**
     * This returns a formatted list of all the edges 
     * and weights associated with the Vertex
     * @return formatted String
     */
    public String edgeListToString()
    {
        String str;
        str = "Adjacencies for "+name+":\n";
        str = adjList.stream().map((e) -> e.toString()).reduce(str, String::concat);
        return str;
    }
}
