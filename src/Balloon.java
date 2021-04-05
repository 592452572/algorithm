package src;

public class Balloon {
    /**
     * 问题描述:一组气球，可以打任何一个，打了之后可以乘上其左边和右边得数，求怎么打最大
     * 思路，使用递归，从最后一个开始
     */
    public static int func1(int[] arr) {
        //创建一个新数组，首尾为1
        int[] newArr = new int[arr.length+2];
        newArr[0] = 1;
        newArr[newArr.length-1] = 1;
        for (int i = 0; i < arr.length; i++) {
            newArr[i+1] = arr[i];
        }
        return dp(newArr, 1, newArr.length-2);
    }

    public static int dp(int[] arr, int s, int e) {
        if (s == e) {
            return arr[s-1]*arr[s]*arr[s+1];
        }
        int max = Math.max(
               arr[s]*arr[s-1]*arr[e+1]+dp(arr, s+1, e),
               arr[e]*arr[s-1]*arr[e+1]+dp(arr, s, e-1)
        );
        for(int i = s+1; i < e - 1; i++) {
            max = Math.max(arr[i]*arr[i-1]*arr[i+1]+dp(arr, s, i-1)+dp(arr, i+1, e),
                    max);
        }
        return max;
    }
    //dp
    public static int func2(int[] arr, int s, int e) {
        int[][] dp = new int[arr.length][arr.length];
        int[] all = new int[arr.length+2];
        all[0] = 1;
        all[all.length-1] = 1;
        for (int i = 0; i < arr.length; i++) {
            all[i+1] = arr[i];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            dp[i][i] = all[i]*all[i+1]*all[i+2];
            for (int j = i+1; j < arr.length; j++) {
                int temp = 0;
                for (int k = i; k <= j; k++) {
                    temp = all[k]*all[k+1]*all[k+2];
                    temp += i != k ? dp[i][k-1]:0;
                    temp += j != k ? dp[k+1][j]:0;
                    dp[i][j] = Math.max(temp, dp[i][j]);
                }
            }
        }
        return dp[0][arr.length-1];
    }
}
