package baltesDS;

/**
 * This class consists of a very simple node interface for use in binary tree
 * data structures.
 * 
 * @author Mark Baltes
 */

public class Node {
  private int data;
  private Node leftChild;
  private Node rightChild;
  
  public Node() {
    this.data = 0;
    this.leftChild = null;
    this.rightChild = null;
  }
  
  public Node(int data, Node left, Node right) {
    this.data = data;
    this.leftChild = left;
    this.rightChild = right;
  }
  
  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(Node leftChild) {
    this.leftChild = leftChild;
  }

  public Node getRightChild() {
    return rightChild;
  }

  public void setRightChild(Node rightChild) {
    this.rightChild = rightChild;
  }

  public void displayNode() {
    System.out.print("Data: " + data);
    System.out.print(" LC: " + leftChild);
    System.out.print(" RC: " + rightChild);
    System.out.println();
  }
}