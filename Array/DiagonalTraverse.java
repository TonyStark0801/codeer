package Array;

import java.util.*;

public class DiagonalTraverse {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = findDiagonalOrder(mat);
        for (int x : result) {
            System.out.print(x + " ");

        }
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        HashMap<Integer, LinkedList> mem = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int index = i + j;
                mem.putIfAbsent(index, new LinkedList());
                if (index % 2 == 0) mem.get(index).appendLeft(mat[i][j]);
                else mem.get(index).appendRight(mat[i][j]);
            }
        }

        System.out.println(mem);
        int[] result = new int[mat.length * mat[0].length];


        int resIndex = 0;
        for (int x : mem.keySet()) {
            Node head = mem.get(x).getHead();
            while (head != null) {
                result[resIndex] = head.val;
                head = head.next;
                resIndex++;
            }
        }
        return result;
    }

    private static void forwardTraversal(List<Integer> result, List<Integer> integers) {
        for (int x : integers) {
            result.add(x);
        }
    }

    private static void reverseTraversal(List<Integer> result, List<Integer> integers) {
        for (int i = integers.size() - 1; i >= 0; i--) {
            result.add(integers.get(i));
        }
    }

}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {

    private Node head;

    public void appendRight(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node iterator = head;
        while (iterator.next != null) {
            iterator = iterator.next;
        }
        iterator.next = new Node(val);
    }

    public void appendLeft(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}
