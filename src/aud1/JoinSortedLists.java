package aud1;

public class JoinSortedLists<E extends Comparable<E>> {

    public SLL<E> join(SLL<E> list1, SLL<E> list2){
        SLL<E> rezultat = new SLL<E>();
        SLLNode<E> jazol1 = list1.getFirst(), jazol2 = list2.getFirst();
        //SLLNode<E> jazol2 = list2.getFirst();

        while(jazol1 != null && jazol2 != null){
            if(jazol1.element.compareTo(jazol2.element)<0){ //jazol1<jazol2
                rezultat.insertLast(jazol1.element);
                jazol1 = jazol1.succ;
            }
            else{
                rezultat.insertLast(jazol2.element);
                jazol2 = jazol2.succ;
            }

        }

        if(jazol1 != null){
            while(jazol1 != null){
                rezultat.insertLast(jazol1.element);
                jazol1 = jazol1.succ;
            }
        }

        if(jazol2 != null){
            while(jazol2 != null){
                rezultat.insertLast(jazol2.element);
                jazol2 = jazol2.succ;
            }
        }

        return rezultat;
    }

    public static void main(String[] args){
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");lista1.insertLast("Bojana");lista1.insertLast("Dejan");
        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");lista2.insertLast("Biljana");lista2.insertLast("Darko");

        JoinSortedLists<String> js = new JoinSortedLists<String>();
        System.out.println(js.join(lista1, lista2));

    }
}
