package com.amitpamecha.doublylinkedlist;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements IDoublyLinkedList<E> {
	
	/*
	 * Nested node class
	 */
	private static class Node<E>{
		private E element;
		private Node<E> prev;
		private Node<E> next;
		
		public Node(E e, Node<E> prev, Node<E> next){
			this.element=e;
			this.prev=prev;
			this.next=next;
		}
		
		public E getElement() {
			return element;
		}
		public Node<E> getPrev() {
			return prev;
		}
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	
	private int size=0;
	private Node<E> head;
	private Node<E> tail;
	
	public DoublyLinkedList() {
		head=new Node<E>(null,null,null);
		tail=new Node<E>(null,head,null);
		head.setNext(tail);
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
	public E first() {
		if(isEmpty()){return null;}
		return head.getNext().getElement();
	}

	@Override
	public E last() {
		if(isEmpty()){return null;}
		return tail.getPrev().getElement();
	}

	@Override
	public void addFirst(E e) {
		Node<E> node = addBetween(e, head, head.getNext());
	}

	@Override
	public void addLast(E e) {
		Node<E> node = addBetween(e, tail.getPrev(), tail);
		
	}

	@Override
	public E removeFirst() {
		if(isEmpty()){return null;}
		return remove(head.getNext());
	}

	@Override
	public E removeLast() {
		if(isEmpty()){return null;}
		return remove(tail.getPrev());
	}
	
	private Node<E> addBetween(E e, Node<E> prev, Node<E> next){
		Node<E> node = new Node<E>(e, prev, next);
		prev.setNext(node);
		next.setPrev(node);
		size++;
		return node;
	}
	
	private E remove(Node<E> node){
		Node<E> nextNode = node.getNext();
		Node<E> prevNode = node.getPrev();
		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);
		size--;
		return node.getElement();
		
	}

}
