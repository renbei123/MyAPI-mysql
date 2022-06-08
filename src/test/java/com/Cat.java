package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

abstract class Cat {
    public  void sayHi() {
        System.out.println("hi~");
    }
    public static void main(String[] arg) {
        int[] a={1,2,-2,1,7,-7};
        System.out.println( Arrays.stream(a).count());
        HashMap map=  new HashMap();
    
    }
}