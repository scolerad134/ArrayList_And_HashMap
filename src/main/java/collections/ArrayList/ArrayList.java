package collections.ArrayList;


import java.util.Arrays;

public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    private int capacity;

    public ArrayList() {
        capacity = DEFAULT_CAPACITY;
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        array = new Object[initialCapacity];
        size = 0;
    }

    public ArrayList(ArrayList<T> array) {
        this.capacity = array.capacity;
        this.array = new Object[this.capacity];
        this.size = array.size();

        for (int i = 0; i < array.size(); i++) {
            this.array[i] = array.get(i);
        }
    }

    private void increaseCapacity() {
        capacity = (capacity * 3) / 2 + 1;
        Object[] newArray = new Object[capacity];

        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }

        array = newArray;
    }

    public boolean isEmpty() {
        return size > 0 ? false : true;
    }

    public int size() {
        return this.size;
    }

    public boolean add(T elem) {
        if (size >= capacity) increaseCapacity();

        array[size++] = elem;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();

        return (T) this.array[index];
    }

    public int indexOf(T elem) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(elem)) return i;
        }

        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();

        T removeElem = (T) this.array[index];
        Object[] newArray = new Object[this.size() - 1];
        int newArrayIndex = 0;

        for (int i = 0; i < this.size(); i++) {
            if (i == index) continue;
            newArray[newArrayIndex++] = this.array[i];
        }

        size--;
        this.array = newArray;

        return removeElem;
    }

    public boolean remove(Object elem) {
        for (int i = 0; i < this.size(); i++) {
            if (this.array[i].equals(elem)) {
                this.remove(i);
                return true;
            }
        }

        return false;
    }

    public T set(int index, T elem) {
        if (index < 0 || index >= this.size()) throw new IndexOutOfBoundsException();

        T oldValue = (T) this.array[index];
        this.array[index] = elem;
        return oldValue;
    }

    public Object[] toArray() {
        Object[] newArray = new Object[this.size()];

        for (int i = 0; i < this.size(); i++)
            newArray[i] = this.array[i];

        return newArray;
    }

    public T[] toArray(T[] newArray) {
        for (int i = 0; i < this.size(); i++) {
            newArray[i] = (T) this.array[i];
        }

        return newArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(this.array, 0, size));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> that = (ArrayList<?>) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(array, that.array);
    }
}













