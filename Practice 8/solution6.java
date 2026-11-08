public class solution6 {
    public static void allnumbers(int n) {

        if (n < 1) return;

        System.out.println(n%10);

        allnumbers(n/10);



    }

    public static void main(String[] args) {
        allnumbers(400); // вызов рекурсивно функции
    }
}