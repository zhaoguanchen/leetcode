package leetcode.solution.array;

/**
 * 495. Teemo Attacking
 */
public class TeemoAttacking {

    public static void main(String[] args) {
        int duration = 2;
        int[] timeSeries = {1, 4};
        TeemoAttacking teemoAttacking = new TeemoAttacking();
        System.out.println(teemoAttacking.findPoisonedDuration(timeSeries, duration));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }

        int total = 0;
        int end = timeSeries[0];

        for (int i = 0; i < timeSeries.length; i++) {
            if (end > duration + timeSeries[i]) {
                continue;
            } else if (timeSeries[i] < end) {
                total += timeSeries[i] + duration - end;
                end = timeSeries[i] + duration;
            } else {
                total += duration;
                end = timeSeries[i] + duration;
            }
        }

        return total;

    }
}
