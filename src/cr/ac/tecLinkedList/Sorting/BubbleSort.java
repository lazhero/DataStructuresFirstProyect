package cr.ac.tecLinkedList.Sorting;

import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.Nodes.DoubleNode;

public class BubbleSort {


    void bubbleSort(DoubleList<Integer> list){
        int n = list.getLength();
        for (int i = 0; i < n-1; i++)
            for( int j = 0; j < n-1; j++)
                if (list.getNode(j).getInfo() > list.getNode(j+1).getInfo()){
                    Integer temp = list.getNode(j).getInfo();
                    list.getNode(j).setInfo(list.getNode(j+1).getInfo());
                    list.getNode(j+1).setInfo(temp);
                }
    }

    void printArray(DoubleList<Integer> list){
        int n = list.getLength();
        for (int i=0; i<n; ++i)
            System.out.println(list.getNode(i).getInfo() + " ");
        System.out.println();
    }


    public static void main(String args[]){
        BubbleSort ob = new BubbleSort();

    }


}
