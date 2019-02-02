public class RadixSort extends BaseClass {

    public static void main(String[] args) {
        printArr(arr);
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //对各个元素的不同位数进行排序
        int count = getMaxCount(arr);
        int baseCount = 1;
        int[] tempArr = new int[1];
        for (int i = 0; i < count; i++, baseCount *= 10) {
            int[] countArr = new int[10];
            tempArr = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                countArr[(arr[j]/baseCount)%10]++;
            }
            for (int j = 1; j < countArr.length; j++) {
                countArr[j] += countArr[j-1];
            }
            for (int j = arr.length-1; j >=  0; j--) {
                tempArr[countArr[(arr[j]/baseCount)%10]-1] = arr[j];
                countArr[(arr[j]/baseCount)%10]--;
            }
        }
        for (int i : tempArr) {
            System.out.print(i+" ");
        }
    }

    public static int getMaxCount(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int count = 1;
        while (max / 10 > 0) {
            count++;
            max /= 10;
        }
        return count++;
    }

}
