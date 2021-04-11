package src.dp.sixthDay;

import java.util.*;

public class Inverted {
    /**
     * 问题描述：一个数组中，取一个数加到另一个数后面之后，逆序，求最终结果
     * 思路：1 ， 12 逆， 312， 3124逆
     */
    public static Integer[] func1(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                queue.offer(arr[i]);
            } else {
                ((LinkedList<Integer>) queue).offerFirst(arr[i]);
            }
        }
        if (arr.length % 2 == 0){
            return queue.toArray(new Integer[arr.length]);
        } else {
            Iterator iterable =  queue.iterator();
            int i = 0;
            while (iterable.hasNext()) {
                intArr[i] = (Integer) iterable.next();
                i++;
            }
            return intArr;
        }

    }
}
