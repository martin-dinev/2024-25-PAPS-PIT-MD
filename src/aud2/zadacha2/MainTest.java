package aud2.zadacha2;
public class MainTest {

    public static void main(String[] args) {

        DLL<Integer> lista = new DLL<Integer>();

        lista.insertLast(4);
        lista.insertLast(9);
        lista.insertLast(4);
        lista.insertLast(4);
        lista.insertLast(5);
        lista.insertLast(8);
        lista.insertLast(9);

        System.out.println("Listata pred otstranuvanje i prebrojuvanje na duplite elementi:");
        System.out.println(lista.toString());

        lista.izvadiDupliIPrebroj();

        System.out.println("Listata po otstranuvanje i prebrojuvanje na duplite elementi:");
        System.out.println(lista.toString());
    }
}
