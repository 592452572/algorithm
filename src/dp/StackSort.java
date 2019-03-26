package dp;

import java.util.Stack;

public class StackSort {

    /**
     * 不采用其他的数据结构让栈进行逆序
     */

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    //取出栈底元素
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.empty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
