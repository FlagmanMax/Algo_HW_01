package ru.geekbrains.lesson3.practice;
import java.util.Random;


public class Main
{
    public static void main(String[] args)
    {
        /**
         * Task 1
         */
        System.out.println("TASK 1");
        ru.geekbrains.lesson3.practice.LinkedList newList = new ru.geekbrains.lesson3.practice.LinkedList();
        Random random = new Random();
        for (int i=0;i<10;i++)
        {
            newList.addLast2(random.nextInt(0,100));
        }
        System.out.println("Исходный список");
        newList.printList2();

        newList.bubbleSort();
        System.out.println("Отсортированный список");
        newList.printList2();

        System.out.println("Перевернутый список");
        newList.revert();
        newList.printList2();

        /**
         * Task 2*
         */
        System.out.println("TASK 2");
        for (int i=0;i<10;i++)
        {
            newList.addLast1(random.nextInt(0,100));
        }
        newList.printList1();

        int n = 5;
        Integer res = newList.nFromTheEnd(n);
        if (res<0)
        {
            System.out.println("Ошибка!");
        }
        else
        {
            System.out.println(n + " с конца элемент из списка = " + res);
        }
    }
}
