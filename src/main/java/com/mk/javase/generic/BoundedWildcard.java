package com.mk.javase.generic;
/*
    Add Bounded in Wildcard
    Restricted parameter upper bound
    Find item in array -> allow array many kind
 */
class TwoD{
    int x;
    int y;
    TwoD(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class ThreeD extends TwoD{
    int z;
    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
class FourD extends ThreeD{
    int t;
    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}
class Coordinate<T extends TwoD>{
    T[] data;

    public Coordinate(T[] data) {
        this.data = data;
    }
    static void showXY(Coordinate<?> c){
        System.out.println("XY Coordinate");
        for(int i = 0; i < c.data.length; i++){
            System.out.println("X : "+ c.data[i].x +" / Y : "+ c.data[i].y); ///  can't get "Z : "+ c.data[i].z -> if want not tpo Bounded WildCard in Coordinated
        }
    }
    static void showXYZ(Coordinate<? extends ThreeD> c){
        System.out.println("XY Coordinate");
        for(int i = 0; i < c.data.length; i++){
            System.out.println("X : "+ c.data[i].x +" / Y : "+ c.data[i].y +" / Z : "+ c.data[i].z); ///  can't get "Z : "+ c.data[i].z -> if want not tpo Bounded WildCard in Coordinated
        }
    }
}
public class BoundedWildcard {
    public static void main(String[] args) {
        ThreeD[] threeDS = {
                new ThreeD(1,2,3),
                new ThreeD(5,6,7)
        };
        Coordinate<ThreeD> threeDCoordinate = new Coordinate<>(threeDS);
        Coordinate.showXY(threeDCoordinate);
        Coordinate.showXYZ(threeDCoordinate);
    }
}
