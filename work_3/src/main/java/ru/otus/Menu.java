package ru.otus;

import java.util.Iterator;

public class Menu {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add(0,"0");                    //Добавил 0 в начало
        list.remove(9);                             //Удалил последний элемент
        list.remove("6");                              //Удалил элемент "6"

        Iterator<String> iterator= list.iterator();        //Итератор с выводом
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------");

        list.set(1,"11");                                  //Заменил 2 элемент
        MyArrayList<String> list1 = list.subList(1,4);     //Подсписок
        Iterator<String> iterator6= list1.iterator();      //Итератор с выводом
        while (iterator6.hasNext()){
            System.out.println(iterator6.next());
        }

        System.out.println("------------------------------");

        MyArrayList<String> list2 = new MyArrayList<>();

        list2.add("2");
        list2.add("4");
        list2.add("6");
        list2.add("8");
        list2.add("10");

        list2.addAll(list);                                 //Слияние списков
        Iterator<String> iterator2= list2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        System.out.println("------------------------------");

        MyArrayList<String> list3 = new MyArrayList<>();

        list3.add("2");
        list3.add("4");
        list3.add("6");
        list3.add("8");
        list3.add("10");

        list3.retainAll(list2);                             //удаление из одного списка элементов другого
        Iterator<String> iterator3= list3.iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }


    }


}
