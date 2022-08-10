/*
 * @author Matteo Huang
 * My implementation of the queue data structure
 */

public class MyQueue <Item>{

    /*
    * Represents the head of the queue
    */
    private Node first;

    /*
    * Represents the tail of the queue
    */
    private Node last;

    /*
    * Represents the size of the queue
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
     * the method isEmpty() checks whether the stack is empty
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return first == null the state of the queue
     */
    public boolean isEmpty() {
        return first == null;
    }

    /*
     * the method size() checks whether the stack is empty
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return top == null the state of the stack
     */
    public int size(){
        return N;
    }

    /*
     * the method head() returns the head of the queue
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return first.item the head's item
     */
    public Item head() {
        if (isEmpty()) return null;
        return first.item;
    }

    /*
     * the method tail() returns the tail of the queue
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return tail.item the tail's item
     */
    public Item tail() {
        if (isEmpty()) return null;
        return last.item;
    }

    /*
     * the method enqueue() adds a new node to the queue
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param item represents the new frame's content
     */
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (first == null) {
            first = node;
            last = first;
        }
        else {
            last.next = node;
            last = last.next;
        }
        N++;
    }

    /*
     * the method dequeue() pops the head of the queue
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param item represents the new frame's content
     * @return item the popped item
     */
    public Item dequeue() {
        Item item = first.item;
        if (N == 1) first = null;
        else {
            first = first.next;
        }
        N--;
        return item;
    }

    /*
     * the method printQueue() prints the queue
     * Time complexity: O(1); Θ(n); Ω(n)
     * @param void
     */
    public void printQueue() {
        Node curr = first;
        while (curr != null) {
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
