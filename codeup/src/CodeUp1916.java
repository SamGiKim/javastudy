import java.util.HashMap;
import java.util.Scanner;

public class CodeUp1916 {
    public static long fibo(HashMap<Integer, Long> hm, int n) {
        if (hm.containsKey(n))
            return hm.get(n);
        if (n <= 1) {
            return n;
        } else {
            long result = (fibo(hm, n-2) % 10009) + (fibo(hm, n-1) % 10009);
            hm.put(n, result);
            return result % 10009;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
        System.out.println(fibo(hm, sc.nextInt()));
    }
}
