package cr.ac.tec.LinkedList.LinkedList.Sorting;

import cr.ac.tec.LinkedList.LinkedList.List.DoubleList;
import cr.ac.tec.LinkedList.LinkedList.List.Sorting;
import cr.ac.tec.LinkedList.LinkedList.Nodes.DoubleNode;
import cr.ac.tec.LinkedList.LinkedList.List.List;

public class SelectionSortDouble<T extends Comparable> implements Sorting<T> {
    private DoubleList<T> List;
    @Override
    public void sort() {
        if(List!=null && List.getLength()>0){
            int min;
            for(int i=0;i<List.getLength();i++){                                                    min=getMin(List,i);
                Swap(i,min);
            }

        }

    }

    @Override
    public void setList(List<T> List) {
        try{
           this.List=(DoubleList<T>)List;
        }
        catch (Exception e){
            this.List=null;
        }

    }
   private int getMin(DoubleList<T> toGet,int pos){
        if(toGet==null || toGet.getLength()<=0 || pos>=toGet.getLength())return -1;
        int p=pos;
        DoubleNode<T> temp=toGet.getNode(pos);
        for(int i=pos;i<toGet.getLength();i++){
            if(toGet.get(i).compareTo(temp.getInfo())<0){
                p=i;
                temp=toGet.getNode(i);
            }
        }
        return p;
    }
    private void Swap(int First, int Second){
        if(First<List.getLength() && Second<List.getLength()){
            T info=List.get(First);
            List.getNode(First).setInfo(List.get(Second));
            List.getNode(Second).setInfo(info);
        }
    }


}
