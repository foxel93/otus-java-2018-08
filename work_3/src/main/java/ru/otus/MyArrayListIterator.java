package ru.otus;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayListIterator<E> implements ListIterator<E> {
    private int index;
    private MyArrayList<E> list;

    public MyArrayListIterator(MyArrayList<E> list, int index) {
        this.list = list;
        this.index=index-1;

    }


    @Override
    public boolean hasNext() {
        return index < list.size() && list.get(index) != null;
    }

    @Override
    public E next() {
        if (index >= list.size())
            throw new NoSuchElementException();

        return list.get(index++);
    }

    @Override
    public boolean hasPrevious() {
        return index != 0;
    }

    @Override
    public E previous() {
        if (index <0)
            throw new NoSuchElementException();

        return list.get(index--);
    }

    @Override
    public int nextIndex() {
        return ++index;
    }

    @Override
    public int previousIndex() {
        return --index;
    }

    @Override
    public void remove() {
        list.remove(list.size()-1);
    }

    @Override
    public void set(E e) {
        list.set(index-1, e);
    }

    @Override
    public void add(E e) {
        list.add(e);
    }

}
