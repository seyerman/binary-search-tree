package binarySearchTree;

/**
 * A data structure based in trees, in which each node may have a left or a right child node. These nodes share a property, in which the left child node is always lesser or equal in a certain order than the node, and the node is always lesser than its right child node. With this property, searching and certain special operations such as maxNode and minNode are always done in, given the worst case, O(n)
 * @param <K> A Comparable object that defines the order property of the nodes.
 * @param <T> The objects to be stored in this data structure.
 */
public class BinarySearchTree<K extends Comparable<K>, T> {

	/**First node in the tree, also known as the "root" node*/
	private BSTNode<K, T> root;

	/**
	 * Instantiates a new BST and makes it root node null.
	 */
	public BinarySearchTree() {
		root = null;
	}
	
	
	/**
	 * Searches for an element given its key.
	 * @param k The key to be searched.
	 * @return An element that has a key matching the one given in parameter. Null if couldn't find such element in the BST.
	 */
	public T search(K k) {

		BSTNode<K, T> node = searchNode(k);
		if (node!= null)
			return node.getInfo();
		else
			return null;
	}
	
	/**
	 * Searches for a node given its key
	 * @param k The key of the node given.
	 * @return A node that matches the key given, or null if the key doesn't exist.
	 */
	public BSTNode<K, T> searchNode(K k) {

		BSTNode<K, T> current = root;

		while (current != null && !current.getKey().equals(k)) {

			if (k.compareTo(current.getKey()) < 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return current;
	}
	

	/**
	 * Attempts to add a node in the Binary Search Tree, by checking if the element has already been added in the tree and then adding it, if appliable.
	 * @param k The key of the element to be added.
	 * @param t The element itself to be added.
	 * @return True if the node could be added, False otherwise.
	 */
	public boolean add(K k, T t) {
		BSTNode<K, T> tA = new BSTNode<>(k,t);
		return addNode(tA);
	}
	
	
	/**
	 * Adds a node in the tree, provided that it's key hasn't been added yet.
	 * @param ta The given node to be added in the tree.
	 */
	protected boolean addNode(BSTNode<K, T> tA) {
		if(search(tA.getKey()) != null) {
			return false;
		}		
		
		if(root == null) {
			root = tA;
			return true;
		}
		
		BSTNode<K, T> current = root;
		boolean added = false;
		
		while(!added){
			if(tA.getKey().compareTo(current.getKey())<0) {
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
		x.setRight(y.getLeft());
		if(y.getLeft()!=null) {
			y.getLeft().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent()==null) {
			root = y;
		}else if(x==x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}else {
			x.getParent().setRight(y);
		}
		y.setLeft(x);
		x.setParent(y);
	}
	
	/**
	 * Public call for the rotate left method. Rotates a node in the given key to the left.<br>
	 * <b>PRE:</b> Given key must have already been added in the tree, and has a right child.
	 * @param key The given key of the node to be rotated.
	 */
	public void rotateLeft(K key) {
		BSTNode<K, T> node = searchNode(key);
		rotateLeft(node);
	}
	
	/**
	 * Rotates a given node to the left, provided it has a right child.
	 * @param x Given node to be rotated. Must have a right child.
	 */
	protected void rotateRight(BSTNode<K, T> x) {
		BSTNode<K, T> y = x.getLeft();
		x.setLeft(y.getRight());
		if(y.getRight()!=null) {
			y.getRight().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent()==null) {
			root = y;
		}else if(x==x.getParent().getRight()) {
			x.getParent().setRight(y);
		}else {
			x.getParent().setLeft(y);
		}
		y.setRight(x);
		x.setParent(y);
	}
	
	/**
	 * Public call for the rotate right method. Rotates a node in the given key to the right.<br>
	 * <b>PRE:</b> Given key must have already been added in the tree, and has a left child.
	 * @param key The given key of the node to be rotated.
	 */
	public void rotateRight(K key) {
		BSTNode<K, T> n = searchNode(key);
		rotateRight(n);
	}
	
	
	public String toString() {
		return toString(root, "", true);
	}
	
	/**
	 * Returns a String representation of this BST by navigating it recursively. Method taken from stackoverflow.com Credit to its respective authors.
	 * @param node Current node
	 * @param indent Total representation as of now.
	 * @param last True if the node is the last one to be used.
	 * @return A formatted String representing a tree.
	 */
	private String toString(BSTNode<K, T> node, String indent, boolean last){
		String treeString = "";
	    treeString = indent + "+- " + node +"\n";
	    indent += last ? "   " : "|  ";

	    if(node.getLeft()!=null) {
	    	treeString += toString(node.getLeft(), indent, node.getRight()==null);
	    }else if(node.getRight()!=null) {
	    	treeString += indent+"|\n";
	    }
	    
	    if(node.getRight()!=null) {
	    	treeString += toString(node.getRight(), indent, true);
	    }
	    
	    return treeString;
	    
	}

}
