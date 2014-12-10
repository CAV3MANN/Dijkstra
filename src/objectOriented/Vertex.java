package objectOriented;

import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joshua
 */
public class Vertex implements Comparable<Vertex>
{
    private final String name;
    private Vector<Edge> adjList = new Vector<Edge>();
    private double minDistance = Double.POSITIVE_INFINITY;
    private Vertex prev;
    
    public Vertex(String pName)
    {
        name = pName;
    }
    
    public String toString()
    {
        return name;
    }
    
    @Override
    public int compareTo(Vertex other) 
    {
        return Double.compare(minDistance, other.minDistance); 
    }
    
    public void addEdge(Vertex target, double weight)
    {
        adjList.add(new Edge(target, weight));
    }
    
    public void addEdge(Edge pEdge)
    {
        adjList.add(pEdge);
    }
    
    public String getEdgeList()
    {
        String str = "";
        str = "Adjacencies for "+name+":\n";
        for(Edge e: adjList)
        {
            str+= e.toString();
        }
        return str;
    }
}
