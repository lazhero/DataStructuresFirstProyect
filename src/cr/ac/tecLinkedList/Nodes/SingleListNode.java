package cr.ac.tecLinkedList.Nodes;

public class SingleListNode<T> {
    private T info;
    private SingleListNode<T> Nextnode;
    public SingleListNode(){
        this(null,null);

    }
    public SingleListNode(T container, SingleListNode<T> Reference){
        info=container;
        Nextnode=Reference;
    }
    public SingleListNode(T container){
        this(container,null);
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setNextnode(SingleListNode<T> nextnode) {
        Nextnode = nextnode;
    }

    public T getInfo() {
        return info;
    }

    public SingleListNode<T> getNextnode() {
        return Nextnode;
    }
}
