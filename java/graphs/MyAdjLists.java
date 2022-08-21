package graphs;

import java.util.LinkedList;
import java.util.ArrayList;

import basicDS.MyLinkedList;
import basicDS.MyQueue;

public class MyAdjLists extends MyGraph{
    protected class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    /*
     * LinkedList of Integer LinkedLists
     */
    private ArrayList<LinkedList<Integer>> adjList;

    public MyAdjLists(String type) {
        super(type);
        this.adjList = new ArrayList<>();
    }

    public void addNode(int node) {
        LinkedList<Integer> curr = new LinkedList<>();
        curr.add(node);
        this.adjList.add(curr);
    }
    public void addEdge(int src, int dest) {
        if (this.getType() == MyGraphTypes.UNDIRECTED) {
            for (int i = 0; i < this.adjList.size(); i++) {
                if (this.adjList.get(i).get(0) == src)
                    this.adjList.get(i).add(dest);
                if (this.adjList.get(i).get(0) == dest)
                    this.adjList.get(i).add(src);
            }

        } else {
            for (int i = 0; i < this.adjList.size(); i++)
                if (this.adjList.get(i).get(0) == src)
                    this.adjList.get(i).add(dest);
        }
    }

    public void removeEdge(int src, int dest) {
        if (this.getType() == MyGraphTypes.UNDIRECTED) {
            for (int i = 0; i < this.adjList.size(); i++) {
                if (this.adjList.get(i).get(0) == src)
                    for (int j = 0; i < this.adjList.get(i).size(); j++)
                        if (this.adjList.get(i).get(j) == dest)
                            this.adjList.get(i).remove(j);

                if (this.adjList.get(i).get(0) == dest)
                    for (int j = 0; i < this.adjList.get(i).size(); j++)
                        if (this.adjList.get(i).get(j) == src)
                            this.adjList.get(i).remove(j);
            }

        } else {
            for (int i = 0; i < this.adjList.size(); i++) {
                if (this.adjList.get(i).get(0) == src)
                    for (int j = 0; i < this.adjList.get(i).size(); j++)
                        if (this.adjList.get(i).get(j) == dest)
                            this.adjList.get(i).remove(j);
            }
        }
    }
    public void printGraph() {
        if (this.getType() == MyGraphTypes.UNDIRECTED) {
            for (int i = 0; i < this.adjList.size(); i++)
                for (int j = 1; j < this.adjList.get(i).size(); j++)
                    System.out.println(this.adjList.get(i).get(0) + "----" + this.adjList.get(i).get(j));
        } else {
            for (int i = 0; i < this.adjList.size(); i++)
                for (int j = 1; j < this.adjList.get(i).size(); j++)
                    System.out.println(this.adjList.get(i).get(0) + "--->" + this.adjList.get(i).get(j));
        }
        System.out.println("\n");
    }

    // Shoould be mostly correct
    public void BFS(int node) {
        MyQueue<Integer> q = new MyQueue<>();
        MyLinkedList<Edge> list = new MyLinkedList<>();
        int[] visited = new int[this.adjList.size()];
        q.enqueue(node);
        visited[node] = 1; // visited

        // initializes the visited array
        for (int i = 0; i < this.adjList.size(); i++) {
            int v = this.adjList.get(i).get(0);
            if (v != node)
                visited[v] = 0; // 0 for unvisited nodes
        }

        while (!q.isEmpty()) {
            int v = q.head();
            q.dequeue();
            System.err.println(v + " visited");
            for (int j = 0; j < this.adjList.get(v).size(); j++) {
                int w = this.adjList.get(v).get(j);
                if (visited[w] == 0) {
                    visited[w] = 1; // 1 for visited nodes
                    q.enqueue(w);
                    list.insert(new Edge(v, w), 0); // inserimento in testa
                }
            }
        }
    }

    public void DFS(int v) {
        MyLinkedList<Edge> list = new MyLinkedList<>();
        int[] visited = new int[this.adjList.size()];
        System.err.println(v + " visited");
        visited[v] = 1;
        for (int i = 0; i < this.adjList.get(v).size(); i++) {
            int w = this.adjList.get(v).get(i);
            if (visited[w] == 0) {
                list.insert(new Edge(v, w), 1);
                DFS(w);
            }
        }
    }
}
