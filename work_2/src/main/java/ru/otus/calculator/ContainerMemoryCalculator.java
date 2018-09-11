package ru.otus.calculator;

import ru.otus.constants.CalcConstants;
import ru.otus.sizeOf.SizeOf.ContainerSize;

public class ContainerMemoryCalculator{
    private Runtime runtime = Runtime.getRuntime();

    public long calculate(int length) {
        System.gc();
        long startMem = getMemory();

        new ContainerSize().sizeOf(length);

        long endMem = getMemory();
        System.gc();

        return (endMem - startMem) / CalcConstants.NOT_SO_BIG_NUMBER;
    }

    private long getMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
