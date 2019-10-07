package binarySearchTree;

public class BinarySearchTree<K extends Comparable<K>, T> {

	private BSTNode<K, T> root;

	public BinarySearchTree() {
		root = null;
	}

	public T search(K k) {

		BSTNode<K, T> current = root;

		while (current != null && !current.getKey().equals(k)) {

			if (k.compareTo(current.getKey()) < 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		if (current != null)
			return current.getInfo();
		else
			return null;
	}
	

	/**
	 * Adds a node in the BST, as long as it has not been added yet.
	 * @param k The key of the element to be added.
	 * @param t The element itself to be added.
	 * @return True if the node could be added, False otherwise.
	 */
	public boolean add(K k, T t) {
		//If element has already been added.
		if(search(k) != null) {
			return false;
		}
		
		//Element not added yet. Node created.
		BSTNode<K, T> tA = new BSTNode<>(k,t);
		//Case this BST has no nodes
		if(root == null) {
			root = tA;
			return true;
		}
		
		BSTNode<K, T> current = root;
		boolean added = false;
		
		while(!added){
			if(k.compareTo(current.getKey())<0) {
				if(current.getLeft() != null) {
					current = current.getLeft();
				}else {
					current.setLeft(tA);
					tA.setParent(current);
					added = true;
				}
			}else {
				if(current.getRight() != null){
					current = current.getRight();
				}else {
					current.setRight(tA);
					tA.setParent(current);
					added = true;
				}
			}
		}
		return added;
		
	}

	/**
	 * Returns the maximum element in this Binary Search Tree
	 * @return the maximum element in this BST, found by going down in right nodes until finding a leaf node.
	 */
	public T max() {
		if(root == null) {
			return null;
		}else {
			BSTNode<K, T> current = root;
			while(current.getRight() != null) {
				current = current.getRight();
			}
			return current.getInfo();
		}
	}
	
	/**
	 * Returns the minimum element in this Binary Search Tree
	 * @return the minimum element in this BST, found by going down in left nodes until finding a leaf node.
	 */
	public T min() {
		if(root == null) {
			return null;
		}else {
			BSTNode<K, T> current = root;
			while(current.getLeft() != null) {
				current = current.getLeft();
			}
			return current.getInfo();
		}
	}
	
	/**
	 * Rotates a given node to the left, provided it has a right child.
	 * @param x Given node to be rotated. Must have a right child.
	 */
	protected void rotateLeft(BSTNode<K, T> x) {
		BSTNode<K, T> y = x.getRight();
		BSTNode<K, T> tb = y.getLeft();
		//X left does not change
		//Y Right does not change
		y.setLeft(x);
		x.setParent(y);
		tb.setParent(x);
		x.setRight(tb);
		
		if(x == root) {
			root = y;
		}
	}
	
	/**
	 * Rotates a given node to the left, provided it has a right child.
	 * @param x Given node to be rotated. Must have a right child.
	 */
	protected void rotateRight(BSTNode<K, T> x) {
		BSTNode<K, T> y = x.getLeft();
		BSTNode<K, T> tc = y.getRight();
		//X Right does not change
		//Y Left does not change
		y.setRight(x);
		x.setParent(y);
		tc.setParent(x);
		x.setLeft(tc);
		
		if(x == root) {
			root = y;
		}
	}
	
	public String toString() {
		return toString(root, "", true);
	}
	
	private String toString(BSTNode<K, T> node, String indent, boolean last){
		String treeString = "";
	    treeString = indent + "+- " + node.getKey()+"("+node.getInfo()+")"+"\n";
	    indent += last ? "   " : "|  ";

	    if(node.getLeft()!=null) {
	    	treeString += toString(node.getLeft(), indent, node.getRight()==null);
	    }
	    
	    if(node.getRight()!=null) {
	    	treeString += toString(node.getRight(), indent, true);
	    }
	    
	    return treeString;
	    
	}	

}
