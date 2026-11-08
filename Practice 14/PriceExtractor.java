import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceExtractor {

    // Цена: целая часть + опционально . и ровно 2 цифры, пробелы, валюта
    private static final Pattern PRICE = Pattern.compile(
            "(\\d+(?:\\.\\d{2})?)\\s*(USD|RUB|EUR)\\b"
    );

    /** Извлекает все корректные цены из текста. */
    public static List<String> extractPrices(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = PRICE.matcher(text);
        while (m.find()) {
            result.add(m.group(1) + " " + m.group(2));   // "25.98 USD"
        }
        return result;
    }

    public static void main(String[] args) {
        String text = """
                Цены в магазине:
                Ноутбук — 25.98 USD
                Мышь — 10.50 USD
                Книга — 1500.00 RUB
                Куртка — 99.99 EUR
                Неправильно: 44 ERR
                Неправильно: 0.004 EU
                Неправильно: 12.3 USD      (одна цифра после точки)
                Неправильно: 5 USD         (нет копеек — допустимо? см. ниже)
                Телефон — 799.00 EUR
                """;

        List<String> prices = extractPrices(text);
        System.out.println("Найдено цен: " + prices.size());
        for (String p : prices) {
            System.out.println("  " + p);
        }
    }
}