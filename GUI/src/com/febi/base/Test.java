package com.febi.base;

import java.util.ArrayList;

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
    
}