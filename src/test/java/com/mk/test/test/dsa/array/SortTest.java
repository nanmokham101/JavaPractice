package com.mk.test.test.dsa.array;

import com.mk.dsa.array.ArrayUtil;
import com.mk.dsa.sorting.BubbleSort;
import com.mk.dsa.sorting.InsertionSort;
import com.mk.dsa.sorting.SelectionSort;
import com.mk.dsa.sorting.Sortable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class SortTest {
    @Test
    public void testArraySorted(){
        int[] arr = new int[]{1,2,7, 8,9,11};
        ArrayUtil arrayUtil = new ArrayUtil();
        boolean isArraySorted = arrayUtil.isArraySorted(arr);
        assertEquals (true,isArraySorted);
    }

    @Test
    public void testSelectionSort(){
        Sortable selectionSort = new SelectionSort();
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] arr = arrayUtil.getRandomArray(10, 100);
        arrayUtil.printArray("Arr ", arr);
        selectionSort.sort(arr);
        arrayUtil.printArray("Sorted Arr ", arr);
        assertTrue(arrayUtil.isArraySorted(arr));
    }
    @Test
    public void testBubbleSort(){
        Sortable bubbleSort = new BubbleSort();
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] arr = arrayUtil.getRandomArray(10, 100);
        arrayUtil.printArray("Arr ", arr);
        bubbleSort.sort(arr);
        arrayUtil.printArray("Sorted Arr ", arr);
        assertTrue(arrayUtil.isArraySorted(arr));
    }

    @Test
    public void testInsertionSort(){
        Sortable insertionSort = new InsertionSort();
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] arr = arrayUtil.getRandomArray(10, 100);
        arrayUtil.printArray("Arr ", arr);
        insertionSort.sort(arr);
        arrayUtil.printArray("Sorted Arr ", arr);
        assertTrue(arrayUtil.isArraySorted(arr));
    }
}
