package binarySearchTree;

import binarySearchTree.BSTNode;

/**
 * An AVL node in the Binary Search Tree data structure. It has an interesting factor known as balance factor (<code>bf</code> in code) that will matter when auto balancing the tree.  
 * @author Jhon Edward Mora - Universidad ICESI - A00355710
 * @param <K> Comparable object that defines the property of order for this node.
 * @param <T> Object that contains the information in this node.
 */
public class AVLNode<K extends Comparable<K>, T> extends BSTNode<K, T> {

	/**The balance factor in this tree, defined as the height of its left subtree minus the height of its right subtree*/
	private int bf;
	
	/**
	 * Instantiates a new AVLNode, using the same parameters as superclass BSTNode, and assigns its balance factor to 0.
	 * @param k The key of this node.
	 * @param in The object holding the information of this node.
	 */
	public AVLNode(K k, T in) {
		super(k, in);
		bf = 0;
	}

	/**
	 * Returns the balance factor of this node. 
	 * @return The balance factor of this node.
	 */
	public int getBalanceFactor() {
		return bf;
	}
	
	/**
	 * Sets the balance factor of this node to the one given in parameter.
	 * @param b The given balance factor.
	 */
	public void setBalanceFactor(int b) {
		bf = b;
	}
}
