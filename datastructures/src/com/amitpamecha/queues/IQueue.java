package com.amitpamecha.queues;

/**
 * FIFO implementation
 * @author amitxpamecha
 *
 */
public interface IQueue<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public void enqueue(E e) throws IllegalStateException;
	
	public E dequeue();
	
	public E first();
	
}
