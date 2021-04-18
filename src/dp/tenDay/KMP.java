package src.dp.tenDay;

public class KMP {

    /**
     *          a b c d a b e d
     * abcabc -1 0 0 0 0 1 2 3
     * kmp算法：给定一个数组arr[]。辅助数组next[]
     * next[i]中记录i位置之前的前缀和后缀匹配的长度，不包含arr[i]本身
     * next[0]=-1 next[1] = 0;
     * next[i]取决于next[i-1],如果arr[i-1] = arr[next[i-1]],则next[i] = next[i-1]+1
     * 如果不等，则判断arr[next[next[i-1]]] == arr[i-1] ,是则next[i] = next[next[i-1]]+1
     */
}
