import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class OsPlanning_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        int [] tasks = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int [] threads = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < tasks.length; i++) {

            tasksStack.push(tasks[i]);

        }
        for (int i = 0; i < threads.length; i++) {

            threadsQueue.offer(threads[i]);

        }
        int taskToBeKilled = Integer.parseInt(reader.readLine());
        int killerThread = 0;
        while(tasksStack.contains(taskToBeKilled)){
            int currentTask = tasksStack.peek();
            int currentThread = threadsQueue.peek();
            if(currentTask == taskToBeKilled){
                tasksStack.pop();
                killerThread = currentThread;
            } else {
                if(currentThread >= currentTask){
                    tasksStack.pop();

                }
                threadsQueue.poll();

            }
        }
        System.out.println("Thread with value " + killerThread + " killed task " + taskToBeKilled);
        for (int thread : threadsQueue) {
            System.out.print(thread + " ");

        }
    }
}
