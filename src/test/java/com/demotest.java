package com;

import org.junit.Test;

public class demotest {

    public static void main(String[] arg) {
        int[] a={1,2,-2,1,7,-7};
               System.out.println( demotest.summax(a));

    }


    public static  int summax(int[] a) {
        int sum=0, max=0;
    for (int index=0;index<a.length;index++){
        sum=sum+a[index];
        if (sum>max)
            max=sum;
        if (sum<0)
            sum=0;
    }
return  max;
    }


    @Test
    public void test2() {

        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));

    }

}


