import java.util.*;
public class CarFleet {
    public static void main(String[] args) {
        int target=12;
        int[] position={10,8,0,5,3};
        int[] speed={2,4,1,1,3};

        //Answer should be 3;
        System.out.println(carFleet(target,position,speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        //Making a combined
        int[][] combined = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combined[i][0] = position[i];  // Store position
            combined[i][1] = speed[i];     // Store speed
        }
        Arrays.sort(combined, (a, b) -> Integer.compare(b[0], a[0]));
        int fleetCount=position.length; //Initially I am keeping fleets same as number of cars
        for(int i=0; i<position.length-1; i++){

            int speedCarFront = combined[i][1];
            int speedCarBack = combined[i+1][1];
            int relativeSpeed = speedCarBack-speedCarFront;
            int positionDiff = combined[i][0]-combined[i+1][0];
            if(speedCarBack > speedCarFront){
                float timeFront = (float)(target-  combined[i][0]) /speedCarFront;
                float catchTime = (float) positionDiff/relativeSpeed;
                if(catchTime<=timeFront){
                    fleetCount--;
                }

            }
        }
//        System.out.println(fleetCount);
        return fleetCount;
    }
}
