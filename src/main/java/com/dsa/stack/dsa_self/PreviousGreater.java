import java.util.Stack;

public class PreviousGreater {

    public static void main(String[] args) {
        int[] a  ={15, 10,18,12,4,6,2,8};
        Stack<Integer> st = new Stack<Integer>();
        System.out.print("-1 ");
        st.push(a[0]);
        for(int i=1;i<a.length;i++){
            while(!st.isEmpty() && st.peek() < a[i])
                st.pop();
            if(!st.isEmpty())
                System.out.print(st.peek()+" ");
            else
                System.out.print("-1 ");
            st.add(a[i]);
        }
    }
}
