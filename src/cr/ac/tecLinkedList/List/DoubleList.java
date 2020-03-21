package cr.ac.tecLinkedList.List;

import cr.ac.tecLinkedList.Nodes.DoubleNode;
import cr.ac.tecLinkedList.Nodes.SingleListNode;

import java.time.temporal.Temporal;

public class DoubleList<T> {
    private DoubleNode<T> head,tail;
    public DoubleList(){
        head=tail=null;
    }
    public void AddHead(T NewInfo){
       DoubleNode<T> temp=new DoubleNode<>(NewInfo);
       if(head==null){
           head=tail=temp;
       }
       else {
           head.setBack(temp);
           temp.setFront(head);
           head = temp;
       }

    }
    public void AddTail(T Newinfo){
        DoubleNode<T> temp=new DoubleNode<T>(Newinfo);
        if(head==null){
            head=tail=temp;
        }
        else {
            tail.setFront(temp);
            temp.setBack(tail);
            tail=temp;
        }

    }
    public T DeleteFromHead(){
        if(this.isEmpty()){
            return null;
        }
        T info=head.getInfo();
        if(head==tail){
            head=tail=null;
            return info;
        }
        else{
            head=head.getFront();
            head.setBack(null);
            return info;
        }
    }
    public T DeleteFromTail(){
        if(this.isEmpty()){
            return null;
        }
        T info=tail.getInfo();
        if(tail==head){
            tail=head=null;
            return info;
        }
        else{
            tail=tail.getBack();
            tail.setFront(null);
            return info;
        }

    }


    public boolean isEmpty(){
        boolean returning=false;
        if(head==null){
            returning=true;
        }
        return returning;
    }
    public boolean inList(T info){
        boolean returning=false;
        if(head==null)return returning;
        DoubleNode<T> temp;
        boolean flag=true;
        for(temp=head;temp.getFront()!=null && flag; temp=temp.getFront()){
            if(temp.getInfo()==info)flag=false;
        }
        if(!flag || tail.getInfo()==info)returning=true;
        return returning;
    }
    public void printing(){
        DoubleNode<T> Temp;
        for(Temp=head;Temp.getFront()!=null;Temp=Temp.getFront()){
            System.out.println(Temp.getInfo());
        }
        System.out.println(tail.getInfo());
    }
    public void printingB(){
        DoubleNode<T> Temp;
        for(Temp=tail;Temp.getBack()!=null;Temp=Temp.getBack()){
            System.out.println(Temp.getInfo());
        }
        System.out.println(head.getInfo());

    }
}