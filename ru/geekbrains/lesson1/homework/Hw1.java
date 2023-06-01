package ru.geekbrains.lesson1.homework;

public class Hw1 {
    public static void main(String[] args) {

    }

    private static int countCube(int k) {
        int result = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    for (int m = 0; m < k; m++) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
