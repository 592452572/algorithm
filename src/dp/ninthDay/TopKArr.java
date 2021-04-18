package src.dp.ninthDay;

public class TopKArr {
    /**
     * 问题描述：给定两个有序数组，求两个数组相加后前k个最大的数
     * 思路：组成一个二维表arr[i][j]
     * 最大值只可能是arr[i][j]，次大值可能是arr[i-1][j] 或arr[i][j-1]
     * 使用大根堆排序解决
     * 防止重复用一个map表记录
     */
}
