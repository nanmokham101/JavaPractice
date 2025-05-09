package com.mk.dsa.search;

import com.mk.dsa.array.Array;
/*

int[] arr = {10, 20, 30, 40, 50};
Time Complexity
 10 → found at index 0 → best case = O(1)

 50 → found at last index → worst case = O(n)

 99 → not found → must check all → O(n)
 */
public class LinearSearch extends Array implements Searchable {
    public LinearSearch(int[] itemsArr) {
        super(itemsArr);
    }

    @Override
    public int findItem(int value) {
        for(int i = 0; i < this.itemsArr.length; i++ ){
            if(this.itemsArr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
