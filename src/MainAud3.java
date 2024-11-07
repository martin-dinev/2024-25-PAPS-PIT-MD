
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distanceTo(Point other) {
        int x_d = Math.abs(this.x - other.x);
        int y_d = Math.abs(this.y - other.y);
        return Math.sqrt(x_d * x_d + y_d * y_d);
    }
}

class Objekt {
    Float tezina;
    Float vrednost;

    public Objekt(float tezina, float vrednost) {
        this.tezina = tezina;
        this.vrednost = vrednost;
    }

    @Override
    public String toString() {
        return "{" + tezina +
                ", " + vrednost +
                '}';
    }
}
//class Lab2Zadaca_ready {
//
//    public static void leftRotate(DLL<Integer> list, int M, int k) {
//        int rot = k % list.getSize();
//        DLLNode<Integer> found = list.find(M);
//
//        if (found != null && rot > 0) {
//            int nodeIndex = list.getIndex(found);
//            if (rot > nodeIndex) {
//                rot = list.getSize() - rot;
//                DLLNode<Integer> tmp = found;
//                for (int i = 0; i < rot; i++)
//                    tmp = tmp.getSucc();
//                list.insertAfter(M, tmp);
//                list.delete(found);
//            } else {
//                DLLNode<Integer> tmp = found;
//                for (int i = 0; i < rot; i++)
//                    tmp = tmp.getPred();
//                list.insertBefore(M, tmp);
//                list.delete(found);
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int numElements;
//        numElements = scan.nextInt();
//
//        DLL<Integer> list = new DLL<Integer>();
//        for (int i = 0; i < numElements; i++) {
//            list.insertLast(scan.nextInt());
//        }
//        int M = scan.nextInt();
//        int k = scan.nextInt();
//
//        System.out.println(list);
//        leftRotate(list, M, k);
//        System.out.println(list);
//    }
//}

public class MainAud3 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Aud3Zadaca1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = cin.nextInt();
            int y = cin.nextInt();
            Point point = new Point(x, y);
            points[i] = point;
        }
        Double min_dist = null;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double curr_dist = points[i].distanceTo(points[j]);
                if (min_dist == null)
                    min_dist = curr_dist;
                else if (curr_dist < min_dist) {
                    min_dist = curr_dist;
                }
            }
        }
        System.out.println("Minimalnoto rastojanie e: " + min_dist);
    }
}

/*
5
5 5
4 6
7 12
8 3
1 1
 */
class Aud3Zadaca2 {
    public static void main(String[] args) {
        int rez = 0;
        int n = 8;
        for (int red1 = 0; red1 < n; red1++) {
            for (int kol1 = 0; kol1 < n; kol1++) {
                for (int red2 = 0; red2 < n; red2++) {
                    for (int kol2 = 0; kol2 < n; kol2++) {
                        if (!se_napagjaat(red1, kol1, red2, kol2)) {
                            rez++;
                        }
                    }
                }
            }
        }
        System.out.println("Broj validni parovi e: " + rez);
    }

    private static boolean se_napagjaat(int red1, int kol1, int red2, int kol2) {
        if (red1 == red2) return true;
        if (kol1 == kol2) return true;
        int hor = Math.abs(kol1 - kol2);
        int ver = Math.abs(red1 - red2);
        if (hor == ver) return true;
        return false;
    }
}

class Aud3Zadaca3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(cin.nextInt());
        }
        coins.sort(Comparator.reverseOrder());
        System.out.println(coins);
        int x = cin.nextInt(), rez = 0;
        for (int i = 0, remaining = x; i < n; i++) {
            int curr = coins.get(i);
            int fits = remaining / curr;
            remaining -= fits * curr;
            rez += fits;
            System.out.println("Parichkata " + curr + " se iskoristuva " + fits + " pati");
        }
        System.out.println("Minimalniot broj na parichki za " + x + " e " + rez);
    }

}

/*
6
5 10 1000 2 1 50
4623
* */
class Zadaca4 {
    String st = """
            # Објект Вредност Тежина
             1 Облека 200 10
             2 Книги 150 20
             3 Монопол, карти… 5 0.5
             4 CD player, MP3 player… 80 5
            """;

    /*
    4
    200 10
    150 20
    5 0.5
    80 5
    20

    4
    100 70
    20 10
    50 25
    120 30
    50

    4
    100 70
    20 10
    50 25
    120 30
    80

    * */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        ArrayList<Objekt> objekti = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            float vrednost = cin.nextFloat();
            float tezina = cin.nextFloat();
            objekti.add(new Objekt(tezina, vrednost));
        }
        int golemina_na_ranec = cin.nextInt();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                Objekt o1 = objekti.get(i);
//                Objekt o2 = objekti.get(j);
//                if (o1.vrednost < o2.vrednost) {
//                    objekti.set(i, o2);
//                    objekti.set(j, o1);
//                }
//            }
//        }
        objekti.sort(Comparator.comparingDouble(objekt -> objekt.vrednost));
        System.out.println(objekti);
        int rez = 0;
        for (int i = 0, remaining = golemina_na_ranec; i < n; i++) {
            Objekt curr = objekti.get(i);
            if (curr.tezina <= remaining) {
                remaining -= curr.tezina;
                rez += curr.vrednost;
            }
        }
        System.out.println("Maksimalnata vrednost na predmetite e: " + rez);

        objekti.sort(Comparator.comparingDouble(objekt -> objekt.vrednost / objekt.tezina));
        objekti.reversed();
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                Objekt o1 = objekti.get(i);
//                Objekt o2 = objekti.get(j);
//                if (o1.vrednost / o1.tezina < o2.vrednost / o2.tezina) {
//                    objekti.set(i, o2);
//                    objekti.set(j, o1);
//                }
//            }
//        }

        System.out.println(objekti);
        rez = 0;
        for (int i = 0, remaining = golemina_na_ranec; i < n; i++) {
            Objekt curr = objekti.get(i);
            if (curr.tezina <= remaining) {
                remaining -= curr.tezina;
                rez += curr.vrednost;
            }
        }
        System.out.println("Maksimalnata vrednost na predmetite e: " + rez);
    }
}


//class Lab2Zadaca2{
//    public static void main(String[] args) {
//
//    }
//
//    private static void rotate(DLL<Integer> list, int m, int k) {
//    }
//}

