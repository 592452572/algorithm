package sort;

import java.util.Arrays;

public class MergeSort extends BaseClass{

    public static void main(String[] args) throws Exception {
        Integer[] arr = new Integer[]{56, 78, 12, 3, 6, 98, 78, 64};
        for (Integer item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
        arr = mergeSort(arr);
        for (Integer item : arr) {
            System.out.print(item+" ");
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public static Integer[] mergeSort(Integer[] arr) throws Exception {
        if (arr.length < 2) {
            return arr;
        }
        double length = new Double(arr.length+"")/2.0;
        //向上取整
        int middle = (int) Math.ceil(length);
        return merge(mergeSort(Arrays.asList(arr).subList(0, middle).toArray(new Integer[middle])), mergeSort(Arrays.asList(arr).subList(middle, arr.length).toArray(new Integer[arr.length-middle])));
    }

    public static Integer[] merge(Integer[] leftArr, Integer[] rightArr) {
        //创建一个存储的数组
        Integer[] arrTemp = new Integer[leftArr.length+rightArr.length];
        //左边和右边的下标
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arrTemp[index++] = leftArr[leftIndex++];
            } else {
                arrTemp[index++] = rightArr[rightIndex++];
            }
        }
        while (leftIndex < leftArr.length) {
            arrTemp[index++] = leftArr[leftIndex++];
        }
        while (rightIndex < rightArr.length) {
            arrTemp[index++] = rightArr[rightIndex++];
        }
        return arrTemp;
    }

}
