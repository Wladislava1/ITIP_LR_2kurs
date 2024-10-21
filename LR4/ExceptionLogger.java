import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionLogger {
    private static final String LOG_FILE = "exceptions_log.txt";

    public static void logException(Exception e) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println("Исключение: " + e.toString());
            for (StackTraceElement element : e.getStackTrace()) {
                out.println("\tat " + element);
            }
            out.println("--------------------------------------------------");
        } catch (IOException ioException) {
            System.out.println("Ошибка при записи в лог файл: " + ioException.getMessage());
        }
    }
}
