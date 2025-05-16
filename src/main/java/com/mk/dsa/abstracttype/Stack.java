package com.mk.dsa.abstracttype;
/*
    Arrange -> initiate array
    Act
    Assert
 */

public class Stack implements IStack{
    int size;
    int[] items;
    int top = -1; // like index no value in array if add value +1 = top 0

    public Stack(int size){
        this.size = size;
        this.items = new int[size];
    }
    @Override
    public void push(int element){
        if(!this.isFull()) { // isFull false -? !false = true -> push / not full so push
            this.items[++top] = element;
        }else{
            throw new StackOverFlowException("Stack is full");
        }
    }
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int pop(){
      //  if(top != -1){ // difficult to read
        if(!isEmpty()){ // isEmpty = !true = false // not Empty -> pop
            return this.items[top--];
        }else {
            throw new StackUnderFlowException("Stack is empty");
        }
    }
    @Override
    public int peek(){ // take a look
        return this.items[top];
    }

    @Override
    public int getSize() {
        return this.top+1;
    }

    // arr[10] -> top 0 - 9 full
   public boolean isFull() {
       // return top == this.items.length -1;
        return top == this.size - 1;
    }
}
