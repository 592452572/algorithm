package dp.secondDay;

import java.util.Stack;

public class StackSort {

    /**
     * 不采用其他的数据结构让栈进行逆序
     * 思路：步骤：1.递归取出栈底的数
     *             2.直至栈顶元素被取出，然后压入栈底
     */

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }


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
        int result = stack.pop(); //1 2 3 4
        if (stack.empty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
