package src.dp.sixthDay;

import java.util.HashMap;
import java.util.Map;

public class ZeroOne {

    /**
     * 问题描述：一个数列由01组成，求01串最长的长度
     *
     */
    public static int func1(int[] arr) {
        int maxNum = 0;
        int i = 0;
        int j = 1;
        int record = arr[0];
        while (j < arr.length) {
            if (record != arr[j]) {
                record = arr[j];
                maxNum = Math.max(maxNum, j-i+1);
                j++;
            }else {
                i = j;
                record = arr[i];
                j++;
            }
        }
        return maxNum;
    }

    /**
     * 问题描述：一个数列由01组成，求01串0和1数量相同最长的长度
     * 思路：将0变成-1相加
     */
    public static int func2(int[] arr) {
        int maxNum = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
            sum += arr[i];
            if (!map.containsKey(sum-0)) {
                map.put(sum, i);
            } else {
                maxNum = Math.max(maxNum, i-map.get(sum)+1);
            }

        }
        return maxNum;
    }
}
