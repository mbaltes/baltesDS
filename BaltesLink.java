package baltesDS;

public class BaltesLink {
  protected Integer value;
  protected BaltesLink next;
  
  public BaltesLink() {
    value = null;
    next = null;
  }
  
  public BaltesLink(int v) {
    value = v;
    next = null;
  }
}
