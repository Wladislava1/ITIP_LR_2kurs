import java.util.ArrayList;//8
import java.util.Arrays;//10
import java.util.Collections;//8
import java.util.HashMap; //14
import java.util.List;//8
import java.util.Locale;
import java.util.Map;//14
import java.text.ParseException;//9
import java.text.SimpleDateFormat;//9
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;//9
import java.util.TimeZone;//9


public class FiftyTask {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD")); //1
        System.out.println(sameLetterPattern("ABCBA", "BCDCB")); //1
        System.out.println(sameLetterPattern("FFGG", "CDCD")); //1
        System.out.println(sameLetterPattern("FFFF", "ABCD")); //1
        System.out.println("__________________2________________________");

        System.out.println(memeSum(26, 39));     //2
        System.out.println(memeSum(122, 81));    //2
        System.out.println(memeSum(1222, 30277));//2
        System.out.println("_____________________3_____________________");

        System.out.println(digitsCount(4666));          //3
        System.out.println(digitsCount(544));           //3
        System.out.println(digitsCount(121317));        //3
        System.out.println(digitsCount(0));             //3
        System.out.println(digitsCount(12345));         //3
        System.out.println(digitsCount(1289396387328L));//3
        System.out.println("______________________4____________________");

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster")); //4
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); //4
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); //4
        System.out.println("______________________5____________________");

        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); //5
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));    //5
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));             //5
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));        //5
        System.out.println("____________________6______________________");

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); //6
        System.out.println(takeDownAverage(new String[]{"10%"})); //6
        System.out.println(takeDownAverage(new String[]{"53%", "79%"})); //6
        System.out.println("_____________________7_____________________");

        System.out.println(canMove("Rook", "A8", "H8"));     //7
        System.out.println(canMove("Bishop", "A7", "G1"));   //7
        System.out.println(canMove("Queen", "C4", "D6"));    //7
        System.out.println("____________________8______________________");

        System.out.println(maxPossible(9328, 456));   //8
        System.out.println(maxPossible(523, 76));     //8
        System.out.println(maxPossible(9132, 5564));  //8
        System.out.println(maxPossible(8732, 91255)); //8
        System.out.println("_____________________9_____________________");

        try {
            // Пример использования
            System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));  // "2011-4-2 17:23"
            System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));  // "1983-8-1 00:01"
            System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));  // "1971-1-1 02:40"
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("_____________________10_____________________");

        System.out.println(isNew(3));   //10
        System.out.println(isNew(30));  //10
        System.out.println(isNew(321)); //10
        System.out.println(isNew(123)); //10




    }
/*______________________________1________________________________________ */
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) {
                    return false;
                }
            } else {
                map1.put(c1, c2);
            }

            if (map2.containsKey(c2)) {
                if (map2.get(c2) != c1) {
                    return false;
                }
            } else {
                map2.put(c2, c1);
            }
        }
        return true;
    }
/*___________________________________2_________________________ */
public static int memeSum(int num1, int num2) {
    StringBuilder result = new StringBuilder();

    String str1 = Integer.toString(num1);
    String str2 = Integer.toString(num2);

    while (str1.length() < str2.length()) str1 = "0" + str1;
    while (str2.length() < str1.length()) str2 = "0" + str2;

    for (int i = 0; i < str1.length(); i++) {
        int digit1 = str1.charAt(i) - '0';
        int digit2 = str2.charAt(i) - '0';
        int sum = digit1 + digit2;

        result.append(sum);
    }
    return Integer.parseInt(result.toString());
}
/*____________________________3_________________________________ */
public static int digitsCount(long num) {
    if (num == 0) {
        return 1;
    }
    if (num < 10) {
        return 1;
    }
    return 1 + digitsCount(num / 10);
}
/*___________________________________4_________________________ */
 public static int totalPoints(String[] guessedWords, String decodedWord) {
        int totalPoints = 0;

        for (String word : guessedWords) {
            if (canForm(word, decodedWord)) {
                int wordLength = word.length();
                
                switch (wordLength) {
                    case 3:
                        totalPoints += 1;
                        break;
                    case 4:
                        totalPoints += 2;
                        break;
                    case 5:
                        totalPoints += 3;
                        break;
                    case 6:
                        totalPoints += 4 + 50;
                        break;
                }
            }
        }
        
        return totalPoints;
    }

    private static boolean canForm(String word, String decodedWord) {
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char c : decodedWord.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        for (char c : word.toCharArray()) {
            if (!letterCount.containsKey(c) || letterCount.get(c) == 0) {
                return false;
            }
            letterCount.put(c, letterCount.get(c) - 1);
        }

        return true;
    }
/*_______________________________5__________________________________________ */
public static int longestRun(int[] arr) {
    if (arr.length == 0) {
        return 0;
    }

    int maxRun = 1;
    int currentRun = 1;

    for (int i = 1; i < arr.length; i++) {
        if (arr[i] == arr[i - 1] + 1 || arr[i] == arr[i - 1] - 1) {
            currentRun++;
        } else {
            maxRun = Math.max(maxRun, currentRun);
            currentRun = 1; 
        }
    }

    maxRun = Math.max(maxRun, currentRun);

    return maxRun;
}
/*___________________________________6_________________________________ */
public static String takeDownAverage(String[] classScores) {
        int totalScore = 0;

        for (String score : classScores) {
            totalScore += Integer.parseInt(score.replace("%", ""));
        }

        int numberOfScores = classScores.length;
        int currentAverage = totalScore / numberOfScores;
        int targetAverage = currentAverage - 5;
        int requiredScore = targetAverage * (numberOfScores + 1) - totalScore;

        return requiredScore + "%";
    }
/*_______________________________________7__________________________________ */
public static boolean canMove(String piece, String start, String end) {
    int startCol = start.charAt(0) - 'A';
    int startRow = start.charAt(1) - '1';
    int endCol = end.charAt(0) - 'A';
    int endRow = end.charAt(1) - '1';

    switch (piece.toLowerCase()) {
        case "pawn":
            return (startCol == endCol && endRow == startRow + 1) || 
                   (startRow == 1 && startCol == endCol && endRow == startRow + 2);

        case "knight":
            return (Math.abs(startCol - endCol) == 2 && Math.abs(startRow - endRow) == 1) || 
                   (Math.abs(startCol - endCol) == 1 && Math.abs(startRow - endRow) == 2);

        case "bishop":
            return Math.abs(startCol - endCol) == Math.abs(startRow - endRow);

        case "rook":
            return startCol == endCol || startRow == endRow;

        case "queen":
            return startCol == endCol || startRow == endRow || 
                   Math.abs(startCol - endCol) == Math.abs(startRow - endRow);

        case "king":
            return Math.abs(startCol - endCol) <= 1 && Math.abs(startRow - endRow) <= 1;

        default:
            return false;
    }
}
/*_______________________________________8______________________________________ */
public static int maxPossible(int num1, int num2) {
        List<Integer> digits = new ArrayList<>();
        while (num2 > 0) {
            digits.add(num2 % 10);
            num2 /= 10;
        }
        Collections.sort(digits, Collections.reverseOrder());

        String num1Str = String.valueOf(num1);
        char[] result = num1Str.toCharArray();
        int j = 0;

        for (int i = 0; i < result.length; i++) {
            if (j < digits.size() && digits.get(j) > (result[i] - '0')) {
                result[i] = (char) (digits.get(j) + '0');
                j++;
            }
        }
        return Integer.parseInt(new String(result));
    }
/*______________________________________9_________________________________ */
private static final Map<String, Double> timeOffsets = new HashMap<>();
    static {
        timeOffsets.put("Los Angeles", -8.0);
        timeOffsets.put("New York", -5.0);
        timeOffsets.put("Caracas", -4.0);
        timeOffsets.put("Buenos Aires", -3.0);
        timeOffsets.put("London", 0.0);
        timeOffsets.put("Rome", 1.0);
        timeOffsets.put("Moscow", 3.0);
        timeOffsets.put("Tehran", 3.5);
        timeOffsets.put("New Delhi", 5.5);
        timeOffsets.put("Beijing", 8.0);
        timeOffsets.put("Canberra", 10.0);
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy HH:mm",  Locale.ENGLISH);
        Date date = sdf.parse(timestamp);
        double offsetA = timeOffsets.get(cityA);
        double offsetB = timeOffsets.get(cityB);
        double timeDifference = offsetB - offsetA;
        long timeInMillis = date.getTime() + (long)(timeDifference * 60 * 60 * 1000);
        sdf = new SimpleDateFormat("yyyy-M-d HH:mm");
        return sdf.format(new Date(timeInMillis));
    }


/*___________________________________10____________________________________ */
public static boolean isNew(int number) {
        String numStr = String.valueOf(number);
        
        char[] digits = numStr.toCharArray();
        Arrays.sort(digits);
        
        do {
            String permStr = new String(digits);
            if (!permStr.equals(numStr) && !permStr.startsWith("0")) {
                if (Integer.parseInt(permStr) < number) {
                    return false;
                }
            }
        } while (nextPermutation(digits));

        return true;
    }

    private static boolean nextPermutation(char[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i]) {
            i--;
        }
        if (i <= 0) return false;
        
        int j = array.length - 1;
        while (array[j] <= array[i - 1]) {
            j--;
        }

        char temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        
        return true;
    }
}