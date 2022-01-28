package day01;

import java.util.Random;
import java.util.zip.DeflaterOutputStream;

/**
 * @author zhougy
 * @create 2022-01-22 13:39
 */
public class Bubble {

    public static void bubble(int[] arr) {
        int len = arr.length;
        if (len <= 1)
            return;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        int rightOne = eor & (~eor + 1);//提取出最右边的1
        int onlyOne = 0;
        for (int cur : arr) {
            if ((cur & rightOne) == 1) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void insertionSort(int[] arr) {
        int len = arr.length;
        if (len <= 2) {
            return;
        }
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
