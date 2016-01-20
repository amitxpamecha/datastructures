package com.amitpamecha.deque;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public interface IDeque<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public E first();
	
	public E last();
	
	public void addFirst(E e) throws IllegalStateException;
	
	public void addLast(E e) throws IllegalStateException;
	
	public E removeFirst() throws IllegalStateException;
	
	public E removeLast() throws IllegalStateException;
	
}
