public class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        data = new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size < data.length) { 
            data[size] = element;
            size++;
        } else {
            System.out.println("Стек переполнен!");
        }
    }

    public T pop() {
        if (size > 0) {
            size--;
            return (T) data[size];
        } else {
            System.out.println("Стек пуст!");
            return null;
        }
    }

    public T peek() {
        if (size > 0) {
            return (T) data[size - 1];
        } else {
            System.out.println("Стек пуст!");
            return null;
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}
