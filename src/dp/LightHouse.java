package dp;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LightHouse {

    /**
     * 灯塔问题，两个灯塔之间，如果其中的灯塔高度都小于两边的灯塔，则两座灯塔可以看见，求有多少对可以看见的灯塔
     * 使用单调栈
     */

    public static int func1(int arr[]) {
        int sumNum = 0;
        Stack<Integer> stack = new Stack<>();
        //选出最大的
        int maxValue = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        stack.push(arr[maxIndex]);
        map.put(arr[maxIndex], 1);
        //正方向便利
        sumNum = foo(map, arr, stack, sumNum, maxIndex+1, arr.length);
        sumNum = foo(map, arr, stack, sumNum, 0, maxIndex);
        while (!stack.empty()) {
            if (stack.size() > 2) {
                int value = stack.pop();
                int num = map.get(value);
                if (num >= 2) {
                    sumNum += num * (num - 1) / 2 + 2 * num;
                }else {
                    sumNum += 2;
                }
                map.put(value, 0);
            } else if (stack.size() == 2) {
                int value = stack.pop();
                int num = map.get(value);
                if (map.get(stack.peek()) == 1) {
                    if (num >= 2) {
                        sumNum += num * (num - 1) / 2 + num;
                    }else {
                        sumNum += 1;
                    }
                } else {
                    if (num >= 2) {
                        sumNum += num * (num - 1) / 2 + 2 * num;
                    }else {
                        sumNum += 2;
                    }
                }
                map.put(value, 0);
            } else if (stack.size() == 1) {
                int value = stack.pop();
                int num = map.get(value);
                if (num >= 2) {
                    sumNum += num * (num - 1) / 2;
                }
            }
        }
        return sumNum;
    }
    public static int foo(Map<Integer, Integer> map, int[] arr, Stack<Integer> stack, int sumNum, int start, int end) {
        //for (int i = maxIndex+1; i < arr.length; i++) {
        for (int i = start; i < end; i++) {
            if (stack.peek() > arr[i]) {
                stack.push(arr[i]);
                map.put(arr[i], map.get(arr[i])==null?1:map.get(arr[i])+1);
            } else if (stack.peek() == arr[i]) {
                map.put(arr[i], map.get(arr[i]));
            } else {
                //新进元素大于栈顶元素，栈顶元素出栈
                while (stack.peek() < arr[i]) {
                    int value = stack.pop();
                    int num = map.get(value);
                    if (num >= 2) {
                        sumNum += num * (num - 1) / 2 + 2 * num;
                    }else {
                        sumNum += 2;
                    }
                    //将出栈元素设为0
                    map.put(value, 0);
                }
                map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
                if (stack.peek() != arr[i]) {
                    stack.push(arr[i]);
                }
            }
        }
        return sumNum;
    }
}
