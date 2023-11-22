package dsa.dataStructures.binarySearchTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // Constructor
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    
    // 1) Insertion
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Private helper method utilised in insert() method.
    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.data) {
            current.left = insertRecursive(current.left, value);
        }
        else if (value > current.data) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    } // End of insertion methods.

    
    

    // 2) Deletion
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    // Private helper method utilised in delete() method.
    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return current;
        }

        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
        }
        else if (value > current.data) {
            current.right = deleteRecursive(current.right, value);
        }
        else {
            if (current.left == null) {
                return current.right;
            }
            else if (current.right == null) {
                return current.left;
            }

            current.data = findMinValue(current.right);
            current.right = deleteRecursive(current.right, current.data);
        }
        return current;
    } // End of deleteRecursive() method,

    // Private helper method to find minimum value in BST. Utilised in deleteRecursive() method.
    private int findMinValue(TreeNode node) {
        int minValue = node.data;
        
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        
        return minValue;
    } // End of deletion methods.

    

    
    // 3) Search
    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    // Private helper method for searching in the BST. Utilised in search() method.
    private boolean searchRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }

        if (current.data == value) {
            return true;
        }

        if (value < current.data) {
            return searchRecursive(current.left, value);
        }
        else {
            return searchRecursive(current.right, value);
        }
    } // End of search methods.

    

    
    // 4) Inorder Traversal
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    // Private helper method for in-order traversal of BST. Utilised in inorderTraversal() method.
    private void inorderRecursive(TreeNode current) {
        
        if (current != null) {
            inorderRecursive(current.left);
            System.out.print(current.data + " ");
            inorderRecursive(current.right);
        }
    } // End of in-order traversal methods.


    
    
    // 5) Preorder Traversal
    public void preorderTraversal() {
        preorderRecursive(root);
    }
    
    // Private helper method for pre-order traversal of BST. Utilised in preorderTraversal() method.
    private void preorderRecursive(TreeNode current) {
        
        if (current != null) {
            System.out.print(current.data + " ");
            preorderRecursive(current.left);
            preorderRecursive(current.right);
        }
    } // End of pre-order traversal methods.

    

    
    // 6) Postorder Traversal
    public void postorderTraversal() {
        postorderRecursive(root);
    }
    
    // Private helper method for post-order traversal of BST. Utilised in postorderTraversal() method.
    private void postorderRecursive(TreeNode current) {
        
        if (current != null) {
            postorderRecursive(current.left);
            postorderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    } // End of post-order traversal methods.

    

    
    // 7) Minimum Value
    public int findMinimumValue() {
        return findMinimumRecursive(root);
    }

    // Private helper method for finding minimum value in a BST. Utilised in findMinimumValue() method.
    private int findMinimumRecursive(TreeNode node) {
        if (node.left == null) {
            return node.data;
        }
        return findMinimumRecursive(node.left);
    } // End of min value methods.




    // 8) Maximum Value
    public int findMaximumValue() {
        return findMaximumRecursive(root);
    }

    // Private helper method to find max value in BST. Utilised in findMaximumValue() method.
    private int findMaximumRecursive(TreeNode node) {
        if (node.right == null) {
            return node.data;
        }
        return findMaximumRecursive(node.right);
    } // End of max value methods.




    // 9) Find Successor of a BST Node
    public int findSuccessor(int value) {
        TreeNode node = findNode(root, value);
        
        if (node == null) {
            return -1; // Value not found in the tree
        }
        
        TreeNode successor = findSuccessorNode(root, node);
        return successor != null ? successor.data : -1;
    }

    // Private helper method to find a node with the value passed. Utilised in findSuccessor() & findPredecessor() methods.
    private TreeNode findNode(TreeNode current, int value) {
        if (current == null || current.data == value) {
            return current;
        }
        if (value < current.data) {
            return findNode(current.left, value);
        }
        return findNode(current.right, value);
    }

    // Private helper method to find successor of a node. Utilised in findSuccessor() method.
    private TreeNode findSuccessorNode(TreeNode root, TreeNode node) {
        if (node.right != null) {
            return findMinNode(node.right);
        }

        TreeNode successor = null;
        
        while (root != null) {
            if (node.data < root.data) {
                successor = root;
                root = root.left;
            }
            else if (node.data > root.data) {
                root = root.right;
            }
            else {
                break;
            }
        }
        return successor;
    } // End of findSuccessorNode() method.

    // Private helper method to find the node with minimum value, which is the leftmost node. Utilised in findSuccessorNode() method.
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    } // End of Successor Methods,




    // 10) Find Predecessor
    public int findPredecessor(int value) {
        TreeNode node = findNode(root, value);
        if (node == null) {
            return -1; // Value not found in the tree
        }
        TreeNode predecessor = findPredecessorNode(root, node);
        return predecessor != null ? predecessor.data : -1;
    }

    // Private helper method to find predecessor of a node. Utilised in findPredecessor() method.
    private TreeNode findPredecessorNode(TreeNode root, TreeNode node) {
        if (node.left != null) {
            return findMaxNode(node.left);
        }

        TreeNode predecessor = null;
        
        while (root != null) {
            if (node.data > root.data) {
                predecessor = root;
                root = root.right;
            }
            else if (node.data < root.data) {
                root = root.left;
            }
            else {
                break;
            }
        }
        return predecessor;
    } // End of findPredecessorNode() method.

    // Private helper method to find the node with max value, which is the rightmost node. Utilised in findPredecessorNode() method.
    private TreeNode findMaxNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    } // End of Predecessor methods.



    // 11) Height (or Depth) Calculation
    public int getHeight() {
        return calculateHeight(root);
    }

    // Private helper method to calculate height of BST. Utilised in getHeight() method.
    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    } // End of Height methods.



    // 12) Size (or Count) Calculation
    public int getSize() {
        return calculateSize(root);
    }

    // Private helper method to find size of BST. Utilised in getSize() method.
    private int calculateSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + calculateSize(node.left) + calculateSize(node.right);
    } // End of size methods.



    // 13) Diameter Calculation
    public int getDiameter() {
        return calculateDiameter(root);
    }

    // Private helper method to calculate diameter of BST. Utilised in getDiameter() method.
    private int calculateDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        int leftDiameter = calculateDiameter(node.left);
        int rightDiameter = calculateDiameter(node.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    } // End of diameter methods.



    // 14) Balancing and Validation
    public boolean isBalanced() {
        return checkBalanced(root);
    }

    // Private helper method to check if BST is balanced. Utilised in isBalanced() method.
    private boolean checkBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return checkBalanced(node.left) && checkBalanced(node.right);
    } // End of balance methods.



    // 15) Convert BST to a sorted array
    public int[] toArray() {
        int[] result = new int[getSize()];
        toArrayRecursive(root, result, new int[]{0});
        return result;
    }

    // Private helper method to convert BST to array. Utilised in toArray() method.
    private void toArrayRecursive(TreeNode node, int[] result, int[] index) {
        if (node == null) {
            return;
        }

        toArrayRecursive(node.left, result, index);
        result[index[0]++] = node.data;
        toArrayRecursive(node.right, result, index);
    } // End of BST to array methods,



    // 16) Sorted Array to BST
    public static BinarySearchTree fromSortedArray(int[] sortedArray) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = createBalancedBST(sortedArray, 0, sortedArray.length - 1);
        return bst;
    }

    // Private helper method to balance a BST. Utilised in fromSortedArray() method.
    private static TreeNode createBalancedBST(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode newNode = new TreeNode(sortedArray[mid]);

        newNode.left = createBalancedBST(sortedArray, start, mid - 1);
        newNode.right = createBalancedBST(sortedArray, mid + 1, end);

        return newNode;
    } // End of array to BST.



    // 17) Combining Trees
    public void combine(BinarySearchTree otherTree) {
        int[] otherArray = otherTree.toArray();
        for (int value : otherArray) {
            insert(value);
        }
    }



    // 18) Serialize a BST to String.
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        serializeRecursive(root, sb);
        return sb.toString();
    }

    // Private helper method to serialize a BST to String. Utilised in serialize() method.
    private void serializeRecursive(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null ");
        } else {
            sb.append(node.data).append(" ");
            serializeRecursive(node.left, sb);
            serializeRecursive(node.right, sb);
        }
    } // End of serialize methods.



    // 19) Deserialize a String to BST.
    public static TreeNode deserialize(String serializedData) {
        String[] values = serializedData.split(" ");
        Queue<String> valueQueue = new LinkedList<>(Arrays.asList(values));
        return deserializeRecursive(valueQueue);
    }

    // Private helper method to deserialize a string to a BST. Utilised in deserialize() method.
    private static TreeNode deserializeRecursive(Queue<String> valueQueue) {
        String value = valueQueue.poll();
        if (value.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeRecursive(valueQueue);
        node.right = deserializeRecursive(valueQueue);

        return node;
    } // End of deserialize method.

    // Examples showing how these methods can be implemented.
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();
        System.out.println();

        System.out.println("Preorder Traversal:");
        bst.preorderTraversal();
        System.out.println();

        System.out.println("Postorder Traversal:");
        bst.postorderTraversal();
        System.out.println();

        System.out.println("Minimum Value: " + bst.findMinimumValue());
        System.out.println("Maximum Value: " + bst.findMaximumValue());

        int valueToSearch = 60;
        System.out.println("Searching for value " + valueToSearch + ": " + bst.search(valueToSearch));

        int valueToDelete = 30;
        System.out.println("Deleting node with value " + valueToDelete);
        bst.delete(valueToDelete);
        bst.inorderTraversal();
        System.out.println();

        int successorValue = 50;
        System.out.println("Successor of " + successorValue + ": " + bst.findSuccessor(successorValue));

        int predecessorValue = 60;
        System.out.println("Predecessor of " + predecessorValue + ": " + bst.findPredecessor(predecessorValue));
    }
}