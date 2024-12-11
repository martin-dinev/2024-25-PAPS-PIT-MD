package aud7;
import java.util.Scanner;

public class RedCross {
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