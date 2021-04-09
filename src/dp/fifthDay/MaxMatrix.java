package dp.fifthDay;

import java.util.Stack;

public class MaxMatrix {

    /**
     * 一个二维数组有0和1组成，求由1组成的最大矩阵
     * 思路：1，求以每一行为底的直方图  2，使用小单调栈
     * 有重复值，让先入的重复值出栈，后入的值入栈，并马上结算先入的值。原因：总有一个的重复值结算的结果是对的！
     */
    public static int getMaxMatrixValue(int[][] arr) {
        int[] a = new int[arr[0].length];
        int maxValue = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    a[j] = 0;
                } else {
                    a[j] += arr[i][j];
                }
                if (stack.isEmpty()) {
                    stack.push(j);
                } else if (stack.peek() < a[j]) {
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && stack.peek() >= a[j]) {
                        int index = stack.pop();
                        if (stack.isEmpty()) {
                            maxValue = Math.max(maxValue, a[index] * j);
                        } else {
                            maxValue = Math.max(maxValue, a[index] * (j - stack.peek() - 1));
                        }
                    }
                    stack.push(j);
                }
            }
        }
        return maxValue;
    }
}
