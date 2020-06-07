package cr.ac.tec.LinkedList.Sorting;
import cr.ac.tec.LinkedList.List.Sorting;
import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.LinkedList.List.List;

public class BubbleSortDouble<T extends Comparable<T>> implements Sorting<T> {
    DoubleList<T> List;

    @Override
    public void sort() {
        if(List!=null && List.getLength()>0){
            int pos=List.getLength()-1;
            while(pos>0){
                T temp;
                for(int i=0;i<pos;i++){
                    if(List.get(i).compareTo(List.get(i+1))>0){
                        temp=List.get(i);
                        List.getNode(i).setInfo(List.get(i+1));
                        List.getNode(i+1).setInfo(temp);
                    }
                }
                pos--;
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
