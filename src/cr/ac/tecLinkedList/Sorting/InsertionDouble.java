package cr.ac.tecLinkedList.Sorting;

import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.List.List;
import cr.ac.tecLinkedList.List.Sorting;
import cr.ac.tecLinkedList.Nodes.DoubleNode;

public class InsertionDouble<T extends Comparable>  implements Sorting<T> {
    private DoubleList<T> List;




    private DoubleNode FindSort(){
        if(List==null || List.getLength()<=0)return null;
        DoubleNode<T> temp=List.getNode(0);
        while(temp.getFront()!=null && temp.getInfo().compareTo(temp.getFront().getInfo())<0){
            temp=temp.getFront();
        }

        return temp;
    }


    @Override
    public void sort() {
        if (List != null && List.getLength() > 0) {
            DoubleNode<T> temp=FindSort();
            DoubleNode<T> tail=List.getNode(List.getLength()-1);
            DoubleNode<T> Changing;
            T backup;
            while(temp!=tail){

                backup=tail.getInfo();
                for(Changing=findPlace(tail,temp);Changing!=null;Changing=Changing.getFront()){
                    T Course=Changing.getInfo();
                    Changing.setInfo(backup);
                    backup=Course;

                }
                temp=temp.getFront();
                tail=List.getNode(List.getLength()-1);
            }


        }
    }
    public DoubleNode<T> findPlace(DoubleNode<T> comparing,DoubleNode<T> reference){
        if(comparing==null || reference==null) return null;
        DoubleNode<T> temp;
        for(temp=List.getNode(0);temp.getFront()!=null && comparing.getInfo().compareTo(temp.getInfo())>0 && temp!=reference.getFront();temp=temp.getFront()){

        }
        return temp;
    }
    @Override
    public void setList(List<T> List){
        try{
            this.List=(DoubleList<T>)List;
        }
        catch (Exception e){
            this.List=null;
        }
    }
}
