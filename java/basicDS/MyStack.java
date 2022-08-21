package basicDS;/*
 * @author Matteo Huang
 * My implementation of the stack data structure
 */

public class MyStack <Item>{

    /*
    * Represents the top frame
    */
    private Node top;

    /*
    * Size of the stack
    */
    private int N;

    /*
     * the class Node represents a single frame, which has
     * as fields an item of a generic type Item and a reference
     * of type Node to the next frame
     */
    private class Node {
        Item item;
        Node next;
    }

    /*
    * the method isEmpty() checks whether the stack is empty
    * Time complexity: O(1) = Θ(1) = Ω(1)
    * @param void
    * @return top == null the state of the stack
    */
    public boolean isEmpty() {
        return top == null;
    }

    /*
     * the method size() returns the stack's size
     * Time Complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return N the size of the stack
     */
    public int size(){
        return N;
    }

    /*
     * the method top() returns the top frame
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return top.item the top frame's item
     */
    public Item top(){
        if (isEmpty()) return null;
        return top.item;
    }

    /*
     * the method push() pushes a new frame into the stack
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param item represents the new frame's content
     */
    public void push(Item item){
        Node oldfirst = top;
        top = new Node();
        top.item = item;
        top.next = oldfirst;
        N++;
    }

    /*
     * the method pop() pops the top frame from the stack
     * Time complexity: O(1) = Θ(1) = Ω(1)
     * @param void
     * @return item the popped frame's item
     */
    public Item pop(){
        if (isEmpty()) return null;
        Item item = top.item;
        top = top.next;
        N--;

        return item;
    }

    /*
     * the method printStack() prints all the stack's content
     * Time complexity: O(1); Θ(n); Ω(n)
     * @param void
     */
    public void printStack(){
        if (isEmpty()) return;
        Node node = top;
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }
}
