package graphs;/*
* @author Matteo Huang
* Implementation of graphs based on both adjacency matrix and
* adjacency lists representations.
*
* Given a graph G, V is the set of its nodes (or vertexes)
* and E is the set of its edges.
*
*/

public class MyGraph {
    /*
     * |V| = n; the number of nodes
     */
    private int n;
    /*
     * |E| = m; the number of nodes
     */
    private int m;

    private int minEdges;

    private int maxEdges;

    private MyGraphTypes type;

    public MyGraph(String graphType) {
        this.n = 0;
        this.m = 0;
        this.type = MyGraphTypes.valueOf(graphType);
    }

    /*
    * Returns the number of nodes
    * @parameter void
    * @return n
    */
    public int getV() {
        return this.n;
    }

    /*
     * Returns the number of edges
     *
     * @parameter void
     * @return m
     */
    public int getE() {
        return this.m;
    }


    public MyGraphTypes getType() {
        return this.type;
    }

    public void calculateMinMaxEdges() {
        this.minEdges = 0;
        if (this.type == MyGraphTypes.UNDIRECTED)
            maxEdges = (n*(n-1))/2;
        else
            maxEdges = n^2;
    }

    public void graphProperty() {
        /* G is dense if m is close to either n^2 (if G is directed) or
         * ((n(n-1))/2 (if G is undirected), which doesn't make sense
         * mathematically speaking. G is sparse otherwise.
         */
    }
}
