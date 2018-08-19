package com.febi.base;

import java.util.*;

public class Test{

    public ArrayList<boolean[]> scenarioGenerator(int n)
    {
        ArrayList<boolean[]> result = new ArrayList<boolean[]>();
//        int n=2;
        
        StringBuilder generateValue = new StringBuilder("");
        for(int i=0;i<n;i++) {
        generateValue.append("1");
        }
        
        String finalValue = generateValue.toString();
        
        int max_num = Integer.parseInt(finalValue, 2);
        for(int i=max_num; i>=0; i--)
        {
            String val = String.format("%"+n+"s", Integer.toBinaryString(i)).replace(' ', '0');
            boolean[] arr = new boolean[n];
            char[] charArray = val.toCharArray();
            for(int j=0; j<charArray.length;j++)
            {
                if(charArray[j]=='1')
                {
                    arr[j]=true;
                }
                else
                {
                    arr[j]=false;
                }
            }
            result.add(arr);
            arr=null;
            val=null;
        }
System.out.println("AND condition");
        for(int i=1;i<result.size();i++)
        {
            for(boolean b: result.get(i))
            {
                System.out.print(b+" ");
            }
            if(result.get(i)[0]&&result.get(i)[1]/*&&result.get(i)[2]*/) {
            System.out.println("should be triggered");
            }else {
            System.out.println("should not be triggered");
            }
            System.out.println();
          
            
        }
        
        return result;
        
        
//System.out.println("OR Condition");   
//for(int i=0;i<result.size();i++)
//{
//    for(boolean b: result.get(i))
//    {
//        System.out.print(b+" ");
//    }
//    if(result.get(i)[0]||result.get(i)[1]) {
//    System.out.println("trigger");
//    }else {
//    System.out.println("No trigger");
//    }
//    System.out.println();
//  
//    
//}
        
    }
    
    
    public void oneAnd(ArrayList<boolean[]> result) {
    	System.out.println("AND condition");
        for(int i=1;i<result.size();i++)
        {
            for(boolean b: result.get(i))
            {
                System.out.print(b+" ");
            }
            if(result.get(i)[0]&&result.get(i)[1]/*&&result.get(i)[2]*/) {
            System.out.println("should be triggered");
            }else {
            System.out.println("should not be triggered");
            }
            System.out.println();
          
            
        }
    }
    
    public boolean oneAnd(boolean[] result,HashMap<Integer,String> condiT) {
//        System.out.println("AND condition");
       
        int maxCond = result.length;
        int noOfOR = 0;
        int noOfAND = 0;
        HashMap<Integer,Integer> ORMap = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> ANDMap = new HashMap<Integer,Integer>();
       
        boolean returnVal = false;
       
       
        Set<Integer> nCon = condiT.keySet();
       
        for(int g : nCon) {
       
        String condP = condiT.get(g);
        if(condP.equalsIgnoreCase("OR")) {
        ORMap.put(noOfOR+1, g);
        noOfOR++;
        }else if(condP.equalsIgnoreCase("AND")) {
        ANDMap.put(noOfAND+1, g);
        noOfAND++;
        }
        }
       
        if(noOfOR>0 & noOfAND>0) {//both AND & OR condition present
       

       
        Set<Integer> orSet = ORMap.keySet();
       
        for(int setOr:orSet) {
       
        	result[ORMap.get(setOr)] =result[ORMap.get(setOr)-1] | result[ORMap.get(setOr)];
        	result[ORMap.get(setOr)-1] = result[ORMap.get(setOr)];
        }
       
        boolean test=result[0];
        
        for(int n=0;n<maxCond-1;n++) {
        test &= result[n] & result[n+1];
        }
        returnVal = test;
       
       
        }else if(noOfOR==0 & noOfAND>0 ) { //only AND condition present
       
        boolean test=result[0];
       
        for(int n=0;n<noOfAND;n++) {
        test &= result[n] & result[n+1];
        }
        returnVal = test;
       
        }else if(noOfOR>0 & noOfAND==0 ) {//only OR condition present
       
        boolean test=result[0];
       
        for(int n=0;n<noOfOR;n++) {
        test |= result[n] | result[n+1];
        }
        returnVal = test;
        }
       
       
     
       
       
        return returnVal;

        }
 
    
}