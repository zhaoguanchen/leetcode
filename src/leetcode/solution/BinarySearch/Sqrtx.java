package leetcode.solution.BinarySearch;

/**
 * 69. Sqrt(x)
 */
public class Sqrtx {

    public static void main(String[] args) {
        int target = 8;

        int right = target << 2;


        System.out.println(right);
        System.out.println(target/2);
//        System.out.println(mySqrt(target));
    }


    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x >> 1;
        while (left <= right) {
            // 移位代替/2操作
            int mid = left + ((right - left) >> 1);
            double powValue = Math.pow(mid, 2);
            if (powValue == x) {
                return mid;
            } else if (powValue < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
