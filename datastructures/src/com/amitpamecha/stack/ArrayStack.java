package com.amitpamecha.stack;

public class ArrayStack<E> implements IStack<E> {

	private int CAPACITY=1000;
	private int index=-1;
	private E[] data = null;
	
	public ArrayStack(){
		this.data=(E[])new Object[CAPACITY];
	}
	
	public ArrayStack(int capacity){
		this.CAPACITY=capacity;
		this.data=(E[])new Object[CAPACITY];
	}
	
	@Override
	public int size() {
		return index+1;
	}

	@Override
	public boolean isEmpty() {
		return index<0;
	}

	@Override
	public void push(E e) throws IllegalStateException {
		if(size()==this.CAPACITY){
			throw new IllegalStateException("Stack is full.");
		}
		index++;
		this.data[index]=e;
		
	}

	@Override
	public E pop() {
		if(isEmpty()){
			return null;
		}
		E temp = data[index];
		data[index]=null;
		index--;
		return temp;
	}

	@Override
	public E top() {
		if(isEmpty()){
			return null;
		}
		return data[index];
	}

}
