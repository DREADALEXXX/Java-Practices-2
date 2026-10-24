// Task3_MergeSortedLists.java
import java.util.*;

public class Task3_MergeSortedLists {
    public static void main(String[] args) {
        // Список 1 — уже отсортирован по GPA (по убыванию)
        List<Student> list1 = new ArrayList<>(List.of(
                new Student("Charlie", "Brown",   "Physics",          3, "PH-31",   4.9),
                new Student("Alice",   "Smith",   "Computer Science", 2, "CS-21",   4.5),
                new Student("Eve",     "Davis",   "Mathematics",      1, "MATH-11", 4.1)
        ));

        // Список 2 — уже отсортирован по GPA (по убыванию)
        List<Student> list2 = new ArrayList<>(List.of(
                new Student("Kate",    "Taylor",  "Biology",          2, "BIO-21",  4.7),
                new Student("Frank",   "Miller",  "Physics",          3, "PH-31",   3.5),
                new Student("Bob",     "Johnson", "Mathematics",      1, "MATH-11", 3.8)
        ));

        // На всякий случай сортируем оба (merge требует ОТСОРТИРОВАННЫХ входов)
        list1.sort(SortingStudentsByGPA.BY_GPA_DESC);
        list2.sort(SortingStudentsByGPA.BY_GPA_DESC);

        System.out.println("=== Список 1 (отсортирован по GPA ↓) ===");
        list1.forEach(System.out::println);

        System.out.println("\n=== Список 2 (отсортирован по GPA ↓) ===");
        list2.forEach(System.out::println);

        // Слияние — используем публичный статический merge из задания 2
        List<Student> merged = SortingStudentsByGPA.merge(
                list1, list2, SortingStudentsByGPA.BY_GPA_DESC);

        System.out.println("\n=== Объединённый отсортированный список ===");
        merged.forEach(System.out::println);
    }
}