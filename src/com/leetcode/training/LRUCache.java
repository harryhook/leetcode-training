package com.leetcode.training;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Integer capacity = 0;
    private Map<Integer, LRUCacheNode> map;
    private LinkedNodeList lruCache;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        this.map = new HashMap<>();
        this.lruCache = new LinkedNodeList();
    }

    public int get(int key) {

        // get if exists return and set one index
        // if not exists return -1
        LRUCacheNode cur = map.get(key);
        if (cur == null) {
            return -1;
        }

        lruCache.moveToHead(cur);

        return cur.value;
    }

    public void put(int key, int value) {
        LRUCacheNode cur = map.get(key);

        //  if key exists update else put
        if (cur != null) {
            lruCache.moveToHead(cur);
            cur.value = value;
        } else {
            LRUCacheNode newNode = new LRUCacheNode(key, value);
            if (map.size() == capacity) {
                map.remove(lruCache.getTail().key);
                lruCache.removeTail();
            }
            map.put(key, newNode);
            lruCache.addToHead(newNode);
        }

    }

    class LinkedNodeList {

        LRUCacheNode dummyHead;
        LRUCacheNode dummyTail;

        LinkedNodeList() {
            dummyHead = new LRUCacheNode(0, 0);
            dummyTail = new LRUCacheNode(0, 0);
            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
        }

        void moveToHead(LRUCacheNode node) {

            node.pre.next = node.next;
            node.next.pre = node.pre;

            addToHead(node);
        }

        void addToHead(LRUCacheNode node) {

            node.next = dummyHead.next;
            dummyHead.next = node;
            node.pre = dummyHead;
            node.next.pre = node;

        }

        void removeTail() {

            LRUCacheNode newTail = dummyTail.pre.pre;
            newTail.next = dummyTail;
            dummyTail.pre = newTail;

        }

        LRUCacheNode getTail() {
            return dummyTail.pre;
        }

    }

    class LRUCacheNode {

        private Integer key;

        private Integer value;

        private LRUCacheNode pre;

        private LRUCacheNode next;

        public LRUCacheNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2));    // return 1
        lRUCache.put(2, 6); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(1));
        ;    // returns -1 (not found)
        lRUCache.put(1, 5); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.put(1, 2);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}

