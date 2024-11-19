import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MainAud5_5Vezbi {
    public static void main(String[] args) {

    }
}

class Aud55Zadaca1 {
    public static void main(String[] args) {
//        7 2
//8 7 3 5 1 3 1
        Scanner sc = new Scanner(System.in);
        int br_zadaci = sc.nextInt();
        int br_vrab = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < br_zadaci; i++) {
            int zadaca = sc.nextInt();
            list.add(zadaca);
        }
        int[] brojaci = new int[9];
//                {1,2,4,6,7,2,1,2}
        brojaci[1] = 2;
        brojaci[2] = 3;
        for (int i = 0; i < list.size(); i++) {
            Integer zadaca = list.get(i);
            brojaci[zadaca]++;
        }

//        for(int vreme = 1 ; vreme <= 8 ; vreme ++){
//            for(int i = 0 ; i < list.size() ; i ++){
//                Integer zadaca = list.get(i);
//                if(vreme == zadaca)
//                    brojaci[vreme] ++;
//            }
//        }
        int vkupno_br_rab_denovi = brojaci[8];
        int slobodno_vreme = 0;
        for (int i = 7; i >= 5; i--) {
            vkupno_br_rab_denovi += brojaci[i];
            if (brojaci[i] >= brojaci[8 - i]) {
                slobodno_vreme += (8 - i) * (brojaci[i] - brojaci[8 - i]);
                brojaci[8 - i] = 0;
            } else {
                brojaci[8 - i] -= brojaci[i];
            }
        }
        vkupno_br_rab_denovi += brojaci[4] / 2;
        brojaci[4] %= 2;
        int potrebno_vreme = 0;
        for (int i = 4; i >= 1; i--) {
            potrebno_vreme += brojaci[i] * i;
        }
        if (slobodno_vreme < potrebno_vreme) {
            int ushte_rabota = potrebno_vreme - slobodno_vreme;
            slobodno_vreme = 0;
            int ushte_denovi = (int) Math.ceil(ushte_rabota / 8.0);
            vkupno_br_rab_denovi += ushte_denovi;
            slobodno_vreme = ushte_denovi * 8 - ushte_rabota;
        } else {
            slobodno_vreme -= potrebno_vreme;
        }

        System.out.println(vkupno_br_rab_denovi + " " + slobodno_vreme);
    }
}

class Aud55Zadaca2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int br_zadaci = sc.nextInt();
        int br_vrab = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < br_zadaci; i++) {
            int zadaca = sc.nextInt();
            list.add(zadaca);
        }
        list.sort(Comparator.reverseOrder());

        int vkupno_denovi = 0;
        int slobodno_vreme = 0;
        while (!list.isEmpty()) {
            int den = 8;
            for (int j = 0; j < list.size(); j++) {
                if (den >= list.get(j)) {
                    den -= list.get(j);
                    list.remove(j);
                    j--;
                }
            }
            vkupno_denovi++;
            slobodno_vreme += den;
        }
        int vk_rab_den = (int) Math.ceil((double) vkupno_denovi / br_vrab);
        slobodno_vreme = vk_rab_den * br_vrab * 8 - (vkupno_denovi * 8 - slobodno_vreme);
        System.out.println(vk_rab_den + " " + slobodno_vreme);
    }
}

class Aud55Zadaca3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(sc.nextInt());
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }
        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        List<Integer> original_index = new ArrayList<>();

        lst1.add(lst.get(0));
        for (int i = 1; i < n; i++) {
            Integer number = lst.get(i);
            Integer last = lst1.get(lst1.size() - 1);
            if (number > last) {
                lst1.add(number);
            } else {
                lst2.add(number);
                original_index.add(i);
            }
        }
        System.out.println(lst2.size());
        for (int i = 0, i1 = 0; i < lst2.size(); i++) {
            Integer number = lst2.get(i);
            while (i1 < lst1.size() && lst1.get(i1) < number) {
                i1++;
            }

            Integer oi = original_index.get(i);
            int ni = i1 + i;
            System.out.println(number + " " + (oi - ni));
        }


    }
}

class Aud55Zadaca4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(sc.nextInt());
        }
        List<Boolean> has_light = new ArrayList<>();

        for (int i = 0; i <= m; i++) {
            has_light.add(false);
        }
        for (int i = 0; i < n; i++) {
            int light_position = lst.get(i);
            has_light.set(light_position, true);
        }
        int first_unlit = 1, number_lights = 0;
        while (first_unlit <= m) {
            Integer last_valid_pos = null;
            for (int vp = first_unlit - 2; vp <= first_unlit + 2; vp++) {
                if (1 <= vp && vp <= m) {
                    if (has_light.get(vp)) {
                        last_valid_pos = vp;
                    }
                }
            }
            first_unlit = last_valid_pos + 3;
            number_lights++;
        }
        System.out.println(number_lights);
    }
}

class Aud55Zadaca5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min_n_cifren = 1;
        for (int i = 0; i < n - 1; i++) {
            min_n_cifren *= 10;
        }
        for (int broj = min_n_cifren; broj < min_n_cifren * 10; broj++) {
            int zbir = zbir_cifri(broj);
            if (zbir == m) {
                System.out.println(broj);
                return;
            }
        }
        System.out.println("Ne postoi");
    }

    private static int zbir_cifri(int broj) {
        int rez = 0;
        while (broj > 0) {
            rez += broj % 10;
            broj /= 10;
        }
        return rez;
    }
}

class Aud55Zadaca6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (m > n * 9 || m < 1) {
            System.out.println("Ne postoi");
            return;
        }
        int[] cifri = new int[n];
        for (int i = 0; i < n; i++) {
            cifri[i] = 0;
        }
        cifri[0] = 1;
        m--;
        int ind = n - 1;
        while (m > 0) {
            int broj = cifri[ind];
            int dodavam = 9 - broj;
            if (dodavam > m) {
                cifri[ind] += m;
                m = 0;
            } else {
                cifri[ind] = 9;
                m -= dodavam;
            }
            ind--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(cifri[i]);
        }
        System.out.println();
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int must_not_pop = -1;
        int rez = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.peek() == must_not_pop) {
                    stack.pop();
                    stack.push(i);
                    must_not_pop = i;
                } else {
                    stack.pop();
                    rez = Math.max(rez, i - stack.peek());
                }
            }
        }
        return rez;
    }
}


class ExpressionEvaluator {

    public static List<String> separated(String s,Character ch){
        List<String> separated = new ArrayList<>();
        separated.add(s);
        while(separated.get(separated.size()-1).indexOf(ch)!=-1){
            String last = separated.get(separated.size() - 1);
            int plus_pos = last.indexOf(ch);
            String without = last.substring(0, plus_pos);
            String remaining = last.substring(plus_pos + 1);
            separated.remove(separated.size()-1);
            separated.add(without);
            separated.add(remaining);
        }
        return separated;
    }

    public static int evaluateExpression(String expression) {
        List<String> separated = separated(expression, '+');
        int sum = 0;
        System.out.println(separated);
        for (String exp: separated){
            List<String> numbers = separated(exp, '*');
            System.out.println(exp + " -> " + numbers);
            int proizv = 1;
            for(String number: numbers){
                proizv *= Integer.parseInt(number);
            }
            sum += proizv;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}


class ExpressionEvaluator2 {


    public static int evaluateExpression(String exp) {
        int rez =0;
        int prev_number = 0;
        Character prev_operation = '+';
        Character ch;
        for (int i = 0,j; i < exp.length(); i=j+1) {
            for( j = i ; j < exp.length() ; j++ ){
                if(!Character.isDigit(exp.charAt(j)))break;
            }
            int broj = Integer.parseInt(exp.substring(i, j));
            if(prev_operation == '*' || prev_operation == '/'){
                if(prev_operation == '*')
                    prev_number *= broj;
                else
                    prev_number /= broj;
            }else{
                if(prev_operation == '-')
                    prev_number = -broj;
                else
                    prev_number = broj;
            }
            if(j==exp.length() || exp.charAt(j) == '+' || exp.charAt(j) == '-')
                rez += prev_number;

            if(j<exp.length())
                prev_operation = exp.charAt(j);
        }

        return rez;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}