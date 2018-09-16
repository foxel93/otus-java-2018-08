package ru.otus;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] elements;

    public MyArrayList() {
        elements = (E[]) new Object[0];
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size() && elements[currentIndex] != null;
            }

            @Override
            public E next() {
                return elements[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public Object[] toArray() {
        Object[] copy = new Object[size()];
        System.arraycopy(elements, 0, copy, 0, size());
        return copy;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new RuntimeException("the method not implemented");
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = elements;
            elements = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, elements, 0, temp.length);
            elements[elements.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        try {
            if (!contains(o)) return false;
            int index = indexOf(o);
            remove(index);
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            int a = 0;
            for (int i = 0; i < size(); i++) {
                if (c.contains(get(i))) a++;
            }
            if (a == size()) return true;
        }
        catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(0,c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            Iterator<?> iterator = c.iterator();
            while (iterator.hasNext()) {
                add(index++,(E) iterator.next());
            }
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            Iterator<?> iterator = c.iterator();
            while (iterator.hasNext()) {
                E e = (E)iterator.next();
                while(contains(e))
                    remove(e);
            }
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            ArrayList<E> temp = new ArrayList<>();
            Iterator<?> iterator = c.iterator();
            while (iterator.hasNext()) {
                E e = (E) iterator.next();
                if (!contains(e)) temp.add(e);
            }
            elements = (E[]) temp.toArray();
            return true;
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[0];
        System.gc();
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        try {
            elements[index]=element;
            return element;
        }catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return element;
    }

    @Override
    public void add(int index, E element) {
        try {
            if (index < 0 || index >= size())
                throw new IndexOutOfBoundsException();
            int firstPart = index;
            int secondPart = size() - index;
            E[] temp = elements;
            elements = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, elements, 0, firstPart);
            elements[index] = element;
            System.arraycopy(temp, index, elements, index + 1, secondPart);
        }catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E remove(int index) {
        try {
            if (index < 0 || index >= size())
                throw new IndexOutOfBoundsException();
            int firstPart = index;
            int secondPart = size() - index-1;

            E[] temp = elements;
            elements = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, elements, 0, firstPart);
            System.arraycopy(temp, index+1, elements, index, secondPart);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size(); i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size() - 1; i >= 0; i--)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = size() - 1; i >= 0; i--)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("Index: "+index);
        return new MyArrayListIterator<>(this, index);
    }

    @Override
    public MyArrayList<E> subList(int fromIndex, int toIndex) {
        try {
            MyArrayList<E> list = new MyArrayList<>();
            for (int i = fromIndex; i <= toIndex; i++) {
                list.add(elements[i]);
            }
            return list;
        }catch (Exception e){

        }
        return null;
    }
}
