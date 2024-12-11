
import aud1.SLL;
import aud1.SLLNode;

import java.util.*;

class Student implements Comparable<Student>{
    int index;
    int vreme;

    public Student(int index, int vreme) {
        this.index = index;
        this.vreme = vreme;
    }

    @Override
    public String toString() {
        return "{" + index + " " +vreme +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        return Integer.compare(vreme, o.vreme);
    }
}

public class MainAud5{

    public static void main(String[] args) {
        Queue<Student> queue = new LinkedList<>();
        queue.offer(new Student(196215, 50));
        queue.offer(new Student(195615, 20));
        queue.offer(new Student(196135, 15));
        queue.offer(new Student(196215, 30));
        queue.offer(new Student(195615, 35));
        queue.offer(new Student(196135, 10));
        queue.offer(new Student(112415, 30));
        queue.offer(new Student(234535, 25));
        System.out.println(queue);

        opsluzhi_studenti(queue, 180);
        System.out.println(queue);

        if (!queue.isEmpty())
            System.out.println(queue.peek().index);
        else
            System.out.println("Nema neopsluzhen student");

        System.out.println("Chekaat ushte " + queue.size());


        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Student(196215, 50));
        priorityQueue.offer(new Student(1912355, 20));
        priorityQueue.offer(new Student(196135, 15));
        priorityQueue.offer(new Student(196215, 30));
        priorityQueue.offer(new Student(195615, 35));
        priorityQueue.offer(new Student(193575, 10));
        priorityQueue.offer(new Student(1112315, 30));
        priorityQueue.offer(new Student(2665535, 25));
        priorityQueue.peek();

        System.out.println(priorityQueue);

        opsluzhi_studenti(priorityQueue, 180);
        System.out.println(priorityQueue);

        if (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.peek().index);
        else
            System.out.println("Nema neopsluzhen student");

        System.out.println("Chekaat ushte " + priorityQueue.size());

    }

    private static void opsluzhi_studenti(Queue<Student> queue, int minuti) {
        while( !queue.isEmpty() ){
            int sledno_vreme = queue.peek().vreme;
            if(sledno_vreme <= minuti){
                Student curr = queue.poll();
                System.out.print(curr.index + " ");
                minuti -= curr.vreme;
            }else{
                break;
            }
        }
        System.out.println();
    }
}

 class Aud5Zadaca1 {
    public static void main(String[] args) {
        String s = "(– b + sqrt[b^2 – 4ac]) / 2a";
        if(regularBracket(s)){
            System.out.println("Da");
        }else{
            System.out.println("Ne");
        }
    }

    static boolean regularBracket(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if(stack.isEmpty()){
                    return false;
                }
                Character top = stack.peek();
                if (matching(top, ch)) {
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean matching(Character open, Character close) {
        if ((open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}'))
            return true;
        else
            return false;
    }
}

class ListaZadaca{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        SLL<Integer> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            int nxt = sc.nextInt();
            sll.insertLast(nxt);
        }
        System.out.println(sll);
        SLLNode<Integer> curr = sll.getFirst();
        while(curr.getSucc()!=null){
            SLLNode<Integer> next = curr.getSucc();
//            System.out.println(curr.getElement() + " " + next.getElement());
            if(curr.getElement() > 0 && next.getElement() > 0){
                sll.delete(next);
            }else if(curr.getElement() < 0 && next.getElement() < 0){
                sll.insertAfter(-curr.getElement(), curr);
                curr = next;
            }else if(curr.getElement().equals(0)){
                sll.delete(curr);
                curr = curr.getSucc();
            }
            else
                curr = curr.getSucc();
        }

//        17
//        0 4 -3 -8 -6 0 7 8 15 7 0 0 0 -2 5 0 0
        if(curr.getElement().equals(0)){
            sll.delete(curr);
        }
        System.out.println(sll);

    }
}

class DrugaZadaca{
    public static void main(String[] args) {
        String str = "/abc///cde/xyz/.1/asdf//a1.b2/newdir/.2/a/";
        List<String> lst = new ArrayList<>();
        for (int i = 0 ; i < str.length() ; i ++){
            if(str.charAt(i) == '/'){
                lst.add("");
            }else{
                String last = lst.getLast();
                lst.removeLast();
                last += str.charAt(i);
                lst.addLast(last);
            }
        }
        System.out.println(lst);
        String primer = ".23";
        String broj = primer.substring(1);
        Integer.parseInt("23");
    }
}