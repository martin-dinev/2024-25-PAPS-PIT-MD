package aud1;

import java.util.Scanner;

public class EvenNumbersSLL {
    public static int evenNumbers(SLL<Integer> list) {
        SLLNode<Integer> tmp = list.getFirst();
        int res = 0;

        while(tmp!=null) {
            if(tmp.element%2==0) {
                res++;
            }
            tmp = tmp.succ;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vnesete go brojot na elementi vo listata:");
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        System.out.println("Vnesete gi elementite na listata (celi broevi):");
        for(int i=0;i<n;i++) {
            list.insertLast(sc.nextInt());
        }

        System.out.println("Brojot na parni elementi vo vnesenata lista e: " + evenNumbers(list));
    }
}


