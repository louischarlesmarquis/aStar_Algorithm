package astaralgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Algorithm{
    public static Vertex aStar(Vertex start, Vertex end){
        PriorityQueue<Vertex> closedList = new PriorityQueue<>();
        PriorityQueue<Vertex> openList = new PriorityQueue<>();

        start.fcost = start.gcost + start.gethcost(end);
        openList.add(start);

        while(!openList.isEmpty()){
            Vertex v = openList.peek();
            if(v == end){
                return v;
            }

            for(Vertex.Edge edge : v.neighbors){
                Vertex v2 = edge.vertex;
                double totalWeight = v.gcost + edge.weight;

                if(!openList.contains(v2) && !closedList.contains(v2)){
                    v2.parent = v;
                    v2.gcost = totalWeight;
                    v2.fcost = v2.gcost + v2.gethcost(end);
                    openList.add(v2);
                } else {
                    if(totalWeight < v2.gcost){
                        v2.parent = v;
                        v2.gcost = totalWeight;
                        v2.fcost = v2.gcost + v2.gethcost(end);

                        if(closedList.contains(v2)){
                            closedList.remove(v2);
                            openList.add(v2);
                        }
                    }
                }
            }

            openList.remove(v);
            closedList.add(v);
        }
        return null;
    }

    public static void printPath(Vertex target){
        Vertex v = target;

        if(v==null){
            return;
        }
        List<Integer> names = new ArrayList<>();

        while(v.parent != null){
            names.add(v.name);
            v = v.parent;
        }
        names.add(v.name);
        Collections.reverse(names);

        for(int name : names){
            System.out.print(name + " ");
        }
        System.out.println();
    }
}