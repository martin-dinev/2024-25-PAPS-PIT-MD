package aud1;

public class ArrayTester {

    public static void main(String[] args) {
        Array<Integer> niza = new Array<Integer>(4);

        niza.insertLast(4);
        System.out.print("Nizata po vmetnuvanje na 4 kako posleden element: ");
        System.out.println(niza.toString());

        niza.insertLast(7);
        niza.insertLast(13);
        System.out.print("Nizata po dodavanje na 7 i 13 kako elementi: ");
        System.out.println(niza.toString());

        niza.insert(1, 3);
        System.out.print("Nizata po dodavanje na 3 kako element na pozicija 1: ");
        System.out.println(niza.toString());

        niza.set(2, 6);
        System.out.print("Nizata po menuvanje na vrednosta na elementot na pozicija 2 vo 6: ");
        System.out.println(niza.toString());

        niza.delete(0);
        System.out.print("Nizata po brishenje na elementot na pozicija 0 (prviot element): ");
        System.out.println(niza.toString());

        System.out.print("Na pozicija 2 vo nizata sega se naogja: ");
        System.out.println(niza.get(2));

        System.out.print("Brojot 3 sega se naogja vo nizata na pozicija: ");
        System.out.println(niza.find(3));

        System.out.print("Sega na krajot goleminata na nizata e: ");
        System.out.println(niza.getSize());
    }
}
