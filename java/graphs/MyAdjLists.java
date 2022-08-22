package graphs;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

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

    // Correct
    public void breadthFirstSearch(int node) {
        MyQueue<Integer> q = new MyQueue<>();
        int[] visited = new int[this.adjList.size()];

        q.enqueue(node);
        visited[node] = 1;
        for (int i : visited)
            if (i != node)
                visited[i] = 0;

        while (!q.isEmpty()) {
            int v = q.head();
            int vIndex = 0;
            // Gets the index of v
            for (int i = 0; i < this.adjList.size(); i++)
                if (this.adjList.get(i).get(0) == v)
                    vIndex = i;
            LinkedList<Integer> tmp = this.adjList.get(vIndex);

            q.dequeue();
            System.out.println( v + " visited");
            for (int i = 0; i < tmp.size(); i++) {
                if (visited[tmp.get(i)] == 0){
                    q.enqueue(tmp.get(i));
                    visited[tmp.get(i)] = 1;
                }
            }
        }
    }

    public void depthFirstSearch() {

    }
}
