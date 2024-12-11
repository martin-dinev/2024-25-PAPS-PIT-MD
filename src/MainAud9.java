import aud9.binarysearchtree.BNode;
import aud9.binarysearchtree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result{
    public Integer rez;

    public Result() {
        this.rez = null;
    }

    void updateRez(int val){
        if(rez == null || rez < val) rez = val;
    }
};
public class MainAud9 {

    public static void main(String[] args) {
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        btree.insert(56);
        btree.insert(26);
        btree.insert(200);
        btree.insert(18);
        btree.insert(28);
        btree.insert(190);
        btree.insert(213);
        btree.insert(12);
        btree.insert(24);
        btree.insert(27);
        int suma = findSumBetweenR(btree.getRoot(),24, 27);

        List<Integer> leaves = findLeaves(btree);

        Integer maks = null;
        for (int i = 0 ; i < leaves.size() ; i ++){
            for(int j = i +1 ; j < leaves.size() ; j ++){
                int val1 = leaves.get(i);
                int val2 = leaves.get(j);
                int sum = findSumBetweenR(btree.getRoot(),val1, val2);
                if(maks == null || sum > maks) maks = sum;
            }
        }
        System.out.println(maks);


        Integer rez = findMaxSumBetweenLeaves(btree);
        System.out.println("Max pateka ima suma "  + rez);
    }

    private static Integer findMaxSumBetweenLeaves(BinarySearchTree<Integer> tree) {
        Result result = new Result();
        findMaxSumToLeafR(tree.getRoot(), result);
        return result.rez;
    }

    private static Integer findMaxSumToLeafR(BNode<Integer> node, Result result) {
        if(node == null) return 0;
        if(node.left == null && node.right == null) return node.info;
        Integer left_max_sum = findMaxSumToLeafR(node.left,result);
        Integer right_max_sum = findMaxSumToLeafR(node.right,result);
        if(node.left!=null && node.right!=null) {
            Integer max_path_through_this_node = left_max_sum + node.info + right_max_sum;
            result.updateRez(max_path_through_this_node);
        }
        return node.info + Math.max(left_max_sum, right_max_sum);
    }

    private static List<Integer> findLeaves(BinarySearchTree<Integer> btree) {
//        return findListOfLeavesR(btree.getRoot());
        List<Integer> result = new ArrayList<>();
        findLeavesR(btree.getRoot(), result);
        return result;
    }

    private static void findLeavesR(BNode<Integer> node, List<Integer> result) {
        if(node.left == null && node.right == null){
            result.add(node.info);
            return;
        }
        if(node.left!=null)findLeavesR(node.left, result);
        if(node.right!=null)findLeavesR(node.right, result);
    }

//    private static List<Integer> findListOfLeavesR(BNode<Integer> node){
//        if (node == null) return List.of(); // skrateno od new List... koga nema potreba od promeni
//
//        List<Integer> rez = new ArrayList<>();
//        if(node.left == null && node.right == null)
//            rez.add(node.info);
//        else{
//            List<Integer> left_leaves = findListOfLeavesR(node.left);
//            List<Integer> right_leaves = findListOfLeavesR(node.right);
//
//            rez.addAll(left_leaves);
//            rez.addAll(right_leaves);
//        }
//        return rez;
//    }

    private static int findSumBetweenR(BNode<Integer> node, int smaller, int larger) {
        if(smaller < node.info && larger < node.info  )
            return findSumBetweenR(node.left, smaller,larger);
        else if(smaller > node.info &&   larger > node.info)
            return findSumBetweenR(node.right, smaller,larger);
        int sum_left = findSumToNodeR(node.left, smaller);
        int sum_right = findSumToNodeR(node.right, larger);
        return sum_left + sum_right + node.info;
    }

    private static int findSumToNodeR(BNode<Integer> node, int value) {
        if(node == null) return 0;
        int rez = node.info;
        if(value>node.info)
            return rez + findSumToNodeR(node.right, value);
        if(value<node.info)
            return rez + findSumToNodeR(node.left, value);
        return 0;
    }
}

class Zadaci3_4_5Aud9{
    public static void main(String[] args) {
        Scanner scanner = new Scanner("10\n56 26 18 200 12 28 190 213 24 27");
        int n = scanner.nextInt();
        BinarySearchTree<Integer> btree = new BinarySearchTree<>();
        for (int i = 0; i < n; i++){
            int val = scanner.nextInt();
            btree.insert(val);
            System.out.println("After adding " + val + " the tree is balanced: " + isBalanced(btree));
            if(i<2)continue;
            System.out.println("After adding " + val + " the 3rd largest is: " + kthLargest(btree, 3));
            System.out.println("The predecessor of val is " + predeccesor(btree.getRoot(), val));
        }
    }

    private static Integer predeccesor(BNode<Integer> node, int val) {
        if(node.info > val)return predeccesor(node.left, val);
        if(node.info == val)return getMax(node.left);
        if(getMin(node.right) == val) return node.info;
        return predeccesor(node.right, val);
    }

    private static Integer getMax(BNode<Integer> node) {
        while(node.right != null) node = node.right;
        return node.info;
    }
    private static Integer getMin(BNode<Integer> node) {
        while(node.left != null) node = node.left;
        return node.info;
    }

    private static Integer kthLargest(BinarySearchTree<Integer> btree, int k) {
        return kthLargestR(btree.getRoot(), k);
    }

    private static Integer kthLargestR(BNode<Integer> node, int k) {
        int size_right = subtreeSize(node.right);
        if(size_right >= k) return kthLargestR(node.right, k);
        k -= size_right;
        if(k == 1) return node.info;
        k --;
        return kthLargestR(node.left, k);
    }

    private static Integer subtreeSize(BNode<Integer> node){
        if(node== null)return 0;
        return 1 + subtreeSize(node.left) +  subtreeSize(node.right);
    }

    private static boolean isBalanced(BinarySearchTree<Integer> btree) {
        return isBalancedR(btree.getRoot());
    }

    private static boolean isBalancedR(BNode<Integer> node) {
        if(node == null) return true;
        boolean self_is_balanced = Math.abs(height(node.left) - height(node.right)) <= 1;
        return self_is_balanced && isBalancedR(node.left) && isBalancedR(node.right);
    }

    private static int height(BNode<Integer> node){
        if(node== null)return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
