package ru.otus.calculator;

import ru.otus.constants.MeasuredType;
import ru.otus.sizeOf.*;
import ru.otus.printer.MemoryResultPrinter;

import static ru.otus.constants.CalcConstants.BIG_NUMBER;

public class MemoryCalculator{
    private Runtime runtime = Runtime.getRuntime();

    public void calculate(MeasuredType type) {
        System.gc();
        long startMem = getMemory();

        getSize(type).sizeOf();

        long endMem = getMemory();
        System.gc();

        long occupyMem = (endMem - startMem) / BIG_NUMBER;

        MemoryResultPrinter.builder()
                .setType(type)
                .setOccupyMemory(occupyMem)
                .build()
                .print();
    }

    private Size getSize(MeasuredType type) {
        switch (type) {
            case EMPTY_STRING:
                return new SizeOf.EmptyStringSize();
            case STRING_POOL_EMPTY_STRING:
                return new SizeOf.EmptyStringFromStringPoolSize();
            case OBJECT:
                return new SizeOf.ObjectSize();
            case MY_OBJECT:
                return new SizeOf.MyObjectSize();
        }
        throw new UnsupportedOperationException("Нет совпадений");
    }

    private long getMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
