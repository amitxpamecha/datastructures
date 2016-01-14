package com.amitpamecha.positionallist;

public interface PositionalList<E> {

	int size();
	
	boolean isEmpty();
	
	Position<E> fist();
	
	Position<E> last();
	
	Position<E> addFist(E e);
	
	Position<E> addLast(E e);
	
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	E remove(Position<E> p) throws IllegalArgumentException;
}
