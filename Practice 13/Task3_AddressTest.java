public class Task3_AddressTest {
    public static void main(String[] args) {
        String[] inputs = {
                "Россия, Московская область, Москва, Тверская, 12, 3, 45",
                "  Россия ,  Ленинградская область , Санкт-Петербург , Невский проспект , 1 , 2 , 10  ",
                "Россия. Татарстан. Казань. Баумана. 5. 1. 22",              // точки
                "Россия; Свердловская область; Екатеринбург; Ленина; 10; 2; 33", // точки с запятой
                "США, Калифорния, Лос-Анджелес, Голливудский бульвар, 100"  // не хватает частей
        };

        for (String input : inputs) {
            System.out.println("ВХОД: \"" + input + "\"");

            Address a1 = new Address();
            a1.parseWithSplit(input);
            System.out.println("  split()       → " + a1);

            Address a2 = new Address();
            a2.parseWithTokenizer(input);
            System.out.println("  StringTokenizer→ " + a2);
            System.out.println();
        }
    }
}