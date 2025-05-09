package com.mk.dsa.search;

import com.mk.dsa.array.Array;

public class SortedLinearSearch extends Array implements Searchable {
    public SortedLinearSearch(int[] itemsArr) {
        super(itemsArr);
    }

    @Override
    public int findItem(int value) {
        int index = 0;
        int length = this.itemsArr.length;
        /*
        this.itemsArr= [1,2,3,4,5,6] find 3
        0< 5 && 1 < 3
        1 < 5 && 2 < 3
        2 < 5 && 3 < 3
        return 2; // index
         */
        while(index < length && this.itemsArr[index] < value){
            index++;
        }
        if(index == length || this.itemsArr[index] != value){
            return -1;
        }
        return index;
    }
}
