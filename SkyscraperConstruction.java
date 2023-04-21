import java.util.*;

public class SkyscraperConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building:");
        int n = sc.nextInt();
        int[] sizes = new int[n];
        System.out.println("Enter the floor sizes given on each day:");
        for (int i = 0; i < n; i++) {
            sizes[i] = sc.nextInt();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            queue.add(sizes[i]);
            System.out.print("Day " + (i + 1) + ": ");
            while (!queue.isEmpty() && queue.peek() == n - i) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        }
    }
}
