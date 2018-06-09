package com.test.akvelon.collections.task_4;

import org.junit.Before;

import java.util.List;

public abstract class ListProcessorImplTest<T extends Comparable> {

    protected List<T> dataset;
    protected ListProcessor<T> processor;

    @Before
    public void setUp() {
        dataset = provideInitialDataset();
        processor = new ListProcessorImpl<>();
        processor.processInsert(dataset, provideValueToInsert());
    }

    protected abstract List<T> provideInitialDataset();

    protected abstract T provideValueToInsert();

}