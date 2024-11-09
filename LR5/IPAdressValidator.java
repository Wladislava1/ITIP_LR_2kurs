import java.util.regex.*;

public class IPAdressValidator {
    public static void main(String[] args) {
        String ipAddress = "120.168.0.1"; 

        Pattern pattern = Pattern.compile(
            "^((25[0-5]|2[0-4][0-9]|[1]?[1-9]?[0-9])\\.){3}" +
            "(25[0-5]|2[0-4][0-9]|[1]?[1-9]?[0-9])$"
        );

        try {
            Matcher matcher = pattern.matcher(ipAddress);

            if (matcher.matches()) {
                System.out.println("IP-адрес корректен.");
            } else {
                System.out.println("Некорректный IP-адрес. Проверьте, что он соответствует формату.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке IP-адреса: " + e.getMessage());
        }
    }
}
