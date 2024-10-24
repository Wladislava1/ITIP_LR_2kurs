import java.util.ArrayList;//2348
import java.util.List;//2348
import java.util.*;//9
import java.util.HashMap;//10
    
public class FourtyTask {
        public static void main(String[] args) {
            System.out.println(nonRepeat("abracadabra"));  //1
            System.out.println(nonRepeat("abababcac"));    //1
            System.out.println("________________________________________");

            System.out.println(bruteForce(1, 5));  //2
            System.out.println(bruteForce(2, 2));  //2
            System.out.println(bruteForce(5, 3));  //2
            System.out.println("________________________________________");

            System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT")); //3
            System.out.println(decode("MTUCI", "MKIIT"));//3
            System.out.println("________________________________________");

            System.out.println(split("()()()"));  //4
            System.out.println(split("((()))"));  //4
            System.out.println(split("((()))(())()()(()())"));  //4
            System.out.println(split("((())())(()(()()))"));    //4
            System.out.println("________________________________________");

            System.out.println(shortHand("abbccc"));         //5
            System.out.println(shortHand("vvvvaajaaaaa"));   //5
            System.out.println(shortHand("hello"));          //5
            System.out.println("________________________________________");

            System.out.println(convertToRome(8));     //6
            System.out.println(convertToRome(1234));  //6
            System.out.println(convertToRome(52));    //6
            System.out.println("________________________________________");

            System.out.println(uniqueSubstring("31312131"));      //7
            System.out.println(uniqueSubstring("1111111"));       //7
            System.out.println(uniqueSubstring("12223234333"));    //7
            System.out.println("________________________________________");

            int[][]  labyrinth1 = { //8
                {1, 3, 1},  //8
                {1, -1, 1},  //8
                {4, 2, 1}  //8
            };  //8
            
            int[][] labyrinth2 = {  //8
                {2, -7, 3},  //8
                {-4, -1, 8},  //8
                {4, 5, 9}  //8
            };
    
            System.out.println(Arrays.toString(labirint(labyrinth1))); //8
            System.out.println(Arrays.toString(labirint(labyrinth2))); //8
            System.out.println("________________________________________");

            System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng")); //9
            System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat")); //9
            System.out.println("________________________________________");

            System.out.println(fibString("CCCABDD")); //10
            System.out.println(fibString("ABC"));     //10
            System.out.println(fibString("ABCDEFGH"));     //10
            System.out.println(fibString("AABBCCDD"));     //10

        }
    /*_____________________________1__________________________________ */
        public static String nonRepeat(String str) {
            str = str.toLowerCase();
            if (str.length() < 4) {
                return str;
            }
            char firstChar = str.charAt(0);
            int count = 1;
            while (count < str.length() && str.charAt(count) == firstChar) {
                count++;
            }
            if (count > 3) {
                return nonRepeat(str.substring(count));
            }
            return str.substring(0, count) + nonRepeat(str.substring(count));
        }
    /*_______________________________2________________________________ */   
    public static List<String> bruteForce(int n, int k) {
        List<String> result = new ArrayList<>();
        if (n > k) {
            return result;
        }
        generateCombinations(result, "", n, k);
        return result;
    }

    private static void generateCombinations(List<String> result, String current, int n, int k) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (int i = 0; i < k; i++) { 
            if (!current.contains(String.valueOf(i))) { 
                generateCombinations(result, current + i, n, k);
            }
        }
    }
    /*___________________________________________3_________________________ */
    public static List<Integer> decode(String text, String key) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int decodedChar = text.charAt(i) ^ key.charAt(i);
            result.add(decodedChar);
        }
        return result;
    }
    public static String encode(int[] numbers, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            char encodedChar = (char) (numbers[i] ^ key.charAt(i));
            result.append(encodedChar);
        }
        return result.toString();
    }
    /*________________________________4_____________________________________ */
    public static List<String> split(String str) {
        List<String> result = new ArrayList<>();
        int balance = 0; 
        int start = 0; 

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                result.add(str.substring(start, i + 1));  
                start = i + 1; 
            }
        }

        return result;
    }
    /*_____________________________________5________________________________ */
    public static String shortHand(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1; 
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                if (count > 1) {
                    result.append("*").append(count);
                }
                count = 1;
            }
        }
        return result.toString();
    }
    /*_____________________________________6______________________________ */
    public static String convertToRome(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }
    /*____________________________________7____________________________ */
    public static String uniqueSubstring(String str) {
        int[] count = new int[10]; 
        int[] firstIndex = new int[10];
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            count[digit]++;
            if (count[digit] == 1) { 
                firstIndex[digit] = i;
            }
        }
        int maxCount = 0;
        int indexOfMax = -1;
        for (int i = 0; i < 10; i++) {
            if (count[i] > maxCount || (count[i] == maxCount && firstIndex[i] < indexOfMax)) {
                maxCount = count[i];
                indexOfMax = firstIndex[i];
            }
        }
        return (indexOfMax % 2 == 0) ? "чет" : "нечет";
    }
    /*__________________________________8________________________________ */
    public static String[] labirint(int[][] labyrinth) {
        int n = labyrinth.length;
        int[][] cost = new int[n][n]; 
        String[][] path = new String[n][n]; 

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            Arrays.fill(path[i], "");
        }

        cost[n - 1][n - 1] = labyrinth[n - 1][n - 1];
        path[n - 1][n - 1] = String.valueOf(labyrinth[n - 1][n - 1]);

        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (labyrinth[row][col] < 0) continue; 

                if (row > 0 && labyrinth[row - 1][col] >= 0) {
                    int newCost = cost[row][col] + labyrinth[row - 1][col];
                    if (newCost < cost[row - 1][col]) {
                        cost[row - 1][col] = newCost;
                        path[row - 1][col] = path[row][col] + "-" + labyrinth[row - 1][col];
                    }
                }

                if (col > 0 && labyrinth[row][col - 1] >= 0) {
                    int newCost = cost[row][col] + labyrinth[row][col - 1];
                    if (newCost < cost[row][col - 1]) {
                        cost[row][col - 1] = newCost;
                        path[row][col - 1] = path[row][col] + "-" + labyrinth[row][col - 1];
                    }
                }
            }
        }
        if (cost[0][0] == Integer.MAX_VALUE) {
            return new String[]{"Прохода нет"};
        } else {
            return new String[]{path[0][0], String.valueOf(cost[0][0])};
        }
    }
    /*_____________________________________9_____________________________ */
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        List<String> sortedWords = new ArrayList<>();
        
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    index = Character.getNumericValue(ch) - 1;
                } else {
                    sb.append(ch);
                }
            }
            while (sortedWords.size() <= index) {
                sortedWords.add(""); 
            }
            sortedWords.set(index, sb.toString());
        }

        return String.join(" ", sortedWords).trim();
    }
    /*__________________________________10_________________________________ */
    public static boolean fibString(String str) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int repeatCount = 0; 
        for (Integer count : charCount.values()) {
            if (count > 1) {
                repeatCount++; 
            }
        }

        return isFibonacci(repeatCount);
    }

    private static boolean isFibonacci(int n) {
        return n == 1 || n == 2 || n == 3 || n == 5 || n == 8 || n == 13;
    }

}


