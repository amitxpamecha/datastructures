package com.amitpamecha.trees;

import com.amitpamecha.positionallist.IPosition;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public abstract class AbstractTree<E> implements ITree<E> {


	@Override
	public boolean isInternal(IPosition<E> p) throws IllegalArgumentException {
		return numChildren(p)>0;
	}

	@Override
	public boolean isExternal(IPosition<E> p) throws IllegalArgumentException {
		return numChildren(p)==0;
	}

	@Override
	public boolean isRoot(IPosition<E> p) throws IllegalArgumentException {
		return p==root();
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	
	/**
	 * The running time of depth(p) for position p is O(dp + 1), 
	 * where dp denotes the depth of p in the tree, 
	 * because the algorithm performs a constant-time recursive step for each ancestor .
	 */
	@Override
	public int depth(IPosition<E> p){
		if(isRoot(p)){
			return 0;
		}else{
			return 1+depth(parent(p));
		}
	}
	
	@Override
	public int height(IPosition<E> p){
		int height=0;
		for(IPosition<E> c : children(p)){
			height=Math.max(height, 1+height(c));
		}
		return height;
	}

}
