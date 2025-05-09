package com.mk.dsa.search;

import com.mk.dsa.array.Array;

/*
[1,2,3,4,5,6] find 6
middle = (first + last) /2

1.  middle = (0 + 5) / 2 = 2
    arr[2] = 3
2. middle1 = ((middle + 1) + 5) = (3+5)/2 = 4
    arr[4] = 5
3. middle2 = ((middle1 + 1) + 5 = (5+5)/2 = 5
    arr[5] = 6 found it

    log n (find 6 : 3 // step)


arr[1,2,3,4,5,6,7,8,9,10] find 7
1.  middle = (0+9)/2 = 4
    arr[4] = 5
    [6,7,8,9,10]
2.  middle1 = ((middle+1)+9)/2 = ((4+1)+9)/2 = 14/2 = 7
    arr[7] = 8
    [6,7]
3.  middle2 = ((5+(middle1-1))/2 = (5+(7-1))/2 = 11/2 = 5
    arr[5] = 6
    [7]
4.  middle2 = ((middle2+1)+ 6)/2 = (6+6)/2 = 6
    arr[6] = 7 found it


    1st step: 16 → half → 8 left

    2nd step: 8 → half → 4

    3rd step: 4 → half → 2

    4th step: 2 → half → 1 → done!

    found the number in 4 steps
    Time Complexity
    log₂(16) = 4
    O(log n)
 */
public class BinarySearch extends Array implements Searchable {

    public BinarySearch(int[] itemsArr) {
        super(itemsArr);
    }

    @Override
    public int findItem(int value) {
        int first = 0;
        int last = this.itemsArr.length -1;
        while (first <= last){
            int middle = (first + last) / 2;
            if(this.itemsArr[middle] == value){
                return middle;
            }else if(this.itemsArr[middle] < value){
                first = middle + 1;
            }else {
                last = middle -1 ;
            }
        }
        return -1;
    }
}
