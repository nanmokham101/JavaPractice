package com.mk.test.test.dsa.array;

import com.mk.dsa.search.BinarySearch;
import com.mk.dsa.search.LinearSearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mk.dsa.search.Searchable;
import com.mk.dsa.search.SortedLinearSearch;
import org.junit.jupiter.api.Test;

public class SearchTest {
    @Test
    public void test(){
        assertEquals(2, 1+1);
    }
    @Test
    public void testLinearSearch(){
        Searchable linearSearch = new LinearSearch(new int[]{3,4,7,8,10,5});
        int index = linearSearch.findItem(11);
        assertEquals(-1,index);
    }
    @Test
    public void testSortedLinearSearch(){
        Searchable sortedLinearSearch = new SortedLinearSearch(new int[]{1,2,3,4,5,6});
        int index = sortedLinearSearch.findItem(-5);
        assertEquals(-1, index);
    }
    @Test
    public void testBinarySearch(){
        Searchable binarySearch = new BinarySearch(new int[]{1,2,3,4,5,6,7,8,9,10});
        int index = binarySearch.findItem(66);
        assertEquals(-1, index);
    }
}
