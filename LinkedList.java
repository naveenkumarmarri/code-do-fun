package com.naveen.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LinkedList {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
	int ch=0;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 
	 System.out.println("enter the dta for first node");
	 int dta=Integer.parseInt(br.readLine());
	 Node head=new Node();
	 head.data=dta;
	 
			System.out.println("enter the dta");
			int dt=Integer.parseInt(br.readLine());
			 createList(dt,head);
		traverse(head);
		insert(5,6,head);
		traverse(head);

		delete(3,head);
		traverse(head);

	}
	public static void createList(int dt,Node n) throws NumberFormatException, IOException
	{
		Node n1=new Node();
		n.node=n1;
		n1.data=dt;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=Integer.parseInt(br.readLine());
		if(ch!=-1)
		{
			int dat=Integer.parseInt(br.readLine());
			 createList(dat,n1);
		}
		if(ch==-1)
		{
			n1.node=null;
		}
	}
	public static void traverse(Node n)
	{
		while(n.node!=null)
		{
			System.out.println(n.data);
			n = n.node;
		}
		if(n.node==null)
		{
			System.out.println(n.data);
		}
	}
	public static void insert(int data,int next,Node no)
	{
		Node n= new Node();
		n.data=next;
		while(no.data!=data)
		{
			no=no.node;
		}
		if((no.data==data)&&(no.node!=null))
		{
			n.node=no.node;
			no.node=n;
			
		}
		if((no.data==data)&&(no.node==null))
		{
			n.node=null;
			no.node=n;
			
		}
	}
	public static void delete(int data, Node no)
	{
		while(no.node.data!=data)
		{
			no=no.node;
		}
		if(no.node.data==data)
		{
			no.node=no.node.node;
		}
	}

}

class Node{
	Node node;
	int data;
}