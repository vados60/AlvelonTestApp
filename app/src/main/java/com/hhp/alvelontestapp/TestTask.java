package com.hhp.alvelontestapp;

import java.util.HashMap;
import java.util.Map;

class TestTask {
    public static Map execute() {
        Map<String, Object> map = provideMap();
        processMap(map, "");
        return map;
    }

    private static void processMap(Map map, String prevKey) {
        for (Object key : map.keySet()) {
            if (map.get(key) instanceof Map) {
                if (prevKey.isEmpty()) {
                    processMap((Map) map.get(key), key.toString());
                } else {
                    processMap((Map) map.get(key), prevKey + "." + key);
                }
            } else {
                if (prevKey.isEmpty()) {
                    System.out.println(key + " : " + map.get(key));
                } else {
                    System.out.println(prevKey + "." + key + " : " + map.get(key));
                }
            }
        }
    }

    private static Map<String, Object> provideMap() {
        Map g = new HashMap<String, Object>();
        g.put("m", 17);
        g.put("n", 3);

        Map c = new HashMap<String, Object>();
        c.put("f", 9);
        c.put("g", g);

        Map map = new HashMap<String, Object>();
        map.put("a", 5);
        map.put("b", 6);
        map.put("c", c);
        return map;
    }

}
