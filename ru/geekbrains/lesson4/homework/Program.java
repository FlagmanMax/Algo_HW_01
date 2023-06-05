package ru.geekbrains.lesson4.homework;


import java.util.Scanner;

/**
 * Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.
 *
 * Красно-черное дерево имеет следующие критерии:
 * • Каждая нода имеет цвет (красный или черный)
 * • Корень дерева всегда черный
 * • Новая нода всегда красная
 * • Красные ноды могут быть только левым ребенком
 * • У краной ноды все дети черного цвета
 */
public class Program
{
    static class Node
    {
        Node left, right;

        int data;

        public enum Colour
        {
            RED,
            BLACK;
        }

        Colour colour;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;

            colour = Colour.RED;    // New node is always red
        }
    }

    public static class RBT
    {
        private static Node root = null;

        /**
         * Left swap function
         */
        Node leftSwap(Node node) {
            System.out.println("left swap");
            Node child = node.right;
            Node childLeft = child.left;

            child.left = node;
            node.right = childLeft;

            return child;
        }

        /**
         * Right swap function
         */
        Node rightSwap(Node node) {
            System.out.println("right swap");
            Node child = node.left;
            Node childRight = child.right;

            child.right = node;
            node.left = childRight;

            return child;
        }

        Node.Colour colourSwap(Node node) {
            if (node.colour == Node.Colour.RED) {
                return Node.Colour.BLACK;
            } else {
                return Node.Colour.RED;
            }
        }


        /**
         * @param node
         * @return
         */
        boolean isRed(Node node) {
            if (node == null) {
                return false;
            }
            return (node.colour == Node.Colour.RED);
        }

        /**
         * Swap colours
         *
         * @param node1
         * @param node2
         */
        void swapColors(Node node1, Node node2) {
            Node.Colour temp = node1.colour;
            node1.colour = node2.colour;
            node2.colour = temp;
        }

        /**
         * Add new element into RED-BLACK tree
         *
         * @param node
         * @param data
         * @return
         */
        Node insert(Node node, int data) {
            if (node == null) {
                return new Node(data);
            }

            if (data < node.data)
            {
                node.left = insert(node.left, data);
            } else if (data > node.data)
            {
                node.right = insert(node.right, data);
            } else
            {
                return node;
            }

            // Case 1
            // Right is read, left is Black
            if (isRed(node.right) && !isRed(node.left)) {
                node = leftSwap(node);
                swapColors(node, node.left);
            }

            // Case 2
            // Left is red, left grandChild is red
            if (isRed(node.left) && isRed(node.left.left)) {
                node = rightSwap(node);
                swapColors(node, node.right);
            }

            // Case 3
            // left and right are red
            if (isRed(node.left) && isRed(node.right)) {
                node.colour = colourSwap(node);

                node.left.colour = Node.Colour.BLACK;
                node.right.colour = Node.Colour.BLACK;
            }

            return node;
        }

        static void check(Node node)
        {
            if (node != null)
            {
                check(node.left);
                char c = 'R';

                if (node.colour == Node.Colour.BLACK)
                {
                    c = 'B';
                }
                System.out.print(node.data + "" + c + " ");
                check(node.right);
            }
        }

        public static void main(String[] args) {

            RBT node = new RBT();
            Scanner scan = new Scanner(System.in);

            char ch;
            int num = 0;
            do
            {
                System.out.println();
                System.out.println("Введите целое число или q для выхода");

                ch = scan.next().charAt(0);
                if (!Character.isDigit(ch))
                {
                    break;
                }

                num = Character.getNumericValue(ch);
                root = node.insert(root, num);

                check(root);

            } while (true);
        }

    }


}
