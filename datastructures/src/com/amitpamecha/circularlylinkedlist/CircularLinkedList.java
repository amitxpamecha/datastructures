package com.amitpamecha.circularlylinkedlist;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public class CircularLinkedList<E> implements ICircularLinkedList<E> {

	private static class Node<E>{
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> node){
			this.element=e;
			this.next=node;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private Node<E> tail;
	private int size=0;
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public E first() {
		if(isEmpty()){return null;}
		return tail.getNext().getElement();
	}

	@Override
	public E last() {
		if(isEmpty()){return null;}
		return tail.getElement();
	}

	@Override
	public void addFirst(E e) {
		if(isEmpty()){
			Node<E> node = new Node<E>(e,null);
			this.tail=node;
		}else{
			Node<E> node = new Node<E>(e,tail.getNext());
			tail.setNext(node);
		}
		size++;
	}

	@Override
	public void addLast(E e) {
		if(isEmpty()){
			Node<E> node = new Node<E>(e,null);
			this.tail=node;
		}else{
			Node<E> node = new Node<E>(e,tail.getNext());
			this.tail=node;
		}
		size++;
	}

	@Override
	public E removeFirst() {
		if(isEmpty()){return null;}
		Node<E> head = tail.getNext();
		if(head==tail){
			tail=null;
		}else{
			tail.setNext(head.getNext());
		}
		size--;
		return head.getElement();
	}

	@Override
	public void rotate() {
		if(tail!=null){
			this.tail=tail.getNext();
		}
	}

}
