package basicDS;/*
* @author Matteo Huang
* My implementation of the concatenated list data structure
*/

public class MyLinkedList<Item> {
    /*
    * represents the head of the list
    */
    private Node first;

    /*
    * represents the list's length
    */
    private int N;

    /*
    * the class Node represents a single node, which has
    * as fields an item of a generic type Item and a reference
    * of type Node to the next node
    */
    private class Node {
        Item item;
        Node next;
    }

    /*
    * the method isEmpty() checks whether the list is empty
    * Time complexity: O(1) = Θ(1) = Ω(1)
    * @param void
    * @return first == null the state of the list
    */
    public boolean isEmpty(){
        return first == null;
    }

    /*
    * the method length() returns the list's length
    * Time Complexity: O(1) = Θ(1) = Ω(1)
    * @param void
    * @return N the size of the list
    */
    public int length(){
        return N;
    }

    /*
     * the method insert() inserts an element at position i
     * Time Complexity: O(1); Θ(n); Ω(n)
     * @param item element to insert
     * @param i insertion index
     */
    public void insert(Item item, int i){
        Node prev = first;
        Node node = new Node();
        node.item = item;
        if (i == 0) {
            first = node;
            first.next = null;
        }
        else {
            for (int j = 0; i < j; j++) {
                prev = prev.next;
            }
            if(prev == null) {
                prev = node;
                prev.next = null;
            } else {
                node.next = prev.next;
                prev.next = node;
            }
        }
        N++;
    }

    /*
     * the method delete() deletes an element at position i
     * Time Complexity: O(1); Θ(n); Ω(n)
     * @param i deletion index
     */
    public void delete(int i){
        Node prev = first;
        Node curr = first;
        if (N == 0) return;
        else {
            for (int j = 0; j < i; j++) {
                curr = prev;
                prev = prev.next;
            }
            if (prev.next == null)
                prev = null;
            else {
                curr.next = prev.next;
            }
        }
        N--;
    }

    /*
     * the method printList() prints the list
     * Time Complexity: O(1); Θ(n); Ω(n)
     * @param void
     */
    public void printList(){
        Node node = first;
        int i = 0;
        while(node != null) {
            System.out.println(i++ + " " + node.item);
            node = node.next;
        }
    }
}
