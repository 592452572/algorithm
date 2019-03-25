package dp;

/**
 * 括号问题
 */
public class Brackets {


    /**
     * 题1：判断一个字符串是否为合法的括号
     */
    public static boolean isBracket1(String str) {
        char[] cs = str.toCharArray();
        boolean flag = true;
        int count = 0;
        for (char c : cs) {
            if (c != '(' || c != ')') {
                flag = false;
                break;
            }
            if (c == ')' && --count < 0){
                flag = false;
                break;
            }
            if (c == '('){
                count++;
            }
        }
        if (count != 0) {
            flag = false;
        }
        return flag;
    }

    /**
     * 题2:判断括号中的最长合法子串
     */

    public static int getBracketSize(String str) {
        char[] cs = str.toCharArray();
        int[] dp = new int[str.length()];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < str.length(); i++) {
            if (cs[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && cs[pre] == '('){
                    dp[i] = dp[i-1]+2+(pre>0?dp[pre-1]:0);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

}
