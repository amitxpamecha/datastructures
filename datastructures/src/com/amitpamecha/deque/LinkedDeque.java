package com.amitpamecha.deque;

import com.amitpamecha.doublylinkedlist.DoublyLinkedList;

/**
 * Concrete implementation of Deque through DoublyLinkedList.
 * @author amitxpamecha
 *
 * @param <E>
 */
public class LinkedDeque<E> implements IDeque<E>{
	
	private DoublyLinkedList<E> data = new DoublyLinkedList<E>();

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public void addFirst(E e) throws IllegalStateException {
		data.addFirst(e);
		
	}

	@Override
	public void addLast(E e) throws IllegalStateException {
		data.addLast(e);
	}

	@Override
	public E removeFirst() throws IllegalStateException {
		E element = data.removeFirst();
		return element;
	}

	@Override
	public E removeLast() throws IllegalStateException {
		E element = data.removeLast();
		return element;
	}
	
	@Override
	public E first() {
		return data.first();
	}

	@Override
	public E last() {
		return data.last();
	}

}
