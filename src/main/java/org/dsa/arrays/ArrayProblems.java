package org.dsa.arrays;

import java.util.Arrays;

public class ArrayProblems {

    public static void main(String[] args) {
        ArrayProblems problems = new ArrayProblems();
        int[] numsTwoSum = {1, 2, 3, 4, 5, 6, 7};
        int[] moveZerosArray = {0, 2, 3, 0, 1, 2, 5, 6, 0};

        System.out.println(Arrays.toString(problems.twoSum(numsTwoSum, 50)));

        problems.moveZeroes(moveZerosArray);

        System.out.println(Arrays.toString(moveZerosArray));
    }
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }

    public void moveZeroes(int[] nums) {
        int writePos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writePos++] = nums[i];
            }
        }

        while (writePos < nums.length) {
            nums[writePos++] = 0;
        }
    }
}
