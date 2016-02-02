package com.amitpamecha.positionallist;

/**
 * Doubly linked list implementation of positional list.
 * @author apamecha
 *
 * @param <E>
 */
public class LinkedPositionalList<E> implements IPositionalList<E> {

	/*
	 * nested node class 
	 */
	private static class Node<E> implements IPosition<E>{

		private E element;
		
		private Node<E> prev;
		
		private Node<E> next;
		
		public Node(E e, Node<E> prevNode, Node<E> nextNode){
			this.element=e;
			this.prev=prevNode;
			this.next=nextNode;
		}
		@Override
		public E getElement() throws IllegalStateException {
			if(getNext()==null){
				throw new IllegalStateException("Position is no longer valid");
			}
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
		public void setElement(E element) {
			this.element = element;
		}
		
	}
	
	private int size=0;
	private Node<E> header;
	private Node<E> trailer;
	
	public LinkedPositionalList(){
		header=new Node<E>(null, null, null);
		trailer=new Node<E>(null,header,null);
		header.setNext(trailer);
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public IPosition<E> first() {
		return header.getNext();
	}

	@Override
	public IPosition<E> last() {
		return trailer.getPrev();
	}

	@Override
	public IPosition<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	@Override
	public IPosition<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	@Override
	public IPosition<E> before(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node=validate(p);
		return node.getPrev();
	}

	@Override
	public IPosition<E> after(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getNext();
	}

	@Override
	public IPosition<E> addBefore(IPosition<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}

	@Override
	public IPosition<E> addAfter(IPosition<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	@Override
	public E set(IPosition<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E oldValue = node.getElement();
		node.setElement(e);
		return oldValue;
	}

	@Override
	public E remove(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E oldValue = node.getElement();
		Node<E> prevNode = node.getPrev();
		Node<E> nextNode = node.getNext();
		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		size--;
		return oldValue;
	}
	
	private IPosition<E> addBetween(E e, Node<E> prev, Node<E> next) throws IllegalArgumentException{
		Node<E> newNode = new Node<E>(e, prev, next);
		prev.setNext(newNode);
		next.setPrev(newNode);
		size++;
		return newNode;
		
	}
	
	private Node<E> validate(IPosition<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)){
			throw new IllegalArgumentException("Not a valid position");
		}
		Node<E> node = (Node<E>)p;
		if(node!=null || node.getNext()==null){
			throw new IllegalArgumentException("Position is no longer in the list");
		}
		return node;
	}
	
}
