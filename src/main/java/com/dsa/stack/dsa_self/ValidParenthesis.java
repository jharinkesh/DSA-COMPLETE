
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("{()}"));
        System.out.println(isValid("{())}"));
        System.out.println(isValid("[{()}]"));
        System.out.println(isValid(""));
        System.out.println(isValid("{"));

    }

    static boolean isValid(String s){
        Stack<Character> st = new Stack<Character>();
        List<Character> opening = Arrays.asList('(','{','[');
        List<Character> closing = Arrays.asList(')','}',']');
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(opening.contains(x))
                st.push(x);
            else{
                if(!st.isEmpty()){
                    char t = st.peek();
                    int index = closing.indexOf(x);
                    char v = opening.get(index);
                    if(t == v)
                        st.pop();
                    else
                        return false;
                }else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
