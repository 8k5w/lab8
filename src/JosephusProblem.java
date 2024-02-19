import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem {

    public static int josephus(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input: n and k must be positive integers.");
        }

        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            // Skip (k-1) people
            for (int i = 0; i < k - 1; i++) {
                // Move the front person to the rear of the queue
                queue.offer(queue.poll());
            }
            // Eliminate the kth person
            queue.poll();
        }

        // Return the last remaining person
        return queue.peek();
    }

    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Skip k-1 people before eliminating

        int survivor = josephus(n, k);
        System.out.println("The last person standing is: " + survivor);
    }
}
