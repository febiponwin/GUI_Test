package com.febi.base;
import java.util.*;
import javax.swing.*;  
import java.awt.event.*;  

import com.febi.base.GUIBase;

public class GUI implements ActionListener{ 
	static int  count = 1;
	static Map<String,List<String>> test;
    JTextField tf1,tf2,tf3;  
    JButton b1,b2,b3,b4;
    JTextArea area;
    JComboBox<String> cb1,cb2;
    StringBuilder sb;
    JRadioButton rb1,rb2;
    GUI(){
    	
    	test = new HashMap<String,List<String>>();
    	sb = new StringBuilder();
        JFrame f= new JFrame("Edit Validater");  
        rb1=new JRadioButton("WNI");    
        rb1.setBounds(50,50,50,30);      
        rb2=new JRadioButton("WNP");    
        rb2.setBounds(100,50,70,30);    
        ButtonGroup bg=new ButtonGroup();    
        bg.add(rb1);bg.add(rb2);
        String fields[]={"Current Payer","Group Policy No"};
        String conditions[]= {"Empty","Not Empty","Equal","Not Equal"};
        cb1=new JComboBox<String>(fields); 
        cb2=new JComboBox<String>(conditions); 
        cb1.setBounds(50,100,90,20); 
        cb2.setBounds(150,100,90,20);
        cb2.addActionListener(this);
        tf1=new JTextField(); //Value field  
        tf1.setBounds(250,100,150,20);  
        tf2=new JTextField();  //edit code field
        tf2.setBounds(80,300,150,20);
        tf2.setEnabled(false);
        
        tf3=new JTextField();  //CID field
        tf3.setBounds(250,50,150,20);
        
        b1=new JButton("AND");  
        b1.setBounds(70,200,100,50);
        b1.addActionListener(this);
        b2=new JButton("OR");
        b2.setBounds(160,200,100,50);
        b2.addActionListener(this);
        b3=new JButton("Finish");
        b3.setBounds(250,200,100,50);
        b3.addActionListener(this);
        b4=new JButton("Run");
        b4.setBounds(250, 300, 100, 50);
        b4.setEnabled(false);
        b4.addActionListener(this);
        
        area=new JTextArea();  
        area.setBounds(50,400, 500,200);
        area.setEditable(false);
        area.setLineWrap(true);
        f.add(area);
        f.add(rb1);f.add(rb2);
        f.add(tf1);f.add(tf2);f.add(tf3);
        f.add(b1);f.add(b2);f.add(b3);f.add(b4);
        f.add(cb1);f.add(cb2);
        f.setSize(800,800);  
        f.setLayout(null);  
        f.setVisible(true);  
    }         
    public void actionPerformed(ActionEvent e) {  
        String value=tf1.getText();
        String CID = tf3.getText();
        
        if(e.getSource()==cb2) {
        	
        	String comp = cb2.getItemAt(cb2.getSelectedIndex());
        	
        	if(comp.equals("Empty")||comp.equals("Not Empty")) {
        		tf1.setText("");
        		tf1.setEnabled(false);
        	}else {
        		tf1.setEnabled(true);
        	}
        }
        
        if(e.getSource()==b3) {
        	b1.setEnabled(false);
            b2.setEnabled(false);
            tf2.setEnabled(true);
            b4.setEnabled(true);
            sb.append(cb1.getItemAt(cb1.getSelectedIndex()));
        	
        	sb.append(" ");
        	
        	sb.append(cb2.getItemAt(cb2.getSelectedIndex()));
        	
        	sb.append(" "+value);
        	area.setText(sb.toString());
        	String keyv = "set_"+count;
        	List<String> loadValues = new ArrayList<String>();
        	loadValues.add(String.valueOf(cb1.getSelectedIndex()));
        	loadValues.add(String.valueOf(cb2.getSelectedIndex()));
        	loadValues.add(value);
        	test.put(keyv, loadValues);
	     }
        
        if(e.getSource()==b1) {
        	
        	if(rb1.isSelected()) {
        		sb.append("For WNI-"+CID+" ");
        	}else if(rb2.isSelected()) {
        		sb.append("For WNP-"+CID+" ");
        	}
        	
        	
        	sb.append(cb1.getItemAt(cb1.getSelectedIndex()));
        	
        	sb.append(" ");
        	
        	sb.append(cb2.getItemAt(cb2.getSelectedIndex()));
        	
        	sb.append(" "+value);
        	
        	sb.append(" AND ");
        	area.setText(sb.toString());
        	
        	String keyv = "set_"+count;
        	List<String> loadValues = new ArrayList<String>();
        	loadValues.add(String.valueOf(cb1.getSelectedIndex()));
        	loadValues.add(String.valueOf(cb2.getSelectedIndex()));
        	loadValues.add(value);
        	test.put(keyv, loadValues);
        	count++;
        }
        if(e.getSource()==b2) {
        	if(!sb.toString().equals("")) {
        		sb.append(cb1.getItemAt(cb1.getSelectedIndex()));
            	
            	sb.append(" ");
            	
            	sb.append(cb2.getItemAt(cb2.getSelectedIndex()));
            	
            	sb.append(" OR ");
            	area.setText(sb.toString());
            	String keyv = "set_"+count;
            	List<String> loadValues = new ArrayList<String>();
            	loadValues.add(String.valueOf(cb1.getSelectedIndex()));
            	loadValues.add(String.valueOf(cb2.getSelectedIndex()));
            	loadValues.add(value);
            	test.put(keyv, loadValues);
            	count++;
        	}else {
        		if(rb1.isSelected()) {
            		sb.append("For WNI-"+CID+" ");
            	}else if(rb2.isSelected()) {
            		sb.append("For WNP-"+CID+" ");
            	}
            	
            	sb.append(cb1.getItemAt(cb1.getSelectedIndex()));
            	
            	sb.append(" ");
            	
            	sb.append(cb2.getItemAt(cb2.getSelectedIndex()));
            	
            	sb.append(" "+value);
            	
            	sb.append(" OR ");
            	
            	area.setText(sb.toString());
            	String keyv = "set_"+count;
            	List<String> loadValues = new ArrayList<String>();
            	loadValues.add(String.valueOf(cb1.getSelectedIndex()));
            	loadValues.add(String.valueOf(cb2.getSelectedIndex()));
            	loadValues.add(value);
            	test.put(keyv, loadValues);
            	count++;
        	}
        }
        if(e.getSource()==b4) {
        	String edit = tf2.getText();
        	sb.append("then "+edit+" should be triggered");
        	area.setText(sb.toString());
        	b3.setEnabled(false);
            Set<String> retrieveValue = test.keySet();//For printing the map which has trigger values
            int nCond=0;
            for(String key:retrieveValue) {
            	System.out.println(key);
            	List<String> jill = test.get(key);
            	for(String printV:jill) {
            		System.out.println(printV);	
            	}
            	if(key.contains("set")) {
            		nCond++;
            	}
            }
         
            int timeToRun = nCond*2;
            Test tr = new Test();
            ArrayList<boolean[]>  result = tr.scenarioGenerator(nCond);
            
            
            List<Map<String,List<String>>> storeV = new ArrayList<Map<String,List<String>>>();
            for(int i=0;i<timeToRun;i++) {
            storeV.add(test);
            }
            
            for(int i=1;i<timeToRun;i++) {
            	
                for(boolean b: result.get(i))
                {
                
                	int getSet = Integer.parseInt(storeV.get(i).get("set_1").get(1));
                	System.out.print(b+" ");
                }
            }
            


        }
         
 
    }  
public static void main(String[] args) {  
		new GUI();
	

    
} }  