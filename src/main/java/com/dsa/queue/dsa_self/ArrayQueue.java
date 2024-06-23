
public class ArrayQueue {
    int[] data;
    final int capacity;
    int size;

    ArrayQueue(int capacity){
        this.capacity = capacity;
        this.data = new int[capacity];
        this.size = 0;
    }

    void enque(int e){
        if(size<capacity){
            data[size] = e;
            size++;
        }
    }

    int deque(){
        System.out.println("deque called");
        if(size == 0)
            return -1;
        int front = data[0];
        for(int i=0;i<size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        return front;
    }

    void disp(){
        System.out.println();
        for(int i=0;i<size;i++)
            System.out.print(data[i] +" ");
    }

    int size(){
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        aq.enque(1);
        aq.enque(2);
        aq.disp();
        aq.deque();
        aq.disp();
    }


}
