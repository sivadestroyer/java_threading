import java.util.Arrays;

class MergeSort {
    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public void split() throws InterruptedException {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        MergeSortThread leftThread = new MergeSortThread(left);
        MergeSortThread rightThread = new MergeSortThread(right);
        leftThread.start();
        rightThread.start();
        leftThread.join();
        rightThread.join();
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

class MergeSortThread extends Thread {
    private int[] arr;

    public MergeSortThread(int[] arr) {
        this.arr = arr;
    }
    public void run() {
        MergeSort mergeSort = new MergeSort(arr);
        try {
            mergeSort.split();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class merge {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {5, 3, 8, 9, 2, 3, 4};
        System.out.println("Original array: " + Arrays.toString(arr));
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.split();
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
