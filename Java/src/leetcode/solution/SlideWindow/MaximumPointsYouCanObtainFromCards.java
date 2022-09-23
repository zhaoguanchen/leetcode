package leetcode.solution.SlideWindow;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 */
public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int[] cardPoints = {100, 40, 17, 9, 73, 75};
        int k = 3;
        MaximumPointsYouCanObtainFromCards solution = new MaximumPointsYouCanObtainFromCards();
        int ans = solution.maxScore(cardPoints, k);
        System.out.println(ans);
        // 248
    }

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;

        for (int num : cardPoints) {
            sum += num;
        }

        int windowStart = 0;
        int windowLength = n - k;

        int currentSum = 0;
        for (int i = windowStart; i < windowLength; i++) {
            currentSum += cardPoints[i];
        }

        int min = currentSum;
        while (windowStart + windowLength < n) {
            currentSum += cardPoints[windowStart + windowLength];
            currentSum -= cardPoints[windowStart];
            min = Math.min(min, currentSum);
            windowStart++;
        }

        return sum - min;
    }
}
