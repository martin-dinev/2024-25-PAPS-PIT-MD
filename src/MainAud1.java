import aud1.Array;
import aud1.SLL;
import aud1.SLLNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainAud1{
    public static void main(String[] args) {
        Array<Integer> array1, array2;
        List<Integer> arraylist1, arraylist2;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        array1 = getAndReadIntegerArray(n, scanner);
        array2 = getAndReadIntegerArray(n, scanner);
        arraylist1 = arrayToList(n, array1);
        arraylist2 = arrayToList(n, array2);
        System.out.println(array1);
        System.out.println(array2);
        System.out.println(arraylist1);
        System.out.println(arraylist2);
        for (int i = 0; i < array1.getSize(); i++) {
            Integer e1 = array1.get(i);
            Integer e2 = array2.get(i);
            if (e1.equals(e2)) {
                array1.delete(i);
                array2.delete(i);
                i--;
            }
        }
        for (int i = 0; i < arraylist1.size(); i++) {
            Integer e1 = arraylist1.get(i);
            Integer e2 = arraylist2.get(i);
            if (e1.equals(e2)) {
                arraylist1.remove(i);
                arraylist2.remove(i);
                i--;
            }
        }
        System.out.println("Posle promena e");
        System.out.println(array1);
        System.out.println(array2);
        System.out.println(arraylist1);
        System.out.println(arraylist2);
    }

    private static List<Integer> arrayToList(int n, Array<Integer> array1) {
        List<Integer> arraylist1;
        arraylist1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arraylist1.add(array1.get(i));
        }
        return arraylist1;
    }

    private static Array<Integer> getAndReadIntegerArray(int n, Scanner scanner) {
        Array<Integer> array1;
        array1 = new Array<>(n);
        for (int i = 0; i < n; i++) {
            array1.insert(i, scanner.nextInt());
        }
        return array1;
    }
}
/*
6
1 2 3 4 5 6
7 2 3 7 7 6


 */


class Test2 {
    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<>();
        napolniLista(lista);
        int size = lista.size();
        SLLNode<Integer> current = lista.getFirst();
        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + current.getElement());
            current = current.getSucc();
        }
//        current = lista.getFirst();
//        while(current != null){
//            System.out.println(current.getElement());
//            current = current.getSucc();
//        }
        System.out.println(lista);

        int broj_parni = izbroj_parni(lista);
        System.out.println("Broj na parni e: " + broj_parni);

        SLL<Integer> rez = izbrisani_parni(lista);
        System.out.println(rez);
        System.out.println(lista);

        int broj_na_op_par = izbroj_opagjachki(lista);
        System.out.println("Broj na opagjachki: " + broj_na_op_par);
        brisi_parni(lista);
        System.out.println(lista);

        lista = new SLL<>();
        napolniLista(lista);
        brisi_parni_v2(lista);
        System.out.println(lista);

        lista = new SLL<>();
        napolniLista(lista);
        SLL<Integer> svrtena = svrtena_lista(lista);

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String name = scanner.next();
            if(name.equals("Kraj")){
                break;
            }
            boolean good = false;
            char c = name.charAt(0);
            if(Character.isUpperCase(c)){
                good = true;
            }

        }



    }

    private static SLL<Integer> svrtena_lista(SLL<Integer> lista) {
        SLL<Integer> rez = new SLL<>();
        SLLNode<Integer> curr = lista.getFirst();
        while (curr != null) {
            rez.insertFirst(curr.getElement());
            curr = curr.getSucc();
        }
        return rez;
    }

    private static void svrti_lista(SLL<Integer> lista) {
        SLL<Integer> rez = new SLL<>();
        SLLNode<Integer> curr = lista.getFirst();
        while (curr != null) {
            rez.insertFirst(curr.getElement());
            curr = curr.getSucc();
        }
        lista.deleteList();
        curr = rez.getFirst();
        while (curr != null) {
            lista.insertLast(curr.getElement());
            curr = curr.getSucc();
        }
    }


    private static void brisi_parni(SLL<Integer> lst) {
        SLL<Integer> rezultat = new SLL<>();
        SLLNode<Integer> current = lst.getFirst();
        while (current != null) {
            Integer e = current.getElement();
            if (e % 2 == 0) {
                current = current.getSucc();
            } else {
                rezultat.insertLast(e);
                current = current.getSucc();
            }
        }
        lst.deleteList();
        current = rezultat.getFirst();
        while (current != null) {
            lst.insertLast(current.getElement());
            current = current.getSucc();
        }
    }

    private static void brisi_parni_v2(SLL<Integer> lst) {
        SLLNode<Integer> current = lst.getFirst();
        while (current != null) {
            Integer e = current.getElement();
            if (e % 2 == 0) {
                lst.delete(current);
            }
            current = current.getSucc();
        }
    }

    private static int izbroj_opagjachki(SLL<Integer> lista) {
        int rez = 0;
        SLLNode<Integer> current = lista.getFirst();
        while (current != null && current.getSucc() != null) {
            int cur_el = current.getElement();
            int next_el = current.getSucc().getElement();
            if (next_el < cur_el) {
                rez++;
            }
            current = current.getSucc();
        }
        return rez;
    }

    private static SLL<Integer> izbrisani_parni(SLL<Integer> lista) {
        SLL<Integer> rezultat = new SLL<>();
        SLLNode<Integer> current = lista.getFirst();
        while (current != null) {
            Integer e = current.getElement();
            if (e % 2 == 0) {
                current = current.getSucc();
            } else {
                rezultat.insertLast(e);
                current = current.getSucc();
            }
        }
        return rezultat;
    }

    private static int izbroj_parni(SLL<Integer> lista) {
        SLLNode<Integer> current = lista.getFirst();
        int broj_parni = 0;
        while (current != null) {
            Integer e = current.getElement();
//            System.out.println(e);
            if (e % 2 == 0) {
                broj_parni++;
            }
            current = current.getSucc();
        }
        return broj_parni;
    }

    private static void napolniLista(SLL<Integer> lista) {
        lista.insertLast(6);
        lista.insertLast(4);
        lista.insertLast(3);
        lista.insertLast(7);
        lista.insertLast(9);
        lista.insertLast(5);
        lista.insertLast(2);
        lista.insertLast(1);
        lista.insertLast(8);
    }
}