public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();

        try {
            stack.push(10);
            System.out.println("Извлечен элемент: " + stack.pop());
            System.out.println("Извлечен элемент: " + stack.pop());
        } catch (CustomEmptyStackException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            ExceptionLogger.logException(e);
        }
    }
}
