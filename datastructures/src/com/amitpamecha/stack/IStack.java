package com.amitpamecha.stack;

public interface IStack<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public void push(E e) throws IllegalStateException;
	
	public E pop();
	
	public E top();
}
