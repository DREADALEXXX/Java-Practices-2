import java.util.regex.Pattern;

public class Task2_ExactString {
    private static final Pattern PATTERN =
            Pattern.compile("^abcdefghijklmnopqrstuv18340$");

    public static boolean isTarget(String s) {
        return PATTERN.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {
                "abcdefghijklmnopqrstuv18340",       // ✅
                "abcdefghijklmnoasdfasdpqrstuv18340", // ❌
                "abcdefghijklmnopqrstuv1834",        // ❌ (нет 0)
                "xabcdefghijklmnopqrstuv18340",      // ❌ (лишний x в начале)
                "ABCDEFGHIJKLMNOPQRSTUV18340"        // ❌ (регистр)
        };

        for (String t : tests) {
            System.out.printf("%-40s → %s%n", t, isTarget(t) ? "ПОДХОДИТ" : "НЕ подходит");
        }
    }
}