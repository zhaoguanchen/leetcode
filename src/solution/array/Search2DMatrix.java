package solution.array;

/**
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int target = 2;
        int[][] mat = {{1, 2}, {2, 1}};

        System.out.println(searchMatrix(mat, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        return true;
    }
}
