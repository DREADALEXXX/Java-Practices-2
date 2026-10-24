import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Task6_WordChain {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String fileName = sc.nextLine().trim();

        String content = Files.readString(Path.of(fileName));
        System.out.println("Слова: " + content);

        String result = getLine(content);
        if (result == null) {
            System.out.println("Невозможно построить цепочку");
        } else {
            System.out.println("Результат: " + result);
        }
    }

    /** Строит цепочку слов, где последняя буква = первая следующего. */
    public static String getLine(String content) {
        List<String> words = new ArrayList<>(Arrays.asList(content.trim().split("\\s+")));
        if (words.isEmpty()) return "";

        // Пробуем начать с каждого слова (вдруг с первого не получится)
        for (int i = 0; i < words.size(); i++) {
            List<String> order = new ArrayList<>();
            Set<Integer> used = new HashSet<>();
            if (dfs(words, i, order, used)) {
                StringBuilder sb = new StringBuilder();
                for (String w : order) {
                    if (sb.length() > 0) sb.append(' ');
                    sb.append(w);
                }
                return sb.toString();
            }
        }
        return null;
    }

    private static boolean dfs(List<String> words, int idx, List<String> order, Set<Integer> used) {
        order.add(words.get(idx));
        used.add(idx);

        if (used.size() == words.size()) return true;   // все использованы

        char last = Character.toLowerCase(words.get(idx).charAt(words.get(idx).length() - 1));

        for (int j = 0; j < words.size(); j++) {
            if (used.contains(j)) continue;
            char first = Character.toLowerCase(words.get(j).charAt(0));
            if (first == last) {
                if (dfs(words, j, order, used)) return true;
            }
        }

        // откат
        order.remove(order.size() - 1);
        used.remove(idx);
        return false;
    }
}