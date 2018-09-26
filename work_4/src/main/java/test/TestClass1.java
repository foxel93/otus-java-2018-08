package test;

import ru.otus.testFramework.Annotation.After;
import ru.otus.testFramework.Annotation.Before;
import ru.otus.testFramework.Annotation.Test;

public class TestClass1 {

    @Before
    public void precondition(){
        System.out.println("Method is called (@before): TestClass1.precondition");
    }
    @Test
    public void testing(){
        System.out.println("Method is called (@test): TestClass1.testing()");
    }

    @Test
    public void testing2(){
        System.out.println("Method is called (@test): TestClass1.testing2()");
    }


    @After
    public void concluding(){
        System.out.println("Method is called (@after): TestClass1.concluding()");
    }
}
