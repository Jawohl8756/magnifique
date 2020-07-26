package com.wunderbar.BuildModel.IteratorPattern;

/**
 * @author Rommel
 * @date 2020/3/15 21:40
 * @description
 */
public class ConcreteIterator implements Iterator{

    private Collection collection;
    private int pos =-1 ;//当前迭代器遍历到的元素位置

    public ConcreteIterator(Collection collection){
        this.collection=collection;
    }


    public Object previous() {
        if(pos>0){
            pos--;

        }
        return collection.get(pos);
    }

    public Object next() {
        if (pos<collection.size()-1){
            pos++;
        }
        return collection.get(pos);
    }

    public boolean hasNext() {

        if(pos<collection.size()-1){
            return true;

        }else{
            return false;
        }

    }
}
