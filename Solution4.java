public class Solution4 {
    public static int sumnumbers(int n) {
        if (n<10)
        {

            return n;
        }

        return sumnumbers((n/10))+ n%10;

    }
    public static void main(String[] args) {
        System.out.println(sumnumbers(123));
    }}

