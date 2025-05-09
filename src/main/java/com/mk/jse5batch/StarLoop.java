package com.mk.jse5batch;

public class StarLoop {
/*

*       i = 0, j = 1
**      i = 1, j = 2
***     i = 2, j = 3
****    i = 3, j = 4
*****   i = 4, j = 5

i = outer loop enter
j = inner loop * (j = i +1)

public static void main(String[] args) {
    for(int i = 0; i <= 4; i++){
        for(int j = 0; j < i +1; j++){
            System.out.print("*");
        }
        System.out.println();
    }
}


    *****   i = 4, j = 5
    ****    i = 3, j = 4
    ***     i = 2, j = 3
    **      i = 1, j = 2
    *       i = 0, j = 1

    j = i + 1

    public static void main(String[] args) {
        for(int i = 0; i <= 4; i++){
            for(int j = i + 1; j <=5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for(int i = 4; i <= 0; i--){
            for(int j = 5; j < i + 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    } */

    /*

          *
         **
        ***
       ****
      *****

    i = outer loop ,
    space   = inner loop
    *       = inner loop
    space,*,i
    4,1,0 space = (4 - 1), * = (i + 1)
    3,2,1
    2,3,2
    1,4,3
    0,5,4
     */
    /*
    public static void main(String[] args) {
        for(int i = 0; i <= 4; i++){
            for(int k = 0; k < 4-i; k++){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    } */


}
