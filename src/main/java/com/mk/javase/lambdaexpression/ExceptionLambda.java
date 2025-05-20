package com.mk.javase.lambdaexpression;
/*
    need to throw and catch the same exception that throw in FP
 */
class EmptyArrayException extends Exception{
    EmptyArrayException(){
        System.out.println("Array Empty.");
    }
}
interface DoubleNumericArrayFun{
    double func(double[] values) throws EmptyArrayException; // here
}
public class ExceptionLambda {
    public static void main(String[] args) {
        double[] values = {0.1, 2.3, 5.6, 8.5, 3.4};
        DoubleNumericArrayFun fun = (double[] vals) ->{
            double sum = 0;
            if(vals.length == 0){
                throw new EmptyArrayException(); // here
            }else {
                for(Double d : vals){
                    sum += d;
                }
            }
            return sum;
        };
        double empty[] = {};
        try {
            System.out.println("Sum : "+ fun.func(values));
            System.out.println("Sum Empty: "+ fun.func(empty));
        } catch (EmptyArrayException e) { // here
            e.printStackTrace();
        }
    }
}
