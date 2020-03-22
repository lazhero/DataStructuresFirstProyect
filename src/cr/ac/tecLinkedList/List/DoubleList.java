package cr.ac.tecLinkedList.List;

import cr.ac.tecLinkedList.Nodes.DoubleNode;
import cr.ac.tecLinkedList.Nodes.SingleListNode;

import java.time.temporal.Temporal;

public class DoubleList<T> {
    private DoubleNode<T> head,tail;
    int length;
    public DoubleList(){
        head=tail=null;
        length=0;
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
       length++;

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
        length++;

    }
    public T DeleteFromHead(){
        if(this.isEmpty()){
            return null;
        }
        T info=head.getInfo();
        if(head==tail){
            head=tail=null;
            length--;
            return info;
        }
        else{
            head=head.getFront();
            head.setBack(null);
            length--;
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
            length--;
            return info;
        }
        else{
            tail=tail.getBack();
            tail.setFront(null);
            length--;
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
    public void delete(int position){
        if(position>-1 && position<length){
            if(position==0)this.DeleteFromHead();
            if(position==length-1)this.DeleteFromTail();
            else {
                DoubleNode<T> temp = head.getFront();

                for (int i = 1; i != position; i++) {
                    temp = temp.getFront();
                }
                temp.getBack().setFront(temp.getFront());
                temp.getFront().setBack(temp.getBack());
            }
            length--;
        }
    }
    public int FindFirstInstancePosition(T value){
        if(!this.isEmpty()){
            DoubleNode<T> temp;
            int i=-1;
            for(temp=head;temp.getFront()!=null;temp=temp.getFront()){
                i++;
                if(temp.getInfo()==value)return i;
            }
            if(tail.getInfo()==value)return length-1;
        }
        return -1;
    }
    public T get(int position){
        if(position>-1 && position<length){
            if(position==0)return head.getInfo();
            if(position==length-1)return tail.getInfo();
            DoubleNode<T> temp=head.getFront();
            for(int i=1;i!=position;i++){
                temp=temp.getFront();
            }
            return temp.getInfo();

        }
        return null;
    }
    public void printingB(){
        DoubleNode<T> Temp;
        for(Temp=tail;Temp.getBack()!=null;Temp=Temp.getBack()){
            System.out.println(Temp.getInfo());
        }
        System.out.println(head.getInfo());

    }
}
