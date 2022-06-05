package com.leetcode.training;

import sun.misc.Cleaner;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestObject {

    private static  Integer num = 1;

    public static void main(String[] args) {
        TestObject object1 = new TestObject();

        int a = 1;
        int b = 1;

        Person person = new Person();
        person.id = 1;

    }
}

class Person {
     int id;
     String name;
}
