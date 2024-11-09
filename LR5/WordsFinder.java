import java.util.regex.*;

public class WordsFinder {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. This is a test sentence.";
        char letter = 't';

        Pattern pattern = Pattern.compile("\\b\\w*" + letter + "\\w*\\b", Pattern.CASE_INSENSITIVE);

        try {
            Matcher matcher = pattern.matcher(text);

            boolean found = false;

            while (matcher.find()) {
                System.out.println("Найдено слово: " + matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("Слова, начинающиеся с буквы '" + letter + "', не найдены.");
            }

        } catch (Exception e) {
            System.out.println("Произошла ошибка при поиске слов: " + e.getMessage());
        }
    }
}
