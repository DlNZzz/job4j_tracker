package ru.job4j.array;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftJ = 0, rightJ = 0;
        for (int i = 0; i < rsl.length;) {
            if (leftJ != left.length) {
                if (rightJ == right.length || left[leftJ] <= right[rightJ]) {
                    rsl[i++] = left[leftJ++];
                }
            }
            if (rightJ != right.length) {
                if (leftJ == left.length || left[leftJ] >= right[rightJ]) {
                    rsl[i++] = right[rightJ++];
                }
            }
        }
        return rsl;
    }
}
