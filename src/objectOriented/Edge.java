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
    private Vertex target;
    private double weight;
    
    public Edge(Vertex pTarget, double pWeight)
    {
        target = pTarget;
        weight = pWeight;
    }

    public Vertex getTarget() 
    {
        return target;
    }

    public double getWeight() 
    {
        return weight;
    }
    
    public void setTarget(Vertex pTarget)
    {
        target = pTarget;
    }
    
    public void setWeight(double pWeight)
    {
        weight = pWeight;
    }
    
    public String toString()
    {
        return "    To "+target.toString()+": "+weight+"\n";
    }
    
}
