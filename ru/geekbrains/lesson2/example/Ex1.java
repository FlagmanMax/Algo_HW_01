package ru.geekbrains.lesson2.example;

import java.util.Random;

public class Ex1 {
    public static void main(String[] args)
    {
//        int[] array = new int[100];
//        for (int j = 0; j < array.length; j++) {
//            array[j] = (int) (Math.random() * 10000);
//        }
        int[] array = randomArray(100,0,100);
        printArray(array);

        //todo делаем вызов одной из сортировок
        bubleSort(array);
        printArray(array);
        // directSort(array);
        //insertSort(array);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
    }

    private static final Random random = new Random();

    public static int[] randomArray(int size, int start, int stop)
    {
        int[] result = new int[size];
        for (int j = 0; j < result.length; j++)
        {
            result[j] = random.nextInt(start, stop);
        }
        return result;
    }
    public static void printArray(int[] array)
    {
        for (int element: array)
        {
            System.out.printf("%d ",element);
        }
        System.out.println();
    }
    /**
     * O(N^2)
     */
    public static void bubleSort(int[] array) {
        boolean needSort;
        do {
            needSort = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    needSort = true;
                }
            }
        } while (needSort);
    }

    /**
     * O(n^2)
     */
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (minPosition != i) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    /**
     * O(n^2)
     */
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
