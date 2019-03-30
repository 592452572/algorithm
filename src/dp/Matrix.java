package dp;

public class Matrix {

    //求一个矩阵的最大子矩阵的值
    //参考求一个数组的最大子串
    public int getMaxMatrix(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int[] s = new int[arr[0].length];
            for (int j = i; j < arr.length; j++) {
                int cur = 0;
                for (int k = 0; k < arr[0].length; k++) {
                    s[k] += arr[j][k];
                    cur += s[k];
                    max = Math.max(cur, max);
                    cur = cur<0?0:cur;
                }
            }
        }
        return max;
    }
}
