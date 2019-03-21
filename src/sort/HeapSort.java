package sort;

public class HeapSort extends BaseClass {

    private static int length = arr.length;

    public static void main(String[] args) {

        printArr(arr);
        heapSort(arr);
        printArr(arr);

    }

    public static void heapSort(int[] arr) {
        //搭建大根堆
        buildMaxHeap(arr);
        //对大根堆进行排序
        for (int i = length-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            length--;
            heapfiy(arr, 0);
        }

    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = arr.length/2-1; i >=0; i--) {
            heapfiy(arr, i);
        }
    }

    public static void heapfiy(int[] arr, int index) {

        if (index > length/2-1) {
            return;
        }

        int bigIndex = index;
        //判断是否有两个叶子节点
        if (2*index+2 <= length-1) {
            //选出大的叶子节点进行比较
            if (arr[2*index+2] < arr[2*index+1]) {
                if (arr[2*index+1] > arr[index]) {
                    bigIndex = 2*index+1;
                }
            } else {
                if (arr[2*index+2] > arr[index]) {
                    bigIndex = 2*index+2;
                }
            }
        } else {
            if (arr[2*index+1] > arr[index]) {
                bigIndex = 2*index+1;
            }
        }
        if (bigIndex != index) {
            int temp = arr[index];
            arr[index] = arr[bigIndex];
            arr[bigIndex] = temp;
            heapfiy(arr, bigIndex);
        }





    }





}
