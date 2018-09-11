package ru.otus.sizeOf;

import ru.otus.constants.CalcConstants;
import ru.otus.MyObject;

import java.util.ArrayList;
import java.util.List;

import static ru.otus.constants.CalcConstants.BIG_NUMBER;
import static ru.otus.constants.CalcConstants.NOT_SO_BIG_NUMBER;

public class SizeOf{
    public static class ContainerSize {

        public void sizeOf(int length) {
            int randomNumber = 255;
            List<List<Integer>> arrayList = new ArrayList<>(NOT_SO_BIG_NUMBER);
            for (int i = 0; i < NOT_SO_BIG_NUMBER; i++) {
                List<Integer> collection = new ArrayList<>();
                for (int j = 0; j < length; j++) {
                    collection.add(randomNumber);
                }
                arrayList.add(collection);
            }
        }
    }
    public static class EmptyStringFromStringPoolSize implements Size {
        @Override
        public void sizeOf() {
            String[] array = new String[BIG_NUMBER];
            for (int i = 0; i < BIG_NUMBER; i++) {
                array[i] = "";
            }
        }
    }
    public static class EmptyStringSize implements Size {
        @Override
        public void sizeOf() {
            String[] array = new String[CalcConstants.BIG_NUMBER];
            for (int i = 0; i < CalcConstants.BIG_NUMBER; i++) {
                array[i] = new String(new char[0]);
            }
        }
    }
    public static class MyObjectSize implements Size {
        @Override
        public void sizeOf() {
            MyObject[] array = new MyObject[BIG_NUMBER];
            for (int i = 0; i < BIG_NUMBER; i++) {
                array[i] = new MyObject();
            }
        }
    }
    public static class ObjectSize implements Size {
        @Override
        public void sizeOf() {
            Object[] array = new Object[CalcConstants.BIG_NUMBER];
            for (int i = 0; i < CalcConstants.BIG_NUMBER; i++) {
                array[i] = new Object();
            }
        }
    }
}
