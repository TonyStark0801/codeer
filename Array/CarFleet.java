package Array;

import java.util.*;

public class CarFleet {
    public static void main(String[] args) {
        int target = 10;
        int[] position = {0, 4, 2};
        int[] speed = {2, 1, 3};

        // Answer should be 3
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        // Combine the position and speed into a 2D array
        int[][] combined = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combined[i][0] = position[i];  // Position
            combined[i][1] = speed[i];     // Speed
        }

        // Sort cars by position in descending order (frontmost car first)
        Arrays.sort(combined, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack to track the time it takes for each car to reach the target
        Stack<Float> carTimeSt = new Stack<>();

        for (int[] carPosSpeed : combined) {
            // Calculate the time it takes for each car to reach the target
            float time = (float) (target - carPosSpeed[0]) / carPosSpeed[1];

            // If the current car reaches the target later than the car ahead, they form a fleet
            if (!carTimeSt.isEmpty() && time <= carTimeSt.peek()) {
                continue;  // This car joins the same fleet as the car in front
            }

            // Otherwise, it forms a new fleet
            carTimeSt.push(time);
        }

        // Return the number of fleets
        return carTimeSt.size();
    }
}
