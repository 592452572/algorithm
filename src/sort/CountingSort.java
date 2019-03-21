package sort;

public class CountingSort extends BaseClass{

    public static void main(String[] args) {
        printArr(arr);
        countingSort(arr, 98);
        printArr(arr);
    }

    public static void countingSort(int[] arr, int maxValue) {
        //构建一个数组，用来存储元素出现的次数
        int[] countArr = new int[maxValue+1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }
        int index = 0;
        //将对应位置的元素一一对应
        for (int i = 0; i < maxValue+1; i++) {
            while (countArr[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

}
