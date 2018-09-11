package ru.otus;

import ru.otus.calculator.MemoryCalculator;
import ru.otus.calculator.ContainerMemoryCalculator;
import ru.otus.printer.ContainerMemoryResultPrinter;

import java.util.ArrayList;
import java.util.List;

import static ru.otus.constants.MeasuredType.*;


public class Menu {
    public static void main(String[] args) {
        System.out.println("Размер пустой строки, списка пустых строк, объекта и своего объекта");
        MemoryCalculator calculator = new MemoryCalculator();
        calculator.calculate(EMPTY_STRING);
        calculator.calculate(STRING_POOL_EMPTY_STRING);
        calculator.calculate(OBJECT);
        calculator.calculate(MY_OBJECT);

        ContainerMemoryCalculator containerMemoryCalculator = new ContainerMemoryCalculator();
        List<Integer> elementsNumber = new ArrayList<>();
        List<Long> occupyMemory = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            elementsNumber.add(i);
            occupyMemory.add(containerMemoryCalculator.calculate(i));
        }
        ContainerMemoryResultPrinter printer = new ContainerMemoryResultPrinter(elementsNumber, occupyMemory);
        printer.print();
    }


}
