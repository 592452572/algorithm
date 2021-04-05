package src.dp;

public class Location {
    /**
     * 问题描述：一个机器人起始在某个位置，一分钟可以向左或者向右移动一次，求K分钟后在T位置的次数
     */
    public static int func1(int n, int s, int k, int t) {
        if (n < 2 || s < 0 || s >= n || k < 1 || t < 0 || t >= n) {
            return 0;
        }
        if (k == 1) {
            return s == t?1:0;
        }
        if (t == 0) {
            return func1(n, s, k-1, 1);
        }
        if (t == n-1) {
            return func1(n, s, k-1, n-2);
        }

        return func1(n, s, k-1, t+1)+func1(n, s, k-1, t-1);

    }

    //动态规划
    public static int func2(int n, int s, int k, int t) {
        int[][] arr = new int[k][n];
        arr[0][s] = 1;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0){
                    arr[i][j] = arr[i-1][j+1];
                }else if (j == n-1) {
                    arr[i][j] = arr[i-1][j-1];
                } else {
                    arr[j][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
                }
            }
        }
        return arr[k-1][t];
    }
    //优化动态规划，两个数组
    public static int func3(int n, int s, int k, int t) {
        int[] a = new int[n];
        int[] b = new int[n];
        a[s] = 1;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 1) {
                    if (j == 0){
                        b[j] = a[j+1];
                    }else if (j == n-1) {
                        b[j] = a[j-1];
                    }else {
                        b[j] = a[j-1]+a[j+1];
                    }
                } else {
                    if (j == 0){
                        a[j] = b[j+1];
                    }else if (j == n-1) {
                        a[j] = b[j-1];
                    }else {
                        a[j] = b[j-1]+a[j+1];
                    }
                }
            }
        }
        if ((k-1) % 2 == 1) {
            return b[t];
        } else {
            return a[t];
        }
    }

    //优化：使用一个变量来记录

    public static int func4(int n, int s, int k, int t) {
        int[] a = new int[n];
        int temp = 0;
        a[s] = 1;
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    temp = a[j];
                    a[j] = a[j+1];
                } else if(j == n-1){
                    a[j] = temp;
                } else {
                    int temp1 = temp;
                    temp = a[j];
                    a[j] = temp1 + a[j+1];
                }
            }
        }
        return a[t];
    }
}
