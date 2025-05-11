package com.mk.test.test.dsa.array;

import com.mk.dsa.sorting.Human;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomObjectSortTest {
    @Test
    public void testHumanAgeSort(){
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Julia", 10));
        humanList.add(new Human("Monica", 9));
        humanList.add(new Human("David", 15));
        humanList.add(new Human("John", 13));
        Collections.sort(humanList);
        humanList.forEach(System.out::println);
    }
}
