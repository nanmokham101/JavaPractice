package ocp17.ch6;

public enum Season {
    WINTER("Low"), SPRING("Medium"), SUMMER("High"), Fall("Medium");
    private final String expectedVisitors;

    private Season(String expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public static void main(String[] args) {
        String a = "test";
        String b = "test1";
        //System.out.println(expectedVisitors);
        if(a.equals(b)){
            System.out.println("same");
        }else{
            System.out.println("different");
        }
    }
}
