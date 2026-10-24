public class Solution3 {
    public static void allnumbers(int n) {

        if (n < 1) return;

        allnumbers(n - 1);

        System.out.println(n);



    }

    public static void main(String[] args) {
        allnumbers(5); // вызов рекурсивно функции
    }
}