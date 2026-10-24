public class PhoneFormatter {

    public static String format(String raw) {
        // 1. Оставляем только цифры и ведущий +
        String digits = raw.replaceAll("[^0-9]", "");

        // 2. Российская запись 8XXXXXXXXXX → +7XXXXXXXXXX
        if (digits.length() == 11 && digits.startsWith("8")) {
            digits = "7" + digits.substring(1);
        }

        // 3. Отделяем код страны от 10-значного номера
        if (digits.length() < 11) {
            throw new IllegalArgumentException("Слишком короткий номер: " + raw);
        }

        String countryCode = digits.substring(0, digits.length() - 10); // 1–3 цифры
        String number      = digits.substring(digits.length() - 10);    // ровно 10

        // 4. Разбиваем номер 3-3-4
        String part1 = number.substring(0, 3);
        String part2 = number.substring(3, 6);
        String part3 = number.substring(6, 10);

        return "+" + countryCode + part1 + "-" + part2 + "-" + part3;
    }

    public static void main(String[] args) {
        String[] tests = {
                "+79175655655",   // РФ, +7
                "89175655655",    // РФ, 8 → +7
                "+104289652211",  // США, +1 (11 цифр после +? проверим)
                "+442071838750",  // UK, +44
                "8 (917) 565-56-55" // с форматированием во входе
        };

        for (String t : tests) {
            try {
                System.out.printf("%-20s → %s%n", t, format(t));
            } catch (IllegalArgumentException e) {
                System.out.printf("%-20s → ОШИБКА: %s%n", t, e.getMessage());
            }
        }
    }
}