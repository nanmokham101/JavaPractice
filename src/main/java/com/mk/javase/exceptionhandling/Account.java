package com.mk.javase.exceptionhandling;
/*
    send money A -> B
    try{
    a.debit() -
    b.credit() + // + after debit success
    }catch(InvalidOperationException ie){ // if b.credit() exception occur (Network issue)
        a.credit() // + to A account
    }
 */
class BusinessLogicException extends Exception{ // if not need to check or unimportant -> extend RuntimeException
    BusinessLogicException(String message){
        super(message);
    }
}
public class Account {
    int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    void credit(int amount) throws BusinessLogicException { // +
        if(amount >0){
            this.balance += amount;
            System.out.println("Balance is "+ this.balance);
        }else{
            throw new BusinessLogicException("Amount is less than 0");
        }
    }
    void debit(int amount) throws BusinessLogicException { // -
        if(amount > 0 && this.balance >= amount){
            this.balance -= amount;
            System.out.println("Balance is "+ this.balance);
        }else{
            throw new BusinessLogicException("Amount is less than 0 and balance not enough");
        }
    }

    public static void main(String[] args) {
        Account A = new Account();

        try {
            A.credit(100);
            A.debit(1000);

        } catch (BusinessLogicException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Balance is "+ A.balance);

    }
}
