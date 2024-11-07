import java.util.regex.*;

public class UpperCharFinder {
    public static void main(String[] args) {
        String text = "This is a simpleTest example where we find testCases in text.";

        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(text);

        StringBuffer modifiedText = new StringBuffer();

        while (matcher.find()) {

            matcher.appendReplacement(modifiedText, matcher.group(1) + "!" + matcher.group(2) + "!");
        }
        matcher.appendTail(modifiedText);

        System.out.println("Измененный текст: " + modifiedText.toString());
    }
}

