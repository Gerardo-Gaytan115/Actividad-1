public class Stack {
    Node top;

    Stack(){
        top = null;
    }

    public void push(String data){
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;
    }

    public String pop(){
        if (isEmpty()){
            return null;
        }

        String data = top.data;
        top = top.next;

        return data;
    }

    public String peek(){
        if (isEmpty()){
            return null;
        }

        return top.data;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public int size(){
        Node current = top;
        int cont = 0;

        while (current != null){
            cont++;
            current = current.next;
        }

        return cont;
    }

    public void display(){
        Node current = top;

        while (current != null){
            if (current == top){
                System.out.println(current.data + "   <- TOP");
            } else {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }
}
