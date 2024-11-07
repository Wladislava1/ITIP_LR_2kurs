import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "Passw0rd123"; 

        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

        try {
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректен.");
            } else {
                System.out.println("Пароль некорректен. Проверьте, что он соответствует всем требованиям.");
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при проверке пароля: " + e.getMessage());
        }
    }
}
