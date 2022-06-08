package com;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class test01 {
    public static void main(String[] args) {
        int f1=1,f2=1,f;
        int M=30;
        System.out.println(f1);
        System.out.println(f2);
        for(int i=3;i<M;i++) {
            f=f2;
            f2=f1+f2;
            f1=f;
            System.out.println(f2);
        }
    }

    @Test
    public void testA(){
//        int[] intArray = new int[]{1, 2, 3, 4};
//        List listFromArray = Arrays.asList(intArray);
//        System.out.println(listFromArray.size());

        System.out.println(String.format("abcdadlfj",1,3,4));
    }

}

