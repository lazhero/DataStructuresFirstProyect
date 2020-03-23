package cr.ac.tecLinkedList.List;

import cr.ac.tecLinkedList.Nodes.DoubleNode;
import cr.ac.tecLinkedList.Nodes.SingleListNode;

public class SingleList<T> {
    private SingleListNode<T> head,tail;
    int length;
    public SingleList(){
        head=tail=null;
        length=0;
    }
    public void AddHead(T NewInfo){
        head=new SingleListNode<T>(NewInfo,head);
        if(tail==null){
            tail=head;
        }
        length++;

    }
    public void AddTail(T Newinfo){
        if(!this.isEmpty()) {
            tail.setNextnode(new SingleListNode<T>(Newinfo));
            tail = tail.getNextnode();
        }
        else{
            tail=head=new SingleListNode<T>(Newinfo);
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
            return info;
        }
        else{
            head=head.getNextnode();
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
            SingleListNode<T> tmp;
            for (tmp=head;tmp.getNextnode()!=tail;tmp=tmp.getNextnode());
            tail=tmp;
            tail.setNextnode(null);
            return info;
        }

    }
    public T DeleteMiddleNode(T info){
        if(isEmpty()) return null;
        T returning=null;
        if(head==tail){
            if(info==head.getInfo()){
                head=tail=null;
                return info;
            }
            else{
                return null;
            }
        }
        SingleListNode<T> Temp;
        for(Temp=head;Temp.getNextnode().getInfo()!=info;Temp=Temp.getNextnode());
        Temp.setNextnode(Temp.getNextnode().getNextnode());
        return info;
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
        if(head==null){
            return false;
        }
        SingleListNode<T> temp;
        for(temp=head;temp!=null && !returning;temp=temp.getNextnode()){
            if(temp.getInfo()==info) returning=true;
        }
        return returning;
    }
    public void printing(){
        SingleListNode<T> temp;
        for(temp=head;temp!=null;temp=temp.getNextnode()){
            System.out.println(temp.getInfo());
        }
    }
    public T get(int position){
        if(position>-1 && position<length){
            if(position==0)return head.getInfo();
            if(position==length-1)return tail.getInfo();
            SingleListNode<T> temp=head.getNextnode();
            for(int i=1;i!=position;i++){
                temp=temp.getNextnode();
            }
            return temp.getInfo();
        }
        else return null;
    }
    public void delete(int position){
        if(position>-1 && position<length){
            if(position==0)this.DeleteFromHead();
            if(position==length-1)this.DeleteFromTail();
            else{
                SingleListNode<T> temp=head;
                for(int i=0;i!=position-1;i++){
                    temp=temp.getNextnode();
                }
                temp.setNextnode(temp.getNextnode().getNextnode());
            }
            length--;
        }
    }
    public int FindFirstInstancePosition(T value){
        if(!this.isEmpty()){
            SingleListNode<T> temp;
            int i=-1;
            for(temp=head;temp.getNextnode()!=null;temp=temp.getNextnode()){
                i++;
                if(temp.getInfo()==value)return i;
            }
            if(tail.getInfo()==value)return length-1;
        }
        return -1;
    }
    public int getLength(){
        return length;
    }
}
