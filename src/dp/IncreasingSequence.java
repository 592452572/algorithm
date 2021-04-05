package src.dp;

public class IncreasingSequence {
    /**
     * 问题描述：求一个数组中递增子序列的最长长度
     * 思路：使用一个数组记录以每个节点为结尾的递增数组长度，使用一个数组记录当递增数组长度为i时，数值为多少
     */
    public static int func(int[] arr) {
        int[] lengthArr = new int[arr.length];
        int[] ends = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            //找到刚好大于那个的数
            lengthArr[i] = findIndex(ends, arr[i]);
            max = Math.max(max, lengthArr[i]);
        }
        return max;
    }
    public static int findIndex(int[] ends, int num) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < ends.length; i++) {
            if (ends[i] == 0) {
                max = i;
                break;
            }
        }
        int mid = (max+min)/2;
        while (min <= max) {
            mid = (max+min)/2;
            if (ends[mid] < num) {
                min = mid+1;
            } else if (ends[mid] > num) {
                min = mid-1;
            } else {
                break;
            }
        }
        ends[mid] = num;
        return mid;
    }
}
