package aud9;
import aud9.binarysearchtree.BNode;
import aud9.binarysearchtree.BinarySearchTree;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("9 1\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 2\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 4\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 6\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("9 9\n8 2 11 1 5 19 3 6 13");
//        Scanner sc = new Scanner("10 4\n8 2 11 1 5 10 19 3 6 13");
//        Scanner sc = new Scanner("10 9\n8 2 11 1 5 10 19 3 6 13");
        int n = sc.nextInt(), k = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        System.out.println(k + "`th largest is " + kthLargest(bst, k));
    }

    private static int kthLargest(BinarySearchTree<Integer> bst, int k) {
        return kthLargestInSubtree(bst.getRoot(), k);
    }

    private static int kthLargestInSubtree(BNode<Integer> node, int k) {
        int rightSubtreeSize = subtreeSize(node.right);
        if (rightSubtreeSize >= k) return kthLargestInSubtree(node.right, k);
        else if (rightSubtreeSize + 1 == k) return node.info;
        return kthLargestInSubtree(node.left, k - rightSubtreeSize - 1);
    }

    private static int subtreeSize(BNode<Integer> node) {
        if (node == null) return 0;
        return 1 + subtreeSize(node.left) + subtreeSize(node.right);
    }
}