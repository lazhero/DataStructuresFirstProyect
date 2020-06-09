package cr.ac.tec.Stack;

import cr.ac.tec.LinkedList.List.DoubleList;

public class Stack<T> {
    private DoubleList<T> reference;

    /**
     *
     */
    public Stack(){
        reference=new DoubleList<>();
    }

    /**
     *
     * @param content
     */
    public void push(T content){
        reference.AddHead(content);
    }

    /**
     *
     * @return
     */
    public T pop(){
        if(!reference.isEmpty()){
            T temp=reference.get(0);
            reference.delete(0);
            return  temp;
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T view(){
        if(!reference.isEmpty()){
            return reference.get(0);
        }
        return null;
    }
}
