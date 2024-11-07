import aud2.DLL;
import aud2.DLLNode;

import java.util.Scanner;

public class MainAud2 {
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<>();
        dll.insertLast(5);
        dll.insertLast(6);
        dll.insertLast(7);
        DLLNode<Integer> curr = dll.getFirst();
        while(curr != null){
            System.out.println(curr.getElement());
            if(curr.getElement() % 2 == 0){
                // vmetni -2 posle sekoj jazol so paren element
                dll.insertAfter(-2, curr);
                curr = curr.getSucc().getSucc();
            }else
                curr = curr.getSucc();
        }


        System.out.println();

        curr = dll.getLast();
        while(curr != null){
            System.out.println(curr.getElement());
            curr = curr.getPred();
        }

    }
}

class Zadaca1{
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<>();
        popolni_lista(dll);
        boolean e_palindrom = dali_e_palindrom(dll);
        System.out.println("Listata e palindrom: "+ e_palindrom);
    }

    private static <E>boolean dali_e_palindrom(DLL<E> dll) {
        DLLNode<E> left = dll.getFirst(), right = dll.getLast();
        while(left != null){
            E l_el = left.getElement();
            E r_el = right.getElement();
            if(!l_el.equals(r_el)){
                return false;
            }

            left = left.getSucc();
            right = right.getPred();
        }
        return true;
//        dll.getFirst()   dll.getLast()
//        5                5
//        1                1
//        4                3 -> return false;
//        2                2
    }

    private static void popolni_lista(DLL<Integer> dll) {
        dll.insertLast(5);
        dll.insertLast(1);
        dll.insertLast(4);
        dll.insertLast(2);
        dll.insertLast(123);
        dll.insertLast(123123);
        dll.insertLast(4);
        dll.insertLast(1);
        dll.insertLast(5);
    }
}

class Zadaca2{
    public static void main(String[] args) {
        aud2.zadacha2.DLL<Integer> dll = new aud2.zadacha2.DLL<>();
        popolni_lista(dll);
        System.out.println(dll);
        brisi_duplikate(dll);
        System.out.println(dll);
    }

    private static <E>void brisi_duplikate(aud2.zadacha2.DLL<E> dll) {
        aud2.zadacha2.DLLNode<E> curr = dll.getFirst();
        while(curr!=null){
            E curr_element = curr.getElement();
            aud2.zadacha2.DLLNode<E> pom = curr.getSucc();
            while(pom != null){
                if(pom.getElement().equals(curr_element)){
                    dll.delete(pom);
                    curr.setBrPojavuvanja(
                            curr.getBrPojavuvanja() +
                            pom.getBrPojavuvanja()
                    );
                }
                pom = pom.getSucc();
            }
            curr = curr.getSucc();
        }
    }


    private static void popolni_lista(aud2.zadacha2.DLL<Integer> dll) {
        dll.insertLast(5);
        dll.insertLast(5);
        dll.insertLast(8);
        dll.insertLast(7);
        dll.insertLast(3);
        dll.insertLast(5);
        dll.insertLast(7);
        dll.insertLast(5);
        dll.insertLast(8);
    }
}



class Zadaca3 {
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<>();
        popolni_lista(dll);
        System.out.println(dll);
        prevrti_lista(dll);
        System.out.println(dll);
        System.out.println(dll.toStringR());
    }

    private static <E>void prevrti_lista(DLL<E> dll) {
        DLLNode<E> curr = dll.getFirst();
        while(curr != null){
            DLLNode<E> pred = curr.getPred();
            DLLNode<E> succ = curr.getSucc();
            curr.setPred(succ);
            curr.setSucc(pred);
            System.out.print(curr + " ");
            curr = succ;
        }
        System.out.println();
        DLLNode<E> last = dll.getLast();
        DLLNode<E> first = dll.getFirst();
        dll.setFirst(last);
        dll.setLast(first);
    }


    private static void popolni_lista(DLL<Integer> dll) {
        dll.insertLast(5);
        dll.insertLast(1);
        dll.insertLast(4);
        dll.insertLast(2);
        dll.insertLast(123);
        dll.insertLast(123123);
        dll.insertLast(13);
        dll.insertLast(8);
        dll.insertLast(9);
    }
}

class ZadacaBrisiPodlisti{
    public static void main(String[] args) {
        DLL<Integer> lista1, lista2;
        Scanner scanner = new Scanner(System.in);
        lista1 = vnesi_lista(scanner);
        lista2 = vnesi_lista(scanner);
        System.out.println(lista1);
        System.out.println(lista2);
        int n = lista1.getSize();
        int m = lista2.getSize();
        DLLNode<Integer> curr = lista1.getFirst();
        while(curr!=null){
            boolean brisi = e_podlista(lista2.getFirst(), curr);
            if(brisi){
                for (int i = 0; i < m-1; i++)
                    lista1.delete(curr.getSucc());
                lista1.delete(curr);
            }
            curr = curr.getSucc();
        }
        System.out.println(lista1);
        curr = lista1.getFirst();
        while(curr!=null){
            System.out.print(curr + " ");
            curr = curr.getSucc();
        }

    }

    private static boolean e_podlista(DLLNode<Integer> prov, DLLNode<Integer> curr) {
        while(prov!=null) {
            if (curr == null) return false;
            if (!prov.getElement().equals(curr.getElement()))
                return false;
            prov = prov.getSucc();
            curr = curr.getSucc();
        }
        return true;
    }

    private static DLL<Integer> vnesi_lista(Scanner cin) {
        DLL<Integer> rez = new DLL<>();
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            int elem = cin.nextInt();
            rez.insertLast(elem);
        }
        return rez;
    }

}
