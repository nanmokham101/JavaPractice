package com.mk.javase.generic;
interface MinMax<T extends Comparable<T>>{
    T min();
    T max();
}
class MinMaxImpl<T extends Comparable<T>> implements MinMax<T>{ // <T extends Comparable<T>> -> definition / MainMax<T> -> usage
    T[] items;
    MinMaxImpl(T[] items){
        this.items = items;
    }
    @Override
    public T min() {
        T minElement = this.items[0];
        for(int i = 0; i < this.items.length; i++){
            if(this.items[i].compareTo(minElement) < 0){
                minElement = this.items[i];
            }
        }
        return minElement;
    }

    @Override
    public T max() {
        T maxElement = this.items[0];
        for(int i = 0; i < this.items.length; i++){
            if(this.items[i].compareTo(maxElement) > 0){
                maxElement = this.items[i];
            }
        }
        return maxElement;
    }
}
public class GenericInterface {
    public static void main(String[] args) {
        Integer[] intArr = {3,4,7,8,9};
        MinMaxImpl minMax = new MinMaxImpl(intArr);
        System.out.println("Min Element : "+ minMax.min());
        System.out.println("Max Element : "+ minMax.max());

        String[] strArr = {"Apple", "Banana","Orange"};
        MinMaxImpl minMaxString = new MinMaxImpl(strArr);
        System.out.println("Min String : "+ minMaxString.min());
        System.out.println("Max String : "+ minMaxString.max());
    }
}
