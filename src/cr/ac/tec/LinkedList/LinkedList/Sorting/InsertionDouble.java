package cr.ac.tec.LinkedList.LinkedList.Sorting;

import cr.ac.tec.LinkedList.LinkedList.List.DoubleList;
import cr.ac.tec.LinkedList.LinkedList.List.List;
import cr.ac.tec.LinkedList.LinkedList.List.Sorting;
import cr.ac.tec.LinkedList.LinkedList.Nodes.DoubleNode;

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
        for(int i=0;i<List.getLength();i++){
            T temp;
            int p=i;
            while(p>0 && List.get(p).compareTo(List.get(p-1))<0){
                temp=List.get(p);
                List.getNode(p).setInfo(List.get(p-1));
                List.getNode(p-1).setInfo(temp);
                p--;
            }
        }
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
