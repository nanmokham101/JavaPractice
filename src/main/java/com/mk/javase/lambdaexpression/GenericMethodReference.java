package com.mk.javase.lambdaexpression;
interface MinMaxFun<T extends Number>{
    T minMaxMethod(T[] items);
}
class Min<T extends Number>{
    T min(T[] items){
        T minElement = items[0];
        for(int i = 0; i < items.length; i++){
            if(minElement.doubleValue() > items[i].doubleValue()){ // 4 > 3
                minElement = items[i];
            }
        }
        return minElement;
    }
}
class Max<T extends Number>{
    T max(T[] items){
        T maxElement = items[0];
        for(int i = 0; i < items.length; i++){
            if(items[i].doubleValue() > maxElement.doubleValue()){ // 4 > 3
                maxElement = items[i];
            }
        }
        return maxElement;
    }
}
public class GenericMethodReference {
    public static void main(String[] args) {
        Integer[] intArr = {0,-1,3,5,6};
        Double[] doubleArr = {9.0, 6.8, 5.7,2.2};

        Min<Integer> minObj = new Min<>();
        MinMaxFun<Integer> fun = minObj::min; // method reference
        System.out.println("Min element : "+ fun.minMaxMethod(intArr));

        Max<Double> maxObjDouble = new Max<>();
        MinMaxFun<Double> fun1 = maxObjDouble::max; // method reference
        System.out.println("Max element : "+ fun1.minMaxMethod(doubleArr));
    }
}
