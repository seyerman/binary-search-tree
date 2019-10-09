package avl;

import binarySearchTree.BSTNode;
import binarySearchTree.BinarySearchTree;

public class AVLTree<K extends Comparable<K>,T> extends BinarySearchTree<K, T> {
	public boolean add(K k, T t) {
		AVLNode<K, T> N = new AVLNode<>(k,t);
		
		boolean added = addNode(N);
		if(added) {
			AVLNode<K, T> P = (AVLNode<K,T>)N.getParent();
			if(N==P.getLeft()) {
				
			}
		}
		return added;
	}
}
