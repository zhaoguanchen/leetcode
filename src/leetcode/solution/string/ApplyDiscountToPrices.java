package leetcode.solution.string;

/**
 * 2288. Apply Discount to Prices
 */
public class ApplyDiscountToPrices {

    public static void main(String[] args) {
        String s = "706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6";
        int d = 28;

        ApplyDiscountToPricesSolution solution = new ApplyDiscountToPricesSolution();
        String ans = solution.discountPrices(s, d);
        System.out.println(ans);
    }


}

class ApplyDiscountToPricesSolution {

    public String discountPrices(String sentence, int discount) {
        double dis = (double) (100 - discount) / 100;
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strings.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            String s = strings[i];
            if (check(s)) {
                Long num = getNum(s);
                Double newNum = num * dis;
                sb.append("$").append(getStr(newNum));
            } else {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    private String getStr(Double d) {
        return String.format("%.2f", d);
    }


    private Long getNum(String s) {
        return Long.valueOf(s.substring(1));
    }

    private boolean check(String s) {
        if (!s.startsWith("$")) {
            return false;
        }

        if (s.length() == 1) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }


}