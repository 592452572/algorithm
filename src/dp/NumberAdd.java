package src.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述：从一个数组中选出符合规则的数
 */
public class NumberAdd {

    /**
     * 从数组中找出相加为某个数的字串，值全是正数
     *
     */
    public static int fun1(int[] arr, int k) {
        int s = 0;
        int e = 0;
        int size = 0;
        int sum = 0;
        while (e < arr.length) {
            sum = sum+arr[e];
            if (sum == k) {
                size = Math.max(e-s+1, size);
                e++;
            } else if (sum < k) {
                e++;
            } else {
                sum = sum-arr[s];
                s++;
            }
        }
        return size;
    }

    /**
     * 题意与上题一致，但是又正数负数，0   sum[index2]-sum[index1]
     */
    public static int func2(int arr[], int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        int maxNum = 0;
        if (sum[0] == k) {
            maxNum = 1;
            hm.put(arr[0], 0);
        }
        for (int i = 1; i < arr.length; i++){
            sum[i] = arr[i]+sum[i-1];
            if (!hm.containsKey(k)) {
                hm.put(sum[i], i);
            }
            if (sum[i] == k) {
                maxNum = i+1;

                continue;
            }
            if (hm.containsKey(sum[i]-k)) {
                maxNum = Math.max(maxNum, i-hm.get(sum[i]-k)+1);
            }
        }
        return maxNum;
    }

    /**
     * 加起来小于一个数的最长数组,算出以每个元素为起点最小值
     */
    public static int func3(int[] arr, int k) {
        int[] minSum = new int[arr.length];
        int maxLength = 0;
        int sum = 0;
        minSum[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            if (minSum[i+1] < 0) {
                minSum[i] = arr[i] + minSum[i+1];
            } else {
                minSum[i] = arr[i];
            }
        }
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (sum + minSum[j] < k) {
                sum += minSum[j];
                j++;
                maxLength = Math.max(maxLength,j-i+1);
            } else {
                sum -= arr[i];
                i++;
            }
        }
        return maxLength;
    }
}
