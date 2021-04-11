package dp.fourthDay;

public class WaterStorage {

    /**
     * 问题描述，给定几个不同高度的直方图，求能蓄水多少
     * 思路:判断每个柱子上面能留多少水
     * 非暴力：取决于左右比他高的柱子的小值，左右两个指针，哪边小，先结算哪边
     */
    public static int getValue(int[] arr) {
        int i = 1;
        int j = arr.length-1;
        int maxLeft = arr[0];
        int maxRight = arr[arr.length];
        int maxValue = 0;
        //记录左右最大的value
        while (i <= j) {
            if (maxLeft <= maxRight) {
                if (arr[i] <= maxLeft) {
                    maxValue += maxLeft - arr[i];
                } else {
                    maxLeft = arr[i];
                }
                i++;
            } else {
                if (arr[j] <= maxRight) {
                    maxValue += maxRight - arr[j];
                } else {
                    maxRight = arr[j];
                }
                j--;
            }
        }
        return maxValue;
    }
}
