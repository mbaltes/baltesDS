package baltesDS;

public class BaltesLinkedList {
  private BaltesLink head;
  
  public BaltesLinkedList() {
    head = new BaltesLink();
  }
  
  public void add(BaltesLink link) {
    if (head.value == null) {
      head.value = link.value;
      return;
    }
    BaltesLink curr = head;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = link;
  }
  
  public void print() {
    BaltesLink curr = head;
    while (curr.next != null) {
      System.out.println(curr.value);
      curr = curr.next;
    }
    System.out.println(curr.value);
  }
  
  public static void main(String[] args) {
    BaltesLinkedList list = new BaltesLinkedList();
    BaltesLink l1 = new BaltesLink(5);
    list.add(l1);
    l1.value = 6;
    list.add(l1);
    
    list.print();
  }
}
