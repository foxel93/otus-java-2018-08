package ru.otus.testFramework;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import ru.otus.testFramework.Annotation.After;
import ru.otus.testFramework.Annotation.Before;
import ru.otus.testFramework.Annotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestFramework {

    private TestFramework() {
    }

    public static void test(Class aClass) {
        TestFramework testFramework = new TestFramework();
        testFramework.startTest(aClass);

    }

    public static void test(String packageName) {
        TestFramework testFramework = new TestFramework();
        Set<Class<?>> classes = testFramework.getClassesForPackage(packageName);
        if (classes != null) {
            for (Class aClass : classes) {
                testFramework.startTest(aClass);
            }
        }

    }

    private void startTest(Class aClass) {
        try {
            Map<Class<?>, Set<Method>> classSetMap = scanClass(aClass);
            startTest(aClass, classSetMap);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }


    private Map<Class<?>, Set<Method>> scanClass(Class<?> aClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methodsClass = aClass.getMethods();
        Set<Method> methodsBefore = new HashSet<>();
        Set<Method> methodsAfter = new HashSet<>();
        Set<Method> methodsTest = new HashSet<>();

        for (Method method : methodsClass) {

            Before annotationBefore = method.getAnnotation(Before.class);
            After annotationAfter = method.getAnnotation(After.class);
            Test annotationTest = method.getAnnotation(Test.class);

            if (annotationTest != null) {
                methodsTest.add(method);
            } else if (annotationBefore != null) {
                methodsBefore.add(method);
            } else if (annotationAfter != null) {
                methodsAfter.add(method);
            }
        }
        Map<Class<?>, Set<Method>> methods = new HashMap<>();
        methods.put(Before.class, methodsBefore);
        methods.put(After.class, methodsAfter);
        methods.put(Test.class, methodsTest);
        return methods;
    }

    private void startTest(Class<?> aClass, Map<Class<?>, Set<Method>> methods) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Method methodTest : methods.get(Test.class)) {
            Object object = aClass.newInstance();
            for (Method methodBefore : methods.get(Before.class)) {
                methodBefore.invoke(object);
            }
            methodTest.invoke(object);
            for (Method methodAfter : methods.get(After.class)) {
                methodAfter.invoke(object);
            }
        }

    }

    private Set<Class<?>> getClassesForPackage(String packageName) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .addUrls(ClasspathHelper.forJavaClassPath())
                .filterInputsBy(new FilterBuilder()
                        .include(FilterBuilder.prefix(packageName))));

        Set<Class<?>> subTypesOf = reflections.getSubTypesOf(Object.class);
        return subTypesOf;
    }

}
