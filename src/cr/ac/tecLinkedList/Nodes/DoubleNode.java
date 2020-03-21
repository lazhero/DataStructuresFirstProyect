package cr.ac.tecLinkedList.Nodes;

public class DoubleNode<T> {
    private T info;
    private DoubleNode<T> Back;
    private DoubleNode<T> Front;
    public DoubleNode(T info, DoubleNode<T> Back, DoubleNode<T> Front){
        this.Back=Back;
        this.info=info;
        this.Front=Front;
    }
    public DoubleNode(){
        this(null,null,null);
    }
    public DoubleNode(T info){
        this(info,null,null);
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setBack(DoubleNode<T> back) {
        Back = back;
    }

    public void setFront(DoubleNode<T> front) {
        Front = front;
    }

    public T getInfo() {
        return info;
    }

    public DoubleNode<T> getBack() {
        return Back;
    }

    public DoubleNode<T> getFront() {
        return Front;
    }

}
