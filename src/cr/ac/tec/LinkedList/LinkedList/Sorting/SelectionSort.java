package cr.ac.tec.LinkedList.LinkedList.Sorting;

/**

public class SelectionSort<T extends Comparable> implements Sorting {


    //private ArrayList<Integer> inputArray = new ArrayList<Integer>();
    @Override
    public void sort(DoubleList List) {
        int smallInt = 0;
        int smallIntIndex = 0;

        for(int i=1;i<List.getLength();i++){
            smallInt = (int) List.get( i-1);
            smallIntIndex = i-1;
            for(int j=i;j<List.getLength();j++){
                if((int) List.get(j)<smallInt){
                    smallInt =(int) List.get(j);
                    smallIntIndex = j;
                }
            }
            swap(i-1, smallIntIndex);
        }

    }

    public SelectionSort(ArrayList<Integer> inputArray){
        this.inputArray= inputArray;
    }
    public void swap(int sourceIndex,int destIndex){
        int temp = List.get(destIndex);
        inputArray.set(destIndex, inputArray.get(sourceIndex));
        inputArray.set(sourceIndex, temp);

    }
    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

}
*/