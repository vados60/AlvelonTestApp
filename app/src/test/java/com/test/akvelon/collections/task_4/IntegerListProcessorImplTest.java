package com.test.akvelon.collections.task_4;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IntegerListProcessorImplTest extends ListProcessorImplTest<Integer> {

    @Override
    public List<Integer> provideInitialDataset() {
        List<Integer> list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        return list;
    }

    @Override
    protected Integer provideValueToInsert() {
        return 9;
    }

    @Test
    public void testIntegerSize() {
        assertEquals(6, dataset.size());
    }

    @Test
    public void testInsertedPosition() {
        assertEquals(9, (int) dataset.get(4));
    }
}