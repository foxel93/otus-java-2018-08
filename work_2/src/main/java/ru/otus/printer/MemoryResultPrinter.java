package ru.otus.printer;

import ru.otus.constants.MeasuredType;

public class MemoryResultPrinter {
    private Long occupyMemory;
    private MeasuredType type;

    public static MemoryResultPrinterBuilder builder() {
        return new MemoryResultPrinterBuilder();
    }

    public static class MemoryResultPrinterBuilder {
        private Long occupyMemory;
        private MeasuredType type;

        public MemoryResultPrinterBuilder setOccupyMemory(Long occupyMemory) {
            this.occupyMemory = occupyMemory;
            return this;
        }

        public MemoryResultPrinterBuilder setType(MeasuredType type) {
            this.type = type;
            return this;
        }

        public MemoryResultPrinter build() {
            MemoryResultPrinter printer = new MemoryResultPrinter();
            printer.type = type;
            printer.occupyMemory = occupyMemory;
            return printer;
        }
    }


    public void print() {
        System.out.println(new StringBuilder("Размер "+ type + " = " + occupyMemory +"\n"));
    }
}
