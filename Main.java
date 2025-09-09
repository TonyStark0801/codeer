import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> test = List.of(1,3,4,5,6,7,8,9);

        var testing = test.stream().sorted();
        System.out.println(testing.toArray());
    }
}
