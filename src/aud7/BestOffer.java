package aud7;

import java.util.Scanner;

public class BestOffer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // Клуч: датумот во стринг формат
        // Хеш функција: дефолтната хеш функција за String класата од Java
        // Вредност: Предавање со максимална заработка
        CBHT<String, Lecture> hashtable = new CBHT<String, Lecture>(2 * N);
        for (int i = 0; i < N; i++) {
            Lecture p = new Lecture(sc.next(), sc.next(), sc.next(), sc.nextInt());
            if (hashtable.search(p.getDate()) == null) {
                hashtable.insert(p.getDate(), p);
            } else {
                SLLNode<MapEntry<String, Lecture>> best_for_date = hashtable.search(p.getDate());
                Lecture best_lecture_for_date = best_for_date.element.value;
                if (p.getFee() > best_lecture_for_date.getFee())
                    hashtable.insert(p.getDate(), p);
            }
        }
        String date = sc.next();
        SLLNode<MapEntry<String, Lecture>> result = hashtable.search(date);
        if (result != null) {
            Lecture best = result.element.value;
            System.out.println(best.getTime() + " " + best.getPlace() + " " + best.getFee());
        } else {
            System.out.println("No offers");
        }
    }
}
