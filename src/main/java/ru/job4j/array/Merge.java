package ru.job4j.array;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftJ = 0, rightJ = 0;
        for (int i = 0; i < rsl.length; i++) {
            int minL = 0, minR = 0;
            for (int j = leftJ; j < left.length; j++) {
                minL = left[leftJ];
                break;
            }
            for (int j = rightJ; j < right.length; j++) {
                minR = right[rightJ];
                break;
            }
            if ((minL > minR || minL == 0) && minR != 0) {
                rsl[i] = minR;
                rightJ++;
            } else {
                rsl[i] = minL;
                leftJ++;
            }
        }
        return rsl;
    }
}
