package dp.leeCode;

public class RunClass {
    public static void main(String[] args) {

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 2;
        nextPermutation(arr);
    }

    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     *
     * @param s
     * @param p
     * @return
     */
    public static  boolean isMatch(String s, String p) {
        //dp[i][j]表示s长度为i,p长度为j时，是否匹配
        int[][] dp = new int[s.length()+1][p.length()+1];

        //初始化 s=="" p!= "" 需结尾是*来消化
        if (p.length() >= 1 && p.charAt(0) == '*') {
            dp[0][1] = 1;
        }
        dp[0][0] = 1;
        for (int j= 2; j < p.length(); j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-2];
            }
        }

        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*'){
                    if (j-2 >= 0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')) {
                        //消除掉：dp[i][j] = dp[i][j-2] 留下一个：dp[i][j] = dp[i-1][j-2]  留下多个: dp[i][j] = dp[i-1][j]
                        if (dp[i-1][j] == 1) {
                            dp[i][j] = 1;
                        } else if (j >= 2 && (dp[i-1][j-2] == 1 || dp[i][j-2] == 1) ) {
                            dp[i][j] = 1;
                        }
                    } else {
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()-1][p.length()-1] == 1?true:false;
    }

    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        if (nums.length>=1) {
            for (int i = nums.length-1; i>=0; i--) {
                for (int j = i-1; j>=0; j--) {
                    if (nums[j] < nums[i]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                int s = 0;
                int e = nums.length-1;
                while (s < e) {
                    int t = nums[s];
                    nums[s] = nums[e];
                    nums[e] = t;
                    s++;
                    e--;
                }

            } else {
                dp(nums, 0, nums.length-1);
            }
            System.out.println(nums);
        }
    }
    public static void dp(int[] nums, int start, int end) {
        int s = start;
        int e = end;
        boolean flag = false;
        for (int i = end; i>=start; i--) {
            for (int j = i-1; j>=start; j--) {
                if (nums[j] < nums[i]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                    s = j;
                    e = end;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        dp1(nums, s+1, e);


    }

    public static void dp1(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= (end-1)-i+start; j++) {
                if (nums[j] > nums[j+1]) {
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }
    }
}
