public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{56, 78, 12, 3, 6, 98};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
    }
}
