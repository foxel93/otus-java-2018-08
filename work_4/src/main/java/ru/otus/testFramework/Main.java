package ru.otus.testFramework;

import test.TestClass1;

public class Main {


    public static void main(String[] args){
        System.out.println("Start test in class...");
       TestFramework.test(TestClass1.class);
        System.out.println("Start test in package...");
       TestFramework.test("test");

    }

}
