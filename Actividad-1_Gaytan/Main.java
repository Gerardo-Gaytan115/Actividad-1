import java.util.Scanner;

public class Main {

  private static int leerOpcion(Scanner scanner, int min, int max) {
    int opcion;

    while (true) {
      System.out.print("Selecciona una opcion: ");

      if (scanner.hasNextInt()) {
        opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion >= min && opcion <= max) {
          return opcion;
        }
      } else {
        scanner.nextLine();
      }

      System.out.println("Opcion invalida, intenta de nuevo.");
    }
  }

  private static int leerEntero(Scanner scanner, String mensaje) {
    System.out.print(mensaje);

    while (!scanner.hasNextInt()) {
      System.out.print("Valor invalido, escribe un numero entero: ");
      scanner.nextLine();
    }

    int valor = scanner.nextInt();
    scanner.nextLine();
    return valor;
  }

  private static Book leerLibro(Scanner scanner) {
    System.out.print("Titulo: ");
    String titulo = scanner.nextLine();
    System.out.print("Autor: ");
    String autor = scanner.nextLine();
    System.out.print("Codigo: ");
    String codigo = scanner.nextLine();
    int anio = leerEntero(scanner, "Año de publicacion: ");

    return new Book(titulo, autor, codigo, anio);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    LinkedList biblioteca = new LinkedList();

    int opcion;
    do {
      System.out.println();
      System.out.println("===== BIBLIOTECA =====");
      System.out.println("1. Agregar libro al inicio");
      System.out.println("2. Agregar libro al final");
      System.out.println("3. Insertar libro en posicion");
      System.out.println("4. Mostrar libros");
      System.out.println("5. Buscar libro");
      System.out.println("6. Consultar libro por posicion");
      System.out.println("7. Eliminar libro");
      System.out.println("8. Eliminar libro por posicion");
      System.out.println("9. Mostrar cantidad de libros");
      System.out.println("10. Salir");

      opcion = leerOpcion(scanner, 1, 10);

      if (opcion == 1) {
        Book libro = leerLibro(scanner);
        biblioteca.insertAtBeginning(libro);
        System.out.println("Libro agregado al inicio.");
      } else if (opcion == 2) {
        Book libro = leerLibro(scanner);
        biblioteca.insertAtEnd(libro);
        System.out.println("Libro agregado al final.");
      } else if (opcion == 3) {
        int posicion = leerEntero(scanner, "Escribe la posicion: ");
        Book libro = leerLibro(scanner);
        biblioteca.insertAt(posicion, libro);
        System.out.println("Libro insertado.");
      } else if (opcion == 4) {
        System.out.println("---- Libros registrados ----");
        biblioteca.display();
      } else if (opcion == 5) {
        if (biblioteca.isEmpty()) {
          System.out.println("No hay libros registrados.");
        } else {
          System.out.print("Codigo del libro a buscar: ");
          String codigo = scanner.nextLine();
          Book encontrado = biblioteca.search(codigo);
          if (encontrado == null) {
            System.out.println("El libro no existe en la biblioteca.");
          } else {
            System.out.println("Libro encontrado: " + encontrado);
          }
        }
      } else if (opcion == 6) {
        if (biblioteca.isEmpty()) {
          System.out.println("No hay libros registrados.");
        } else {
          int posicion = leerEntero(scanner, "Escribe la posicion: ");
          Book libro = biblioteca.get(posicion);
          if (libro == null) {
            System.out.println("Posicion invalida.");
          } else {
            System.out.println("Libro: " + libro);
          }
        }
      } else if (opcion == 7) {
        if (biblioteca.isEmpty()) {
          System.out.println("No hay libros registrados.");
        } else {
          System.out.print("Codigo del libro a eliminar: ");
          String codigo = scanner.nextLine();
          if (biblioteca.delete(codigo)) {
            System.out.println("Libro eliminado.");
          } else {
            System.out.println("El libro no existe en la biblioteca.");
          }
        }
      } else if (opcion == 8) {
        if (biblioteca.isEmpty()) {
          System.out.println("No hay libros registrados.");
        } else {
          int posicion = leerEntero(scanner, "Escribe la posicion: ");
          if (biblioteca.deleteAt(posicion)) {
            System.out.println("Libro eliminado.");
          } else {
            System.out.println("Posicion invalida.");
          }
        }
      } else if (opcion == 9) {
        System.out.println("Cantidad de libros: " + biblioteca.size());
      }

    } while (opcion != 10);

    System.out.println("Programa finalizado.");
    scanner.close();
  }
}
