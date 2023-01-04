import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(7);
        stack.pop();
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(1);
        stack.push(10);
        stack.pop();
        stack.pop();
        stack.push(9);
        System.out.println(stack);
    }
}