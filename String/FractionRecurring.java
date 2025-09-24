package String;

import java.util.HashSet;
import java.util.Set;

public class FractionRecurring {
    public static void main(String[] args) {
        System.out.println(new FractionRecurring().fractionToDecimal(200, 4));
        System.out.println(new FractionRecurring().fractionToDecimal(4, 333));

    }

    private String fractionToDecimal(int numerator, int denominator) {
        double res = (double) numerator / denominator;
        while (numerator/denominator != 0){
            System.out.println(numerator%denominator);
            numerator = numerator*10;
        }
        return String.valueOf(res);
    }


}

