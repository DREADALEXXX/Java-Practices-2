// Task1_DeveloperInfo.java
import java.util.Date;

public class Task1_DeveloperInfo {
    public static void main(String[] args) {
        // Дата и время ПОЛУЧЕНИЯ задания (в реальности — вводится вручную,
        // здесь берём момент запуска как «получение»)
        Date received = new Date();

        // Небольшая пауза, чтобы даты отличались
        sleepMs(1500);

        // Дата и время СДАЧИ задания — текущий момент
        Date submitted = new Date();

        System.out.println("=== Информация о задании ===");
        System.out.println("Разработчик: Иванов Иван Иванович");
        System.out.println("Получено:    " + received);
        System.out.println("Сдано:       " + submitted);

        long diffMs = submitted.getTime() - received.getTime();
        System.out.println("На выполнение потрачено: " + diffMs + " мс");
    }

    private static void sleepMs(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
