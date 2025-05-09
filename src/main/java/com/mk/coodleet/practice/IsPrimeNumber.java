package com.mk.coodleet.practice;

public class IsPrimeNumber {
    public static void main(String[] args) {
        IsPrimeNumber isPrimeNumber = new IsPrimeNumber();
        int num = 15;
        System.out.println("The Prime number between 1 and "+ num + " is ");
        for(int i = 2; i <= num; i++){
            if(isPrimeNumber.isPrime(i)){
                System.out.println(i +" ");
            }
        }
    }
    private boolean isPrime(int num){
        if(num != 2) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
