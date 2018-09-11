package ru.otus.printer;

import java.util.List;

public class ContainerMemoryResultPrinter {
    private List<Integer> elementsNumber;
    private List<Long> occupyMemory;

    public ContainerMemoryResultPrinter(List<Integer> elementsNumber, List<Long> occupyMemory) {
        this.elementsNumber = elementsNumber;
        this.occupyMemory = occupyMemory;
    }


    public void print() {
        System.out.println("Рост размера контейнера от количества элементов в нем");
        System.out.println("Кол-во элементов - Размер контейнера");
        for (int i = 0; i < elementsNumber.size(); i++) {
            System.out.println(elementsNumber.get(i) + " - " + occupyMemory.get(i));
        }
    }
}
