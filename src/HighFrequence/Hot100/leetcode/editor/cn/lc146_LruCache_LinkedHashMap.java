package HighFrequence.Hot100.leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

//LRU 缓存
class lc146_LruCache_LinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public lc146_LruCache_LinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}