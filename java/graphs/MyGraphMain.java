package graphs;

public class MyGraphMain {
    public static void main(String[] args) {
        MyAdjMatrix g1 = new MyAdjMatrix("UNDIRECTED", 10, 10);
        g1.addEdge(1, 2);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(3,5);
        g1.printGraph();

        MyAdjMatrix g2 = new MyAdjMatrix("DIRECTED", 10, 10);
        g2.addEdge(1, 2);
        g2.addEdge(2,3);
        g2.addEdge(2,4);
        g2.addEdge(3,5);
        g2.printGraph();

        MyAdjLists g3 = new MyAdjLists("UNDIRECTED");
        g3.addNode(0);
        g3.addNode(1);
        g3.addNode(2);
        g3.addNode(3);

        g3.addEdge(1,2);
        g3.addEdge(2,3);
        g3.addEdge(3,1);

        g3.printGraph();

        MyAdjLists g4 = new MyAdjLists("DIRECTED");
        g4.addNode(0);
        g4.addNode(1);
        g4.addNode(2);
        g4.addNode(3);

        g4.addEdge(1,2);
        g4.addEdge(2,3);
        g4.addEdge(3,1);

        g4.printGraph();

        g4.BFS(2);
        //g4.DFS(2);
    }
}
