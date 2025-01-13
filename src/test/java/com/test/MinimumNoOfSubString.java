package com.test;

import java.util.HashSet;
import java.util.Set;

public class MinimumNoOfSubString {

	public static void main(String[] args) {
		
		String str= "dddd";
		
		//String str= "working";
		Set<Character> st= new HashSet<>();
		 int count=1;
		for(int i=0; i<str.length(); i++)
		{
			char ch= str.charAt(i);
			if(st.contains(ch))
			{
				count++;
				st.clear();
			}
			st.add(ch);
		}
		
		System.out.println(count);
		

	}

}
