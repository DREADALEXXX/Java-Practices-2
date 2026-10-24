// Task4_DateFromInput.java
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task4_DateFromInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите год: ");
        int year = sc.nextInt();
        System.out.print("Введите месяц (1-12): ");
        int month = sc.nextInt();
        System.out.print("Введите число: ");
        int day = sc.nextInt();
        System.out.print("Введите часы (0-23): ");
        int hour = sc.nextInt();
        System.out.print("Введите минуты (0-59): ");
        int minute = sc.nextInt();

        // === Вариант 1: через GregorianCalendar (правильный) ===
        Calendar cal = new GregorianCalendar(year, month - 1, day, hour, minute, 0);
        Date dateFromCal = cal.getTime();

        // === Вариант 2: через устаревший конструктор Date ===
        @SuppressWarnings("deprecation")
        Date dateDeprecated = new Date(year - 1900, month - 1, day, hour, minute);

        System.out.println("\n=== Результаты ===");
        System.out.println("Calendar.getTime():     " + dateFromCal);
        System.out.println("new Date(y-1900, ...):  " + dateDeprecated);
        System.out.println("Совпадают: " + dateFromCal.equals(dateDeprecated));

        // Дополнительно: поля из Calendar
        System.out.println("\nРазбор по полям (Calendar):");
        System.out.println("  Год:    " + cal.get(Calendar.YEAR));
        System.out.println("  Месяц:  " + (cal.get(Calendar.MONTH) + 1));   // 0-based!
        System.out.println("  День:   " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("  Час:    " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("  Минута: " + cal.get(Calendar.MINUTE));
        System.out.println("  День недели: " + cal.get(Calendar.DAY_OF_WEEK));

        sc.close();
    }
}