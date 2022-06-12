package leetcode.solution.array;

/**
 * 2303. Calculate Amount Paid in Taxes
 */
public class CalculateAmountPaidInTaxes {

    public static void main(String[] args) {
        int income = 10;
        int[][] brackets = {{3, 50}, {7, 10}, {12, 25}};
        CalculateAmountPaidInTaxes findKClosestElements = new CalculateAmountPaidInTaxes();
        double ans = findKClosestElements.calculateTax(brackets, income);
        System.out.println(ans);
    }


    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        int base = 0;
        for (int[] bracket : brackets) {
            int bound = bracket[0];
            int tax = bracket[1];

            if (bound > income) {
                ans += (income - base) * tax / 100.0;
                break;
            } else {
                ans += (bound - base) * tax / 100.0;
                base = bound;
            }

        }

        return ans;
    }
}
