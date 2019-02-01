public class ShellSort extends BaseClass {

    public static void main(String[] args) {

        printArr(arr);
        shellSort(arr, 2);
        printArr(arr);

    }

    /**
     * 希尔排序
     * @param arr 要排序的数组
     * @param baseCount 跳跃的基数
     */
    public static void shellSort(int[] arr, int baseCount) {
        //跳跃的步数大小
        for (int jumpCount = arr.length / baseCount; jumpCount >= 1; jumpCount = jumpCount / 2) {
            //根据步数进行插入排序
            for (int i = jumpCount; i < arr.length; i++) {
                int j;
                int temp = arr[i];
                for (j = i - jumpCount; j >= 0; j-=jumpCount) {
                    if (temp < arr[j]) {
                        arr[j+jumpCount] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j+jumpCount] = temp;
            }
        }
    }

}
