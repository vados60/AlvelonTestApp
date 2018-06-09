package com.test.akvelon.collections.task_4;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringListProcessorImplTest extends ListProcessorImplTest<String> {

    @Override
    protected List<String> provideInitialDataset() {
        List<String> list = new LinkedList();
        list.add("P");
        list.add("a");
        list.add("b");
        list.add("f");
        list.add("z");
        return list;
    }

    @Override
    protected String provideValueToInsert() {
        return "Z";
    }

    @Test
    public void testStringSize() {
        assertEquals(6, resultDataset.size());
    }

    @Test
    public void testStringPosition() {
        assertEquals("Z", resultDataset.get(1));
    }

}