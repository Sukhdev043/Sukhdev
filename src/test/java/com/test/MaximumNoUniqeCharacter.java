package com.test;

import java.util.HashSet;
import java.util.Set;

public class MaximumNoUniqeCharacter {

	public static void main(String[] args) {
	
		//String with maximum number of unique characters
		
	//String[] str= {"AN KOW", "LO JO", "ZEW DO RO"};
		//Output: “ZEW DO RO” 
	
	String str[] = { "BOB", "A AB C JOHNSON", "ANJALI",
            "ASKRIT", "ARMAN MALLIK" };
	String st=MaximumNo(str);
	System.out.println(st);

	}
	
	public static String MaximumNo(String[] str)
	{
		
		int count=1;
		String result="";
		int res=0;
		Set<Character> set = new HashSet<>();
		for(int i=0; i<str.length;i++)
		{
			String temp= str[i];
			for(int j=0; j<temp.length(); j++)
			{
				char ch= temp.charAt(j);
				if(!set.contains(ch))
				{
					count++;
					set.add(ch);
					
				}
			}
				if(count>res)
				{
					res= count;
				    result= str[i];
				}
			 
				count=1;
				set.clear();
		
	    }
		
		return result;
	}
	

}
