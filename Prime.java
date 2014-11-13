package com.naveen.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


 class Prime {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int in=Integer.parseInt(br.readLine());
		Stack <Character> s =new Stack<Character>();
		String output="";
		String [] str=new String[in];
		for(int i=0;i<in;i++)
		{
			 str[i]=br.readLine();
		}
		for(int i=0;i<str.length;i++ )
		{
			String st=str[i];
			char [] ch=st.toCharArray();
			for(char c:ch)
			{
				switch(c)
				{
				case '(':
					s.push('(');
				case '+':
				case '-':
					while (!s.isEmpty()) {
				         char opTop = s.pop();
				         if (opTop == '(') {
				            s.push(opTop);
				            break;
				         }
				         else {
				            
				               s.push(opTop);
				               break;
				             }
					}
				case '*':
				case '/':
					while (!s.isEmpty()) {
				         char opTop = s.pop();
				         if (opTop == '(') {
				            s.push(opTop);
				            break;
				         }
				         else {
				              output = output + opTop;
				         }
					}
				case ')':
					while(!(s.isEmpty()))
					{
						if((c=s.pop())=='(')
								{
									break;
								}
						else
						{
							output=output+c;
						}
					}
					default:
						output=output+c;
				}
				
				while (!s.isEmpty()) {
			         output = output + s.pop();
			      }
			      System.out.println(output);
			      
			}
		}
			}

	



}
