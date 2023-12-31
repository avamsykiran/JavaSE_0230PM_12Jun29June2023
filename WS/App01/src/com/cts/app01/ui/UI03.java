package com.cts.app01.ui;

import java.util.Scanner;

public class UI03 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Whats your name? ");
		String userName = sc.nextLine();
		
		int len = userName.length();
		
		for(int i=0;i<len;i++) {
			System.out.println(userName.substring(0,i+1));
		}
		
		for(int i=0;i<len;i++) {
			System.out.println(userName.substring(0,len-i));
		}
		
		String rev = (new StringBuffer(userName)).reverse().toString();
		
		System.out.println(rev);
		System.out.println(rev.equalsIgnoreCase(userName)?"A Pallendrome":"Not A Pallendrome");
		
		int words=0;
		int vowels=0;
		int consonants=0;
		int digits=0;
		
		for(int i=0;i<len;i++) {
			String s = userName.substring(i, i+1);
			
			if(s.matches("\\s")) words++;
			else if(s.matches("[aeiouAEIOU]")) vowels++;
			else if(s.matches("[0-9]")) digits++;
		}
		
		consonants = len - vowels - digits - words;
		
		System.out.println("Words: "+words+1);
		System.out.println("Vowels: "+vowels);
		System.out.println("Digits: "+digits);
		System.out.println("Consonents: "+consonants);
		
		sc.close();

	}

}
