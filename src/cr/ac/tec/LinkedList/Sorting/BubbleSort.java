package cr.ac.tec.LinkedList.Sorting;

import cr.ac.tec.LinkedList.List.DoubleList;

public class BubbleSort {


    public void bubbleSort(DoubleList<Integer> list){
        int n = list.getLength();
        for (int i = 0; i < n-1; i++)
            for( int j = 0; j < n-1; j++)
                if (list.getNode(j).getInfo() > list.getNode(j+1).getInfo()){
                    Integer temp = list.getNode(j).getInfo();
                    list.getNode(j).setInfo(list.getNode(j+1).getInfo());
                    list.getNode(j+1).setInfo(temp);
                }
    }

    public void printDoubleList(DoubleList<Integer> list){
        int n = list.getLength();
        for (int i=0; i<n; ++i)
            System.out.println(list.getNode(i).getInfo() + " ");
        System.out.println();
    }


    public static void main(String args[]){
        BubbleSort ob = new BubbleSort();
        DoubleList<Integer> list = new DoubleList<>();
        list.AddHead(64);
        list.AddHead(34);
        list.AddHead(25);
        list.AddHead(12);
        list.AddHead(22);
        ob.bubbleSort(list);
        ob.printDoubleList(list);
    }


}
