import java.util.*; //1
import java.util.Stack;
import java.math.BigInteger;//6


public class SixtyTask {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived")); //1
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood")); //1
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison")); //1
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM")); //1
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit")); //1
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth")); //1

        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2")); //2
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", "b")); //2
        System.out.println(stripUrlParams("https://edabit.com", "b")); //2

        System.out.println(nicoCipher("mubashirhassan", "crazy")); //3
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh")); //3
        System.out.println(nicoCipher("andiloveherso", "tesha")); //3
        System.out.println(nicoCipher("edabitisamazing", "matt")); //3
        System.out.println(nicoCipher("iloveher", "612345")); //3

        System.out.println(java.util.Arrays.toString(twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15, 3}, 45))); //4
        System.out.println(java.util.Arrays.toString(twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 5}, 45))); //4
        System.out.println(java.util.Arrays.toString(twoProduct(new int[] {1, 2, -1, 4, 5, 6, 10, 7}, 20))); //4
        System.out.println(java.util.Arrays.toString(twoProduct(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10))); //4
        System.out.println(java.util.Arrays.toString(twoProduct(new int[] {100, 12, 4, 1, 2}, 15))); //4

        System.out.println(isExact(6));    //5
        System.out.println(isExact(24));   //5
        System.out.println(isExact(125));  //5
        System.out.println(isExact(720));  //5
        System.out.println(isExact(1024)); //5
        System.out.println(isExact(40320)); //5

        System.out.println(fractions("0.(6)"));          //6
        System.out.println(fractions("1.(1)"));          //6
        System.out.println(fractions("3.(142857)"));     //6
        System.out.println(fractions("0.19(2367)"));     //6
        System.out.println(fractions("0.1097(3)"));      //6

        System.out.println(pilishString("33314444")); //7
        System.out.println(pilishString("TOP"));       //7
        System.out.println(pilishString("X"));         //7
        System.out.println(pilishString(""));          //7
        System.out.println(pilishString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE"));
        //7

        System.out.println(formula("6 * 4 = 24")); //8
        System.out.println(formula("18 / 17 = 2")); //8
        System.out.println(formula("16 * 10 = 160 = 14 + 120")); //8


        System.out.println(isValid("aabbcd")); //9
        System.out.println(isValid("aabbccddeefghi")); //9
        System.out.println(isValid("abcdefghhgfedecba")); //9

        System.out.println(palindromeDescendant(11211230)); //10
        System.out.println(palindromeDescendant(13001120)); //10
        System.out.println(palindromeDescendant(23336014)); //10
        System.out.println(palindromeDescendant(11)); //10
        System.out.println(palindromeDescendant(12345)); //10

    }

/*______________________________________1_________________________________________________________ */
    public static String hiddenAnagram(String sentence, String phrase) {
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanedPhrase = phrase.replaceAll("[^a-zA-Z]", "").toLowerCase();

        Map<Character, Integer> targetFrequency = getFrequencyMap(cleanedPhrase);
        int start = 0, end = 0;
        Map<Character, Integer> currentFrequency = new HashMap<>();

        while (end < cleanedSentence.length()) {
            char endChar = cleanedSentence.charAt(end);
            currentFrequency.put(endChar, currentFrequency.getOrDefault(endChar, 0) + 1);
            if (end - start + 1 > cleanedPhrase.length()) {
                char startChar = cleanedSentence.charAt(start);
                currentFrequency.put(startChar, currentFrequency.get(startChar) - 1);
                if (currentFrequency.get(startChar) == 0) {
                    currentFrequency.remove(startChar);
                }
                start++;
            }

            if (currentFrequency.equals(targetFrequency)) {
                return cleanedSentence.substring(start, end + 1);
            }

            end++;
        }

        return "noutfond";
    }

    private static Map<Character, Integer> getFrequencyMap(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }
/*_________________________________________2_____________________________________________ */
public static String stripUrlParams(String url, String... paramsToRemove) {
    if (!url.contains("?")) {
        return url;
    }

    String[] parts = url.split("\\?", 2);
    String baseUrl = parts[0];
    String queryParams = parts[1];
    List<String> removeList = Arrays.asList(paramsToRemove);
    Map<String, String> paramMap = new LinkedHashMap<>();

    String[] pairs = queryParams.split("&");
    for (String pair : pairs) {
        String[] keyValue = pair.split("=");
        String key = keyValue[0];
        String value = keyValue.length > 1 ? keyValue[1] : "";
        if (!removeList.contains(key)) {
            paramMap.put(key, value);
        }
    }

    if (paramMap.isEmpty()) {
        return baseUrl;
    }

    List<String> sortedKeys = new ArrayList<>(paramMap.keySet());
    Collections.sort(sortedKeys);

    StringBuilder resultParams = new StringBuilder();
    for (String key : sortedKeys) {
        if (resultParams.length() > 0) {
            resultParams.append("&");
        }
        resultParams.append(key).append("=").append(paramMap.get(key));
    }
    return baseUrl + "?" + resultParams.toString();
}
/*________________________________________3____________________________________ */
public static String nicoCipher(String message, String key) {
    // Шаг 1
    int keyLength = key.length();
    while (message.length() % keyLength != 0) {
        message += " ";
    }
    // Шаг 2
    char[] keyArray = key.toCharArray();
    Integer[] keyIndexes = new Integer[keyLength];
    for (int i = 0; i < keyLength; i++) {
        keyIndexes[i] = i;
    }

    Arrays.sort(keyIndexes, Comparator.comparingInt(i -> keyArray[i]));
    // Шаг 3
    List<String> rows = new ArrayList<>();
    for (int i = 0; i < message.length(); i += keyLength) {
        rows.add(message.substring(i, i + keyLength));
    }
    // Шаг 4
    StringBuilder encodedMessage = new StringBuilder();
    for (int index : keyIndexes) {
        for (String row : rows) {
            encodedMessage.append(row.charAt(index));
        }
    }
    return encodedMessage.toString();
}
/*____________________________________4___________________________________ */
public static int[] twoProduct(int[] arr, int n) {
    Map<Integer, Integer> seen = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
        int current = arr[i];
        if (n % current == 0) {
            int complement = n / current;
            if (seen.containsKey(complement)) {
                return new int[] {complement, current};
            }
        }
        seen.put(current, i);
    }
    return new int[0];
}
/*__________________________________5_____________________________________ */
public static List<Integer> isExact(int x) {
    return isExactHelper(x, 1, 1);
}
private static List<Integer> isExactHelper(int x, int n, int factorial) {
    if (factorial == x) {
        List<Integer> result = new ArrayList<>();
        result.add(factorial);
        result.add(n);
        return result;
    }
    if (factorial > x) {
        return new ArrayList<>();
    }
    
    return isExactHelper(x, n + 1, factorial * (n + 1));
}
/*_________________________________________6__________________________________ */
public static String fractions(String decimal) {
    String[] parts = decimal.split("\\.");
    String integerPart = parts[0];
    String fractionalPart = parts[1];
    
    String nonRepeating = fractionalPart.split("\\(")[0];
    String repeating = fractionalPart.split("\\(").length > 1
            ? fractionalPart.split("\\(")[1].replace(")", "")
            : "";

    BigInteger numerator, denominator;

    if (repeating.isEmpty()) {
        numerator = new BigInteger(integerPart + nonRepeating);
        denominator = BigInteger.TEN.pow(nonRepeating.length());
    } else { 
        String fullNumber = integerPart + nonRepeating + repeating;
        String nonRepeatingNumber = integerPart + nonRepeating;

        BigInteger fullNumerator = new BigInteger(fullNumber);
        BigInteger nonRepeatingNumerator = new BigInteger(nonRepeatingNumber);

        int lenRepeating = repeating.length();
        int lenNonRepeating = nonRepeating.length();

        numerator = fullNumerator.subtract(nonRepeatingNumerator);
        denominator = BigInteger.TEN.pow(lenNonRepeating + lenRepeating)
                .subtract(BigInteger.TEN.pow(lenNonRepeating));
    }

    BigInteger gcd = numerator.gcd(denominator);
    numerator = numerator.divide(gcd);
    denominator = denominator.divide(gcd);

    return numerator + "/" + denominator;
}
/*_______________________________7_____________________________________ */
   public static String pilishString(String txt) {
        if (txt.isEmpty()) {
            return "";
        }

        int[] piDigits = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int digit : piDigits) {
            if (index >= txt.length()) {
                break; 
            }
            int wordLength = Math.min(digit, txt.length() - index);
            StringBuilder word = new StringBuilder(txt.substring(index, index + wordLength));
            index += wordLength;
            while (word.length() < digit) {
                word.append(word.charAt(word.length() - 1));
            }

            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(word);
        }

        return result.toString();
    }
/*______________________________________8_______________________________________ */
  public static boolean formula(String input) {
        String[] parts = input.split(" = ");
        if (parts.length < 2) {
            return false; 
        }

        try {
            double previousValue = evaluate(parts[0]);

            for (int i = 1; i < parts.length; i++) {
                double currentValue = evaluate(parts[i]);
                if (previousValue != currentValue) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        expression = expression.replaceAll(" ", "");
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    i++;
                }
                values.push(Double.parseDouble(expression.substring(start, i)));
                i--; 
            }
            else if (c == '(') {
                operators.push(c);
            }
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
        }
        return 0;
    }
/*__________________________________________9__________________________________ */
public static String isValid(String str) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : str.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int freq : charFrequency.values()) {
            frequencyCount.put(freq, frequencyCount.getOrDefault(freq, 0) + 1);
        }

        if (frequencyCount.size() == 1) {
            return "YES";
        }

        if (frequencyCount.size() > 2) {
            return "NO";
        }

        int[] keys = new int[2];
        int[] values = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            keys[i] = entry.getKey();
            values[i] = entry.getValue();
            i++;
        }

        if ((Math.abs(keys[0] - keys[1]) == 1 && (values[0] == 1 || values[1] == 1)) ||
            (keys[0] == 1 && values[0] == 1) ||
            (keys[1] == 1 && values[1] == 1)) {
            return "YES";
        }

        return "NO";
    }
/*___________________________________10______________________________________ */    
public static boolean isPalindrome(String number) {
    int left = 0;
    int right = number.length() - 1;
    while (left < right) {
        if (number.charAt(left) != number.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

public static String getNextDescendant(String number) {
    StringBuilder descendant = new StringBuilder();
    for (int i = 0; i < number.length() - 1; i += 2) {
        int sum = (number.charAt(i) - '0') + (number.charAt(i + 1) - '0');
        descendant.append(sum);
    }
    return descendant.toString();
}


public static boolean palindromeDescendant(int num) {
    String number = String.valueOf(num);

    if (isPalindrome(number)) {
        return true;
    }

    while (number.length() > 2) {
        number = getNextDescendant(number);
        if (isPalindrome(number)) {
            return true;
        }
    }
    return isPalindrome(number);
}

}
