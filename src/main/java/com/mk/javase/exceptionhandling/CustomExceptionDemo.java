package com.mk.javase.exceptionhandling;

class DividedByZeroException extends Exception {
    DividedByZeroException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    static int div1(int a, int b) throws DividedByZeroException {
        if (b == 0) {
            throw new DividedByZeroException("Divisor is zero");
        }
        return a / b;
    }

    static int method() {
        try {
            return div1(2, 0);
        } catch (DividedByZeroException de) {// if catch with RuntimeException the catch block not working because java not catch the Runtime Exception
            return 5;
        } finally {
            return 0;
        }
    }

    public static void main(String[] args) {
        int result = method(); // output is 0 because exception occur return 5 but finally is 0, highest priority finally is override
        // Eg. Staff make decision , Manager make decision, CEO make decision -> CEO decision is highest decision

        System.out.println(result);
    }
}
