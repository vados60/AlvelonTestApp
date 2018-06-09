package com.test.akvelon.collections.task_4;

import java.util.List;

public interface ListProcessor<T extends Comparable> {

    List<T> processInsert(List<T> list, T value);
}
