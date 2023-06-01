package ru.geekbrains.lesson2.lection;

import java.lang.reflect.GenericDeclaration;

public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]
        {
            4,2,5,8,1,9,2,3,6,8,5
        };

        //bubble(array);
        //directSort(array);
        //insertSort(array);
        quickSort(array,0, array.length-1);

        for (int i=0;i< array.length; i++)
        {
            System.out.print(array[i]+ " ");
        }
    }


    public static void bubble(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    finish = false;
                }
            }
        } while(!finish);
    }

    public static void directSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            int minPosition = i;

            for (int j=i+1; j< array.length; j++)
            {
                if (array[j] < array[minPosition])
                {
                    minPosition = j;
                }
            }

            if (i != minPosition)
            {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public static void insertSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = i+1; j < array.length; j++)
            {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int startPosition, int stopPosition)
    {
        int left = startPosition;
        int right = stopPosition;

        int pivot = array[(startPosition + stopPosition)/2];

        do
        {
            while (array[left] < pivot)
            {
                left++;
            }

            while (array[right] > pivot)
            {
                right--;
            }

            if (left <= right)
            {
                if (left < right)
                {
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < stopPosition)
        {
            quickSort(array, left, stopPosition);
        }
        if (startPosition < right)
        {
            quickSort(array, startPosition, right);
        }
    }
}
