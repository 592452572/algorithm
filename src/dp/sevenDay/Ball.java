package src.dp.sevenDay;

public class Ball {
    /**
     * 问题描述：给定一组气球，比如 3 5 1，射击气球可与其前后的气球进行乘积，如打5 则为3*5*1,3 5, 3*5, 5, 求怎么打，值最大
     * 思路：给定函数，制定某个数为最后打的情况。
     * arr[n]  ,func(arr, 0, n-1)则求的是arr(0至n-1)的最大值。
     * 基准思路：假设这个范围内func(arr, start, end)，i为最后打的气球，则最优解：
     *  i是中间的数，则arr[start-1]*arr[i]*arr[end+1] +func(arr, start, i-1)+func(arr, i+1, end)(因为arr[i]是最后打，所以左边和右边都没了，之前乘上这个范围外的数)
     *  i是两边，则只需加一边的数
     *  考虑左边界和右边界问题，可以使用辅助数组，在原数组开头结尾+1，则函数为func(arr, 1, n-2)
     */
}
