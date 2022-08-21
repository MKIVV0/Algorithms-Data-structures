package graphs;

public class MyAdjMatrix extends MyGraph {

    private int[][] adjMatrix;

    public MyAdjMatrix(String graphType, int i, int j) {
        super(graphType);
        this.adjMatrix = new int[i][j];
    }

    public void addEdge(int i, int j) {
        if (this.getType() == MyGraphTypes.UNDIRECTED) {
            if (this.adjMatrix[i][j] == 1 && this.adjMatrix[j][i] == 1)
                System.out.println("There's already an edge between nodes " + i + " and " + j);
            else if (i == j)
                System.err.println("It's not possible to add an edge from a node to itself in an undirected graph.");
            else {
                this.adjMatrix[i][j] = 1;
                this.adjMatrix[j][i] = 1;
            }
        } else {
            if (this.adjMatrix[i][j] == 1)
                System.out.println("There's already an edge between nodes " + i + " and " + j);
            else
                this.adjMatrix[i][j] = 1;
        }
    }

    public void removeEdge(int i, int j) {
        if (this.getType() == MyGraphTypes.UNDIRECTED) {
            if (this.adjMatrix[i][j] == 0 && this.adjMatrix[j][i] == 0)
                System.err.println("There's no edge between nodes " + i + " and " + j);
            else if (i == j)
                System.err.println("Edge from a node to itself are not present by default in an undirected graph.");
            else {
                this.adjMatrix[i][j] = 0;
                this.adjMatrix[j][i] = 0;
            }
        } else {
            if (this.adjMatrix[i][j] == 0)
                System.err.println("There's no edge between nodes " + i + " and " + j);
            else
                this.adjMatrix[i][j] = 0;
        }
    }

    public void printGraph() {
        if (this.getType() == MyGraphTypes.UNDIRECTED) {
            for (int i = 0; i < this.adjMatrix.length; i++)
                for (int j = 0; j < this.adjMatrix[i].length; j++)
                    if (this.adjMatrix[i][j] == 1 && this.adjMatrix[j][i] == 1)
                        System.out.println(i + "----" + j);
        } else  {
            for (int i = 0; i < this.adjMatrix.length; i++)
                for (int j = 0; j < this.adjMatrix[i].length; j++)
                    if (this.adjMatrix[i][j] == 1)
                        System.out.println(i + "--->" + j);
        }
        System.out.println("\n");
    }
}
