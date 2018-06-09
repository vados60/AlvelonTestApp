package com.test.akvelon.task_flat_map;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of the {@link MapProcessor} interface.
 */

public class MapProcessorImpl implements MapProcessor {

    private Map<String, Object> resultMap = new HashMap<>();

    @Override
    public Map<String, Object> processMap(Map<String, Object> map) {
        processMap(map, "");
        return resultMap;
    }

    /**
     * Method that takes map and checks it's entries.
     * If value is another map - this method is recursively called again and provides
     * key of current entry as @param prevKey.
     * Otherwise current <key,value> pair is added to resultMap.
     */
    private void processMap(Map<String, Object> map, String prevKey) {
        for (String key : map.keySet()) {
            if (map.get(key) instanceof Map) {
                if (prevKey.isEmpty()) {
                    processMap((Map<String, Object>) map.get(key), key);
                } else {
                    processMap((Map<String, Object>) map.get(key), prevKey.concat(".").concat(key));
                }
            } else {
                if (prevKey.isEmpty()) {
                    resultMap.put(key, map.get(key));
                } else {
                    resultMap.put(prevKey.concat(".").concat(key), map.get(key));
                }
            }
        }
    }


}
