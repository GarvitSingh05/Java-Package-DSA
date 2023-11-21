package dsa.dataStructures.binaryTree;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    //Constructor to initialise a node
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    Node root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Public method for insertion in tree
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    // Private helper recursive method for Insertion in tree. Utilised in insert() method.
    private Node insertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        } 
        else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    } //End of Insertion

    // Public method for deletion in tree
    public void delete(int data) {
        root = deleteRecursive(root, data);
    }

    // Private helper recursive method for Deletion operation in tree. Utilised in delete() method.
    private Node deleteRecursive(Node current, int data) {
        if (current == null) {
            return current;
        }

        if (data < current.data) {
            current.left = deleteRecursive(current.left, data);
        } 
        else if (data > current.data) {
            current.right = deleteRecursive(current.right, data);
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
    } // End of Deletion

    // Search the Binary Tree
    public boolean search(int data) {
        return searchRecursive(root, data);
    }

    // Private helper recursive method for Searching. Utilised in search() method.
    private boolean searchRecursive(Node current, int data) {
        if (current == null) {
            return false;
        }

        if (data == current.data) {
            return true;
        } else if (data < current.data) {
            return searchRecursive(current.left, data);
        } else {
            return searchRecursive(current.right, data);
        }
    } // End of Search in Binary Tree

    // Inorder Traversal
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    // Private helper recursive method for in-order traversal in binary tree. Utilised in inorderTraversal() method.
    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    } // End of in-order traversal.

    // Preorder Traversal
    public void preorderTraversal() {
        preorderRecursive(root);
    }

    // Private helper recursive method for pre-order traversal in binary tree. Utilised in preorderTraversal() method.
    private void preorderRecursive(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    } // End of pre-order traversal.

    // Postorder Traversal
    public void postorderTraversal() {
        postorderRecursive(root);
    }

    // Private helper recursive method for post-order traversal in binary tree. Utilised in postorderTraversal() method.
    private void postorderRecursive(Node root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    } // End of post-order traversal.

    // Level Order Traversal
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    } // End of Level-order traversal.

    // Find minimum value
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        return findMinValue(root);
    }

    // Private helper method for finding minimum value. Utilised in findMin() method.
    private int findMinValue(Node root) {
        return root.left == null ? root.data : findMinValue(root.left);
    } // End of find minimum value.

    // Find maximum value
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty.");
        }
        return findMaxValue(root);
    }

    // Private helper method for finding maximum value. Utilised in findMax() method.
    private int findMaxValue(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    } // End of find maximum value

    // Private helper recursive method to search for a node. Utilised in findPredecessor() and findSuccessor() methods.
    private Node findNode(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            return findNode(root.left, data);
        } else if (data > root.data) {
            return findNode(root.right, data);
        } else {
            return root;
        }
    } // End of findNode() method.

    // Method to find successor of a particular node
    public int findSuccessor(int data) {
        Node node = findNode(root, data);

        if (node == null) {
            throw new IllegalArgumentException("Node not found.");
        }
        
        Node successor = findSuccessorNode(root, node);
        
        if (successor == null) {
            throw new IllegalStateException("No successor found.");
        }
        return successor.data;
    }

    // Private helper method to return node with minimum value, which is the leftmost node. Utilised in findSuccessor() method.
    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Private helper method for findSuccessor() method.
    private Node findSuccessorNode(Node root, Node node) {
        if (node.right != null) {
            return findMinNode(node.right);
        }
        
        Node successor = null;
        
        while (root != null) {
            if (node.data < root.data) {
                successor = root;
                root = root.left;
            } else if (node.data > root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return successor;
    } // End of findSuccessor() method.

    
    // Find Predecessor
    public int findPredecessor(int data) {
        Node node = findNode(root, data);
        if (node == null) {
            throw new IllegalArgumentException("Node not found.");
        }
        Node predecessor = findPredecessorNode(root, node);
        if (predecessor == null) {
            throw new IllegalStateException("No predecessor found.");
        }
        return predecessor.data;
    }

    // Private helper method to return node with maximum value, which is the rightmost node.
    private Node findMaxNode(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Private helper method for finding predecessor node. Utilised in findPredecessor() method.
    private Node findPredecessorNode(Node root, Node node) {
        if (node.left != null) {
            return findMaxNode(node.left);
        }
        Node predecessor = null;
        while (root != null) {
            if (node.data > root.data) {
                predecessor = root;
                root = root.right;
            } else if (node.data < root.data) {
                root = root.left;
            } else {
                break;
            }
        }
        return predecessor;
    } // End of findPredecessor() method.

    // Height / Depth calculation
    public int getHeight() {
        return calculateHeight(root);
    }

    // Private helper method for calculating height of binary tree. Utilised in getHeight() method.
    private int calculateHeight(Node node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    } // End of Height Calculation.

    // Size / Count calculation
    public int getSize() {
        return calculateSize(root);
    }

    // Private helper method to calculate size of binary tree.
    private int calculateSize(Node node) {
        if (node == null) {
            return 0;
        }
        return calculateSize(node.left) + calculateSize(node.right) + 1;
    } // End of getSize() method.

    // Tree diameter calculation
    public int getDiameter() {
        return calculateDiameter(root);
    }

    // Private helper method to calculate diameter of the tree.
    private int calculateDiameter(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        int leftDiameter = calculateDiameter(node.left);
        int rightDiameter = calculateDiameter(node.right);

        /*  Diameter can be the maximum of three values:
            1. Diameter of the left subtree.
            2. Diameter of the right subtree.
            3. Longest path that passes through the root. */
        return Math.max(Math.max(leftDiameter, rightDiameter), leftHeight + rightHeight + 2);
    } // End of getDiameter() method.

    // Method to check if the binary tree is balanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    // Private helper method used in isBalanced() method.
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    } // End of isBalanced() method.

    // Convert binary tree to an array
    public int[] treeToArray() {
        int size = getSize();
        int[] result = new int[size];
        treeToArray(root, result, 0);
        return result;
    }

    // Private helper method used in treeToArray() method.
    private int treeToArray(Node node, int[] array, int index) {
        if (node == null) {
            return index;
        }

        index = treeToArray(node.left, array, index);
        array[index++] = node.data;
        index = treeToArray(node.right, array, index);

        return index;
    } // End of treeToArray() method.

    // Convert an array to binary tree
    public void arrayToTree(int[] array) {
        root = arrayToTree(array, 0, array.length - 1);
    }

    // Private helper method used in arrayToTree() method.
    private Node arrayToTree(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);

        node.left = arrayToTree(array, start, mid - 1);
        node.right = arrayToTree(array, mid + 1, end);

        return node;
    } // End of arrayToTree() method.

    // Serialize a tree to string.
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    // Private helper method for serialize() method.
    private void serialize(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("null ");
            return;
        }

        sb.append(node.data).append(" ");
        serialize(node.left, sb);
        serialize(node.right, sb);
    } // End of serialize() method.

    // Deserialize a string to tree
    public void deserialize(String data) {
        String[] values = data.split(" ");
        Queue<String> queue = new LinkedList<>();
        for (String value : values) {
            queue.offer(value);
        }
        root = deserialize(queue);
    }

    // Private helper method for deserialize() method.
    private Node deserialize(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("null")) {
            return null;
        }

        Node node = new Node(Integer.parseInt(value));
        node.left = deserialize(queue);
        node.right = deserialize(queue);

        return node;
    } // End of deserialize() method.

    // Examples showing how these methods can be implemented.
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();

        System.out.println("\n\nPreorder Traversal:");
        tree.preorderTraversal();

        System.out.println("\n\nPostorder Traversal:");
        tree.postorderTraversal();

        System.out.println("\n\nLevel Order Traversal:");
        tree.levelOrderTraversal();

        int searchData = 40;
        System.out.println("\n\nSearch for " + searchData + ": " + tree.search(searchData));

        int deleteData = 30;
        tree.delete(deleteData);
        System.out.println("\n\nDeleted " + deleteData);
        System.out.println("\nInorder Traversal after deletion:");
        tree.inorderTraversal();

        System.out.println("\nMinimum Value: " + tree.findMin());
        System.out.println("Maximum Value: " + tree.findMax());

        int successorData = 40;
        System.out.println("\nSuccessor of " + successorData + ": " + tree.findSuccessor(successorData));

        int predecessorData = 60;
        System.out.println("Predecessor of " + predecessorData + ": " + tree.findPredecessor(predecessorData));

        System.out.println("\nHeight of the tree: " + tree.getHeight());
        System.out.println("Size of the tree: " + tree.getSize());
        System.out.println("Diameter of the tree: " + tree.getDiameter());

        int[] toArray = tree.treeToArray();
        System.out.println("\nBinary Tree to Array:");
        for (int value : toArray) {
            System.out.print(value + " ");
        }

        int[] array = {20, 30, 40, 50, 60, 70, 80};
        BinaryTree treeFromArray = new BinaryTree();
        treeFromArray.arrayToTree(array);
        System.out.println("\n\nArray to Binary Tree (Inorder Traversal):");
        treeFromArray.inorderTraversal();

        int[] array2 = {10, 20, 30, 40, 50};
        BinaryTree tree2 = new BinaryTree();
        tree2.arrayToTree(array2);

        System.out.println("\nIs the tree balanced? " + tree.isBalanced());

        String serializedTree = tree.serialize();
        System.out.println("\nSerialized Tree: " + serializedTree);

        BinaryTree deserializedTree = new BinaryTree();
        deserializedTree.deserialize(serializedTree);
        System.out.println("\nDeserialized Tree (Inorder Traversal):");
        deserializedTree.inorderTraversal();
    }
}