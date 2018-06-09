package com.test.akvelon.collections.task_4;

import org.junit.Before;

import java.util.List;

public abstract class ListProcessorImplTest<T extends Comparable> {

    protected List<T> initialDataset;
    protected ListProcessor<T> processor;
    protected List<T> resultDataset;

    @Before
    public void setUp() {
        initialDataset = provideInitialDataset();
        processor = new ListProcessorImpl<>();
        resultDataset = processor.processInsert(initialDataset, provideValueToInsert());
    }

    protected abstract List<T> provideInitialDataset();

    protected abstract T provideValueToInsert();

}