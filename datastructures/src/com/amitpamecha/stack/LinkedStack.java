package com.amitpamecha.stack;

import com.amitpamecha.singlylinkedlist.SinglyLinkedList;

public class LinkedStack<E> implements IStack<E> {

	private SinglyLinkedList<E> data=new SinglyLinkedList<E>();
	
	public LinkedStack(){
		
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(E e) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return null;
	}

}
