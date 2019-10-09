package avl;

import binarySearchTree.BSTNode;

public class AVLNode<K extends Comparable<K>, T> extends BSTNode<K,T>{
	
	private int balanceFactor;
	
	public AVLNode(K k, T in) {
		super(k, in);
		balanceFactor = 0;
	}
	
	public int getBalanceFactor() {
		return balanceFactor;
	}
	
	public void setBalanceFactor(int bf) {
		balanceFactor = bf;
	}
}
