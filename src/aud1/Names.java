package aud1;
import java.util.Scanner;

public class Names {
    public static void main(String[] args) {
        SLL<String> names = new SLL<>();

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();

        while(!line.equals("KRAJ")) {
            if(Character.isUpperCase(line.charAt(0))) {
                names.insertFirst(line);
            }
            line = input.nextLine();
        }

        System.out.println("Broj na vneseni validni iminja: " + names.size());

        SLLNode<String> tmp = names.getFirst();

        while(tmp!=null) {
            System.out.println(tmp.element);
            tmp = tmp.succ;
        }
    }
}

