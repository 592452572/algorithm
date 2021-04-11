package dp.fifthDay;


import java.util.LinkedList;
import java.util.Queue;

public class ArrGTValue {

    /**
     * 给定一个(arr[i...j])-min(arr[i...j]) <= k
     * 思路： 使用两个双向队列，一个中存最大的值在前面，另一个存最小的值在前面,以某个点为开头
     * 双向队列（大） 当数组有指针向右移动时，判断队列尾部是否数值比新增的数小，小的话则数弹出
     * 原理：因为有一个之前更大且更慢过期的数，前面的数已经没必要要了
     *  如果一个数组中max(arr)-min(arr) <= k 则其所有子数组都满足max(arr)-min(arr) <= k
     *  如果一个数组中max(arr)-min(arr) > k 则包含他的所有数组数组都满足max(arr)-min(arr) > k
     *  流程，必须以start开始的子数组数量为end-start个
     */
    public static int getResult(int[] arr, int k) {
        Queue<Integer> maxQueue = new LinkedList<>();
        Queue<Integer> minQueue = new LinkedList<>();
        int num = 0;
        maxQueue.offer(0);
        minQueue.offer(0);
        int i = 0;
        int j = 1;
        while (i != arr.length || j != arr.length) {
            int max = ((LinkedList<Integer>) maxQueue).getLast();
            int min = ((LinkedList<Integer>) minQueue).getLast();
            while (!maxQueue.isEmpty() && arr[j] > arr[max]) {
                ((LinkedList<Integer>) maxQueue).removeLast();
            }
            maxQueue.offer(j);
            while (!minQueue.isEmpty() && arr[j] < arr[min]) {
                ((LinkedList<Integer>) minQueue).removeLast();
            }
            minQueue.offer(j);
            int value = arr[maxQueue.peek()] - arr[minQueue.peek()];
            if (value <= k) {
                j++;
            } else {
                if (max == i) {
                    maxQueue.poll();
                }
                if (min == i) {
                    minQueue.poll();
                }
                i++;

            }
        }
        return 0;
    }

}
