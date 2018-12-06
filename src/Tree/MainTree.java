package Tree;

public class MainTree {

	public static void main(final String[] args) {
		final BinarySearchTree bst = new BinarySearchTree();
		bst.addNode(10);
		bst.addNode(16);
		bst.addNode(-5);
		bst.addNode(15);
		bst.addNode(-3);
		bst.addNode(2);
		bst.addNode(18);

		// System.out.println("rootNode: " + bst.rootNode.data);

		bst.printTree();

		// System.out.println("Search Node:" + bst.searchNode(567));
		// bst.printTopView();

		// final BinarySearchTree bst1 = new BinarySearchTree();
		// bst1.addNode(10);
		// bst1.addNode(16);
		// bst1.addNode(-5);
		// bst1.addNode(15);
		// bst1.addNode(-3);
		// bst1.addNode(2);
		// bst1.addNode(18);
		//
		// final BinarySearchTree bst2 = new BinarySearchTree();
		// bst2.addNode(10);
		// bst2.addNode(16);
		// bst2.addNode(-5);
		// bst2.addNode(15);
		// bst2.addNode(-3);
		// bst2.addNode(2);
		// bst2.addNode(18);
		// final BinarySearchTreeUtil bstUtil = new BinarySearchTreeUtil();
		// System.out.println("Are Tree same: " + bstUtil.areTreeSame(bst1.rootNode,
		// bst2.rootNode));

		// System.out.println("Tree Size: " + bst.size());
		// System.out.println("Tree Height: " + bst.getHeight());
		// System.out.println("Level Order Traversal: ");
		// bst.printLevelOrderTraversal();
		// System.out.println("Sum: " + bst.sum());
		// System.out.println("is binary search tree: " + bst.isTreeBinarySearchTree());

		// final BinarySearchTree newTree = new BinarySearchTree();
		// final Node n1 = new Node(100);
		// final Node n2 = new Node(200);
		// final Node n3 = new Node(130);
		// final Node n4 = new Node(10);
		//
		// newTree.rootNode = n4;
		// newTree.rootNode.left = n1;
		// newTree.rootNode.right = n2;
		// newTree.rootNode.left.left = n3;
		// newTree.rootNode.left.right = n4;
		//
		// System.out.println("is new binary search tree: " +
		// newTree.isTreeBinarySearchTree());

		System.out.println("Iterative Post Order Traversal");
		bst.printIterativePostOrderTraversal();
		//
		// System.out.println();
		// System.out.println("Iterative Pre Order Traversal");
		// bst.printIterativePreorderTraversal();
		//
		// System.out.println();
		// System.out.println("Iterative In Order Traversal");
		// bst.printIterativeInorderTraversal();

		//		System.out.println("Print Level Order Traversal Reverse");
		//		bst.printLevelOrderTraversalReverse();
		//
		//		System.out.println();
		//		System.out.println("Print Level Order Traversal Spiral Order Two Stack");
		//		bst.printLevelOrderTraversalInSpiralOrderTwoStack();
		//
		//		System.out.println();
		//		System.out.println("Print Level Order Traversal Spiral Order Dqueue");
		//		bst.printLevelOrderTraversalInSpiralOrderDqueue();

		System.out.println();
		System.out.println("print Iterative Traversal Bt One Stack");
		bst.printIterativePostOrderTraversalBtOneStack();
	}

}
