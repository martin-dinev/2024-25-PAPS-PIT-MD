package aud7;
import java.util.Scanner;

public class Birthdays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // Клуч: месецот во стринг формат
        // Хеш функција: дефолтната хеш функција за String класата од Java
        // Вредност: број на појавувања на клучот месец
        CBHT<String, Integer> birthdays = new CBHT<>(23);
        for (int i = 0; i < N; i++) {
            String p[] = sc.nextLine().split("\\.");
            // доколку елементот со клуч p[1] не постои во хеш табелата
            if (birthdays.search(p[1]) == null) birthdays.insert(p[1], 1);
            else {
                // доколку елементот со клуч p[1] постои во хеш табелата
                SLLNode<MapEntry<String, Integer>> br = birthdays.search(p[1]);
                birthdays.insert(p[1], br.element.value + 1);
            }
        }
        String month = sc.nextLine();
        SLLNode<MapEntry<String, Integer>> result = birthdays.search(month);

        //доколку не постои елемент со клуч mesec
        if (result == null) System.out.println("Empty");
        else System.out.println(result.element.value);
    }
}


