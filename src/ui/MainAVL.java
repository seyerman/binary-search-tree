package ui;

import avl.AVLTree;

/**
 * Simple main class to test different methods and functions of class AVL
 */
public class MainAVL {

	public static void main(String[] args) {
		AVLTree<Integer, String> avl1 = new AVLTree<Integer, String>();
		
		avl1.add(15, "Juan");
		avl1.add(7, "Cristian");
		avl1.add(23, "Sergio");
		avl1.add(12, "Andrés");
		avl1.add(5, "Felipe");
		avl1.add(2, "Mateo");
		avl1.add(36, "Nicolás");
		
		System.out.println(avl1);		
	}

}
