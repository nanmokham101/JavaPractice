package com.mk.javase.generic;

import java.time.LocalDate;

/*
    Allow the Hierarchy type not allow the other tye
    Number -> int, long, double, float
 */
class State<T extends Number>{ // <T extend MyClass & MyInterface
    T[] items;
    State(T[] items){
        this.items = items;
    }
    double average(){
        double sum = 0;
        for(int i = 0; i < this.items.length; i++){
            sum += this.items[i].doubleValue(); // can't assign to double
        }
        return sum/this.items.length;
    }
    // Wildcard type -> extend Number and allow to be Integer and Double
    boolean sameAverage(State<?> state){
        return this.average() == state.average();
    }
}
public class BoundedType {
    public static void main(String[] args) {
        State<Integer> state = new State(new Integer[]{1,2,3,4,5});
        System.out.println("Average Integer : "+ state.average());

        Double[] doubles = new Double[]{1.0,1.6,5.6};
        State<Double> doubleState = new State(doubles);
        System.out.println("Average Double : "+ doubleState.average());

        Long[] longs = new Long[]{1L,6L,5L};
        State<Long> longState = new State(longs);
        System.out.println("Average Long : "+ longState.average());

       // String[] strings = new String[]{"A","B","C"}; not working
        //State<String> stringState = new State(strings);

        // Wildcard type allow the Integer and Double type that extend Number want to allow 2 type for sameAverage
        // Want to Compare with different type
        System.out.println("Average same : "+ state.sameAverage(doubleState));
    }
}
