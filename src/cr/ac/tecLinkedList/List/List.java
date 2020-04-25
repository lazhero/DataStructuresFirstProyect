package cr.ac.tecLinkedList.List;

import cr.ac.tecLinkedList.Nodes.DoubleNode;

public interface List<T> {
    public abstract void AddHead(T NewInfo);
    public abstract void AddTail(T Newinfo);
    public abstract T DeleteFromHead();
    public abstract T DeleteFromTail();
    public abstract boolean isEmpty();
    public abstract boolean inList(T info);
    public abstract void ChangeContent(int position,T content);

    public abstract T get(int position);
    public abstract void delete(int position);

    public abstract int getLength();
}
