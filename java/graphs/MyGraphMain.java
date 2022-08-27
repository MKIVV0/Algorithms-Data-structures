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

        MyAdjLists g4 = new MyAdjLists("UNDIRECTED");
        g4.addNode(0);
        g4.addNode(1);
        g4.addNode(2);
        g4.addNode(3);
        g4.addNode(4);
        g4.addNode(5);
        g4.addNode(6);
        g4.addNode(7);
        g4.addNode(8);
        g4.addNode(9);
        g4.addNode(10);


        g4.addEdge(1,2);
        g4.addEdge(2,3);
        g4.addEdge(3,1);
        g4.addEdge(3,4);
        g4.addEdge(5,6);
        g4.addEdge(5,4);
        g4.addEdge(2,8);
        g4.addEdge(8,10);
        g4.addEdge(9,10);
        g4.addEdge(0,8);
        g4.addEdge(7,5);

        g4.printGraph();

        System.out.println("- Breadth First Search (traversing the entire graph):");
        g4.breadthFirstSearch(7);
        System.out.println("\n");
        System.out.println("- Breadth First Search (traversing from a source to a destination):");
        g4.breadthFirstSearch(7, 10);
        System.out.println("\n");
        /*
        System.out.println("- Recursive Depth First Search (traversing the entire graph):");
        g4.initializeVisitedArray();
        g4.recDepthFirstSearch(1);
        System.out.println("\n");
        System.out.println("- Iterative Depth First Search (traversing the entire graph):");
        g4.iterDepthFirstSearch(2);*/

        System.out.println("\n\n altDFS: ");
        g4.altBFS(7);
    }
}
