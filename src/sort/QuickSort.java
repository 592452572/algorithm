package sort;

public class QuickSort extends BaseClass {

    public static void main(String[] args) {
        printArr(arr);
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }

    /**
     *
     * @param arr 操作的数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        //选定第一个元素为基准
        int temp = arr[start];
        //定制两个指针，分别指向第一个元素和最后一个元素（第一个元素是为了防止第一次右边的指针就与左边的指针重合）
        int left = start;
        int right = end;
        //指针重合停止
        while (left < right){
            //先从右边开始找到小于等于基准的元素，停止（一定要是右边，因为最后是将两个指针重合的元素与基准进行交换，若不是从右边开始，则会发生比基准大的元素与基准位置交换）
            while (arr[right] >= temp && right > left){
                right--;
            }
            //在从左边开始，找到大于
            while (arr[left] <= temp && right > left){
                left++;
            }
            //指针未重合，将大于基准和小于基准的两个数位置交换
            if (right > left) {
                int t = arr[right];
                arr[right] = arr[left];
                arr[left] = t;
            }
        }
        //将基准和指针重合元素的位置进行交换
        int t = arr[left];
        arr[left] = arr[start];
        arr[start] = t;
        //以新的位置为分割线，重复以上操作
        quickSort(arr, start, left-1);
        quickSort(arr, left+1, end);
    }
}
