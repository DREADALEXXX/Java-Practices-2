import java.util.regex.Pattern;

public class Task7_PasswordRegex {
    private static final Pattern PASSWORD = Pattern.compile(
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z0-9_]{8,}$"
    );

    public static boolean isStrong(String p) {
        return p != null && PASSWORD.matcher(p).matches();
    }

    public static void main(String[] args) {
        String[] tests = {
                "F032_Password",  // ✅
                "TrySpy1",        // ✅
                "smart_pass",     // ❌ нет заглавной и цифры
                "A007",           // ❌ короче 8
                "A007_abcd",      // ✅
                "abcdefgh1",      // ❌ нет заглавной
                "ABCDEFG1",       // ❌ нет строчной
                "Abcdefgh",       // ❌ нет цифры
                "Abcdef 1",       // ❌ пробел — недопустимый символ
                "Abcdef1!"        // ❌ `!` — недопустимый символ
        };
        for (String t : tests)
            System.out.printf("%-15s → %s%n", t, isStrong(t) ? "✅ надёжный" : "❌ слабый");
    }
}