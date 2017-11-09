import java.util.Stack;

/**
 * Created by ramiz on 11/9/17.
 */
public class Queue<T> {
    private Stack<T> stackNewestOnTop = new Stack<T>();
    private Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) { // Push onto newest stack
        stackNewestOnTop.push(value);
    }

    public T peek() {
        if (stackOldestOnTop.isEmpty()) {
            this.moveDataToOldestOnTopStack();
        }

        return stackOldestOnTop.peek();
    }

    public T dequeue() {
        if (stackOldestOnTop.isEmpty()) {
            this.moveDataToOldestOnTopStack();
        }

        return stackOldestOnTop.pop();
    }

    private void moveDataToOldestOnTopStack() {
        while (!stackNewestOnTop.isEmpty()) {
            stackOldestOnTop.push(stackNewestOnTop.pop());
        }
    }
}
