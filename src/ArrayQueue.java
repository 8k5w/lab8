public class ArrayQueue <E>implements Queue<E>, Cloneable{
    private  E data[];
    private int sz=0;
    private int f=0;
    public ArrayQueue(int cap)
    {
        data= (E[])new Object[cap];
    }
    @Override
    public int size() {
        return sz;
    }

    @Override
    public boolean isEmpty() {
        return sz==0;
    }

    @Override
    public void enqueue(E e) {
        if (size()== data.length)
            throw new IllegalStateException("Queue is full");
        int x=(f+sz)% data.length;
        data[x]=e;
        sz++;


    }

    @Override
    public E dequeue() {
        if (isEmpty())return null;
        E deleted=data[f];
        data[f]=null;
        f=(f+1)% data.length;
        sz--;
        return deleted;
    }

    @Override
    public E first() {
        if (isEmpty())return null;
        return data[f];
    }
@Override
public ArrayQueue<E> clone() {
        try {
        ArrayQueue<E> clonedQueue = (ArrayQueue<E>) super.clone();
        clonedQueue.data = data.clone();
        return clonedQueue;
        } catch (CloneNotSupportedException e) {
        throw new InternalError(e);
        }
        }


}
