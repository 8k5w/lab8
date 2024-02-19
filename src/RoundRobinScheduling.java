import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduling {

    public static void schedule(int[] processes, int timeQuantum) {
        if (processes == null || processes.length == 0 || timeQuantum <= 0) {
            throw new IllegalArgumentException("Invalid input: processes array must not be empty and time quantum must be positive.");
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add all processes to the queue
        for (int process : processes) {
            queue.offer(process);
        }

        while (!queue.isEmpty()) {
            int currentProcess = queue.poll();
            System.out.println("Running process " + currentProcess);

            // Decrease the remaining time of the current process by the time quantum
            int remainingTime = currentProcess - timeQuantum;

            if (remainingTime > 0) {
                // If the process still has remaining time, re-add it to the queue
                queue.offer(remainingTime);
                System.out.println("Time quantum expired. Process " + currentProcess + " added back to the queue with remaining time " + remainingTime);
            } else {
                // If the process is completed, print the completion message
                System.out.println("Process " + currentProcess + " completed.");
            }
        }
    }

    public static void main(String[] args) {
        int[] processes = {24, 10, 12, 5};
        int timeQuantum = 4;

        schedule(processes, timeQuantum);
    }
}