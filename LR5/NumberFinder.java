import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "Martha also needs 2 bags of flour and 2 bags of sugar. Flour costs 3.2 dollars per 5-pound bag. Sugar costs 4 dollars per 5-pound bag. It costs 6.8 dollars for the flour and 8 dollars for the sugar. Together, they cost 14 dollars.";

        Pattern pattern = Pattern.compile("\\b\\d+\\.?\\d*\\b");
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найдено число: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Числа в тексте не найдены.");
        }
    }
}
