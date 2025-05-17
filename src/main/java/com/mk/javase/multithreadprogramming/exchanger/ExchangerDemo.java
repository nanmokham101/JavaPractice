package com.mk.javase.multithreadprogramming.exchanger;

import java.util.concurrent.Exchanger;

/*
    Chat messages
    one type -> send -> arrived
    other -> get -> reply
 */
class StringProducer extends Thread {
    String str;
    Exchanger<String> exchanger;

    StringProducer(Exchanger<String> exchanger) {
        this.str = "";
        this.exchanger = exchanger;
    }

    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) { // 3 times exchange
            for (int j = 0; j < 5; j++) { // 5 chr per 1 time  = 15 char
                str += ch++; // concat str = A,B,C,...
            }
            try {
                str = this.exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StringConsumer extends Thread {
    String str;
    Exchanger<String> exchanger;

    StringConsumer(Exchanger<String> exchanger) {
        this.str = "";
        this.exchanger = exchanger;
    }

    public void run() {
        for (int i = 0; i < 3; i++) { // 3 times exchange so need to catch 3 time
            try {
                str = this.exchanger.exchange(new String());
                System.out.println("Received String : "+ str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ExchangerDemo {
    public static void main(String[] args) {
        var exchanger = new Exchanger<String>();
        var producerStr = new StringProducer(exchanger);
        var consumerStr = new StringConsumer(exchanger);
        producerStr.start();
        consumerStr.start();
    }
}
