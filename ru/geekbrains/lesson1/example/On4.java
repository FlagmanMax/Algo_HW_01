package ru.geekbrains.lesson1.example;

public class On4 {
        public static void main(String[] args) {
            System.out.println("countCube() = " + countCube1(6));
            //System.out.printf("count =%i", countCube1(6));
        }

        public static int countCube1(int k) {
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
