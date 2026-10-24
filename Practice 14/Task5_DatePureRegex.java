import java.util.regex.Pattern;

public class Task5_DatePureRegex {
    private static final Pattern DATE =
            Pattern.compile(
                    "^(0[1-9]|[12][0-9]|3[01])/" +       // день 01–31
                            "(0[1-9]|1[0-2])/" +                  // месяц 01–12
                            "((19|2[0-9])\\d{2}|[3-9]\\d{3})$"    // год 1900–9999
            );

    public static boolean isDate(String s) {
        return DATE.matcher(s).matches();
    }

    public static void main(String[] args) {
        String[] tests = {
                "29/02/2000",   // ✅ високосный
                "30/04/2003",   // ✅
                "01/01/2003",   // ✅
                "29/02/2001",   // ❌ не високосный — но regex пропустит!
                "31/04/2003",   // ❌ 31 апреля нет — но regex пропустит!
                "30-04-2003",   // ❌ дефисы
                "1/1/1899",     // ❌ год < 1900 и без нулей
                "00/01/2003"    // ❌ день 0
        };
        for (String t : tests)
            System.out.printf("%-12s → %s%n", t, isDate(t) ? "формат ОК" : "НЕ дата");
    }
}