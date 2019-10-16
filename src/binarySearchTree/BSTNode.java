package binarySearchTree;

/**
 * This class represents each of the nodes in the Binary Search Tree data structure. This nodes meet two main properties, being the first that they always have, at most, two child nodes: a left child node and a right child node; and the second property being that the left child node is always lesser or equal than the node, and the node being always lesser than its right child node. 
 * @param <K> A Comparable object that defines the order property between the nodes.
 * @param <T> The object to be stored in this node.
 */
public class BSTNode<K extends Comparable<K>,T> {
	
	/**The key that defines the order property between the nodes.*/
	private K key;
	
	/**The object to be stored in this node.*/
	private T info;
	
	/**The left child node of this node.*/
	private BSTNode<K, T> left;
	
	/**The right child node of this node.*/
	private BSTNode<K, T> right;
	
	/**The parent node of this node.*/
	private BSTNode<K, T> parent;
	
	/**
	 * Instantiates a new BSTNode with the given information as its parameters.
	 * @param k The key of this node. 
	 * @param in The element stored in this node.
	 */
	public BSTNode (K k, T in){
		key = k;
		info = in;
	}
	
	/**
	 * Returns the key of this node.
	 * @return the key of this node.
	 */
	public K getKey() {
		return key;
	}
	
	/**
	 * Returns the stored element in this node.
	 * @return The stored element in this node.
	 */
	public T getInfo() {
		return info;
	}
	
	/**
	 * Returns the left child node of this node.
	 * @return the left child node of this node.
	 */
	public BSTNode<K, T> getLeft(){
		return left;
	}
	
	/**
	 * Returns the parent node of this node.
	 * @return the parent node of this node.
	 */
	public BSTNode<K, T> getParent(){
		return parent;
	}
	
	/**
	 * Returns the left child node of this node.
	 * @return the left child node of this node.
	 */
	public BSTNode<K, T> getRight(){
		return right;
	}
	
	/**
	 * Sets the left child of this node to the one received as parameter.
	 * @param l The node to be set as left child of this node.
	 */
	public void setLeft(BSTNode<K, T> l) {
		left = l;
	}
	
	/**
	 * Sets the right child of this node to the one received as parameter.
	 * @param r The node to be set as right child of this node.
	 */
	public void setRight(BSTNode<K, T> r) {
		right = r;
	}
	
	/**
	 * Sets the parent node of this node to the one received as parameter.
	 * @param p The node to be set as parent of this node.
	 */
	public void setParent(BSTNode<K, T> p) {
		parent = p;
	}
	
	public String toString() {
		return getKey() + "(" + getInfo() + ")";
	}
}
