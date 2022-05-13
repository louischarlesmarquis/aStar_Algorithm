
package astaralgorithm;

public class AStarAlgorithm extends Algorithm{

    public static void main(String[] args) {
        Vertex head = new Vertex(3);
        head.gcost = 0;

        Vertex v1 = new Vertex(2);
        Vertex v2 = new Vertex(5);
        Vertex v3 = new Vertex(3);

        head.addEdge(2, v1);
        head.addEdge(4, v2);
        head.addEdge(3, v3);
        v3.addEdge(1, v2);

        Vertex n4 = new Vertex(1);
        Vertex n5 = new Vertex(3);
        Vertex end = new Vertex(7);

        v1.addEdge(7, n4);
        v2.addEdge(4, n5);
        v3.addEdge(6, n4);

        n4.addEdge(3, end);
        n5.addEdge(1, n4);
        n5.addEdge(3, end);

        Vertex temp = aStar(head, end);
        printPath(temp);
    }
    
}
