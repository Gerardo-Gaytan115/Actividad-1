import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack historial = new Stack();
        Queue tareas = new Queue();
        int opcion = -1;

        while (opcion != 0){
            System.out.println("");
            System.out.println("===== CENTRO DE OPERACIONES =====");
            System.out.println("1. Registrar accion");
            System.out.println("2. Deshacer ultima accion");
            System.out.println("3. Ver ultima accion");
            System.out.println("4. Mostrar historial");
            System.out.println("5. Agregar tarea");
            System.out.println("6. Procesar siguiente tarea");
            System.out.println("7. Ver siguiente tarea");
            System.out.println("8. Mostrar tareas pendientes");
            System.out.println("9. Mostrar estado del sistema");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1){
                System.out.print("Ingrese la accion realizada: ");
                String accion = sc.nextLine();
                historial.push(accion);
                System.out.println("Accion registrada correctamente.");

            } else if (opcion == 2){
                if (historial.isEmpty()){
                    System.out.println("No hay acciones registradas. No se puede deshacer.");
                } else {
                    String accion = historial.pop();
                    System.out.println("Ultima accion: " + accion);
                    System.out.println("Accion deshecha correctamente.");
                }

            } else if (opcion == 3){
                if (historial.isEmpty()){
                    System.out.println("No hay acciones registradas.");
                } else {
                    System.out.println("Ultima accion: " + historial.peek());
                }

            } else if (opcion == 4){
                if (historial.isEmpty()){
                    System.out.println("El historial esta vacio.");
                } else {
                    System.out.println("---- Historial de acciones ----");
                    historial.display();
                }

            } else if (opcion == 5){
                System.out.print("Ingrese la tarea: ");
                String tarea = sc.nextLine();
                tareas.enqueue(tarea);
                System.out.println("Tarea agregada correctamente.");

            } else if (opcion == 6){
                if (tareas.isEmpty()){
                    System.out.println("No hay tareas pendientes.");
                } else {
                    String tarea = tareas.dequeue();
                    System.out.println("Procesando: " + tarea);
                }

            } else if (opcion == 7){
                if (tareas.isEmpty()){
                    System.out.println("No hay tareas pendientes.");
                } else {
                    System.out.println("Siguiente tarea: " + tareas.peek());
                }

            } else if (opcion == 8){
                if (tareas.isEmpty()){
                    System.out.println("No hay tareas pendientes.");
                } else {
                    System.out.println("---- Tareas pendientes ----");
                    tareas.display();
                }

            } else if (opcion == 9){
                System.out.println("---- Estado del sistema ----");
                System.out.println("Acciones en el historial: " + historial.size());
                System.out.println("Historial vacio: " + historial.isEmpty());
                System.out.println("Tareas pendientes: " + tareas.size());
                System.out.println("Tareas vacias: " + tareas.isEmpty());

            } else if (opcion == 0){
                System.out.println("Saliendo del sistema.");

            } else {
                System.out.println("Opcion invalida.");
            }
        }

        sc.close();
    }
}
