package com.test.akvelon.collections.task_4;

import java.util.List;

public class ListProcessorImpl<T extends Comparable> implements ListProcessor<T> {

    private int counter = 0;

    @Override
    public void processInsert(List<T> list, T value) {
        int pos = 0;
        if (!list.isEmpty()) {
            pos = getInsertPosition(list, value, 0, list.size() - 1);
        }
        System.out.println(pos);
        list.add(pos, value);
        System.out.println(list);
    }

    /**
     * This method calculates position for new element in the list.
     * It follows half-division method where it takes bounds of elements and compare median value
     * with {@param value}. on each step bounds become tighther until they become neighbours.
     *
     * @param list
     * @param value
     * @param left
     * @param right
     * @return position where to insert new element
     */
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
