import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {
    // Сортировка по GPA в порядке УБЫВАНИЯ
    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());   // b vs a → убывание
    }

    // Быстрая сортировка с использованием этого компаратора
    public void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(Student[] arr, int low, int high) {
        Student pivot = arr[high];          // опорный — последний
        int i = low - 1;                    // граница «меньших pivot»

        for (int j = low; j < high; j++) {
            // если arr[j] должен стоять ЛЕВЕЕ pivot (по компаратору)
            if (compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);             // ставим pivot на место
        return i + 1;
    }

    private void swap(Student[] arr, int i, int j) {
        Student tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}