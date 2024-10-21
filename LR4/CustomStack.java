import java.util.ArrayList;

public class CustomStack<T> {
    private ArrayList<T> stack;

    public CustomStack() {
        this.stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() throws CustomEmptyStackException {
        if (stack.isEmpty()) {
            throw new CustomEmptyStackException("Попытка извлечь элемент из пустого стека");
        }
        return stack.remove(stack.size() - 1);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

