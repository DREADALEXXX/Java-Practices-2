import java.util.Arrays;
public class Task1_InsertionSort {
    // Сортировка вставками по iDNumber
    public static void insertionSort(Student[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Student key = arr[i];       // элемент, который будем вставлять
            int j = i - 1;

            // сдвигаем элементы, которые больше key, вправо
            while (j >= 0 && arr[j].getIDNumber() > key.getIDNumber()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;           // вставляем key на свободное место
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice",   103, 4.5),
                new Student("Bob",     101, 3.8),
                new Student("Charlie", 105, 4.9),
                new Student("Dave",    102, 3.2),
                new Student("Eve",     104, 4.1)
        };

        System.out.println("До сортировки:");
        for (Student s : students) System.out.println(s);

        insertionSort(students);

        System.out.println("\nПосле сортировки по iDNumber (вставками):");
        for (Student s : students) System.out.println(s);
    }
}
class Student implements Comparable<Student> {
    private String name;
    private int iDNumber;
    private double gpa;

    public Student(String name, int iDNumber, double gpa) {
        this.name = name;
        this.iDNumber = iDNumber;
        this.gpa = gpa;
    }

    public String getName()    { return name; }
    public int getIDNumber()   { return iDNumber; }
    public double getGpa()     { return gpa; }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', id=%d, gpa=%.2f}", name, iDNumber, gpa);
    }
}