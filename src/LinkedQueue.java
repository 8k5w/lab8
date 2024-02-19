import java.util.LinkedList;

public class LinkedQueue <E> implements Queue<E>{
    LinkedList<E> l= new LinkedList<>();


    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        l.addFirst(e);
    }

    @Override
    public E dequeue() {
        return l.removeLast();
    }

    @Override
    public E first() {
        return l.getLast();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void concatenate(LinkedQueue<E> clone) {
        if (clone.isEmpty()) {
            return;
        }
        if (this.isEmpty()) {
            l = clone.l;
        } else {
            Node<E> lastNode = l.getLast();
            lastNode.next = clone.l.getFirst();
        }
        l.size += clone.size();}
}
