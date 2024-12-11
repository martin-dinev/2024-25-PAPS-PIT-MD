package aud8_1;

import aud8_1.SLLTree.SLLNode;

import java.util.Iterator;

class MainAud8 {
    public static void main(String[] args) {
        SLLTree<String> t = new SLLTree<String>();
        t.makeRoot("Archy");
        Tree.Node<String> archy = t.root();
        t.addChild(archy,"Joe");
        t.addChild(archy,"Colin");
        Tree.Node<String> frank = t.addChild(archy,"Frank");
        Tree.Node<String> george = t.addChild(archy, "George");
        t.addChild(george, "Fred");
        Tree.Node<String> ann = t.addChild(frank, "Ann");
        t.addChild(ann, "Jon");
        t.addChild(ann, "Emma");
        t.addChild(frank, "Maggie");
        Tree.Node<String> david = t.addChild(frank, "David");
        Tree.Node<String> jeff = t.addChild(david, "Jeff");
        t.addChild(david, "Susie");

        ispecatiDrvo(t);
        System.out.println("Na nivo 2 imame " + izbrojNaNivo(t, 2));
        System.out.println("Na nivo 3 imame " + izbrojNaNivo(t, 3));

        System.out.println("Stepenot na drvoto e " + stepenNadrvo(t));



    }

    private static int stepenNadrvo(SLLTree<String> t) {
        return stepenNadrvoRekurzivno(t, t.root);
    }

    private static int stepenNadrvoRekurzivno(SLLTree<String> tree ,SLLTree<String>.SLLNode<String> node) {
        int rez = tree.childCount(node);
        SLLTree<String>.SLLNode<String> child = node.firstChild;
        while (child != null) {
            int child_rez = stepenNadrvoRekurzivno(tree, child);
            rez = Math.max(rez, child_rez);
            child = child.sibling;
        }
        return rez;
    }

    private static int izbrojNaNivo(SLLTree<String> t, int nivo) {
        return izbrojNaNivoRekurzivno(t.root, 0, nivo);
    }

    private static int izbrojNaNivoRekurzivno(SLLTree<String>.SLLNode<String> node, int nivo, int celno_nivo) {
        if(celno_nivo == nivo){
            return 1;
        }else {
            SLLTree<String>.SLLNode<String> child = node.firstChild;
            int rez = 0;
            while (child != null) {
                int child_rez = izbrojNaNivoRekurzivno(child, nivo + 1, celno_nivo);
                rez += child_rez;
                child = child.sibling;
            }
            return rez;
        }
    }

    private static void ispecatiDrvo(SLLTree<String> t) {
        ispecatiJazelRekurzivno(t.root, 0);
    }

    private static void ispecatiJazelRekurzivno(SLLTree<String>.SLLNode<String> node, int nivo){
        for (int i = 0; i < nivo; i++) System.out.print("    ");
        System.out.println(node.getElement());
        SLLTree<String>.SLLNode<String> child = node.firstChild;
        while(child != null){
            ispecatiJazelRekurzivno(child, nivo + 1);
            child = child.sibling;
        }
    }



    private static <E>void ispecatiDrvoSoIterator(SLLTree<E> t) {
        ispecatiJazelRekurzivnoSoIterator(t, t.root(), 0);
    }

    private static <E>void ispecatiJazelRekurzivnoSoIterator(Tree<E> tree, Tree.Node<E> node, int nivo){
        for (int i = 0; i < nivo; i++) System.out.print("    ");
        System.out.println(node.getElement());
//        for (Tree.Node<String> child: tree.childrenNodes(node)){
//
//        }
        Iterator<Tree.Node<E>> it = tree.childrenNodes(node);
        while (it.hasNext()) {
            ispecatiJazelRekurzivnoSoIterator(tree, it.next(), nivo + 1);
        }
    }
}