package slidingwindow;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static  int maxProfit(int[] prices) {
        int profit  =0;
        int i =0;
        while(i<prices.length-1){
            int j = i+1;

            while(j<prices.length && prices[i]<prices[j]){
                j++;
            }
            if(prices[j-1]>prices[i]) profit = Math.max(profit,prices[j-1]-prices[i]);
            i= j;
        }
        return profit;
    }
}
