package LibraryApp;

import java.util.ArrayList;

class Library {
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Reader> members = new ArrayList<Reader>();

  public void addMember(Reader member) throws Exception {
    if (existsMemberWithId(member.getId())) {
      throw new Exception("Duplicated member Id");
    }
    this.members.add(member);
  }

  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Reader member : this.members) {
      if (member.getId() == id) {
        isExist = true;
      }
    }
    return isExist;
  }

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.books.remove(book);

    Reader member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }

  public void receiveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);
    this.books.add(book);

    Reader member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    this.members.get(memberIndex).borrowedBooks.remove(book);
  }

  private int getMemberIndex(Reader member) {
    return this.members.indexOf(member);
  }

  private Reader getMemberById(String id) {
    for (Reader member : this.members) {
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  private Book getBookById(String id) {
    for (Book book : this.books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }
  private boolean existsMemberWithId(String id) {
    Reader memberWithSameId = members.stream()
      .filter(currentMember -> currentMember.getId().equals(id))
      .findAny()
      .orElse(null);

    return (memberWithSameId != null);
  }
}