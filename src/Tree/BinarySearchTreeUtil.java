package Tree;

public class BinarySearchTreeUtil {

	public boolean areTreeSame(final Node rootNode1, final Node rootNode2) {
		if (rootNode1 == null && rootNode2 == null) {
			return true;
		}

		if (rootNode1 == null || rootNode2 == null) {
			return false;
		}

		return rootNode1.data == rootNode2.data && areTreeSame(rootNode1.left, rootNode2.left) && areTreeSame(rootNode1.right, rootNode2.right);
	}
}
