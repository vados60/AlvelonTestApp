package com.test.akvelon.task_flat_map;

import java.util.Map;

/**
 * An object that makes map flatten.
 */
public interface MapProcessor{
    /**
     * Returns processed map of the same type that consumed as a parameter.
     *
     * @return processed map
     */
    Map<String, Object> processMap(Map<String, Object> map);
}
