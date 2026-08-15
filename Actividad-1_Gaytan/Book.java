public class Book {

  private String title;
  private String author;
  private String code;
  private int year;

  Book(String title, String author, String code, int year) {
    this.title = title;
    this.author = author;
    this.code = code;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getCode() {
    return code;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return title + " | " + author + " | " + code + " | " + year;
  }
}
