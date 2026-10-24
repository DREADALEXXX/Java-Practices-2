// Task2_DateCompare.java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2_DateCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите дату в формате dd.MM.yyyy HH:mm: ");
        String input = sc.nextLine().trim();

        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        fmt.setLenient(false);   // запрещаем «31.02.2025» — пусть падает

        try {
            Date userDate = fmt.parse(input);   // строка → Date
            Date now = new Date();              // текущий момент

            int cmp = userDate.compareTo(now);

            System.out.println("Введено:  " + fmt.format(userDate));
            System.out.println("Сейчас:   " + fmt.format(now));

            if (cmp > 0) {
                System.out.println("→ Введённая дата в БУДУЩЕМ");
            } else if (cmp < 0) {
                System.out.println("→ Введённая дата в ПРОШЛОМ");
            } else {
                System.out.println("→ Даты СОВПАДАЮТ (с точностью до минуты)");
            }

            // Разница — наглядно
            long diffMs = now.getTime() - userDate.getTime();
            long diffDays = Math.abs(diffMs) / (1000L * 60 * 60 * 24);
            System.out.println("Разница: " + diffDays + " дн. (" + diffMs + " мс)");
        } catch (ParseException e) {
            System.out.println("Ошибка: неверный формат или несуществующая дата. " +
                    "Ожидается dd.MM.yyyy HH:mm");
        }

        sc.close();
    }
}