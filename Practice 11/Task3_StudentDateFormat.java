// Task3_StudentDateFormat.java
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task3_StudentDateFormat {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat input = new SimpleDateFormat("dd.MM.yyyy");
        Student s = new Student(
                "Alice", "Smith", "Computer Science", 2, "CS-21", 4.5,
                input.parse("15.03.2004"));

        System.out.println("toString():");
        System.out.println(s);

        System.out.println("\nДата рождения в разных форматах:");
        System.out.println("dd.MM.yyyy        → " + s.formatBirthDate("dd.MM.yyyy"));
        System.out.println("yyyy-MM-dd        → " + s.formatBirthDate("yyyy-MM-dd"));
        System.out.println("d MMMM yyyy (RU)  → " + s.formatBirthDate("d MMMM yyyy"));
        System.out.println("EEEE, d MMM yyyy  → " + s.formatBirthDate("EEEE, d MMM yyyy"));

        System.out.println("\nСтандартные стили (DateFormat):");
        System.out.println("SHORT  → " + s.formatBirthDate(Student.DateFormatStyle.SHORT));
        System.out.println("MEDIUM → " + s.formatBirthDate(Student.DateFormatStyle.MEDIUM));
        System.out.println("FULL   → " + s.formatBirthDate(Student.DateFormatStyle.FULL));
    }
}
