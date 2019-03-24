package dp;

import java.util.Map;

/**
 * 场景描述: 甲乙两个人从一个数组中取数，假设甲乙都是绝对聪明的个体，取数只能取头和尾，如何取数才能做到最大
 */
public class TowNumber {

    public static void main(String[] args) {
    }

    /**使用递归
     *递归都是基于一个人，请勿将s认为是后选的分数,我们应该认为两个fs两个函数都是先选择的人可以获取的分数
     */
    public static int func1(int[] arr){
        return f(arr, 0, arr.length);
    }

    //先取
    public static int f(int[] arr, int i, int j) {
        //如果剩下一个数，直接返回
        if (i == j) {
            return arr[i];
        }
        //否则，取大的
        return Math.max(arr[j]+s(arr, i, j-1), arr[i]+s(arr,i+1, j));
    }

    //后取，注：后取返回的值是要给先取的人加上的，所以作为后取者，必定会返回一个最小值得选择结果给先取者
    public static int s(int[] arr, int i, int j) {
        //如果剩下一个数，先取者就没得选了，直接返回0
        if (i == j) {
            return 0;
        }
        //否则，后选择肯定会留下一个小的结果给先选择
        return Math.min(f(arr, i, j-1), f(arr, i+1, j));
    }

    /**
     * 动态规划
     * 通过观察发现,例子f(0, 9)可由 max(s(1, 9), s(0,8))推得，因此可以维护两张表，使用动态规划，将重复递归的操作省略
     */
    public static int func2(int[] arr) {
        //用两个数组来储存
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j <= arr.length; j++) {
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    f[i][j] = arr[i];
                    s[i][j] = 0;
                    continue;
                }
                f[i][j] = Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }
        return f[0][arr.length];
    }


    /**
     * 递归，将两个合成一个
     */
    public static int func3(int[] arr, int i, int j) {
        //如果剩下一个，直接返回
        if (i == j){
            return arr[i];
        }
        //如果剩下两个，取大的那一个
        if (i == j - 1) {
            return Math.max(arr[i], arr[j]);
        }
        return Math.max(arr[i]+Math.min(func3(arr, i+1+1, j), func3(arr, i+1, j-1)), arr[j]+Math.min(func3(arr, i+1, j-1), arr[j]+func3(arr, i, j-2)));
    }


    /**
     * 动态规划
     */
    public static int func4(int[] arr) {
        int[][] f = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++){
            for (int i = j; i >= 0; i--) {
                if (i == j) {
                    f[i][j] = arr[i];
                } else if (i+1 == j) {
                    f[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    f[i][j] = Math.max(Math.min(arr[i]+f[i+2][j], arr[i]+f[i+1][j-1]), Math.min(arr[j]+f[i+1][j-1], arr[j]+f[i][j-2]));
                }

            }
        }
        return f[0][arr.length];
    }
}
