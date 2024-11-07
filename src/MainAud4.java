import aud2.DLL;
import aud2.DLLNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainAud4 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Lab2Zadaca {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numElements;
        numElements = scan.nextInt();

        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < numElements; i++) {
            list.insertLast(scan.nextInt());
        }
        int M = scan.nextInt();
        int k = scan.nextInt();

        System.out.println(list);
        doRotateLeft(list, M, k);
        System.out.println(list);
    }

    private static void doRotateLeft(DLL<Integer> list, int m, int k) {
        DLLNode<Integer> curr = list.getFirst();
        int index = 0;
        while (curr != null) {
            if (curr.getElement().equals(m)) {
                break;
            }
            curr = curr.getSucc();
            index++;
        }
        if (curr == null) {
            System.out.println("Elementot ne postoi vo listata");
            return;
        }
        int br_slobodni_mesta_levo = index;
        if (br_slobodni_mesta_levo >= k) {
            DLLNode<Integer> moveBefore = curr;
            for (int i = 0; i < k; i++)
                moveBefore = moveBefore.getPred();
            list.insertBefore(curr.getElement(), moveBefore);
        } else {
            k = list.getSize() - k;
            DLLNode<Integer> moveAfter = curr;
            for (int i = 0; i < k; i++)
                moveAfter = moveAfter.getSucc();

            list.insertAfter(curr.getElement(), moveAfter);
        }
        list.delete(curr);
    }

}

class CookiesAndWishes {
    //    7 6
//    5 9 4 3 1 6 8
//    9 8 3 4 3 2
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int[] wishes = new int[n];
        for (int i = 0; i < n; i++) {
            wishes[i] = cin.nextInt();
        }
        int[] cookies = new int[m];
        for (int i = 0; i < m; i++) {
            cookies[i] = cin.nextInt();
        }
        Arrays.sort(wishes);
        Arrays.sort(cookies);

        int available = 0, rez = 0, i = 0;
        for (int cookie: cookies){
            while(i < n && cookie > wishes[i]){
                i++;
                available++;
            }
            if(available>0){
                rez++;
                available--;
            }
        }
        System.out.println(rez);
    }
}

class ClosingIntervals {
    static class ClosedInterval{
        int left;
        int right;

        public ClosedInterval(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "{" + left + " " + right + "}\n";
        }
    }
    static class Kraj implements Comparable<Kraj> {
        char oc;
        int x;

        public Kraj(char oc, int x) {
            this.oc = oc;
            this.x = x;
        }

        @Override
        public int compareTo(Kraj o) {
            if(this.x<o.x)return -1;
            if(this.x>o.x)return 1;
            if(this.oc == o.oc) return 0;
            if(this.oc == 'o') return -1;
            return 1;
        }
    }
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int n = cin.nextInt();
//        ClosedInterval[] intervals = new ClosedInterval[n];
//        for (int i = 0; i < n; i++) {
//            intervals[i] = new ClosedInterval(cin.nextInt(), cin.nextInt());
////            intervals[i].right // use max of these for niza size
//        }
//
//        int[] niza = new int[15];
//        for (int i = 0; i < n; i++) {
//            for (int j = intervals[i].left; j <= intervals[i].right ; j++) {
//                niza[j] = 1;
//            }
//        }
//        for (int e : niza)
//            System.out.print(e + " ");
//        System.out.println();
//        for (int i = 0; i < 15; i++) {
//            if(niza[i] == 1){
//                int j = i;
//                while(j < 15 && niza[j] == 1) j++;
//                System.out.println("Interval od " + i + " do " + (j-1));
//                i=j;
//            }
//        }
//        /*
//        5
//        1 3
//        2 6
//        4 5
//        8 12
//        10 14
//         */
//
//
//
//
//    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        ClosedInterval[] intervals = new ClosedInterval[n];
        Kraj[] kraevi = new Kraj[2*n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new ClosedInterval(cin.nextInt(), cin.nextInt());
            kraevi[i] = new Kraj('o', intervals[i].left);
            kraevi[i+n] = new Kraj('c', intervals[i].right);
        }
        Arrays.sort(kraevi);
        for (Kraj kraj : kraevi)
            System.out.println(kraj.oc +  " " + kraj.x);
        System.out.println();

        int prev = 0;
        List<ClosedInterval> list = new ArrayList<>();
        for(Kraj kraj:kraevi){
            int next = prev + (kraj.oc == 'o'?+1:-1);
            if(prev == 0 && next > 0){
                list.add(new ClosedInterval(kraj.x, -1));
            }
            if(prev > 0 && next == 0){
                list.getLast().right = kraj.x;
            }
            prev = next;
        }

        System.out.println(list.size());
        System.out.println(list);

//        int[] niza = new int[15];
//        for (int i = 0; i < n; i++) {
//            for (int j = intervals[i].left; j <= intervals[i].right ; j++) {
//                niza[j] = 1;
//            }
//        }
//        for (int e : niza)
//            System.out.print(e + " ");
//        System.out.println();
//        for (int i = 0; i < 15; i++) {
//            if(niza[i] == 1){
//                int j = i;
//                while(j < 15 && niza[j] == 1) j++;
//                System.out.println("Interval od " + i + " do " + (j-1));
//                i=j;
//            }
//        }
        /*
        5
        1 3
        2 6
        4 5
        8 12
        10 14
         */




    }

}

class SortingButBetter {
//

}

class PowerButBetter {
//

}