package com.amitpamecha.positionallist;

public interface Position<E> {
	
	E getElement() throws IllegalStateException;

}
