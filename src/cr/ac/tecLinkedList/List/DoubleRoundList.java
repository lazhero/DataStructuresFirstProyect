package cr.ac.tecLinkedList.List;

import cr.ac.tecLinkedList.Nodes.DoubleNode;

public class DoubleRoundList<T> {
    private DoubleNode<T> head,tail;
    int length;
    public DoubleRoundList(){
        head=tail=null;
        length=0;
    }
    public void AddHead(T NewInfo){
       DoubleNode<T> temp=new DoubleNode<>(NewInfo);
       if(head==null){
           temp.setBack(temp);
           temp.setFront(temp);
           head=tail=temp;

       }
       else {
           head.setBack(temp);
           temp.setFront(head);
           temp.setBack(tail);
           tail.setFront(temp);
           head = temp;
       }
       length++;

    }
    public void AddTail(T Newinfo){
        DoubleNode<T> temp=new DoubleNode<T>(Newinfo);
        if(head==null){
            temp.setFront(temp);
            temp.setBack(temp);
            head=tail=temp;
        }
        else {
            tail.setFront(temp);
            temp.setBack(tail);
            temp.setFront(head);
            head.setBack(temp);
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
            head.setBack(tail);
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
            tail.setFront(head);
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
        for(temp=head;temp.getFront()!=head && flag; temp=temp.getFront()){
            if(temp.getInfo()==info)flag=false;
        }
        if(!flag || tail.getInfo()==info)returning=true;
        return returning;
    }
    public void printing(){
        DoubleNode<T> Temp;
        for(Temp=head;Temp.getFront()!=head;Temp=Temp.getFront()){
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

    public void printing8(){
        DoubleNode<T> Temp=head;
        while(true){
            System.out.println(Temp.getInfo());
            Temp=Temp.getFront();
        }
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


}
