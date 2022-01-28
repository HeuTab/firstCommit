package day01;

import sun.security.util.ByteArrayLexOrder;

import java.util.Random;

/**
 * @author zhougy
 * @create 2022-01-23 11:47
 */
public class merge {

    public static void process(int[] arr, int left, int right) {
        if (left == right)
            return;
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        mergeSort(arr, left, mid, right);
    }

    public static void mergeSort(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int p = 0;
        int left2 = left;
        int right2 = mid + 1;
        while (left2 <= mid && right2 <= right) {
            if (arr[left2] >= arr[right2]) {
                help[p++] = arr[right2++];
            } else {
                help[p++] = arr[left2++];
            }
        }
        while (right2 <= right) {
            help[p++] = arr[right2++];
        }
        while (left2 <= mid) {
            help[p++] = arr[left2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        process(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
