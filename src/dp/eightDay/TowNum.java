package src.dp.eightDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TowNum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *思路：hash表

     */
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.get(target-num) == null) {
                map.put(num, i);
            } else {
                arr[0] = map.get(target-num);
                arr[1] = i;
                break;
            }
        }
        return arr;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length && list.size() > (nums1.length+nums2.length)) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        for (int index = i; index < nums1.length; index++) {
            list.add(nums1[index]);
        }

        for (int index = j; index < nums2.length; index++) {
            list.add(nums2[index]);
        }
        //0 1 2 3 4 5
        if (list.size() == 1) {
            return list.get(0);
        }

        if ((nums1.length+ nums2.length)%2 == 1) {
            return list.get((nums1.length+nums2.length-1)/2);
        } else {
            int max = (nums1.length+nums2.length)/2;
            int min = max - 1;
            return ((double)list.get(max) + (double)list.get(min))/2;
        }

    }
}
