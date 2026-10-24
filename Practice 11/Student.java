// Student.java
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private String specialty;
    private int    course;
    private String group;
    private double gpa;
    private Date   birthDate;       // ← НОВОЕ поле

    public Student(String name, String surname, String specialty,
                   int course, String group, double gpa, Date birthDate) {
        this.name      = name;
        this.surname   = surname;
        this.specialty = specialty;
        this.course    = course;
        this.group     = group;
        this.gpa       = gpa;
        this.birthDate = birthDate;
    }

    // ... остальные геттеры/сеттеры как раньше ...

    public Date getBirthDate()            { return birthDate; }
    public void setBirthDate(Date d)      { this.birthDate = d; }

    /**
     * Возвращает строковое представление даты рождения в заданном формате.
     * @param format шаблон SimpleDateFormat, например "dd.MM.yyyy"
     * @return отформатированная дата или "—", если дата не задана
     */
    public String formatBirthDate(String format) {
        if (birthDate == null) return "—";
        return new SimpleDateFormat(format, Locale.getDefault()).format(birthDate);
    }

    /**
     * Удобные «короткий / средний / полный» форматы.
     * Можно использовать java.text.DateFormat вместо ручных шаблонов.
     */
    public String formatBirthDate(DateFormatStyle style) {
        if (birthDate == null) return "—";
        java.text.DateFormat df;
        switch (style) {
            case SHORT:  df = java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT);  break;
            case MEDIUM: df = java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM); break;
            case FULL:   df = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);   break;
            default:     df = java.text.DateFormat.getDateInstance();
        }
        return df.format(birthDate);
    }

    public enum DateFormatStyle { SHORT, MEDIUM, FULL }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return String.format(
                "Student{name='%s', surname='%s', specialty='%s', course=%d, group='%s', gpa=%.2f, birthDate=%s}",
                name, surname, specialty, course, group, gpa,
                birthDate == null ? "—" : new SimpleDateFormat("dd.MM.yyyy").format(birthDate));
    }
}
