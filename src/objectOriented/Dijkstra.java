package objectOriented;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
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
public class Dijkstra {

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        // TODO code application logic here
    }
    */
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        //Vector<Vertex> vList = new Vector<Vertex>();
        Vertex[] vList;
        //String line;
        int amountOfVertices = 0;
        int currentVertex = 0;
        int currentTarget = 0;

        FileReader file = new FileReader("C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\objectOriented\\NineDirected.csv");
        Scanner inFile = new Scanner(file);

        Scanner line = new Scanner(inFile.nextLine());
        line.useDelimiter(",");

        while(line.hasNext())
        {
            line.next();
            amountOfVertices++;
        }
        
        
        vList = new Vertex[9];

        for(int i = 0; i < vList.length;i++)
        {
            vList[i] = new Vertex("v"+i);
        }

        System.out.println(amountOfVertices);
        
        inFile.close();
        file.close();
        
        file = new FileReader("C:\\Users\\Joshua\\Documents\\GitHub\\Dijkstra\\src\\objectOriented\\NineDirected.csv");
        inFile = new Scanner(file);
        
        while(inFile.hasNextLine())
        {
            line = new Scanner(inFile.nextLine());
            line.useDelimiter(",");
            
            while(line.hasNextDouble())
            {
                double weight = line.nextDouble();
                
                if(weight != 0)
                    vList[currentVertex].addEdge(vList[currentTarget], weight);
        
                currentTarget++;
            }
            currentTarget = 0;
            currentVertex++;
        }
        
        for(Vertex v: vList)
        {
            System.out.println(v.getEdgeList());
        }        
        /*
        for(int i = 0; i <9; i++)
        {
            vList.add(new Vertex("v"+i));
            System.out.println(vList.get(i).toString());
        }
        
        System.out.println(vList.get(0).toString());
        
    
        
        vList.get(1).addEdge(vList.get(0), 9);
        vList.get(1).addEdge(vList.get(2), 5);
        vList.get(1).addEdge(vList.get(3), 6);
        vList.get(1).addEdge(vList.get(5), 13);
        
        vList.get(2).addEdge(vList.get(1), 2);
        vList.get(2).addEdge(vList.get(4), 4);
        vList.get(2).addEdge(vList.get(5), 5);
        vList.get(2).addEdge(vList.get(1), 2);
       
        System.out.println(vList.get(1).getEdgeList());
                */
    }
}
