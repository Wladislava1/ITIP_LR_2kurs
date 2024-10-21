public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "ф", "4", "5"};
        int sum = 0;
        int count = 0;
        
        try {
            for (int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                sum += num;
                count++;
            }
            double average = (double) sum / count;
            System.out.println("Среднее арифметическое: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Элемент массива не является числом.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Произошел выход за границы массива.");
        } finally {
            System.out.println("Операция завершена.");
        }
    }
}
