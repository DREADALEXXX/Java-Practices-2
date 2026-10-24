// SortingStudentsByGPA.java
import java.util.*;

public class SortingStudentsByGPA {
    // Поле — массив объектов Student (по заданию называется iDNumber).
    // Используем ArrayList — удобнее для merge (задание 3).
    private List<Student> iDNumber;

    public SortingStudentsByGPA() {
        this.iDNumber = new ArrayList<>();
    }

    // ============================================================
    // 1) ЗАПОЛНЕНИЕ МАССИВА
    // ============================================================
    public void setArray() {
        iDNumber.add(new Student("Alice",   "Smith",   "Computer Science", 2, "CS-21",   4.5));
        iDNumber.add(new Student("Bob",     "Johnson", "Mathematics",      1, "MATH-11", 3.8));
        iDNumber.add(new Student("Charlie", "Brown",   "Physics",          3, "PH-31",   4.9));
        iDNumber.add(new Student("Dave",    "Wilson",  "Computer Science", 2, "CS-21",   3.2));
        iDNumber.add(new Student("Eve",     "Davis",   "Mathematics",      1, "MATH-11", 4.1));
        iDNumber.add(new Student("Frank",   "Miller",  "Physics",          3, "PH-31",   3.5));
    }

    // ============================================================
    // КОМПАРАТОРЫ
    // ============================================================
    // Основной: по GPA по УБЫВАНИЮ (как требует задание)
    public static final Comparator<Student> BY_GPA_DESC =
            (a, b) -> Double.compare(b.getGpa(), a.getGpa());   // b vs a → убывание

    // Для п.4: по другому полю — по фамилии (алфавитный порядок)
    public static final Comparator<Student> BY_SURNAME =
            Comparator.comparing(Student::getSurname)
                    .thenComparing(Student::getName);          // tie-breaker по имени

    // ============================================================
    // 2a) БЫСТРАЯ СОРТИРОВКА (quicksort) С Comparator
    // ============================================================
    /** Основной вызов: quicksort по GPA по убыванию. */
    public void quicksort() {
        quicksort(BY_GPA_DESC);
    }

    /** Перегрузка: quicksort с произвольным компаратором. */
    public void quicksort(Comparator<Student> cmp) {
        quicksort(iDNumber, 0, iDNumber.size() - 1, cmp);
    }

    private void quicksort(List<Student> list, int low, int high, Comparator<Student> cmp) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, cmp);
            quicksort(list, low, pivotIndex - 1, cmp);
            quicksort(list, pivotIndex + 1, high, cmp);
        }
    }

    // Схема Ломуто: pivot — последний элемент
    private int partition(List<Student> list, int low, int high, Comparator<Student> cmp) {
        Student pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (cmp.compare(list.get(j), pivot) <= 0) {   // arr[j] должен быть левее pivot
                i++;
                Collections.swap(list, i, j);
            }
        }
        Collections.swap(list, i + 1, high);              // ставим pivot на место
        return i + 1;
    }

    // ============================================================
    // 2b) СОРТИРОВКА СЛИЯНИЕМ (merge sort)
    // ============================================================
    public void mergeSort() {
        mergeSort(BY_GPA_DESC);
    }

    public void mergeSort(Comparator<Student> cmp) {
        List<Student> sorted = mergeSort(iDNumber, cmp);
        iDNumber.clear();
        iDNumber.addAll(sorted);
    }

    private List<Student> mergeSort(List<Student> list, Comparator<Student> cmp) {
        if (list.size() <= 1) return new ArrayList<>(list);
        int mid = list.size() / 2;
        List<Student> left  = mergeSort(list.subList(0, mid), cmp);
        List<Student> right = mergeSort(list.subList(mid, list.size()), cmp);
        return merge(left, right, cmp);
    }

    /**
     * Публичное статическое слияние двух ОТСОРТИРОВАННЫХ списков.
     * Используется и для merge sort, и в Задании 3.
     */
    public static List<Student> merge(List<Student> a, List<Student> b, Comparator<Student> cmp) {
        List<Student> result = new ArrayList<>(a.size() + b.size());
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (cmp.compare(a.get(i), b.get(j)) <= 0) {
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }
        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));
        return result;
    }

    // ============================================================
    // 3) ВЫВОД МАССИВА
    // ============================================================
    public void outArray() {
        for (Student s : iDNumber) System.out.println(s);
    }

    // ============================================================
    // 4) СОРТИРОВКА ПО ДРУГОМУ ПОЛЮ (по фамилии)
    // ============================================================
    public void sortBySurname() {
        quicksort(BY_SURNAME);
    }

    // Геттер/сеттер для доступа к полю (нужен в задании 3)
    public List<Student> getIDNumber()              { return iDNumber; }
    public void setIDNumber(List<Student> list)     { this.iDNumber = list; }

    // ============================================================
    // main для демонстрации
    // ============================================================
    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.setArray();

        System.out.println("=== Исходный массив ===");
        sorter.outArray();

        System.out.println("\n=== quicksort: по GPA по убыванию ===");
        sorter.quicksort();
        sorter.outArray();

        System.out.println("\n=== mergeSort: по GPA по убыванию ===");
        sorter.mergeSort();
        sorter.outArray();

        System.out.println("\n=== Сортировка по другому полю: по фамилии ===");
        sorter.sortBySurname();
        sorter.outArray();
    }
}
