import java.util.Scanner;

public class Solution5 {
    public static void printOdds() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) {
            return;                 // база: конец последовательности
        }

        if (n % 2 != 0) {
            System.out.println(n);  // печатаем нечётное
        }

        printOdds();                // рекурсивный шаг
    }

    public static void main(String[] args) {
        printOdds();
    }
}