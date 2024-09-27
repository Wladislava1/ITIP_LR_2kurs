import java.util.Arrays;
public class TwentyTask {
    
    public static void main(String args[]){
        System.out.println(duplicateChars("Barack", "Obama")); //1

        int[] numbers = {3, 12, 7, 81, 52}; //2
        int count = dividedByThree(numbers); //2
        System.out.println(count); //2

        System.out.println(getInitials("simonov sergei evgenievich")); //3
        System.out.println(getInitials("kozhevnikova tatiana vitalevna")); //3

        double[] arr1 = {3.5, 7.0, 1.5, 9.0, 5.5};//4
        double[] result1 = normalizator(arr1);//4
        System.out.println(Arrays.toString(result1));//4
        double[] arr2 = {10.0, 10.0, 10.0, 10.0};//4
        double[] result2 = normalizator(arr2);//4
        System.out.println(Arrays.toString(result2));//4

        double[] nums = {1.6, 0, 212.3, 34.8, 0, 27.5};//5
        int[] compressed = compressedNums(nums);//5
        System.out.println(Arrays.toString(compressed));//5

        System.out.println(camelToSnake("helloWorld")); //6
        System.out.println(camelToSnake("CamelCaseExample")); //6

        int[] testArray = {3, 5, 8, 1, 2, 4};//7
        int result = secondBiggest(testArray);//7
        System.out.println(result); //7

        System.out.println(localReverse("baobab", 'b')); //8
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));//8

        System.out.println(equal(8, 1, 8)); //9
        System.out.println(equal(5, 5, 5)); //9
        System.out.println(equal(4, 9, 6)); //9

        System.out.println(isAnagram("LISTEN", "silent")); //10
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!")); //10
        System.out.println(isAnagram("hello", "world")); //10
    }
    /*____________________________1__________________________________ */
    public static String duplicateChars(String s1, String s2) {
        char[] arrayS1 = s1.toCharArray();
        char[] arrayS2 = s2.toCharArray();
        String newRow = "";
        for (int i = 0; i < arrayS1.length; i++) {
            boolean found = false; 
            for (int j = 0; j < arrayS2.length; j++) {
                if (String.valueOf(arrayS1[i]).equalsIgnoreCase(String.valueOf(arrayS2[j]))) {
                    found = true; 
                    break; 
                }
            }
            if (!found) { 
                newRow += arrayS1[i];
            }
        }
        return newRow;
    }
    /*____________________2____________________________________________________ */
    public static int dividedByThree(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if ( array[i] % 2 != 0 && array[i] % 3 == 0){
                count += 1;
            }
        }
        return count;
    }
/*__________________________3___________________________________________ */
    public static String getInitials(String fullName){
        String[] parts = fullName.split(" "); 
        if (parts.length < 3) {
            return "Некорректный формат ФИО"; 
        }
        
        String firstNameInitial = parts[1].substring(0, 1).toUpperCase(); 
        String patronymicInitial = parts[2].substring(0, 1).toUpperCase(); 
        String lastName = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase(); 
        return firstNameInitial + "." + patronymicInitial + "." + lastName; 
    }
    /*_____________________________________4______________________________ */
    public static double[] normalizator(double[] array) {
        if (array.length == 0) {
            return new double[0]; 
        }
        double min = array[0];
        double max = array[0];
    
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        if (min == max) {
            return new double[array.length];
        }
        double[] normalizedArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            normalizedArray[i] = (array[i] - min) / (max - min);
        }
        return normalizedArray;
    }
    /*________________________________5__________________________________ */
    public static int[] compressedNums(double[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                result[index] = (int) array[i]; 
                index++;
            }
        }
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i] > result[j]) {
                    int temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        return result; 
    }
    /*________________________________6____________________________ */
    public static String camelToSnake(String words) {
        if (words == null || words.isEmpty()) {
            return "Некорректный формат"; 
        }
        String rowWords = ""; 
        for (int i = 0; i < words.length(); i++) {
            char currentChar = words.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                if (i != 0) {
                    rowWords += "_"; 
                }
                rowWords += Character.toLowerCase(currentChar);
            } else {
                rowWords += currentChar; 
            }
        }
        return rowWords;
    }
    /*______________________________7___________________________ */
        public static int secondBiggest(int[] arr) {
            if (arr.length < 2) {
                return 0; 
            }
            int biggest = arr[0]; 
            int secondBiggest = arr[1]; 
            if (secondBiggest > biggest) {
                int temp = biggest;
                biggest = secondBiggest;
                secondBiggest = temp;
            }
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] > biggest) {
                    secondBiggest = biggest;
                    biggest = arr[i];
                } else if (arr[i] > secondBiggest && arr[i] != biggest) {
                    secondBiggest = arr[i];
                }
            }
            return secondBiggest;
        }
    /*______________________________8__________________________________ */
        public static String localReverse(String str, char marker) {
            StringBuilder result = new StringBuilder(); 
            StringBuilder temp = new StringBuilder(); 
            boolean insideMarker = false;
    
            for (int i = 0; i < str.length(); i++) { 
                char ch = str.charAt(i); 
                if (ch == marker) {
                    if (insideMarker) {
                        result.append(temp.reverse()); 
                        result.append(marker);
                        temp.setLength(0); 
                    } else {
                        result.append(marker); 
                    }
                    insideMarker = !insideMarker; 
                } else {
                    if (insideMarker) {
                        temp.append(ch); 
                    } else {
                        result.append(ch); 
                    }
                }
            }
            result.append(temp.reverse());
            return result.toString(); 
        }
        /*__________________________9__________________________ */
        public static int equal(int a, int b, int c) {

            if (a == b && b == c) {
                return 3;
            }
            else if (a == b || a == c || b == c) {
                return 2;
            }
            else {
                return 0;
            }
        }
        /*_________________________10__________________________ */
        public static boolean isAnagram(String str1, String str2) {
            str1 = str1.toLowerCase().replaceAll("[^a-z]", "");
            str2 = str2.toLowerCase().replaceAll("[^a-z]", "");
    
            if (str1.length() != str2.length()) {
                return false;
            }
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
    
            return Arrays.equals(charArray1, charArray2);
        }
    
}
        
    

