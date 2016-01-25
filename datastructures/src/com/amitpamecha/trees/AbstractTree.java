package com.amitpamecha.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amitpamecha.positionallist.IPosition;
import com.amitpamecha.queues.LinkedQueue;

/**
 * 
 * @author amitxpamecha
 *
 * @param <E>
 */
public abstract class AbstractTree<E> implements ITree<E> {

	/*
	 * Nested class 
	 */
	private class ElementIterator implements Iterator<E> {
		
		Iterator<IPosition<E>> posIterator = positions().iterator();

		@Override
		public boolean hasNext() {
			return posIterator.hasNext();
		}

		@Override
		public E next() {
			return posIterator.next().getElement();
		}

		@Override
		public void remove() {
			posIterator.remove();
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	@Override
	public Iterable<IPosition<E>> positions() {
		return null;
	}
	
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
	
	/**
	 * This method returns an iterable container of the positions of the tree in preorder.
	 * @return
	 */
	public Iterable<IPosition<E>> preorder(){
		List<IPosition<E>> snapshot = new ArrayList<IPosition<E>>();
		if(!isEmpty()){
			preorderSubTree(root(),snapshot);
		}
		return snapshot;
	} 
	
	private void preorderSubTree(IPosition<E> node,List<IPosition<E>> snapshot){
		snapshot.add(node);
		for(IPosition<E> child : children(node)){
			preorderSubTree(child,snapshot);
		}
	}
	
	/**
	 * This method returns an iterable container of the positions of the tree in postorder.
	 * @return
	 */
	public Iterable<IPosition<E>> postorder(){
		List<IPosition<E>> snapshot = new ArrayList<IPosition<E>>();
		if(!isEmpty()){
			postorderSubTree(root(), snapshot);
		}
		return snapshot;
	}
	
	private void postorderSubTree(IPosition<E> node, List<IPosition<E>> snapshot){
		for(IPosition<E> child : children(node)){
			postorderSubTree(child, snapshot);
			snapshot.add(node);	
		}
			
	}
	
	/**
	 * This method returns an iterable container of the positions of the tree is such a pattern
	 * that we traverse a tree visiting all the positions at depth d before we visit the 
	 * positions at depth d + 1. 
	 * @return
	 */
	public Iterable<IPosition<E>> breadthfirst(){
		List<IPosition<E>> snapshot=new ArrayList<IPosition<E>>();
		if(!isEmpty()){
			LinkedQueue<IPosition<E>> queue = new LinkedQueue<IPosition<E>>();
			queue.enqueue(root());
			while(!queue.isEmpty()){
				IPosition<E> node = queue.dequeue();
				snapshot.add(node);
				for(IPosition<E> child : children(node)){
					queue.enqueue(child);
				}
			}
		}
		return snapshot;
	}
	
}
