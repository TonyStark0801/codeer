import java.util.Arrays;
import java.util.Stack;

public class NextSmallElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, };
        //res = [1,-1,3,-1]

        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            while(stack.peek() >= arr[i]) {
                stack.pop();
            }
            res[i] = stack.peek();
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
