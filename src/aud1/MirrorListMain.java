package aud1;
public class MirrorListMain {

    public static void main(String[] args) {
        SLL<String> lista = new SLL<String>();
        lista.insertLast("ovaa");
        lista.insertLast("lista");
        lista.insertLast("kje");
        lista.insertLast("bide");
        lista.insertLast("prevrtena");
        System.out.println("Listata pred da bide prevrtena: " + lista.toString());
        lista.mirror();
        System.out.println("Listata otkako e prevrtena: " + lista.toString());
    }
}

