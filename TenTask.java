package task;
public class TenTask{
    public static void main(String[] args) {
        System.out.println("task1");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("task2");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println("task3");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("task4");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("task5");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("task6");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("task7");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("task8");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("task9");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("task10");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
        
    }

    public static double convert(int gallons){
        return 3.785 * gallons;
    }
    
    public static int fitCalc(int min, int active){
        return min * active;
    }

    public static int containers(int box, int bags, int bar){
        return box * 20 + bags * 50 + bar * 100;
    }

    public static String triangleType(int a, int b, int c){
        if (a > 0 && b > 0 && c > 0){
        }
        if (a == b && c == b){
           return "isosceles";
        } else if (((a == b && a != c) || (c == b && b!= a) || (c == a && a!= b)) && ((a + b > c) && (a + c > b) && (c + b > a))){
            return "equilateral";   
        } else if ((a + b < c) || (a + c < b) || (c + b < a)){
            return "not a triangle";
        } else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int a, int b){
        return a > b ? a : b ;
    } 

    public static int howManyItems(double n, double a, double b){
        double square = a * b;
        double squareHalf = n / 2;
        int count = (int) (squareHalf / square);
        return count;     
    }

    public static int factorial(int n){
        int count = 1;
        for(int i = 1; i < n+1; i++){
            count = count * i; 
        }
        return count;
    }

    public static int gcd(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; 
    }

    public static int ticketSaler(double quantity, double cost){
        int result = (int) (quantity * cost * 0.72);
        return result;
    }

    public static int tables(int student, int quantityTable){
        int place = quantityTable * 2;
        int table = student - place;
        if((place < student) && table % 2 != 0 ){
            return (table + 1) / 2;
        } else {
            return 0;
        }

    }
}