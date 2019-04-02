package dp;

public class MaxValue {

    /**
     * 给定一个数组，分为两个部分，求最大的值
     * 思路：从左边到右边遍历一次获得以各个位置为结尾的最大值，记录到数组中，在从右往左重复操作
     */
    public static int getMaxValue(int[] arr) {
        //给定一个数组记录以每个节点为结尾的最大值
        int[] arrMax = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(cur, max);
            arrMax[i] = max;
            cur = cur < 0?0:cur;
        }
        max = Integer.MIN_VALUE;
        cur = 0;
        for (int i = arr.length-1; i >= 1; i--) {
            cur += arr[i];
            max = Math.max(cur, max);

            arrMax[i] = max;
            maxValue = Math.max(max + arrMax[i-1], maxValue);
            cur = cur < 0?0:cur;
        }
        return maxValue;
    }

    /**
     * 给定一个数组，求左边最大值减去右最大值边后的绝对值最大的时候
     * 直接用最大值减去最左边的值，或减去最右边的值， 如：1,2, 最大值肯定会包含1， -1,2，右边肯定不会包含-1， -1，-2，给了左边取得-1的机会，可能值相见会变小
     */
    public static int getMaxValue2(int[] arr) {
        int[] arrMax = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            max = Math.max(cur, max);
            arrMax[i] = max;
            cur = cur < 0?0:cur;
        }
        return Math.max(Math.abs(max-arr[0]), Math.abs(max-arr[1]));
    }

}
