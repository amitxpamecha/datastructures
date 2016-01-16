package com.amitpamecha.singlylinkedlist;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public class SinglyLinkedList<E> implements ISinglyLinkedList<E> {

	/*
	 * nested class Node which will have reference 
	 * to element stored and reference to subsequent 
	 * node in the list.
	 */
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
	
	private Node<E> head;
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
		return head.getElement();
	}
	@Override
	public E last() {
		return tail.getElement();
	}
	@Override
	public void addFirst(E e) {
		size++;
		Node<E> node = new Node<E>(e, head);
		if(isEmpty()){
			this.tail=node;
		}
		this.head=node;
		
		
	}
	@Override
	public void addLast(E e) {
		size++;
		Node<E> node = new Node<E>(e,null);
		if(isEmpty()){
			this.head=node;
		}
		this.tail.setNext(node);
		this.tail=node;
		
	}
	@Override
	public E removeFirst() {
		if(isEmpty()){
			return null;
		}
		Node<E> node = this.head;
		this.head=node.getNext();
		size--;
		if(size==0){
			tail=null;
		}
		
		return node.getElement();
	}
	
}
