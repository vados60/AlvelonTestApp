package com.test.akvelon.collections.task_4;

import java.util.LinkedList;
import java.util.List;

public class ListProcessorImpl<T extends Comparable> implements ListProcessor<T> {

    private List<T> result = new LinkedList<>();
    private int counter = 0;

    @Override
    public List<T> processInsert(List<T> list, T value) {
        int pos = getInsertPosition(list, value, 0, list.size() - 1);
        System.out.println(pos);

        result.addAll(list);
        result.add(pos, value);
        System.out.println(result);
        return result;
    }

    private int getInsertPosition(List<T> list, T value, int left, int right) {
        counter++;
        int avg = (left + right) / 2;
        System.out.println(counter + " | " + left + " " + right);

        if (left == 0 &&
                list.get(left).compareTo(value) > 0) {
            return left;
        } else if (right == list.size() - 1 &&
                list.get(right).compareTo(value) < 0) {
            return right + 1;
        }

        if (right - left == 1) {
            return right;
        } else if (list.get(avg).compareTo(value) > 0) {
            return getInsertPosition(list, value, left, avg);
        } else {
            return getInsertPosition(list, value, avg, right);
        }
    }
}
