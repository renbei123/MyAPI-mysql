package com;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class mytest {


    @Test
    public void a() {
        int a[]={1,2,66,66,66,113,157,182,192,201};
        int b[]={40,45,66,70,120,140,160,200,1655,1732};
        int lena=a.length;
        int lenb=b.length;
        ArrayList c=new ArrayList();

        int indexa=0,indexb=0;

        while (indexa<lena&&indexb<lenb){
            if (a[indexa]<b[indexb])  { c.add(a[indexa]); indexa++;continue;}
            if (a[indexa]==b[indexb])  {c.add(a[indexa]);c.add(b[indexb]); indexa++;indexb++;continue;}
            if (a[indexa]>b[indexb])    {c.add(b[indexb]);indexb++;continue;}
        }

           while (indexb<lenb){
               c.add(b[indexb]);
               indexb++;
           }

            while (indexa<lena){
                c.add(a[indexa]);
                indexa++;
            }


//        Iterator it1 = c.iterator();
//        while (it1.hasNext()) {
//            System.out.print(it1.next()+" ");
//        }
        System.out.println(Arrays.deepToString(c.toArray()));

          Iterator iterator=c.iterator();
          while (iterator.hasNext()){
              System.out.print(iterator.next()+", ");

          }

    }

    @Test
    public void a2(){

    }


}
