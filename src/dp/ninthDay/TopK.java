package src.dp.ninthDay;

public class TopK {
    /**
     * 问题描述：求一个数组中，出现次数最大的k个数
     * 思路：使用map + 大根堆
     */

    /**
     * 问题描述：求一个数组中，出现次数最大的k个数，后面会持续进数。求实时算出
     * 思路：使用map<str,记录次数> + 小根堆（为了方便进数） + map2<str,出现在堆上的位置>
     *  为啥使用小根堆：
     *      因为次数是不断加的，所以一开始堆里是没数据的
     *      每次加一个数，判断值是否大于小根堆顶部的数，如果是，则替换后，进行重排操作
     */
}
