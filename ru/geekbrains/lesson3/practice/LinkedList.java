package ru.geekbrains.lesson3.practice;
import java.util.Stack;

import ru.geekbrains.lesson3.lection.List;

public class LinkedList
{
    public static Node1 head;
    public static class Node1
    {
        public Node1 next;
        public int value;
    }

    public static Node2 head2;
    public static Node2 tail;
    public static class Node2
    {
        public Node2 next;
        public Node2 previous;
        public int value;
    }
    public static void addFirst2(int value)
    {
        Node2 node = new Node2();
        node.value = value;

        if (head2 != null)
        {
            head2.previous = node;
            node.next = head2;
        }
        else
        {
            node.next = null;
            node.previous = null;
            tail = node;
        }
        head2 = node;
    }
    public static void addLast2(int value)
    {
        if (tail != null)
        {
            Node2 Last = new Node2();
            Last.value = value;
            Last.next = null;

            if (tail != head2)
            {
                Last.previous = tail;
                tail.next = Last;
            }
            else
            {
                head2.next = Last;
                Last.previous = head2;
            }
            tail = Last;
        }
        else
        {
            addFirst2(value);
        }
    }
    public static void delLast2()
    {
        if (tail != null)
        {
            if (tail == head2)
            {
                tail = null;
                head2 = null;
            }
            else
            {
                Node2 previous;
                previous = tail.previous;
                previous.next = null;
                tail = previous;
            }
        }
    }
    public void delFirst2()
    {
        if (head2 != null)
        {
            if (head2 != tail)
            {
                Node2 next = head2.next;
                next.previous = null;
                head2 = next;
            }
            else
            {
                delLast2();
            }
        }
        else
        {
            head2 = null;
            tail = null;
        }
    }
    public Node2 findNode2(int value)
    {
        Node2 node = head2;
        while (node != null)
        {
            if (node.value == value)
            {
                return node;
            }
            else
            {
                node = node.next;
            }
        }
        return null;
    }

    public void addFirst1(int value)
    {
        Node1 node = new Node1();
        node.value = value;

        if (head != null)
        {
            node.next = head;
        }
        else
        {
            node.next = null;
        }
        head = node;
    }
    public void addLast1(int value)
    {
        if (head != null)
        {
            Node1 current;
            current = head;

            while (current.next != null)
            {
                current = current.next;
            }

            Node1 Last = new Node1();
            Last.value = value;
            Last.next = null;

            current.next = Last;
        }
        else
        {
            addFirst1(value);
        }
    }
    public void delLast1()
    {
        if (head != null)
        {
            Node1 current, previous;
            current = head;
            previous = head;

            while (current.next != null)
            {
                previous = current;
                current = current.next;
            }

            if (current == previous)
            {
                head = null;
            }
            else
            {
                previous.next = null;
            }
        }
    }
    public void delFirst1()
    {
        if (head != null)
        {
            head = head.next;
        }
        else
        {
            head = null;
        }
    }

    public Node1 findNode1(int value)
    {
        Node1 node = head;
        while (node != null)
        {
            if (node.value == value)
            {
                return node;
            }
            else
            {
                node = node.next;
            }
        }
        return null;
    }

    public boolean isInList1(int value)
    {
        Node1 node = head;
        while (node != null)
        {
            if (node.value == value)
            {
                return true;
            }
            else
            {
                node = node.next;
            }
        }
        return false;
    }

    public static void printList2()
    {
        Node2 current = head2;
        while(current != null)
        {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void printList1()
    {
        Node1 current = head;
        while(current != null)
        {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println();
    }

    public static void bubbleSort()
    {
        boolean finish;

        do
        {
            finish = true;
            Node2 current = head2;
            while (current.next != null)
            {
                if (current.value > current.next.value)
                {
                    int temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;

                    finish = false;
                }
                current = current.next;
            }
        } while(!finish);
    }

    public void revert()
    {
        if (head2 != null && head2.next != null)
        {
            Node2 temp = head2;
            revert(head2.next, head2);

            temp.next = null;
        }

    }
    private void revert(Node2 currentNode, Node2 previousNode)
    {
        if (currentNode.next == null)
        {
            head2 = currentNode;
        }
        else
        {
            revert(currentNode.next,currentNode);
        }
        currentNode.next = previousNode;

        //previousNode.next = null;
    }

    Integer nFromTheEnd(int n)
    {
        Integer result = -1;
        Stack nElements = new Stack();

        if (head == null)
        {
            return -1;
        }

        Node1 current = head;

        while (current != null)
        {
            nElements.push(current.value);
            current = current.next;
        }

        for (int i=0;i<n;i++)
        {
            if (nElements.isEmpty())
                return -1;
            result = (Integer) nElements.pop();
        }

        return result;
    }
}
