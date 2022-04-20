package LibraryApp;

import java.util.ArrayList;

class Reader {
  private String id;
  private String name;
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();

  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }
  public String toString() {
    return name;
  }
}