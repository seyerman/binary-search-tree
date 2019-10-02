package binarySearchTree;

public class BSTNode<K extends Comparable<K>,T> {
	private K key;
	private T info;
	
	private BSTNode<K, T> left;
	private BSTNode<K, T> right;
	
	private BSTNode<K, T> parent;
	
	public BSTNode (K k, T in){
		key = k;
		info = in;
	}
	
	public K getKey() {
		return key;
	}
	
	public T getInfo() {
		return info;
	}
	
	public BSTNode<K, T> getLeft(){
		return left;
	}
	
	public BSTNode<K, T> getParent(){
		return parent;
	}
	
	public BSTNode<K, T> getRight(){
		return right;
	}
	
	public void setLeft(BSTNode<K, T> l) {
		left = l;
	}
	
	public void setRight(BSTNode<K, T> r) {
		right = r;
	}
	
	public void setParent(BSTNode<K, T> p) {
		parent = p;
	}
}
