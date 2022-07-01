package sdfAsmtTasks.task2;

import java.util.Arrays;

public class AverageNum {
    public static int findAverage(int[] nums) {
        return Arrays.stream(nums).sum()/nums.length;
      }
}