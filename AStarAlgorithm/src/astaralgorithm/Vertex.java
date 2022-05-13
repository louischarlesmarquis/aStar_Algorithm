/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astaralgorithm;

import java.util.*;

/**
 *
 * @author Admin
 */
public class Vertex implements Comparable<Vertex> {
    private static int count = 0;
    public int name; //used to identify each node and to clearly display the solution path 
    //list containing the vertex's neighbours
    public List<Edge> neighbors;
    //parent cell
    public Vertex parent = null;
    //G cost: distance from starting node to current node
    public double gcost;
    //H cost: distance from current node to final node
    public double hcost;
    //final cost = (G+H) cost
    public double fcost;
    
    //inner class representing the link between the vertices
    public static class Edge {
        //each edge carries a weight and is linked to a vertex
        public int weight; //distance from one vertex to another
        public Vertex vertex;
        public Edge(int weight, Vertex vertex){
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    Vertex(double h){
        this.hcost = h;
        this.name = count++;
        this.neighbors = new ArrayList<>();
    }

    //implementing the compareTo method
    @Override
    public int compareTo(Vertex v) {
        if (this.fcost < v.fcost){ 
            return -1; 
        }
        if (this.fcost > v.fcost){
            return 1; 
        }
        else{
            return 0; 
        }
    }

    public void addEdge(int weight, Vertex vertex){
        Edge newEdge = new Edge(weight, vertex);
        neighbors.add(newEdge);
    }

    public double gethcost(Vertex target){
        return this.hcost;
    }
}
