// Task5_CollectionsBenchmark.java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task5_CollectionsBenchmark {
    private static final int N = 100_000;   // размер коллекции
    private static final int OPS = 5_000;   // число операций в тесте
    private static final Random RND = new Random(42);

    public static void main(String[] args) {
        System.out.printf("N = %d, операций = %d%n%n", N, OPS);

        System.out.println("=== add в конец ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  fill(l, N); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); fill(l, N); });

        System.out.println("\n=== add в начало ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  for (int i = 0; i < OPS; i++) l.add(0, i); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); for (int i = 0; i < OPS; i++) l.add(0, i); });

        System.out.println("\n=== add в середину ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  fill(l, N); for (int i = 0; i < OPS; i++) l.add(l.size()/2, i); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); fill(l, N); for (int i = 0; i < OPS; i++) l.add(l.size()/2, i); });

        System.out.println("\n=== get по случайному индексу ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  fill(l, N); for (int i = 0; i < OPS; i++) l.get(RND.nextInt(N)); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); fill(l, N); for (int i = 0; i < OPS; i++) l.get(RND.nextInt(N)); });

        System.out.println("\n=== remove с начала ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  fill(l, N); for (int i = 0; i < OPS; i++) l.remove(0); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); fill(l, N); for (int i = 0; i < OPS; i++) l.remove(0); });

        System.out.println("\n=== remove из середины ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  fill(l, N); for (int i = 0; i < OPS; i++) l.remove(l.size()/2); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); fill(l, N); for (int i = 0; i < OPS; i++) l.remove(l.size()/2); });

        System.out.println("\n=== contains (поиск) ===");
        bench("ArrayList",  () -> { List<Integer> l = new ArrayList<>();  fill(l, N); for (int i = 0; i < OPS; i++) l.contains(RND.nextInt(N)); });
        bench("LinkedList", () -> { List<Integer> l = new LinkedList<>(); fill(l, N); for (int i = 0; i < OPS; i++) l.contains(RND.nextInt(N)); });
    }

    private static void fill(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) list.add(i);
    }

    // Запуск задачи и замер времени
    private static void bench(String label, Runnable task) {
        // прогрев JIT
        for (int w = 0; w < 3; w++) task.run();

        long start = System.nanoTime();
        task.run();
        long elapsed = System.nanoTime() - start;

        System.out.printf("  %-11s %,12d нс  (%,.2f мс)%n",
                label, elapsed, elapsed / 1_000_000.0);
    }
}