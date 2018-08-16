package com.febi.base;

import java.util.*;

public class AnotherTest {
 
    public static void main(String a[]){
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        List<String> kill = new ArrayList<String>();
        kill.add("1");
        kill.add("2");
        kill.add("3");
        hm.put("first", kill);
       

        System.out.println(hm);
        HashMap<String, List<String>> subMap = new HashMap<String, List<String>>();
        subMap.putAll(hm);
        List<String> kill2 = new ArrayList<String>();
        
        for(String value:kill) {
        	kill2.add(value);
        }
        
//        kill2.add("1");
        kill2.set(1,"Second");
//        kill2.add("3");
        
        subMap.put("first", kill2);
        
        System.out.println(hm);
        System.out.println(subMap);
    }
}


