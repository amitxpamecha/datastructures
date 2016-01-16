package com.amitpamecha.positionallist;

public interface IPositionalList<E> {

	int size();
	
	boolean isEmpty();
	
	IPosition<E> fist();
	
	IPosition<E> last();
	
	IPosition<E> addFist(E e);
	
	IPosition<E> addLast(E e);
	
	IPosition<E> before(IPosition<E> p) throws IllegalArgumentException;
	
	IPosition<E> after(IPosition<E> p) throws IllegalArgumentException;
	
	IPosition<E> addBefore(IPosition<E> p, E e) throws IllegalArgumentException;
	
	IPosition<E> addAfter(IPosition<E> p, E e) throws IllegalArgumentException;
	
	E set(IPosition<E> p, E e) throws IllegalArgumentException;
	
	E remove(IPosition<E> p) throws IllegalArgumentException;
}
