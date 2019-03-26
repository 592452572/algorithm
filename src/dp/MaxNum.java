package dp;

public class MaxNum {

    /**
     * 给定一个数组，求其最大值
     * 策略：放弃前缀和后缀为负数的结果
     */
    public static int getMaxNum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            sum = sum<0?0:sum;
        }
        return max;
    }
}
