package com.naveen.prac;

/*ASSIGNMENT NO:4
PROBLEM:CONVERSION OF INFIX TO POSTFIX
DESIGNED AND DEVELOPED BY:M.SIVA KUMAR
ROLL NO:10906012
*/

import java.io.*;
import java.lang.*;
import java.util.*;
class postfix
{
	char a[]=new char[50];
	int top=1;
	char x;
	char stack[]=new char[50];
	BufferedReader obj=new BufferedReader(new InputStreamReader(System.in));
	public void read()throws IOException
	{
		System.out.println("Enter the infix expression and -1 at end");
		String s1=obj.readLine();
		for(int i=0;i<s1.length();i++)
		{
		a[i]=s1.charAt(i);
		}
		stack[top]='#';
		System.out.println("the postfix expression is: ");
		for(int i=0;i<a.length;i++)
		{
			x=a[i];
			if(x==-1)
			{
				while(top>1)
				{
					System.out.println(stack[top]);
					top--;
				}
			}
			else if(x>='A'&&x<='Z')
			{
				System.out.println(x);
			}
			else if(x==')')
			{
				while (stack[top]!='(')
				{
					System.out.println(stack[top]);
					top--;
				}
				top--;
			}
			else
			{
				while(ISP(stack[top])>=ICP(x));
				{
					System.out.println(stack[top]);
					top--;
				}
				add(x);
			}
		}
	}
	void add(char x)
	{
		top++;
		stack[top]=x;
	}
	public int ISP(char ch)
	{
		switch(ch)
		{
			case '^':return(3);
			case '*':
			case '/':return(2);
			case '+':
			case '-':return(1);
			case '(':return(4);
			case ')':return(0);
		}
		return(-1);
	}
	public int ICP(char ch)
	{
		switch(ch)
		{
			case '@':return(4);
			case '*':
			case '/':return(2);
			case '+':
			case '-':return(1);
			case '(':return(4);
			case ')':return(0);
		}
		return(-1);
	}
}
class Problem4
{
public static void main(String args[])throws IOException
{
postfix p=new postfix();
p.read();
}
}