package dp.leeCode;

public class RunClass {
    public static void main(String[] args) {


        System.out.println(isMatch("ab", ".*c"));
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
}
