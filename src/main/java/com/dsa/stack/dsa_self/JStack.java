package stack;

public class JStack {

	public static void main(String[] args) throws Exception {
		JStack st = new JStack(4);
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.disp();
		
//		System.out.println("popping");
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println(st.pop());

		
		System.out.println(st.isEmpty());
		
	}
	
	final int[] data;
	final int capacity;
	int top;
	
	JStack(int capacity){
		this.capacity = capacity;
		this.data = new int[capacity];
		top = -1;
	}
	
	void push(int item) {
		if(top<capacity-1) {
			top++;
			data[top] = item;
		}
	}
	
	int pop() throws Exception {
		if(top>-1) {
			int x = data[top];
			top--;
			return x;
		}else {
			throw new Exception("Stack Underflow");
		}
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	int peek() throws Exception {
		if(top>-1) {
			return data[top];
		}else {
			throw new Exception("Stack Underflow");
		}
	}
	
	int size() {
		return top+1;
	}
	
	void disp() {
		System.out.println("Elements of Stack: ");
		if(top>-1) {
			for(int i=top;i>=0;i--)
				System.out.println(i +" : " +data[i]);
		}
	}
	
	
}
