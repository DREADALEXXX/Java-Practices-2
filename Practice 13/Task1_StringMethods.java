public class Task1_StringMethods {
    public static void main(String[] args) {
        String s = "I like Java!!!";
        demo(s);
    }

    static void demo(String s) {
        System.out.println("Исходная строка: \"" + s + "\"\n");

        // 1. Строка передана параметром — уже сделано

        // 2. Последний символ
        System.out.println("2. Последний символ: '" + s.charAt(s.length() - 1) + "'");

        // 3. Заканчивается ли на "!!!"
        System.out.println("3. endsWith(\"!!!\"): " + s.endsWith("!!!"));

        // 4. Начинается ли с "I like"
        System.out.println("4. startsWith(\"I like\"): " + s.startsWith("I like"));

        // 5. Содержит ли "Java"
        System.out.println("5. contains(\"Java\"): " + s.contains("Java"));

        // 6. Позиция "Java"
        System.out.println("6. indexOf(\"Java\"): " + s.indexOf("Java"));

        // 7. Заменить 'а' на 'о'
        System.out.println("7. replace('а','о'): " + s.replace('а', 'о'));
        // ⚠️ 'а' здесь — РУССКАЯ, в строке "I like Java!!!" её нет!
        System.out.println("   replace('a','o') (латинская): " + s.replace('a', 'o'));

        // 8. Верхний регистр
        System.out.println("8. toUpperCase(): " + s.toUpperCase());

        // 9. Нижний регистр
        System.out.println("9. toLowerCase(): " + s.toLowerCase());

        // 10. Вырезать "Java"
        System.out.println("10. substring: " + s.substring(0, 7) + s.substring(11));
        // Или найти границы программно:
        int start = s.indexOf("Java");
        int end = start + "Java".length();
        System.out.println("    substring (динамически): " + s.substring(0, start) + s.substring(end));
    }
}
