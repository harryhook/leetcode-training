package com.leetcode.training;

import sun.misc.Cleaner;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestObject {

    private byte[]  bytes = new byte[1024 * 1024 * 1024];

    public static void main(String[] args) {
        TestObject object1 = new TestObject();
        WeakReference<TestObject> object3 = new WeakReference<>(new TestObject());
        System.gc();
        System.out.println(object3.get());  // null

//        ReferenceQueue referenceQueue = new ReferenceQueue<>();
//        PhantomReference<TestObject> object4 = new PhantomReference<>(new TestObject(), referenceQueue);
//        System.out.println(referenceQueue.poll());  // null
//        System.gc();
//        System.out.println(object4.get());  // null
//        System.out.println(referenceQueue.poll());  //java.lang.ref.PhantomReference@6e0be858

        TestObject testPhantomObject = new TestObject();

        Cleaner testPhantomObjectCleaner = Cleaner.create(testPhantomObject, new Runnable() {
            @Override
            public void run() {
                System.out.println("clean testPhantomObject");
            }
        });

        testPhantomObject = null;
        System.gc();

    }
}
