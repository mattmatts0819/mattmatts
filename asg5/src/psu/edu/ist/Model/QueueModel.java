package psu.edu.ist.Model;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
public class QueueModel <T> {

    private Queue source;

    public QueueModel() {
        this.source = new LinkedList();
    }


    /**
     * Method used to add an element to the source queue.
     * runtime: O(1)
     * @param element generic element to be added
     */
    public void enqueue(T element){
        source.add(element);
    }

    /**
     * Method used to remove and turn the first element of the queue
     * runtime: O(1)
     * @return element at the front of the queue
     */
    public T dequeue(){
        return (T) source.poll();
    }

    /**
     * Method used to return first element of the queue
     * runtime: O(1)
     * @return element at the front of the queue
     */
    public T peekFront(){
        return (T) source.peek();
    }

    /**
     * method used to return the last element of the queue
     * runtime: O(N)
     * @return element at the rear of the queue
     */
    public T peekRear(){
        Queue<T> temp = new LinkedList<>();
        temp.addAll(source);  // copy of original queue to modify
        T ret = null;
        while(!temp.isEmpty()){
            ret = temp.remove();
        }
        return ret;
    }

    /**
     * method used to return the whole queue
     * runtime: O(1)
     * @return whole source queue
     */
    public Queue getWrappedQueue(){
        return this.source;
    }

    /**
     * method used to clear all contents of the queue
     * runtime: O(1)
     */
    public void clear(){
        source.clear();
    }

    /**
     * setter method used to set the contents of the queue after the undo button is pressed
     * runtime: O(1)
     * @param source queue taken from top of stack
     */
    public void setSource(Queue source) {
        this.source = source;
    }

    /**
     * creates printable string of all queue contents
     * @return String containing all queue contents
     */
    @Override
    public String toString() {
        return this.source.toString();
    }
}
