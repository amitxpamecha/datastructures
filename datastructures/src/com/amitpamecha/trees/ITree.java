package com.amitpamecha.trees;

import java.util.Iterator;

import com.amitpamecha.positionallist.IPosition;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public interface ITree<E> extends Iterable<E> {
	
	IPosition<E> root();
	
	IPosition<E> parent(IPosition<E> p) throws IllegalArgumentException;
	
	Iterable<IPosition<E>> children(IPosition<E> p) throws IllegalArgumentException;
	
	int numChildren(IPosition<E> p) throws IllegalArgumentException;
	
	boolean isInternal(IPosition<E> p) throws IllegalArgumentException;
	
	boolean isExternal(IPosition<E> p) throws IllegalArgumentException;
	
	boolean isRoot(IPosition<E> p) throws IllegalArgumentException;
	
	int size();
	
	boolean isEmpty();
	
	Iterator<E> iterator();
	
	Iterable<IPosition<E>> positions();
	
	int depth(IPosition<E> p);
	
	int height(IPosition<E> p);

}
