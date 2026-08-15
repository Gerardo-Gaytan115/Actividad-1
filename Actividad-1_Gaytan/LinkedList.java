public class LinkedList {

  Node head;

  LinkedList() {
    this.head = null;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int size() {
    int cont = 0;
    Node current = head;

    while (current != null) {
      cont++;
      current = current.next;
    }

    return cont;
  }

  public void insertAtBeginning(Book data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
  }

  public void insertAtEnd(Book data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
      return;
    }

    Node current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
  }

  public void insertAt(int index, Book data) {
    if (head == null || index <= 0) {
      insertAtBeginning(data);
      return;
    }

    int total = size();
    if (index >= total) {
      insertAtEnd(data);
      return;
    }

    Node newNode = new Node(data);
    Node current = head;

    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }

    newNode.next = current.next;
    current.next = newNode;
  }

  public Book search(String code) {
    Node current = head;

    while (current != null) {
      if (current.data.getCode().equalsIgnoreCase(code)) {
        return current.data;
      }
      current = current.next;
    }

    return null;
  }

  public Book get(int index) {
    if (index < 0 || index >= size()) {
      return null;
    }

    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }

    return current.data;
  }

  public boolean delete(String code) {
    if (head == null) {
      return false;
    }

    if (head.data.getCode().equalsIgnoreCase(code)) {
      head = head.next;
      return true;
    }

    Node current = head;
    while (current.next != null) {
      if (current.next.data.getCode().equalsIgnoreCase(code)) {
        current.next = current.next.next;
        return true;
      }
      current = current.next;
    }

    return false;
  }

  public boolean deleteAt(int index) {
    if (head == null || index < 0 || index >= size()) {
      return false;
    }

    if (index == 0) {
      head = head.next;
      return true;
    }

    Node current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.next;
    }

    current.next = current.next.next;
    return true;
  }

  public void display() {
    if (head == null) {
      System.out.println("No hay libros registrados");
      return;
    }

    Node current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }
}
