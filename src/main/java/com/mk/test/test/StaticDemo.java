package com.mk.test.test;

class Data {
    public static void main(String[] args) {
        int tickets = 2; // tickets = 2
        String guests = "abc"; // guests = abc
        tickets = addTickets(tickets); // tickets = 2
        System.out.println(tickets);
        guests = addGuests(guests); // guests = abcd
        System.out.println(guests);
        System.out.println(tickets + guests); // 2abcd
    }

    public static int addTickets(int tickets) {
        tickets++;
        return tickets;
    }

    public static String addGuests(String guests) {
        guests += "d";
        return guests;

    }
}
//        var p1 = new StaticDemo();
//        p1.name = "Lilly";
//        p1.nameOfTallestPenguin = "Lilly";
//        var p2 = new StaticDemo();
//        p2.name = "Willy";
//        p2.nameOfTallestPenguin = "Willy";
//
//        System.out.println(p1.name); // Lilly
//        System.out.println(p1.nameOfTallestPenguin); // Willy
//        System.out.println(p2.name); // Willy
//        System.out.println(p2.nameOfTallestPenguin); // Willy
//
//        StaticDemo s = new StaticDemo();
//        System.out.println(s.hiss);
//        s.hiss = 0;
//        System.out.println(s.hiss);
//        //StaticDemo.hiss = null;
//        //System.out.println(s.hiss);
//
//        StaticDemo.hiss = 7;
//        StaticDemo s1 = new StaticDemo();
//        StaticDemo s2 = new StaticDemo();
//
//        s1.hiss = 8;
//        System.out.println(StaticDemo.hiss);
//        s2.hiss = 9;
//        System.out.println(StaticDemo.hiss);




public class StaticDemo {
    Integer a = 6;
    //Long b= 8; why does in Integer and not in Long

//    public void rest(Long x) {
//        System.out.print("long");
//    }
//    public static void main(String[] args) {
//        var g = new Gorilla();
//        g.rest(8); // DOES NOT COMPILE
//    }

//    String name;
//    static String nameOfTallestPenguin;
//   // static Long hiss = 2L;
//    static long hiss = 2;
}