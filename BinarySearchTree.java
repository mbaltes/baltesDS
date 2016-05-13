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
  
  public void delete(int key) {
    //
  }
  
  public void preOrderTraversal(Node root) {
    if (root != null) {
      System.out.println(root.getData() + " ");
      preOrderTraversal(root.getLeftChild());
      preOrderTraversal(root.getRightChild());
    }
  }
  
  public void inOrderTraversal(Node root) {
    if (root != null) {
      preOrderTraversal(root.getLeftChild());
      System.out.println(root.getData() + " ");
      preOrderTraversal(root.getRightChild());
    }
  }
  
  public void postOrderTraversal(Node root) {
    if (root != null) {
      preOrderTraversal(root.getLeftChild());
      preOrderTraversal(root.getRightChild());
      System.out.println(root.getData() + " ");
    }
  }
  
  public static void main(String[] args) {
    BinarySearchTree b = new BinarySearchTree();
    b.insert(32);
    b.insert(27);
    b.insert(57);
    
    b.preOrderTraversal(b.root);
    System.out.println();
    b.inOrderTraversal(b.root);
    System.out.println();
    b.postOrderTraversal(b.root);
    
    Node found = b.find(587);
    if (found != null) {
      System.out.println("Found.");
    } else {
      System.out.println("Not found.");
    }
  }
}