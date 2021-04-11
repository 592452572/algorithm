package src.dp.sevenDay;

public class DongGui {

    /**
     * 问题描述：给定两个数。n，k n为数组长度，k为最大值。数组满足arr[i]<=arr[i+1] || arr[i] mod arra[i+1] !=0，求一共有多少满足的数组
     * 思路：func(1, n, k),默认n==0的值为1,因为任何值都比1大 1--表示该位置上的数， n表示还有多少位， k表示最大值
     * func(start, n, k) 依赖（sum(func(start至k, n-1))+sum(func(1至start-1, n-1) mod start != 0)）
     * n == 0 return 1
     * 优化，k为纵坐标，n为横坐标。算出列的总值，减去无关的值
     * 由于求值只需依赖前一列的值，可以用两个数组滚动。最优1一个数组，从大往小更新，因为大值直接可以加起来，小值需要筛选
     */
}
