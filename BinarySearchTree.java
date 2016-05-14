package baltesDS;

public class BinarySearchTree {
  private Node root;
  
  public Node find(int key) {
    Node current = root; // Start at the root.
    while (current.getData() != key) {
      if (key < current.getData()) { // We go left.
        current = current.getLeftChild();
      } else { // We go right.
        current = current.getRightChild();
      }
      if (current == null) { // We didn't find the node.
        return null;
      }
    }
    return current;
  }
  
  public void insert(int key) {
    // Make new node to insert.
    Node newNode = new Node(key, null, null);
    if (root == null ) { // The tree is currently empty, so make newNode root.
      root = newNode;
    } else { // There is already a root node.
      Node current = root;
      Node parent;
      while (true) { // This loop will exit internally.
        parent = current;
        if (key < current.getData()) { // We go left.
          current = current.getLeftChild();
          if (current == null) { // We are at end, so add.
            parent.setLeftChild(newNode);
            return;
          }
        } else { // We go right.
          current = current.getRightChild();
          if (current == null) { // We are at end, so add.
            parent.setRightChild(newNode);
            return;
          }
        }
      }
    }
  }
  
  public boolean delete(int key) {
    Node current = root;
    Node parent = root;
    boolean isLeftChild = true;
    while (current.getData() != key) { // Search for node
      parent = current;
      if (key < current.getData()) { // Go left.
        isLeftChild = true;
        current = current.getLeftChild();
      } else { // Go right.
        isLeftChild = false;
        current = current.getRightChild();
      }
      if (current == null) { // Didn't find, so return false.
        return false;
      }
    }
    // If here, we have found the node to delete.
    // First case: Node has no children, so we simply delete it.
    if (current.getLeftChild() == null && current.getRightChild() == null) {
      if (current == root) {
        root = null;
      } else if (isLeftChild) {
        parent.setLeftChild(null);
      } else {
        parent.setRightChild(null);
      }
    } else if (current.getRightChild() == null) {
      // Second case: Node has no right child, so we replace with left
      // subtree.
      if (current == root) {
        root = current.getLeftChild();
      } else if (isLeftChild) {
        parent.setLeftChild(current.getLeftChild());
      } else {
        parent.setRightChild(current.getLeftChild());
      }
    } else if (current.getLeftChild() == null) {
      // Third case: Node has no left child, so replace with right subtree.
      if (current == root) {
        root = current.getRightChild();
      } else if (isLeftChild) {
        parent.setLeftChild(current.getRightChild());
      } else {
        parent.setRightChild(current.getRightChild());
      }
    } else { // Node has two children, so replace with inorder successor.
      // We first find the successor of node to delete.
      Node successor = getSuccessor(current);
      // Connect parent of current node to successor node.
      if (current == root) {
        root = successor;
      } else if (isLeftChild) {
        parent.setLeftChild(successor);
      } else {
        parent.setRightChild(successor);
      }
      // Connect successor to current node's left child.
      successor.setLeftChild(current.getLeftChild());
    }
    // Successor can't have a left child.
    return true;
  }
  
  private Node getSuccessor(Node delNode) {
    Node successorParent = delNode;
    Node successor = delNode;
    Node current = delNode.getRightChild();
    while (current != null) {
      successorParent = successor;
      successor = current;
      current = current.getLeftChild();
    }
    if (successor != delNode.getRightChild()) {
      successorParent.setLeftChild(successor.getRightChild());
      successor.setRightChild(delNode.getRightChild());
    }
    return successor;
  }

  public void preOrderTraversal(Node root) {
    if (root != null) {
      System.out.print(root.getData() + " ");
      preOrderTraversal(root.getLeftChild());
      preOrderTraversal(root.getRightChild());
    }
  }
  
  public void inOrderTraversal(Node root) {
    if (root != null) {
      inOrderTraversal(root.getLeftChild());
      System.out.print(root.getData() + " ");
      inOrderTraversal(root.getRightChild());
    }
  }
  
  public void postOrderTraversal(Node root) {
    if (root != null) {
      postOrderTraversal(root.getLeftChild());
      postOrderTraversal(root.getRightChild());
      System.out.print(root.getData() + " ");
    }
  }
  
  public static void main(String[] args) {
    BinarySearchTree b = new BinarySearchTree();
    b.insert(32);
    b.insert(27);
    b.insert(57);
    b.insert(5);
    b.insert(40);
    b.delete(32);
    
    b.preOrderTraversal(b.root);
    System.out.println();
    b.inOrderTraversal(b.root);
    System.out.println();
    b.postOrderTraversal(b.root);
    
    
  }
}