package collections.HashMap;

import java.util.*;

import static java.lang.Math.abs;

public class MyHashMap<K, V> {
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    int mapFullness;
    private int threshold;
    private float loadFactor;
    private Node<K, V>[] table;

    private class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public MyHashMap() {
        this.size = 0;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.mapFullness = 0;
        this.threshold = (int) Math.floor(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        this.table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        this.size = 0;
        this.loadFactor = loadFactor;
        this.mapFullness = 0;
        this.threshold = (int) Math.floor(initialCapacity * loadFactor);
        this.table = new Node[initialCapacity];
    }

    static final int hash(Object key) {
        return (key == null) ? 0 : abs(key.hashCode());
    }

    private int getIndex(int hashcode) {
        return hashcode % this.table.length;
    }

    public V put(K k, V v) {
        V oldValue;
        int hashcode = hash(k);
        int index = getIndex(hashcode);

        Node node = new Node(hashcode, k, v, null);

        if (table[index] == null) {
            table[index] = node;
            this.mapFullness++;
        } else {
            Node tmpNode = table[index];

            do {
                if (tmpNode.hash == hashcode && tmpNode.key.equals(k)) {
                    oldValue = (V) tmpNode.value;
                    tmpNode.value = v;
                    return oldValue;
                }

                if (tmpNode.next != null) tmpNode = tmpNode.next;

            } while (tmpNode.next != null);

            tmpNode.next = node;
        }

        this.size++;
        if (this.mapFullness >= this.threshold) resize();

        return null;
    }

    public V get(K k) {
        int hashcode = hash(k);
        int index = getIndex(hashcode);

        Node<K, V> tmpNode = this.table[index];

        if (tmpNode == null) return null;

        while (tmpNode != null) {
            if (tmpNode.key.equals(k)) return tmpNode.value;
            tmpNode = tmpNode.next;
        }

        return null;
    }

    public V remove(K k) {
        int hashcode = hash(k);
        int index = getIndex(hashcode);

        Node<K, V> tmpNode = this.table[index];
        Node<K, V> prevNode = null;

        if (tmpNode == null) return null;

        while (tmpNode != null) {
            if (tmpNode.key.equals(k)) {
                this.size--;
                V oldValue = (V) tmpNode.value;
                if (tmpNode.next == null && prevNode == null) {
                    this.table[index] = null;
                    this.mapFullness--;
                } else if (tmpNode.next != null && prevNode == null) this.table[index] = tmpNode.next;
                else prevNode.next = tmpNode.next;
                return oldValue;
            }
            prevNode = tmpNode;
            tmpNode = tmpNode.next;
        }

        return null;
    }

    public boolean containsKey(K k) {
        int hashcode = hash(k);
        int index = getIndex(hashcode);

        Node<K, V> tmpNode = this.table[index];

        if (tmpNode == null) return false;

        while (tmpNode != null) {
            if (tmpNode.key.equals(k)) return true;
            tmpNode = tmpNode.next;
        }

        return false;
    }

    public boolean containsValue(V v) {
        for (int i = 0; i < this.table.length; i++) {
            Node<K, V> tmpNode = this.table[i];

            if (tmpNode == null) continue;

            while (tmpNode != null) {
                if (tmpNode.value.equals(v)) return true;
                tmpNode = tmpNode.next;
            }
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();

        for (int i = 0; i < this.table.length; i++) {
            Node<K, V> tmpNode = this.table[i];

            if (tmpNode == null) continue;

            while (tmpNode != null) {
                keys.add(tmpNode.key);
                tmpNode = tmpNode.next;
            }
        }

        return keys;
    }

    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();

        for (int i = 0; i < this.table.length; i++) {
            Node<K, V> tmpNode = this.table[i];

            if (tmpNode == null) continue;

            while (tmpNode != null) {
                values.add(tmpNode.value);
                tmpNode = tmpNode.next;
            }
        }

        return values;
    }

    public void clear() {
        this.size = 0;
        this.mapFullness = 0;
        this.threshold = (int) Math.floor(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        this.table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    private void resize() {
        int tableSize = this.threshold;
        this.threshold = (int) (table.length * 1.5 * this.loadFactor);
        Node<K, V>[] newTable = new Node[(int) (table.length * 1.5)];

        for (int i = 0; i < tableSize; i++) {
            newTable[i] = this.table[i];
        }

        this.table = newTable;
    }

    public boolean isEmpty() {
        return this.size > 0 ? false : true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;
        return size == myHashMap.size && threshold == myHashMap.threshold && Float.compare(loadFactor, myHashMap.loadFactor) == 0 && Arrays.equals(table, myHashMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, threshold, loadFactor);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }
}
