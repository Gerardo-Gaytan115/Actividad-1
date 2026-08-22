public class Queue {
    Node front;
    Node rear;

    Queue(){
        front = null;
        rear = null;
    }

    public void enqueue(String data){
        Node newNode = new Node(data);

        if (rear == null){
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public String dequeue(){
        if (isEmpty()){
            return null;
        }

        String data = front.data;
        front = front.next;

        if (front == null){
            rear = null;
        }

        return data;
    }

    public String peek(){
        if (isEmpty()){
            return null;
        }

        return front.data;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public int size(){
        Node current = front;
        int cont = 0;

        while (current != null){
            cont++;
            current = current.next;
        }

        return cont;
    }

    public void display(){
        Node current = front;

        while (current != null){
            if (current == front && current == rear){
                System.out.println(current.data + "   <- FRONT / REAR");
            } else if (current == front){
                System.out.println(current.data + "   <- FRONT");
            } else if (current == rear){
                System.out.println(current.data + "   <- REAR");
            } else {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }
}
