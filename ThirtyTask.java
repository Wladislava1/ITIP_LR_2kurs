import java.util.ArrayList;
import java.util.List;

public class ThirtyTask{
    public static void main(String [] args){
        System.out.println(isStrangePair("ratio", "orator")); //1
        System.out.println(isStrangePair("sparkling", "groups")); //1
        System.out.println(isStrangePair("bush", "hubris")); //1
        System.out.println(isStrangePair("", "")); //1

        List<Object[]> products = new ArrayList<>();//2
        products.add(new Object[]{"Laptop", 124200});//2
        products.add(new Object[]{"Phone", 51450});//2
        products.add(new Object[]{"Headphones", 13800});//2

        List<Object[]> discountedProducts = sale(products, 25);//2

        for (Object[] product : discountedProducts) {//2
            System.out.println(product[0] + ": " + product[1]);//2
        }//2

        System.out.println(successShoot(0, 0, 5, 2, 2));  // 3
        System.out.println(successShoot(-2, -3, 4, 5, -6));  // 3

        System.out.println(parityAnalysis(243)); // 4
        System.out.println(parityAnalysis(12));  // 4
        System.out.println(parityAnalysis(3));   // 4

        System.out.println(rps("rock", "paper"));        // 5
        System.out.println(rps("paper", "rock"));        // 5
        System.out.println(rps("paper", "scissors"));    // 5
        System.out.println(rps("scissors", "scissors"));  // 5
        System.out.println(rps("scissors", "paper"));     // 5

        System.out.println(bugger(39));   //6
        System.out.println(bugger(999));  // 6
        System.out.println(bugger(4));    // 6


        Object[][] inventory = {//7
            {"Скакалка", 550, 8},//7
            {"Шлем", 3750, 4},//7
            {"Мяч", 2900, 10}//7
        };//7
        System.out.println(mostExpensive(inventory));//7 

        System.out.println(longestUnique("abcba")); // 8
        System.out.println(longestUnique("bbb"));   // 8
        System.out.println(longestUnique("abcdefg")); // 8
        System.out.println(longestUnique("pwwkew"));  // 8

        System.out.println(isPrefix("automation", "auto-"));  //9
        System.out.println(isSuffix("arachnophobia", "-phobia")); //9
        System.out.println(isPrefix("retrospect", "sub-"));  //9
        System.out.println(isSuffix("vocation", "-logy"));  //9

        System.out.println(doesBrickFit(1, 1, 1, 1, 1)); // 10
        System.out.println(doesBrickFit(1, 2, 1, 1, 1)); // 10
        System.out.println(doesBrickFit(1, 2, 2, 1, 1)); // 10
        System.out.println(doesBrickFit(2, 2, 1, 2, 2)); // 10
        System.out.println(doesBrickFit(3, 3, 3, 3, 3)); // 10

    }
    /*_____________________________1______________________________________ */
    public static boolean isStrangePair(String str1, String str2){
        if (str1.isEmpty() && str2.isEmpty()) {
            return true;
        }
        boolean result = !str1.isEmpty() && !str2.isEmpty() &&
        str1.charAt(0) == str2.charAt(str2.length() - 1) &&
        str1.charAt(str1.length() - 1) == str2.charAt(0);

        return result;
    }

    /*_______________________________2_____________________________________ */
    public static List<Object[]> sale(List<Object[]> products, int discount) {
        List<Object[]> result = new ArrayList<>();
        
        for (Object[] product : products) {
            String name = (String) product[0];
            int price = (int) product[1];
            
            int newPrice = Math.max(1, (int) Math.round(price * (1 - discount / 100.0)));
            
            result.add(new Object[] {name, newPrice});
        }
        
        return result;
    }
    /*_________________________________3_____________________________________ */
    public static boolean successShoot(int x, int y, int r, int m, int n) {
        double distance = Math.sqrt(Math.pow(m - x, 2) + Math.pow(n - y, 2));
        return distance <= r;
    }
    /*_______________________________4_______________________________________ */
    public static boolean parityAnalysis(int num) {
        boolean isNumEven = num % 2 == 0;
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        boolean isSumEven = sum % 2 == 0;
        return isNumEven == isSumEven;
    }
    /*_________________________________5______________________________________ */
    public static String rps(String player1, String player2) {
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();
        if (player1.equals(player2)) {
            return "Tie";
        }
        switch (player1) {
            case "rock":
                return player2.equals("scissors") ? "Player 1 wins" : "Player 2 wins";
            case "paper":
                return player2.equals("rock") ? "Player 1 wins" : "Player 2 wins";
            case "scissors":
                return player2.equals("paper") ? "Player 1 wins" : "Player 2 wins";
            default:
                return "Invalid input"; 
        }
    }
    /*_____________________________________6______________________________________ */
    public static int bugger(int num) {
        int count = 0;
        while (num >= 10) {
            int product = 1; 
            int temp = num;  
            while (temp > 0) {
                product *= temp % 10; 
                temp /= 10; 
            }

            num = product; 
            count++;
        }
        return count;
    }
    /*________________________________7__________________________________________ */
    public static String mostExpensive(Object[][] inventory) {
        String mostExpensiveItem = ""; 
        int maxTotalCost = 0; 
        for (Object[] item : inventory) {
            String name = (String) item[0];
            int price = (int) item[1]; 
            int quantity = (int) item[2]; 
            int totalCost = price * quantity;
            if (totalCost > maxTotalCost) {
                maxTotalCost = totalCost;
                mostExpensiveItem = name;
            }
        }
        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxTotalCost;
    }
    /*_______________________________________8_______________________________________ */
    public static String longestUnique(String input) {
        String longest = ""; 
        StringBuilder current = new StringBuilder(); 

        for (char c : input.toCharArray()) {
            while (current.indexOf(String.valueOf(c)) != -1) {
                current.deleteCharAt(0);
            }
            current.append(c);
            if (current.length() > longest.length()) {
                longest = current.toString(); 
            }
        }
        return longest; 
    }
    /*______________________________9__________________________________________ */
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.replace("-", ""));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.replace("-", ""));
    }
    /*____________________________10____________________________________________ */
    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        int[] brickDimensions = {a, b, c};
        int[] holeDimensions = {w, h};

        java.util.Arrays.sort(brickDimensions);
        java.util.Arrays.sort(holeDimensions);

        return (brickDimensions[0] <= holeDimensions[0] && brickDimensions[1] <= holeDimensions[1]);
    }

}