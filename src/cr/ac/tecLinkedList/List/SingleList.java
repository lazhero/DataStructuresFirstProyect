package cr.ac.tecLinkedList.List;

import cr.ac.tecLinkedList.Nodes.SingleListNode;

public class SingleList<T> {
    private SingleListNode<T> head,tail;
    public SingleList(){
        head=tail=null;
    }
    public void AddHead(T NewInfo){
        head=new SingleListNode<T>(NewInfo,head);
        if(tail==null){
            tail=head;
        }
    }
    public void AddTail(T Newinfo){
        if(!this.isEmpty()) {
            tail.setNextnode(new SingleListNode<T>(Newinfo));
            tail = tail.getNextnode();
        }
        else{
            tail=head=new SingleListNode<T>(Newinfo);
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
}
