package com.amitpamecha.trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amitpamecha.positionallist.IPosition;

/**
 * Linked node implementation of Binary tree.
 * @author apamecha
 *
 * @param <E>
 */
public class LinkedBinaryTree<E> extends AbstractTree<E> implements IBinaryTree<E> {

	/*
	 * Nested Node Class
	 */
	private static class Node<E> implements IPosition<E>{
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E e, Node<E> parent, Node<E> left, Node<E> right){
			this.element=element;
			this.parent=parent;
			this.left=left;
			this.right=right;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}
		
		
	}//node class ends
	
	private Node<E> root = null;
	private int size=0;
	
	private Node<E> validate(IPosition<E> p) throws IllegalArgumentException{
		if(!(p instanceof Node)){
			throw new IllegalArgumentException("Invalid position.");
		}
		Node<E> node = (Node<E>)p;
		if(node.getParent()==node){
			throw new IllegalArgumentException("p is no longer in tree.");
		}
		return node;
	}
	
	
	@Override
	public IPosition<E> root() {
		return root;
	}

	@Override
	public IPosition<E> parent(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	/**
	 * Snapshot approach to find children of position
	 */
	@Override
	public Iterable<IPosition<E>> children(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		List<IPosition<E>> list = new ArrayList<IPosition<E>>(2);
		list.add(node.getLeft());
		list.add(node.getRight());
		return list;
	}

	@Override
	public int numChildren(IPosition<E> p) throws IllegalArgumentException {
		int number=0;
		if(left(p)!=null){
			number++;
		}
		if(right(p)!=null){
			number++;
		}
		return number;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public IPosition<E> left(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public IPosition<E> right(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public IPosition<E> sibling(IPosition<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> parentNode = node.getParent();
		if(parentNode!=null){
			if(parentNode.getLeft()==node){
				return node.getRight();
			}
			else if(parentNode.getRight()==node){
				return node.getLeft();
			}
		}
			return null;
		
	}
	
	public IPosition<E> addRoot(E e) throws IllegalStateException{
		if(!isEmpty()){
			throw new IllegalStateException("Tree is not empty.");
		}
		
		Node<E> node = new Node<E>(e, null, null, null);
		size=1;
		return node;
	}
	
	public IPosition<E> addLeft(IPosition<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(node.getLeft()!=null){
			throw new IllegalArgumentException("p already has a left node");
		}
		Node<E> leftNode = new Node<E>(e,node,null,null);
		node.setLeft(leftNode);
		size++;
		return leftNode;
	}
	
	public IPosition<E> addRight(IPosition<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(node.getRight()!=null){
			throw new IllegalArgumentException("p already has a right node");
		}
		Node<E> rightNode = new Node<E>(e,node,null,null);
		node.setRight(rightNode);
		size++;
		return rightNode;
	}

	public E set(IPosition<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		E temp = node.getElement();
		node.setElement(e);
		return temp;
	}
	
	public void attach(IPosition<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(isInternal(p)){
			throw new IllegalArgumentException("p must be a leaf node");
		}
		size = size+t1.size()+t2.size();
		if(!t1.isEmpty()){
			node.setLeft(t1.root);
			t1.root.setParent(node);
			t1.root=null;
			t1.size=0;
		}
		if(!t2.isEmpty()){
			node.setRight(t2.root);
			t2.root.setParent(node);
			t2.root=null;
			t2.size=0;
		}
		
	}
	
	public E remove(IPosition<E> p) throws IllegalArgumentException{
		Node<E> node = validate(p);
		if(numChildren(p)==2){
			throw new IllegalArgumentException("p has two children");
		}
		Node<E> child = node.getLeft()==null?node.getLeft() : node.getRight();
		
		if(child!=null){
			child.setParent(node.getParent());
		}
		if(node==root()){
			root=child;
		}else{
			Node<E> parent = node.getParent();
			if(parent.getLeft()==node){
				parent.setLeft(child);
			}else if(parent.getRight()==node){
				parent.setRight(child);
			}
		}
		size--;
		E temp = node.getElement();
		node.setLeft(null);
		node.setRight(null);
		node.setParent(null);
		return temp;
	}
	
	/**
	 * This method returns an iterable container of the positions of the tree, reported in inorder.
	 */
	public Iterable<IPosition<E>> inorder(){
		List<IPosition<E>> snapshot = new ArrayList<IPosition<E>>();
		if(!isEmpty()){
			inorderSubTree(root(), snapshot);
		}
		return snapshot;
	}
	
	private void inorderSubTree(IPosition<E> node, List<IPosition<E>> snapshot){
		if(left(node)!=null){
			inorderSubTree(left(node), snapshot);
		}
		snapshot.add(node);
		if(right(node)!=null){
			inorderSubTree(right(node), snapshot);
		}
	}
}
