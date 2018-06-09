package com.test.akvelon.task_flat_map;

import com.test.akvelon.task_flat_map.MapProcessor;
import com.test.akvelon.task_flat_map.MapProcessorImpl;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MapProcessorUnitTest {

    private Map<String, Object> initialDataset;
    private Map<String, Object> resultDataset;
    private MapProcessor processor;

    /**
     * Initialization of main objects and processing initial dataset to get resultDataset
     */
    @Before
    public void before() {
        initialDataset = provideInitialMap();
        processor = new MapProcessorImpl();
        resultDataset = processor.processMap(initialDataset);
    }

    @Test
    public void testResultSize() {
        assertEquals(5, resultDataset.size());
    }

    @Test
    public void testPositiveResultEquity() {
        assertEquals(providePositiveResultMap(), resultDataset);
    }

    @Test
    public void testNegativeResultEquity() {
        assertNotEquals(provideNegativeResultMap(), resultDataset);
    }

    private static Map<String, Object> provideInitialMap() {
        Map<String, Object> g = new HashMap<>();
        g.put("m", 17);
        g.put("n", 3);

        Map<String, Object> c = new HashMap<>();
        c.put("f", 9);
        c.put("g", g);

        Map<String, Object> map = new HashMap<>();
        map.put("a", 5);
        map.put("b", 6);
        map.put("c", c);
        return map;
    }

    private static Map<String, Object> providePositiveResultMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 5);
        map.put("b", 6);
        map.put("c.f", 9);
        map.put("c.g.m", 17);
        map.put("c.g.n", 3);
        return map;
    }

    private static Map<String, Object> provideNegativeResultMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", 5);
        map.put("b", 6);
        map.put("c.f", 9);
        map.put("c.g.n", 3);
        return map;
    }
}