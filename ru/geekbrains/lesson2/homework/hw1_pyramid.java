package ru.geekbrains.lesson2.homework;

import ru.geekbrains.lesson2.example.Ex1;
import ru.geekbrains.lesson2.example.Ex2;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class hw1_pyramid
{

    /**
     *
     * @param args
     * Compare different sort algorithms, including Pyramid search:
     * 	i	    Bubble	Pyramid	    Quick	System
     *  10000	    70	     3	     1	     5
     *  20000	   279	     2	     1	     2
     *  30000	   816	     3	     1	     2
     *  40000	  1441	     4	     1	     3
     *  50000	  2564	     4	     2	     3
     *  60000	  3219	     5	     2	     4
     *  70000	  4982	     5	     3	     2
     *  80000	  7187	     6	     4	     2
     *  90000	  8975	     7	     4	     3
     * 100000	 14225	     8	     5	     3
     */
    public static void main(String[] args)
    {
        Date startDate;
        Date endDate;

        System.out.printf("\ti\tBubble\tPyramid\tQuick\tSystem\r\n");
        for (int i=10000; i<=100000; i+=10000)
        {
            int[] array = randomArray(i,0,1000);

            startDate = new Date();
            Ex1.bubleSort(array.clone());
            endDate = new Date();
            long bubbleSortDuration = endDate.getTime() - startDate.getTime();
            //System.out.println("i= " + i + ", Bubble sort duration = " + bubbleSortDuration);

            startDate = new Date();
            pyramidSort(array.clone());
            endDate = new Date();
            long pyramidSortDuration = endDate.getTime() - startDate.getTime();
            //System.out.println("i= " + i + ", Pyramid sort duration = " + pyramidSortDuration);

            startDate = new Date();
            Ex2.quickSort(array.clone(), 0, array.length - 1);
            endDate = new Date();
            long quickSortDuration = endDate.getTime() - startDate.getTime();
            //System.out.println("i= " + i + ", Quick sort duration = " + quickSortDuration);

            startDate = new Date();
            Arrays.sort(array.clone());
            endDate = new Date();
            long systemSortDuration = endDate.getTime() - startDate.getTime();
            //System.out.println("i= " + i + ", System sort duration = " + systemSortDuration);

            //System.out.println(i + "\t\t" + bubbleSortDuration + "\t\t" + pyramidSortDuration + "\t\t" + quickSortDuration + "\t\t" + systemSortDuration);
            System.out.printf("%6d\t%6d\t%6d\t%6d\t%6d\r\n", i, bubbleSortDuration,pyramidSortDuration,quickSortDuration,systemSortDuration);
        }
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

    public static void pyramidSort(int[] arr)
    {
        // Step 1
        for (int i=arr.length/2-1; i>=0; i--)
        {
            sift(arr, arr.length, i);
        }

        // Step 2
        for (int i=arr.length-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            sift(arr,i,0);
        }
    }

    private static void sift(int[] arr, int size, int rootIndex)
    {
        int biggest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < size && arr[leftChild] > arr[biggest])
        {
            biggest = leftChild;
        }

        if (rightChild < size && arr[rightChild] > arr[biggest])
        {
            biggest = rightChild;
        }

        if (biggest != rootIndex)
        {
                int temp = arr[rootIndex];
                arr[rootIndex] = arr[biggest];
                arr[biggest] = temp;

                sift(arr, size, biggest);
        }

    }
}
