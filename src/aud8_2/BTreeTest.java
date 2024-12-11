package aud8_2;

public class BTreeTest {

    public static void main(String[] args) {
        BNode<Character> a, b, c;
        BTree<Character> tree = new BTree<Character>('F');
        a = tree.addChild(tree.root, BNode.LEFT, 'D');
        b = tree.addChild(a, BNode.LEFT, 'B');
        c = tree.addChild(b, BNode.LEFT, 'A');
        c = tree.addChild(b, BNode.RIGHT, 'C');
        c = tree.addChild(a, BNode.RIGHT, 'E');
        a = tree.addChild(tree.root, BNode.RIGHT, 'G');
        b = tree.addChild(a, BNode.RIGHT, 'I');
        c = tree.addChild(b, BNode.LEFT, 'H');
        c = tree.addChild(b, BNode.RIGHT, 'J');


        System.out.println(tree);

        tree.inorder();
        tree.preorder();
        tree.postorder();

        printNonRecursive(tree);
        tree.inorderNonRecursive();

        System.out.println("Brojot na vnatresni jazli e " + tree.insideNodes());
        System.out.println("Brojot na vnatresni jazli e " + insideNodes(tree));
        System.out.println("Brojot na listovi e " + tree.leaves());
        System.out.println("Brojot na listovi e " + leafNodes(tree));
        System.out.println("Dlabocinata na drvoto e " + tree.depth());
        System.out.println("Dlabocinata na drvoto e " + depth(tree));

        tree.mirror();
        tree.inorder();
    }

    private static int insideNodes(BTree<Character> tree) {
        return insideNodesRecursive(tree.root);
    }
    private static int insideNodesRecursive(BNode<Character> node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + insideNodesRecursive(node.left) + insideNodesRecursive(node.right);
    }
    private static int leafNodes(BTree<Character> tree) {
        return leafNodesRecursive(tree.root);
    }
    private static int leafNodesRecursive(BNode<Character> node) {
        if(node == null)return 0;
        if (node.left == null && node.right == null) {
            return 1;
        }else
            return leafNodesRecursive(node.left) + leafNodesRecursive(node.right);
    }

    private static int depth(BTree<Character> tree) {
        return depthRecursive(tree.root, 0);
    }
    private static int depthRecursive(BNode<Character> node, int nivo) {
        if(node == null)return 0;
        if (node.left == null && node.right == null) {
            return nivo;
        }else
            return Math.max(depthRecursive(node.left, nivo+1) , depthRecursive(node.right, nivo+1));
    }

    private static void printNonRecursive(BTree<Character> tree) {
        System.out.println("Printing non recursive");
        BNode<Character> node = tree.root;
        Stack<BNode<Character>> stack = new ArrayStack<>(100);
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty()) continue;
            BNode<Character> peek = stack.peek();
            stack.pop();
            System.out.print(peek.info + " ");
            node = peek.right;
        }
        System.out.println("   Done");
    }

}
