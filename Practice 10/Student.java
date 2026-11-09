// Student.java
public class Student implements Comparable<Student> {
    // === Переменные экземпляра (по заданию) ===
    private String name;        // Имя
    private String surname;     // Фамилия
    private String specialty;   // Специальность
    private int    course;      // Курс
    private String group;       // Группа
    private double gpa;         // Средний балл — нужен для сортировки (задание 2)

    // === Конструктор, включающий ВСЕ переменные ===
    public Student(String name, String surname, String specialty,
                   int course, String group, double gpa) {
        this.name      = name;
        this.surname   = surname;
        this.specialty = specialty;
        this.course    = course;
        this.group     = group;
        this.gpa       = gpa;
    }

    // === Геттеры ===
    public String getName()      { return name; }
    public String getSurname()   { return surname; }
    public String getSpecialty() { return specialty; }
    public int    getCourse()    { return course; }
    public String getGroup()     { return group; }
    public double getGpa()       { return gpa; }

    // === Сеттеры ===
    public void setName(String name)           { this.name = name; }
    public void setSurname(String surname)     { this.surname = surname; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setCourse(int course)          { this.course = course; }
    public void setGroup(String group)         { this.group = group; }
    public void setGpa(double gpa)             { this.gpa = gpa; }

    // === Задание 4: собственная реализация Comparable ===
    // Естественный порядок — по GPA по возрастанию
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return String.format(
                "Student{name='%s', surname='%s', specialty='%s', course=%d, group='%s', gpa=%.2f}",
                name, surname, specialty, course, group, gpa);
    }
}