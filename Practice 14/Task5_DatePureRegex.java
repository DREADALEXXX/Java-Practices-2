import java.time.LocalDate;
import java.util.regex.Pattern;

public class Task5_DatePureRegex {
    private static final Pattern FORMAT =
            Pattern.compile("^(\\d{2})/(\\d{2})/(\\d{4})$");

    public static boolean isDate(String s) {
        if (s == null) return false;
        var m = FORMAT.matcher(s);
        if (!m.matches()) return false;              // формат не тот

        int day   = Integer.parseInt(m.group(1));
        int month = Integer.parseInt(m.group(2));
        int year  = Integer.parseInt(m.group(3));

        if (year < 1900 || year > 9999) return false;

        try {
            LocalDate.of(year, month, day);          // ← проверка реальности
            return true;
        } catch (java.time.DateTimeException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] tests = {
                "29/02/2000", "30/04/2003", "01/01/2003", "29/02/2004",
                "29/02/2001", "31/04/2003", "30/02/2025",
                "30-04-2003", "1/1/1899", "01/01/1899", "00/01/2003"
        };
        for (String t : tests)
            System.out.printf("%-12s → %s%n", t, isDate(t) ? "✅ дата" : "❌ НЕ дата");
    }
}