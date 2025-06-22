
// Stack ADT Interface
public interface StackADT<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
// Array-based Stack Implementation
public class ArrayStack<T> implements StackADT<T> {
    private T[] stack;
    private int top;
    private int capacity;
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = (T[]) new Object[capacity];
        top = -1;
    }
    @Override
    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        stack[++top] = item;
    }
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return stack[top--];
    }
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack[top];
    }
    @Override
    public boolean isEmpty() {
        return top == -1;
    }
    @Override
    public int size() {
        return top + 1;
    }
}