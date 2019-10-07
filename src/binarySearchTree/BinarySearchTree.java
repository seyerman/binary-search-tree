package binarySearchTree;

public class BinarySearchTree<K extends Comparable<K>, T> {

	private BSTNode<K, T> root;

	public BinarySearchTree() {
		root = null;
	}

	public T search(K k) {

		BSTNode<K, T> node = searchNode(k);
		if (node!= null)
			return node.getInfo();
		else
			return null;
	}
	
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
	
	//Pre: k!=null and t!=null
	public boolean add(K k, T t) {
		if(search(k) != null) {
			return false;
		}
		
		BSTNode<K, T> tA = new BSTNode<>(k,t);
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
	
	//pre: node!=null and node.right!=null
	protected void leftRotate(BSTNode<K, T> x) {
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
	
	public void leftRotate(K key) {
		BSTNode<K, T> node = searchNode(key);
		leftRotate(node);
	}
}
