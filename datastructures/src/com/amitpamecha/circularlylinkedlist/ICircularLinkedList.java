package com.amitpamecha.circularlylinkedlist;

public interface ICircularLinkedList<E> {

		public int size();
		public boolean isEmpty();
		public E first();
		public E last();
		public void addFirst(E e);
		public void addLast(E e);
		public E removeFirst();
		public void roate();

}
