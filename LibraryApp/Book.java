package LibraryApp;

class Book {
  private String id;
  private String title;
  public String getTitle() {
    return title;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String toString() {
    return title;
  }
}