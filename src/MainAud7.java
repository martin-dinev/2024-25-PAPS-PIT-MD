import aud7.CBHT;
import aud7.MapEntry;
import aud7.OBHT;
import aud7.SLLNode;

import java.util.Scanner;

class MainAud7 {
    static class ChemichalElement {
        String chemiclaCode;

        public ChemichalElement(String chemiclaCode) {
            this.chemiclaCode = chemiclaCode;
        }

        @Override
        public int hashCode() {
            return this.chemiclaCode.charAt(0) - 'A';
        }
    }

    public static void main(String[] args) {
        ChemichalElement a = new ChemichalElement("Marko");
        ChemichalElement b = new ChemichalElement("Marko");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }
}

class ChemicalElement {
    // A ChemicalElement object represents a chemical element.
// Each element contains the two characters of the chemical symbol.
// The first character must be an uppercase letter. Where present,
// the second character must be a lowercase letter. If absent, the
// second character is a space.
    private char sym1, sym2; // The two letters of the chemical symbol.

    public ChemicalElement(String symbol) {
        sym1 = Character.toUpperCase(symbol.charAt(0));
        if (symbol.length() >= 2) sym2 = Character.toLowerCase(symbol.charAt(1));
        else sym2 = ' ';
    }

    public int hashCode() {
        return sym1 - 'A';
    } // избраната хеш функција

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof ChemicalElement other)) return false;
        else return this.sym1 == other.sym1 && this.sym2 == other.sym2;
    }

    @Override
    public String toString() {
        return "CE{" + sym1 + sym2 +
                '}';
    }
}


class CBHTTest {
    public static void main(String[] args) {
        CBHT<ChemicalElement, Integer> table1 = new CBHT<ChemicalElement, Integer>(26);
        table1.insert(new ChemicalElement("H"), 1);
        ChemicalElement he1 = new ChemicalElement("He");
        ChemicalElement he2 = new ChemicalElement("He");
        System.out.println(he1 .equals( he2  ));
        table1.insert(he1, 2);
        table1.insert(he2, 234);
        table1.insert(new ChemicalElement("Li"), 3);
        table1.insert(new ChemicalElement("Be"), 4);
        table1.insert(new ChemicalElement("Na"), 11);
        table1.insert(new ChemicalElement("Mg"), 12);
        table1.insert(new ChemicalElement("K"), 19);
        table1.insert(new ChemicalElement("Ca"), 20);
        table1.insert(new ChemicalElement("Rb"), 37);
        table1.insert(new ChemicalElement("Sr"), 38);
        table1.insert(new ChemicalElement("Cs"), 55);
        table1.insert(new ChemicalElement("Ba"), 56);
        System.out.println("Table from presentation slide 6");
        System.out.println(table1);
    }
}

class Rodendeni{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int rezult = 0;
//        for (int i = 0; i < n; i++) {
//            int broj  = sc.nextInt();
//            if(broj == 3) rezult ++;
//        }



        CBHT<String, Integer> tabela = new CBHT<>(23);

        for (int i = 0; i < n; i++) {
            String mesec = sc.next().split("\\.")[1];
            SLLNode<MapEntry<String, Integer>> node = tabela.search(mesec);
            int nova_vrednost;
            if(node == null){
                nova_vrednost = 1;
            }else{
                Integer value = node.element.value;
                nova_vrednost = value + 1;
            }
            tabela.insert(mesec, nova_vrednost);
        }
        String mesec = sc.next();
        SLLNode<MapEntry<String, Integer>> result = tabela.search(mesec);
        if(result == null){
            System.out.println("Rezultatot e nula");
        }else{
            System.out.println("Rez e " + result.element.value);
        }
    }
}

class Ponudi{
    static class Ponuda{
        String datum, vreme, mesto;
        int vrednost;

        public Ponuda(String datum, String vreme, String mesto, int vrednost) {
            this.datum = datum;
            this.vreme = vreme;
            this.mesto = mesto;
            this.vrednost = vrednost;
        }

        @Override
        public String toString() {
            return "Ponuda{" +
                    "datum='" + datum + '\'' +
                    ", vreme='" + vreme + '\'' +
                    ", mesto='" + mesto + '\'' +
                    ", vrednost=" + vrednost +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, Ponuda> tabela = new CBHT<>(2*n);
        for (int i = 0; i < n; i++) {
            Ponuda ponuda = new Ponuda(sc.next(), sc.next(), sc.next(), sc.nextInt());
            SLLNode<MapEntry<String, Ponuda>> prev = tabela.search(ponuda.datum);
            if(prev == null){
                tabela.insert(ponuda.datum, ponuda);
            }else{
                int prev_vrednost = prev.element.value.vrednost;
                if(ponuda.vrednost > prev_vrednost){
                    tabela.insert(ponuda.datum, ponuda);
                }
            }
            System.out.println(tabela);
            System.out.flush();
        }
        String datum = sc.next();
        SLLNode<MapEntry<String, Ponuda>> result = tabela.search(datum);
        if(result == null){
            System.out.println("Rezultatot e nula");
        }else{
            Ponuda p = result.element.value;
            System.out.println("Rez e " + p.vreme + " " + p.mesto + " " + p.vrednost);
        }
    }
}

class RedCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OBHT<String, Integer> hashtable = new OBHT<String, Integer>(11);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            String key = sc.next().replaceAll("[1-2]", "");
            int bucket = hashtable.search(key);
            if (bucket == -1) hashtable.insert(key, 1);
            else hashtable.insert(key, hashtable.getBucket(bucket).value + 1);
        }
        System.out.println(hashtable);
    }
}
