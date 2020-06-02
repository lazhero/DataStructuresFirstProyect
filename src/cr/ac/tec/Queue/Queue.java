package cr.ac.tec.Queue;

import cr.ac.tecLinkedList.List.DoubleList;

public class Queue<T> {
    private DoubleList<T> reference;
    public Queue(){
        reference=new DoubleList<>();
    }
    public void push(T content){
        reference.AddTail(content);
    }
    public T pop(){
        if(!reference.isEmpty()){
            T temp=reference.get(0);
            reference.delete(0);
            return  temp;
        }
        return null;
    }
    public T view(){
        if(!reference.isEmpty()){
            return reference.get(0);
        }
        return null;
    }

}
