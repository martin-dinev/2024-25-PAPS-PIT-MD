package aud7;
import java.util.Hashtable;

public class TestHashtable {
    public static void main(String[] args) {
        Hashtable<Character, Integer> m = new Hashtable<Character, Integer>();
        String s = "АБВГДЃЕЖЗЅИЈКЛЊМНЊОПРСТЌУФХЦЧЏШ";
        for (int i = 0; i < s.length(); i++) {
            m.put(s.charAt(i), i);// se polni hash tabelata
        }

        System.out.println(m);
        // ja zemame vrednosta za bukavata Ш
        System.out.println("Kofichkata vo koja se naoga Ш e " + m.get('Ш'));
    }
}
