package com.amitpamecha.stack;

import com.amitpamecha.singlylinkedlist.SinglyLinkedList;

public class LinkedStack<E> implements IStack<E> {

	private SinglyLinkedList<E> data=new SinglyLinkedList<E>();
	
	public LinkedStack(){
		
	}
	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public void push(E e) throws IllegalStateException {
		data.addFirst(e);
		
	}

	@Override
	public E pop() {
		return data.removeFirst();
	}

	@Override
	public E top() {
		return data.first();
	}

}
