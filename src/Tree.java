import java.util.HashMap;
import java.util.Map;

/**
 * Created by ramiz on 11/9/17.
 */
public class Tree {
    class Node {
        int data;
        Node left;
        Node right;
    }

    private int getMin(Node root) {
        //base case: check if leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int min = root.data;
        if (root.left != null) {
            int left = getMin(root.left);
            min = left < min ? left : min;
        }

        if (root.right != null) {
            int right = getMin(root.right);
            min = right < min ? right : min;
        }

        return min;
    }

    private int getMax(Node root) {
        //base case: check if leaf node
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int max = root.data;
        if (root.left != null) {
            int left = getMax(root.left);
            max = left > max ? left : max;
        }

        if (root.right != null) {
            int right = getMax(root.right);
            max = right > max ? right : max;
        }

        return max;
    }

    public boolean checkBST(Node root) {
        //if no node, then I assumption is yes
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) { //if only single node then assume yes
            return true;
        }

        //check left node to verify BST
        if (!checkBST(root.left)) {
            return false;
        }

        //check right node to verify BST
        if (!checkBST(root.right)) {
            return false;
        }


        //check current node to verify BST
        boolean isLeftOK = false;
        if (root.left != null && getMax(root.left) < root.data) {
            isLeftOK = true;
        }

        boolean isRightOK = false;
        if (root.right != null && getMin(root.right) > root.data) {
            isRightOK = true;
        }

        return isLeftOK && isRightOK;
    }
}
