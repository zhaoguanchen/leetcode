package leetcode.solution.array;

/**
 * 605. Can Place Flowers
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int n = 1;
        int[] mat = {0};

        System.out.println(canPlaceFlowers(mat, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length < 2 * n - 1) {
            return false;
        }
        if (n == 1 && flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return true;
            }
        }
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count == n;


    }

}
