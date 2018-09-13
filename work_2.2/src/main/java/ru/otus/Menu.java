package ru.otus;


public class Menu {

        public static void main(String [] args) {
            System.out.println("Size of empty string - " + Agent.getSize(new String(new char[0])));
            int size = 100000;
            String array[] = new String[size];
            for (int i = 0; i < size; i++) {
                array[i] = "";
            }
            System.out.println("Size of empty string from pool ["+size+"] - " + Agent.getSize(array));

            System.out.println("Size of object - " + Agent.getSize(new Object()));
            System.out.println("Size of my object - " + (Agent.getSize(new A())));

            System.out.println("index    -    size of Integer[100]");
            for (int i = 0; i < 100; i++) {
                System.out.println(i + "     -     "+Agent.getSize(new Integer[i]));
            }
        }
    }

class A {
    Integer id;
    String name = "ggg";
    Long a = 5l;

}
