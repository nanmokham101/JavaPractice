package ocp17.ch6;

class Person {
    static String name;

    void setName(String q) {
        name = q;
    }
}

public class Child22 extends Person {
    static String name;

    void setName(String w) {
        name = w;
    }

    public static void main(String[] p) {
        final Child22 m = new Child22();
        final Person t = m;
        m.name = "Elysia";
        t.name = "Sophia";
        m.setName("Webby");
        t.setName("Olivia");
        System.out.println(m.name + " " + t.name);
    }
}