package com.test.akvelon.collections.task_4;

import java.util.List;

/**
 * Provides class for inserting new item into sorted List
 *
 * @param <T>
 */
public interface ListProcessor<T extends Comparable> {
    /**
     * Inserts {@param value} into sorted {@param list}
     *
     * @param list
     * @param value
     */
    void processInsert(List<T> list, T value);
}
