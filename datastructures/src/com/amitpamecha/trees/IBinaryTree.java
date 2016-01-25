package com.amitpamecha.trees;

import com.amitpamecha.positionallist.IPosition;

public interface IBinaryTree<E> extends ITree<E>{

	IPosition<E> left(IPosition<E> p) throws IllegalArgumentException;
	
	IPosition<E> right(IPosition<E> p) throws IllegalArgumentException;
	
	IPosition<E> sibling(IPosition<E> p) throws IllegalArgumentException;
	
	Iterable<IPosition<E>> inorder();
}
