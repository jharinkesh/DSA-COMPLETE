public class LinkedQueue<E> {
    Node front;
    int size;

    void enque(E x){
        if(size ==0){
            front = new Node(x);
        }else{
            Node n1 = front;
            while(n1.next!=null){
                n1 = n1.next;
            }
            n1.next = new Node(x);
        }
        size++;
    }

    E deque(){
        if(size ==0)
            return null;
        Node f = front;
        front = front.next;
        size--;
        return (E)f.data;
    }

    void disp(){
        System.out.println();
        for(Node x = front;x!=null;x=x.next){
            System.out.print(x.data+ " ");
        }
    }

    int size(){
        return this.size;
    }

    public static void main(String[] args) {
        LinkedQueue<String> lq = new LinkedQueue<String>();
        lq.enque("hi");
        lq.enque("how");
        lq.enque("are");
        lq.enque("you");
        lq.disp();
        lq.deque();
        lq.disp();
        System.out.println("\n"+lq.size());
    }


}

class Node<E> {
    E data;
    Node next;
    Node(E data){
        this.data = data;
    }
}
