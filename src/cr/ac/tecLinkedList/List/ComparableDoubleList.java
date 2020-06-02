package cr.ac.tecLinkedList.List;

public class ComparableDoubleList<T extends Comparable> extends DoubleList<T> {
    private Sorting sortingMethod;
    public ComparableDoubleList(){
    }
    public void sort(){
        if(sortingMethod!=null) {
            sortingMethod.sort();
        }
    }
    public void setSortingMethod(Sorting sortingMethod){
        this.sortingMethod=sortingMethod;
        this.sortingMethod.setList(this);
    }
}
