package Array;

import java.util.*;

public class DiagonalTraverse {

    public static void main(String[] args) {

        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] result = findDiagonalOrder(mat);
        for (int x: result){
            System.out.print(x+" ");

        }
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        HashMap<Integer, List<Integer>> mem = new HashMap<>();
        for(int i = 0;i<mat.length;i++){
            for(int j =0; j<mat[i].length;j++){
                int index = i+j;
                mem.putIfAbsent(index,new ArrayList<>());
                mem.get(index).add(mat[i][j]);
            }
        }
        boolean traverseLast = true;
        List<Integer> result = new ArrayList<>();

        for(int x : mem.keySet()){
            if(traverseLast) reverseTraversal(result, mem.get(x));
            else forwardTraversal(result, mem.get(x));

            traverseLast = !traverseLast;

        }
        int[] res = new int[result.size()];
        for(int i =0; i< res.length; i++ ){
            res[i] = result.get(i);
        }

        return res;
    }

    private static void forwardTraversal(List<Integer> result, List<Integer> integers) {
        for(int x : integers){
            result.add(x);
        }
    }

    private static void reverseTraversal(List<Integer> result, List<Integer> integers) {
        for(int i =  integers.size()-1; i>=0;i--){
            result.add(integers.get(i));
        }
    }

}
