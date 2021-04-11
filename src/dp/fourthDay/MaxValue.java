package dp.fourthDay;

public class MaxValue {

    /**
     * 给定一个数组，分为两个不相交的两个子数组，求相加最大的值
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
     * 思路：整个数组肯定会有一个最大值。最大值在左边时，需右边最大值尽量小。因为是右边，所以肯定包含最右边。当右部分最右边的数多于1位时，则倒数第二个数可能会
     * 大于最右边的数，所以就会使右半部分的数变大，导致整个相减变小。因此只有右边只有一位时，相减就是最大值
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
