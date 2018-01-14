package MyArrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] data;
    private int size;
    private int capacity;

    public Object[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public MyArrayList(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(Collection<? extends T> c) {

    }

    private void ensureCapacity(int n) {
        if (n >= capacity) {
            T[] newData = (T[]) new Object[capacity * 3 / 2 + 1];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
            capacity = capacity * 3 / 2 + 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
