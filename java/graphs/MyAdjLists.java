package graphs;

import java.util.LinkedList;
import java.util.ArrayList;

import basicDS.MyLinkedList;
import basicDS.MyQueue;

public class MyAdjLists extends MyGraph{
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

    public Integer BFS() {
        MyQueue<Integer> q = new MyQueue<>();
        MyLinkedList<Integer> list = new MyLinkedList<>();
        return 0;
    }
}
