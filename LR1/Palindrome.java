public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }

    public static String reverseString(String s){
        String reversRow = "";
        for( int i = (s.length() - 1); i >= 0; i--) {
            reversRow = reversRow + s.charAt(i);
        }
        return reversRow;
    }

    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }
}
