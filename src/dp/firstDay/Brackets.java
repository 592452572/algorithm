package dp.firstDay;

/**
 * 括号问题
 */
public class Brackets {


    /**
     * 题1：判断一个字符串是否为合法的括号
     * 思路 "(" +1 ")"-1 用一个count记录次数，当count中途<0 或结束时!= 0则false
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
     * s[] 为字符串
     * 思路：给定一个数组arr，储存以每个位置作为结尾时，最长的合法子串长度
     * index=0时，arr[0] = 0
     * index != 0 时，if (arr[index] == '(') 则arr[index] = 0
     *                if (arr[index] == ')') 则判断s[index-arr[index-1]-1]的值是否为"(" 是的话则arr[inedx] = arr[index-1]+2
     *                         且需再往前判断arr[arr[index]-1]的值是否为0，不是的话则arr[index] = arr[index]+arr[arr[index]-1]
     *
     * 遍历至最后则可获得最大子串长度
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
