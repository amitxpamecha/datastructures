package com.amitpamecha.queues;

/**
 * Concrete implementation of queue through array.
 * @author amitxpamecha
 *
 * @param <E>
 */
public class ArrayQueue<E> implements IQueue<E> {

	private E[] data;
	private int size=0;
	private int front=0;
	private int CAPACITY=1000;
	
	public ArrayQueue(){
		data = (E[])new Object[CAPACITY];
	}
	
	public ArrayQueue(int capacity){
		data = (E[])new Object[capacity];
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
	public void enqueue(E e) throws IllegalStateException {
		if(size==data.length){
			throw new IllegalStateException("Queue is full.");
		}
		//enqueue:- (f+size)%N
		int index = (front+size)%data.length;
		data[index]=e;
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()){return null;}
		//dequeue:- (f+1)%N
		E element = data[front];
		data[front]=null;
		front = (front+1)%data.length;
		size--;
		return element;
	}

	@Override
	public E first() {
		if(isEmpty()){return null;}
		return data[front];
	}

}
