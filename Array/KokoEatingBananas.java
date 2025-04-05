package Array;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        System.out.println(minEatingSpeed(piles,h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxPile = piles[0];
        int k = maxPile;
        //First let find the pile with max bananas
        //O(N)
        for(int banana: piles){
            maxPile = Math.max(maxPile, banana);
        }

        int left = 1;
        int right = maxPile;
        while (left<=right){
            int rate = (left+right)/2;
            int hours = calculateHours(rate, h,piles);
            if(hours==-1 || hours > h){
                left = rate+1;
                continue;
            }
            k =rate;
            right = rate-1;
            System.out.println("Hours: "+hours);
        }
        return  k;
    }
    public  static  int calculateHours(int rate, int targetHours, int[] piles){
        int hours = 0;
        System.out.println("Rate "+rate);
        for(int banana: piles){
            hours+=Math.ceilDiv(banana, rate);
            if(hours>targetHours) return  -1;
        }
        return  hours;
    }
}
