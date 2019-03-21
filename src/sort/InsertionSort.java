package sort;

public class InsertionSort extends BaseClass {

    public static void main(String[] args) {
        printArr(arr);
        insertionSort(arr);
        printArr(arr);
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //选择将要排序的元素
            int temp = arr[i];
            int j;
            //将该元素与其前面的元素比对大小
            for (j = i - 1; j >= 0; j--) {
                //小的话，将大的元素往后移一位
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
                //重复以上操作，直到前面无元素或者该元素比前方的元素大
            }
            arr[j+1] = temp;
        }
    }
}
