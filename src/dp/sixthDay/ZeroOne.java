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
     * 一种巧妙的解法：定义一个数据temp[N]， temp[i]表示从num[0...i]中 num_of_0 - num_of_1，0的个数与1的个数的差那么如果num[i+1] ~ num[j]是符合条件的子串
     * ，一定有 temp[i] == temp[j]，因为中间的部分0、1个数相等，相减等于0。只需要扫一遍num[N]就能把temp[N]构造出来了。这样问题就转换成了求距离最远的一对数，使得temp[i] == temp[j]，
     * 因为temp[i]的范围一定是[-N,N]，-N到N的范围所对应的从num[0]开始的子串的结尾下标i都存起来，这样每扫到temp[i]，查数就行了。

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
