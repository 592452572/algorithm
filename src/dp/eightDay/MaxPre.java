package dp.eightDay;

import java.util.LinkedList;
import java.util.List;

public class MaxPre {
    /**
     * 「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。
     *
     * 给你一个字符串 s，请你返回它的 最长快乐前缀。
     *
     * 如果不存在满足题意的前缀，则返回一个空字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-happy-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String s = "babbb";
        getS2(s);
    }
    public static String getS(String s){
        char[] chars = s.toCharArray();
        if (s.length() == 1) {
            return "";
        }
        char startChar = chars[0];
        char endChar = chars[chars.length-1];
        List<Integer> startIndex = new LinkedList<>();
        List<Integer> endIndex = new LinkedList<>();


        for (int i = 0; i <chars.length; i++) {
            if (i != 0 && chars[i] == startChar) {
                startIndex.add(i);
            }
            if (i != chars.length-1 && chars[i] == endChar){
                endIndex.add(i);
            }
        }
        String result = "";
        for (int j = endIndex.size()-1; j >= 0; j--) {
            Integer eIndex =  endIndex.get(j);
            //判断长度
            for (int i = 0; i< startIndex.size();  i++)  {
                Integer sIndex = startIndex.get(i);
                if (eIndex + 1 == s.length()-sIndex) {
                    if (s.substring(0, eIndex+1).equals(s.substring(sIndex, s.length()))) {
                        result = s.substring(0, eIndex+1);
                        break;
                    }
                } else if (eIndex + 1 > s.length()-sIndex) {
                    break;
                }
            }
            if (result != "") {
                break;
            }
        }
        return result;
    }


    public static String getS1(String s){
        char[] chars = s.toCharArray();
        if (s.length() == 1) {
            return "";
        }
        char endChar = chars[chars.length-1];

        List<Integer> endIndex = new LinkedList<>();


        for (int i = 0; i <chars.length; i++) {
            if (i != chars.length-1 && chars[i] == endChar){
                endIndex.add(i);
            }
        }
        String result = "";
        for (int j = endIndex.size()-1; j >= 0; j--) {
            Integer eIndex =  endIndex.get(j);
            if (s.substring(0, eIndex+1).equals(s.substring(s.length()-eIndex-1, s.length()))) {
                result = s.substring(0, eIndex+1);
                break;
            }


        }
        return result;
    }

    public static String getS2(String s){
        char[] chars = s.toCharArray();
        if (s.length() == 1) {
            return "";
        }
        char endChar = chars[chars.length-1];



        String result = "";
        for (int i = chars.length-1; i >= 0; i--) {
            if (i != chars.length-1 && chars[i] == endChar){
                if (s.substring(0, i+1).equals(s.substring(s.length()-i-1, s.length()))) {
                    result = s.substring(0, i+1);
                    break;
                }
            }
        }


        return result;
    }

   //kmp
        public String longestPrefix(String s) {
            if (s == null || s.length() < 2) return "";
            char[] sChars = s.toCharArray();
            int[] nexts = new int[s.length() + 1];
            nexts[0] = -1;
            nexts[1] = 0;
            int cur = 2;
            int preNext = 0;
            while (cur < nexts.length) {
                if (sChars[cur - 1] == sChars[preNext]) {
                    nexts[cur++] = ++preNext;
                } else if (preNext > 0) {
                    preNext = nexts[preNext];
                } else {
                    nexts[cur++] = 0;
                }
            }
            return s.substring(0, nexts[nexts.length - 1]);
        }



}
