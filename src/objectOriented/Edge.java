/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectOriented;
/**
 *
 * @author Joshua
 */
public class Edge 
{
    private final Vertex target;
    private final double weight;
    
    /**
     * Constructs an Edge object with a target and a weight.
     * @param pTarget: Vertex 
     * @param pWeight: double  
     */
    public Edge(Vertex pTarget, double pWeight)
    {
        target = pTarget;
        weight = pWeight;
    }
    
    /**
     * Returns the Target of this edge.
     * @return Vertex
     */
    public Vertex getTarget() 
    {
        return target;
    }

    /**
     * Returns the Weight associated with this edge.
     * @return double
     */
    public double getWeight() 
    {
        return weight;
    }
    
    /**
     * Returns a string value such as the following:
     * "    To v10: 2.0"
     * Where v10 is the Target and 2.0 is the weight.
     * Notice the leading tab character.
     * @return formatted String
     */
    @Override
    public String toString()
    {
        return "    To "+target.toString()+": "+weight+"\n";
    }
    
}
