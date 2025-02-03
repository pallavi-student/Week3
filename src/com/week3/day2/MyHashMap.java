package com.week3.day2;

class MyHashMap {
    private static class Entry {
        int key, value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int SIZE = 1000;
    private Entry[] map;

    public MyHashMap() {
        map = new Entry[SIZE];
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        if (map[hash] == null) {
            map[hash] = new Entry(key, value);
        } else {
            Entry cur = map[hash];
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                if (cur.next == null) break;
                cur = cur.next;
            }
            cur.next = new Entry(key, value);
        }
    }

    public int get(int key) {
        int hash = getHash(key);
        Entry cur = map[hash];
        while (cur != null) {
            if (cur.key == key) return cur.value;
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        Entry cur = map[hash], prev = null;

        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) map[hash] = cur.next;
                else prev.next = cur.next;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        System.out.println(hashMap.get(1)); // Output: 100
        hashMap.remove(1);
        System.out.println(hashMap.get(1)); // Output: -1
    }
}