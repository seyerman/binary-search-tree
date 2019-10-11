package avl;

import binarySearchTree.BSTNode;
import binarySearchTree.BinarySearchTree;

public class AVLTree<K extends Comparable<K>,T> extends BinarySearchTree<K, T> {
	public boolean add(K k, T t) {
		AVLNode<K, T> N = new AVLNode<>(k,t);
		
		boolean added = addNode(N);
		if(added) {
			// N is the child of P whose height increases by 1.
			AVLNode<K, T> P = (AVLNode<K,T>)N.getParent();
			
			boolean balanced = false;
			while(P!=null && !balanced) {
				// balance_factor(P) has not yet been updated!
				if(N==P.getLeft()) {// the left subtree increases
					
					if(P.getBalanceFactor()==1) { // ==> the temporary balance_factor(P) == 2 ==> rebalancing is required.
						
						if(N.getBalanceFactor()==-1) { // Left Right Case
							leftRotate(N); // Reduce to Left Left Case
						}
						
						// Left Left Case
						rightRotate(P);
						balanced = true; // Leave the loop
					}
					
					if(P.getBalanceFactor()==-1) {
						P.setBalanceFactor(0); // N’s height increase is absorbed at P.
						balanced = true; // Leave the loop
					}
					P.setBalanceFactor(1); // Height increases at P
				}else { // N == right_child(P), the child whose height increases by 1.
					if(P.getBalanceFactor()==-1) { // ==> the temporary balance_factor(P) == -2 ==> rebalancing is required.
						if(N.getBalanceFactor()==1) { // Right Left Case
							rightRotate(N); // Reduce to Right Right Case
						}
						// Right Right Case
						leftRotate(P);
						balanced = true; // Leave the loop
					}
					
					if(P.getBalanceFactor()==1) {
						P.setBalanceFactor(0); // N’s height increase is absorbed at P.
						balanced = true;
					}
					
					P.setBalanceFactor(-1); // Height increases at P
				}
				N = P;
				P = (AVLNode<K,T>)N.getParent();
				
			}
		}
		return added;
	}	
}
