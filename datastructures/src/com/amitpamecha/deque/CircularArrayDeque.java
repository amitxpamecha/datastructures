package com.amitpamecha.deque;

public class CircularArrayDeque<E> implements IDeque<E> {
	
	private int front=0;
	private int rear=0;
	private int size=0;
	private E[] data;
	private int CAPACITY=1000;
	
	public CircularArrayDeque(){
		data=(E[])new Object[CAPACITY];
	}
	
	public CircularArrayDeque(int capacity){
		CAPACITY=capacity;
		data=(E[])new Object[CAPACITY];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}


	@Override
	public void addFirst(E e) throws IllegalStateException {
		if(size==CAPACITY){
			throw new IllegalStateException("Deque is full.");
		}
		data[front]=e;
		front = (front-1+CAPACITY)%CAPACITY;
		size++;
	}

	@Override
	public void addLast(E e) throws IllegalStateException {
		if(size==CAPACITY){
			throw new IllegalStateException("Deque is full.");
		}
		data[rear++]=e;
		size++;
	}

	@Override
	public E removeFirst() throws IllegalStateException {
		if(isEmpty()){return null;}
		E element = data[front];
		data[front]=null;
		front=(front+1)%CAPACITY;
		size--;
		return element;
	}

	@Override
	public E removeLast() throws IllegalStateException {
		if(isEmpty()){return null;}
		E element = data[rear];
		data[rear]=null;
		rear=(rear-1+CAPACITY)%CAPACITY;
		size--;
		return element;
	}
	
	@Override
	public E first() {
		if(isEmpty()){return null;}
		return data[front];
	}

	@Override
	public E last() {
		if(isEmpty()){return null;}
		return data[rear];
	}

}
