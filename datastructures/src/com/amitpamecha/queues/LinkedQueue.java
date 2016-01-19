package com.amitpamecha.queues;

import com.amitpamecha.singlylinkedlist.SinglyLinkedList;

/**
 * Concrete implementation of Queue through LinkedList.
 * @author amitxpamecha
 *
 * @param <E>
 */
public class LinkedQueue<E> implements IQueue<E> {
	
	private SinglyLinkedList<E> data = new SinglyLinkedList<E>();

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public void enqueue(E e) throws IllegalStateException {
		data.addLast(e);
	}

	@Override
	public E dequeue() {
		return data.removeFirst();
	}

	@Override
	public E first() {
		return data.first();
	}

}
